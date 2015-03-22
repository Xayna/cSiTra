package bham.transformation;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import bham.transformation.util.Helper;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class NoSQLConnection {


	private String host;
	private String port;
	private  Cluster cluster ;
	private  Session session ;
	
	Properties props;
	
	/*
	 * Default Constructor 
	 */
	public NoSQLConnection ()
	{
		try {
			// Load in Database properties from file
			props = new Properties();
			
			// try to load the last saved properties
			InputStream in = DBConnection.class
					.getResourceAsStream(Helper.NEW_PROPERTIES_FILE_NAME);

			// if no new properties exists load the default ones
			if (in == null) {
					System.err
							.println("Error: Failed to find the \"newdatabase.properties\" file. Note that it must be ");
					System.err
							.println("in the same directory as Main.class and that the name is case sensitive");
					System.exit(1);
				
			}
	
			props.load(in);
			
			host = props.getProperty(Helper.NDB_HOST_PROP);
			port = props.getProperty(Helper.NDB_PORT_PROP);
			// close stream
			in.close();
			
			if (host == null || host.isEmpty()) 
			{
				System.out.println("No host is provided");
				System.exit(1);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public  Session connect() throws Exception {
		try {
			//connect to db cluster
			cluster = Cluster.builder().addContactPoint(host).build();
			session = cluster.connect();
			Metadata metadata = cluster.getMetadata();
			System.out.printf("Connected to cluster: %s\n",
					metadata.getClusterName());
			for (Host host : metadata.getAllHosts()) {
				System.out
						.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
								host.getDatacenter(), host.getAddress(),
								host.getRack());
			}

		
		} catch (Exception e) {
			System.err.println("Connecting error....");
			e.printStackTrace();
			System.exit(1);
		} 
		
		return session;

	}

	/*
	 * Fill dummy data for testing 
	 */
	public  void fillTestData(Session session2) {
		session.execute("INSERT INTO users (firstname, lastname, age, email, city) VALUES ('John', 'Smith', 46, 'johnsmith@email.com', 'Sacramento');");

		session.execute("INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Jane', 'Doe', 36, 'janedoe@email.com', 'Beverly Hills');");

		session.execute(" INSERT INTO users (firstname, lastname, age, email, city) VALUES ('Rob', 'Byrne', 24, 'robbyrne@email.com', 'San Diego');");

	}

	/*
	 * create dummy schema for testing 
	 */
	public   void createTestSchema(Session session2) {
		session.execute("CREATE KEYSPACE demo2 WITH replication "
				+ "= {'class':'SimpleStrategy', 'replication_factor':1};");

		session.execute("USE demo2;");
		session.execute("CREATE TABLE users (" + "firstname text,"
				+ "lastname text," + "age int," + "email text," + "city text,"
				+ "PRIMARY KEY (lastname));");

	}

	/*
	 * Close session and cluster connection
	 */
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