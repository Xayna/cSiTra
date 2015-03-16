package bham.trasformation;

import nosql.Cell;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.KeySpace;
import nosql.Row;

import org.eclipse.emf.common.util.EList;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class CDBTransformationService {

	 Cluster conn;
	Session session;

	public void generate(KeySpace myKeySpace) {
		try {
			conn = Cluster.builder().addContactPoint("127.0.0.1").build();
			session = conn.connect();
			 Metadata metadata = conn.getMetadata();
		      System.out.printf("Connected to cluster: %s\n", 
		            metadata.getClusterName());
		      for ( Host host : metadata.getAllHosts() ) {
		         System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
		               host.getDatacenter(), host.getAddress(), host.getRack());
		      }
			System.out.println("i'm here");

		//	conn = new NoSQLConnection();
		//	session = conn.connect();
			createSchema(session, myKeySpace);
			System.out.println("i'm here");
		//	fillData(session, myKeySpace);
		//	conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void fillData(Session mySession, KeySpace myKeySpace) {
	 try{
			EList<ColumnFamily> tables = myKeySpace.getFamilies();
			for( ColumnFamily tab : tables){
				EList<Row> rows =  tab.getRows();
				for(Row row: rows){
					EList<Cell> cells =  row.getCells();
					for(Cell cell : cells){
						//if((cell.getColumn().getName() != ta) && (cell.getColumn().getName()))
						session.execute("INSERT INTO " + tab.getName() + "(" +cell.getColumn().getName()+ ")" + " VALUES ('"+ cell.getValue() +");");
						//	session.execute("INSERT INTO users (firstname, lastname, age, email, city) VALUES ('John', 'Smith', 46, 'johnsmith@email.com', 'Sacramento');");

					}
				} 			
			}
	 }catch(Exception e){
		 e.printStackTrace();
	 }
			
			/*
			session.execute("INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Jane', 'Doe', 36, 'janedoe@email.com', 'Beverly Hills');");

			session.execute(" INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Rob', 'Byrne', 24, 'robbyrne@email.com', 'San Diego');");
	*/
	}

	private void createSchema(Session mySession, KeySpace myKeySpace) {
		try {
			try{
			//drop keySpace 
			session.execute("DROP KEYSPACE " + myKeySpace.getName() );
			}catch (Exception ex)
			{
				System.out.println("createSchema : Keyspace "+myKeySpace.getName()+" does not exists"  );
			}
			// keySpace
			String keySpaceStr = "CREATE KEYSPACE " + myKeySpace.getName()
					+ " WITH replication "
					+ "= {'class':'SimpleStrategy', 'replication_factor':1};" ;
			
			System.out.println(keySpaceStr);
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
					columnsStr += col.getName() + " " + col.getDatatype() + ",";
					// if(!col.getSize().isEmpty())
					// columnsStr += "(" + col.getSize() + ")";
					// columnsStr += ",";
				}
				/*System.out.println("1 ---- "+(family.getPK() != null?"not null":"null"));
				System.out.println(" 2 ---- " + ((pkColumns = family.getPK().getColumns()) != null));
				System.out.println(" 3 ---- "+ (pkColumns.size() > 0));*/
				if ( family.getPK() != null && (pkColumns = family.getPK().getColumns()) != null && pkColumns.size() > 0) {
					int index = 0;
					//System.out.println(pkColumns.size()+"!!!!!!!!");
					while (index < pkColumns.size() - 1) {
						pkStr += ((Column) pkColumns.get(index)).getName();
						pkStr += ",";
						index++;
					}
					pkStr += ((Column) pkColumns.get(index)).getName();
					//System.out.println(pkStr);
					
				}
				pkStr = "PRIMARY KEY (" + pkStr + ")";
				String noSqlStr = "CREATE TABLE " + family.getName() + "("
						+ columnsStr + pkStr +  ");";
				System.out.println(noSqlStr);
				session.execute(noSqlStr);
			}

			// createColumnFaminly();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}