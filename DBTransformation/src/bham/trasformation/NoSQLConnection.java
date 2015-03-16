package bham.trasformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class NoSQLConnection {

	private static String HOST = null;
	private static String PORT = null;
	private static String KEYSPACE = "TestKS";
	private static String CQLV3 = "3.0.0";
	private static String url = null;
	private static java.sql.Connection con = null;
	private static Properties prop;

	private  Cluster cluster;
	private  Session session;
	
	public NoSQLConnection ()
	{
		// to test this from another class like Main use the following
		/*
		NoSQLConnection test = new NoSQLConnection();
		Session s = test.connect();
		test.createTestSchema(s);
		test.fillTestData(s);
		test.close();
		*/
		
		//this only for testing 
		// should be deleted after testing is done
		/*try{
		connect();
		createTestSchema(session);
		fillTestData(session);
		close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}*/
	}

	public  Session connect() throws Exception {
		try {
			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
			session = cluster.connect();

		

			/*
			 * System.out.println("i'm here"); prop = new Properties();
			 * Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
			 * url = prop.getProperty("NoSQL.url"); HOST = "localhost";//
			 * prop.getProperty("NoSQL.Host"); int PORT = 8888 ;//
			 * prop.getProperty("NoSQL.Port");
			 * 
			 * try { System.out.println("i'm here");
			 * 
			 * con = DriverManager.getConnection(String.format(
			 * "jdbc:cassandra://localhost/8888/opscenter")); //
			 * %s:%d/%s",HOST,PORT,"system")); System.out.println("i'm here");
			 * 
			 * Statement stmt = con.createStatement(); System.out.println(con);
			 * 
			 * //String data=
			 * "CREATE columnfamily news (key int primary key, category text , linkcounts int ,url text)"
			 * ; //Statement st = con.createStatement(); //st.execute(data);
			 * 
			 * // Drop Keyspace String dropKS =
			 * String.format("DROP KEYSPACE %s;",KEYSPACE);
			 * 
			 * stmt.execute(dropKS);
			 * 
			 * 
			 * // Create KeySpace String createKS = String.format(
			 * "CREATE KEYSPACE %s WITH strategy_class = SimpleStrategy AND strategy_options:replication_factor = 1;"
			 * ,KEYSPACE); stmt = con.createStatement(); stmt.execute(createKS);
			 */
		} catch (Exception e) {// Exception on DROP is OK
			e.printStackTrace();
		} 
		/*
		 * / Use Keyspace String useKS = String.format("USE %s;",KEYSPACE);
		 * stmt.execute(useKS);
		 * 
		 * // Create the target Column family String createCF =
		 * "CREATE COLUMNFAMILY RegressionTest (keyname text PRIMARY KEY," +
		 * "bValue boolean, " + "iValue int " +
		 * ") WITH comparator = ascii AND default_validation = bigint;";
		 * 
		 * 
		 * stmt.execute(createCF); stmt.close(); con.close();
		 */
		// open it up again to see the new CF
		// con =
		// DriverManager.getConnection(String.format("jdbc:cassandra://%s:%d/%s",HOST,PORT,KEYSPACE));
		// System.out.println(con);
		return session;

	}

	public  void fillTestData(Session session2) {
		session.execute("INSERT INTO users (firstname, lastname, age, email, city) VALUES ('John', 'Smith', 46, 'johnsmith@email.com', 'Sacramento');");

		session.execute("INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Jane', 'Doe', 36, 'janedoe@email.com', 'Beverly Hills');");

		session.execute(" INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Rob', 'Byrne', 24, 'robbyrne@email.com', 'San Diego');");

	}

	public   void createTestSchema(Session session2) {
		// to-do
		// first we need to check if the schema exists or not
		// if it is exist drop it and create new one

		session.execute("CREATE KEYSPACE demo2 WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':1};");

		session.execute("USE demo2;");
		session.execute("CREATE TABLE users (" + "firstname text,"
				+ "lastname text," + "age int," + "email text," + "city text,"
				+ "PRIMARY KEY (lastname));");

	}

	public void close ()
	{
		try {
			if (session != null)
				if (!session.isClosed())
					session.close();
			if (cluster != null)
				if (!cluster.isClosed())
					cluster.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}