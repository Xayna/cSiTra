package bham.trasformation;

import java.util.Calendar;

import nosql.Cell;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.KeySpace;
import nosql.Row;

import org.eclipse.emf.common.util.EList;

import bham.trasformation.rules.DatatypeMapping;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class CDBTransformationService {

	NoSQLConnection conn;
	Session session;

	public void generate(KeySpace myKeySpace) {
		try {
			//conn = Cluster.builder().addContactPoint("127.0.0.1").build();
			//session = conn.connect();
			
			//System.out.println("i'm here");

			 conn = new NoSQLConnection();
			 session = conn.connect();
			 
			createSchema(session, myKeySpace);
			
			fillData(session, myKeySpace);
			 conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
	}

	private void fillData(Session mySession, KeySpace myKeySpace) {
		try {
			System.out.println("Filling data : " + Calendar.getInstance().getTime().toString());
			EList<ColumnFamily> tables = myKeySpace.getFamilies();
			for (ColumnFamily tab : tables) {
				EList<Row> rows = tab.getRows();
				for (Row row : rows) {
					EList<Cell> cells = row.getCells();
					if (cells != null && cells.size() > 0) {
						String colNames = "";
						String cellsValues = "";

						int index = 0;
						while (index < cells.size() - 1) {
							Column tempCol = cells.get(index).getColumn();
							Cell tempCell = cells.get(index);

							colNames += tempCol.getName();
							colNames += ",";
							if (DatatypeMapping.isStringType(tempCol
									.getDatatype()))
								cellsValues += "'" + tempCell.getValue() + "'";
							else
								cellsValues += tempCell.getValue();
							cellsValues += ",";
							index++;
						}
						colNames += cells.get(index).getColumn().getName();

						if (DatatypeMapping.isStringType(cells.get(index)
								.getColumn().getDatatype()))
							cellsValues += "'" + cells.get(index).getValue()
									+ "'";
						else
							cellsValues += cells.get(index).getValue();

						String sql = "INSERT INTO " + tab.getName() + "("
								+ colNames + ")" + " VALUES (" + cellsValues
								+ ");";
						//System.out.println(sql);
						session.execute(sql);
						
						// the syntax for add new col
						/*
						 * ALTER column_name TYPE cql_type | ( ADD column_name
						 * cql_type ) | ( DROP column_name ) | ( RENAME
						 * column_name TO column_name ) | ( WITH property AND
						 * property ... )
						 */

					}
				}
			}
			
			System.out.println("Inserting is finished : " + Calendar.getInstance().getTime().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * session.execute(
		 * "INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Jane', 'Doe', 36, 'janedoe@email.com', 'Beverly Hills');"
		 * );
		 * 
		 * session.execute(
		 * " INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Rob', 'Byrne', 24, 'robbyrne@email.com', 'San Diego');"
		 * );
		 */
	}

	private void createSchema(Session mySession, KeySpace myKeySpace) {
		try {
			try {
				// drop keySpace check there is command DORP KEYSPACE IFEXISTS
				session.execute("DROP KEYSPACE " + myKeySpace.getName());
			} catch (Exception ex) {
				System.out.println("createSchema : Keyspace "
						+ myKeySpace.getName() + " does not exists");
			}
			// keySpace
			String keySpaceStr = "CREATE KEYSPACE " + myKeySpace.getName()
					+ " WITH replication "
					+ "= {'class':'SimpleStrategy', 'replication_factor':1};";

			System.out.println(keySpaceStr + Calendar.getInstance().getTime().toString());
			session.execute(keySpaceStr);

			session.execute("USE " + myKeySpace.getName() + ";");

			// ColumnFamily
			EList<ColumnFamily> families = myKeySpace.getFamilies();
			for (ColumnFamily family : families) {

				String columnsStr = "";
				String pkStr = "";
				EList pkColumns;

				EList columns = family.getColumns();
				for (Object object : columns) {
					Column col = (Column) object;
					// to-do see why the columns are doubled through transformation
					//if(!columnsStr.contains(col.getName()))
					columnsStr += col.getName() + " " + col.getDatatype() + ",";
					// if(!col.getSize().isEmpty())
					// columnsStr += "(" + col.getSize() + ")";
					// columnsStr += ",";
				}
				/*
				 * System.out.println("1 ---- "+(family.getPK() !=
				 * null?"not null":"null")); System.out.println(" 2 ---- " +
				 * ((pkColumns = family.getPK().getColumns()) != null));
				 * System.out.println(" 3 ---- "+ (pkColumns.size() > 0));
				 */
				
				if (family.getPK() != null
						&& (pkColumns = family.getPK().getColumns()) != null
						&& pkColumns.size() > 0) {
					int index = 0;
					// System.out.println(pkColumns.size()+"!!!!!!!!");
					while (index < pkColumns.size() - 1) {
						pkStr += ((Column) pkColumns.get(index)).getName();
						pkStr += ",";
						index++;
					}
					pkStr += ((Column) pkColumns.get(index)).getName();
					// System.out.println(pkStr);

				}
				
				// check options 
				/*
				 * if it has options
				 * withStr = "WITH "
				 * if (options)
				 * {
				 * 	for each option in Options
				 * 		withstr += option.getname + option.value==""?"":"="+options.value ;
				 * } 
				 */
				pkStr = "PRIMARY KEY (" + pkStr + ")";
				String noSqlStr = "CREATE TABLE " + family.getName() + "("
						+ columnsStr + pkStr + ");";
				System.out.println(noSqlStr);
				session.execute(noSqlStr);
			}

			// createColumnFaminly();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
