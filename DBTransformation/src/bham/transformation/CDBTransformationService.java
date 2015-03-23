package bham.transformation;

import java.util.ArrayList;

import nosql.Cell;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.KeySpace;
import nosql.Row;
import nosql.Type;

import org.eclipse.emf.common.util.EList;

import bham.transformation.rules.DatatypeMapping;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

public class CDBTransformationService {

	NoSQLConnection conn = null;
	Session session = null;

	/*
	 * Generate Cassandra db
	 * 
	 * @param myKeySpace, used to generate cassandra db
	 * 
	 * @return
	 */
	public void generate(KeySpace myKeySpace) {
		try {
			// initiate connection
			conn = new NoSQLConnection();
			session = conn.connect();

			Main.times.add(System.currentTimeMillis());
			System.out.println(Main.calTimeDiff(false) + " ms Cassandra Connection established.");
			// creating db schema
			createSchema(session, myKeySpace);
			Main.times.add(System.currentTimeMillis());
			System.out.println(Main.calTimeDiff(false) + " ms Schema Created.");
			// fill db with data
			fillData(session, myKeySpace);
			Main.times.add(System.currentTimeMillis());
			Main.calTimeDiff(true);
			System.out.println(Main.totalTime + " ms Data Inserted.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// closing connection
			if (conn != null)
				conn.close();
		}
	}

	/*
	 * Filling created db with data
	 * 
	 * @param mySession, used to open session with db server to execute db
	 * queries
	 * 
	 * @param KeySpace, contains data to be filled in the db
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void fillData(Session mySession, KeySpace myKeySpace) {
		String colNames, cellValues, sql, addCellValues;
		PreparedStatement ps=null;
		BoundStatement bs = null;
		try {
			// extracting tables from keyspace
			EList<ColumnFamily> tables = myKeySpace.getFamilies();
			for (ColumnFamily tab : tables) {
				// get list of rows associated with each table
				EList<Row> rows = tab.getRows();
				if (tab.getComment() != null && tab.getComment().equals("Reference Table for Foreign Key")) {
					colNames = ((Column) tab.getPK().getColumns().get(0)).getName() + ", " + ((Column) ((Cell) (rows.get(0).getCells().get(1))).getColumn()).getName() + "List";
					ps = session.prepare("INSERT INTO " + tab.getName() + "(" + colNames + ")" + " VALUES (?, ?);");
					for (Row row : rows) {
						colNames = ""; cellValues = ""; sql = ""; addCellValues = "[";
						bs = new BoundStatement(ps);
						Object PKCell =null;
						if(DatatypeMapping.isStringType(((Cell)row.getCells().get(0)).getColumn().getDatatype()))
							PKCell = "'"+((Cell)row.getCells().get(0)).getValue()+"'";
						else
							PKCell =((Cell)row.getCells().get(0)).getValue();
						row.getCells().remove(0);
						/*for (Cell cell : ((EList<Cell>) row.getCells())) {
							if (cell.getColumn().getName().equals(((Column) tab.getPK().getColumns().get(0)).getName()))
								if(DatatypeMapping.isStringType(cell.getColumn().getDatatype()))
									addCellValues += "'"+cell.getValue()+"', ";
								else
									addCellValues +=cell.getValue()+", ";
						}*/
						//addCellValues = addCellValues.substring(0, addCellValues.length() - 2)+"]";
						bs.bind(PKCell, getValues(row.getCells())); 
						//System.out.println(bs);
						session.execute(bs);
					}
				} else {
					EList<Cell> cells = rows.get(0).getCells();
					colNames = "";
					String cellsValues = "";
					for (Cell cell : (EList<Cell>)cells) {
						colNames += cell.getColumn().getName()+", ";
						cellsValues+="?, ";
					}
					colNames = colNames.substring(0, colNames.length() - 2);
					cellsValues = cellsValues.substring(0, cellsValues.length() - 2);
					System.out.println("INSERT INTO " + tab.getName() + "(" + colNames + ")" + " VALUES (" + cellsValues + ");");
					ps = session.prepare("INSERT INTO " + tab.getName() + "(" + colNames + ")" + " VALUES (" + cellsValues + ");");
					
					
					for (Row row : rows) {
						// get list of cells associated with each row
						bs = new BoundStatement(ps);
						ArrayList<Object> val = getValues(row.getCells());
						bs.bind(val.toArray());
						System.out.println(val.toArray());
						/*for(Object obj: getValues(row.getCells())){
							//bs.set
							bs.bind();
						}*/
						//System.out.println(bs.toString());
						session.execute(bs);
					}
				}
				Main.times.add(System.currentTimeMillis());
				System.out.println(Main.calTimeDiff(true)+ "ms "+rows.size()+" rows entered into "+tab.getName()+" column family.");
			}
			System.out.println("\n");

		} catch (Exception e) {
			System.err.println(bs.toString());
			e.printStackTrace();
		}

	}

	/*
	 * Create db schema
	 * 
	 * @param mySession, used to open session with db server to execute db
	 * queries
	 * 
	 * @param KeySpace, contains info used to create schema
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void createSchema(Session mySession, KeySpace myKeySpace) {
		try {
			try {
				// drop keySpace check there is command DORP KEYSPACE IFEXISTS
				session.execute("DROP KEYSPACE " + myKeySpace.getName());
			} catch (Exception ex) {
				System.err.println("\n createSchema : error while dropping Keyspace " + myKeySpace.getName() + " does not exists");
			}
			// create keySpace
			// for now the keyspace options are static
			// in the future should be read form options object that is created
			// based on the options selected by the user
			String keySpaceStr = "CREATE KEYSPACE " + myKeySpace.getName() + " WITH replication " + "= {'class':'SimpleStrategy', 'replication_factor':1};";

			System.out.println(keySpaceStr);
			session.execute(keySpaceStr);

			// using the new schema
			session.execute("USE " + myKeySpace.getName() + ";");

			// create ColumnFamilies
			EList<ColumnFamily> families = myKeySpace.getFamilies();
			for (ColumnFamily family : families) {

				String columnsStr = "";
				String pkStr = "";
				EList pkColumns;

				EList columns = family.getColumns();
				if (family.getComment() != null && family.getComment().equals("Reference Table for Foreign Key")) {
					Column col = (Column) family.getPK().getColumns().get(0);
					columnsStr = col.getName() + " " + col.getDatatype() + ",";
					col = (Column) ((Cell) ((Row) family.getRows().get(0)).getCells().get(1)).getColumn();
					columnsStr += col.getName() + "List list<" + col.getDatatype() + ">,";
				} else {
					for (Object object : columns) {
						Column col = (Column) object;
						columnsStr += col.getName() + " " + col.getDatatype() + ",";
						// cassandra does not support size
						// if(!col.getSize().isEmpty())
						// columnsStr += "(" + col.getSize() + ")";
						// columnsStr += ",";
					}
				}

				// get the pk
				// pk is mandatory in cassandra
				if (family.getPK() != null && (pkColumns = family.getPK().getColumns()) != null && pkColumns.size() > 0) {
					int index = 0;
					// for composite key
					while (index < pkColumns.size() - 1) {
						pkStr += ((Column) pkColumns.get(index)).getName();
						pkStr += ",";
						index++;
					}
					pkStr += ((Column) pkColumns.get(index)).getName();

				}

				// check options
				// future work , to be implemented later
				/*
				 * if it has options withStr = "WITH " if (options) { for each
				 * option in Options withstr += option.getname +
				 * option.value==""?"":"="+options.value ; }
				 */
				pkStr = "PRIMARY KEY (" + pkStr + ")";
				String noSqlStr = "CREATE TABLE " + family.getName() + "(" + columnsStr + pkStr + ");";
				System.out.println(noSqlStr);
				session.execute(noSqlStr);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * CheckType to return the right formate
	 * @param cell
	 * @return String, formated string 
	 */
	private ArrayList<Object> getValues(EList<Cell> cells)
	{
		ArrayList<Object> values = new ArrayList<Object>();
		for(Cell cell: cells){
			if (cell.getColumn().getDatatype().equals(Type.BOOLEAN_LITERAL))
				values.add(cell.getValue().equals("t") || cell.getValue().equals("T") || cell.getValue().equals("1") ||cell.getValue().equals(1) ? true:false );
			else
				values.add(cell.getValue());
		}
		return values;
	}
}
