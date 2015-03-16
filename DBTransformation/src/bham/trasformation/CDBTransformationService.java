package bham.trasformation;

import org.eclipse.emf.common.util.EList;

import com.datastax.driver.core.Session;

import nosql.*;

public class CDBTransformationService {

	NoSQLConnection conn;
	Session session;

	public void generate(KeySpace myKeySpace) {
		try {

			conn = new NoSQLConnection();
			session = conn.connect();
			createSchema(session, myKeySpace);
			fillData(session, myKeySpace);
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void fillData(Session mySession, KeySpace myKeySpace) {
		// TODO Auto-generated method stub

	}

	private void createSchema(Session mySession, KeySpace myKeySpace) {
		try {
			// keySpace
			session.execute("CREATE KEYSPACE " + myKeySpace.getName()
					+ " WITH replication "
					+ "= {'class':'SimpleStrategy', 'replication_factor':1};");

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
					columnsStr += col.getName() + " " + col.getDatatype() + ",";
					// if(!col.getSize().isEmpty())
					// columnsStr += "(" + col.getSize() + ")";
					// columnsStr += ",";
				}

				if ((pkColumns = family.getPK().getColumns()).size() > 0) {
					int index = 0;
					while (index < pkColumns.size() - 1) {
						pkStr += ((Column) pkColumns.get(index)).getName();
						pkStr += ",";
						index++;
					}
					pkStr += ((Column) pkColumns.get(index)).getName();
				}
				String noSqlStr = "CREATE TABLE" + family.getName() + "("
						+ columnsStr + "PRIMARY KEY (" + pkStr + "));";

				session.execute(noSqlStr);
			}

			// createColumnFaminly();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
