package bham.trasformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.Properties;

 

public class NoSQLConnection {

	private static  String HOST =  null;
    private static  String PORT = null ;
    private static  String KEYSPACE = "TestKS";
    private static  String CQLV3 = "3.0.0";
    private static String url = null;  
    private static java.sql.Connection con = null;
    private static Properties prop;

    public static Connection connect() throws Exception
    {
    	System.out.println("i'm here");
    	prop = new Properties();
    	Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
    	url = prop.getProperty("NoSQL.url");
    	HOST =  "localhost";// prop.getProperty("NoSQL.Host");
    	int PORT = 8888 ;// prop.getProperty("NoSQL.Port");   
    	
    	try { 
        	System.out.println("i'm here");

    	con = DriverManager.getConnection(String.format("jdbc:cassandra://localhost/8888/opscenter")); // %s:%d/%s",HOST,PORT,"system"));
    	System.out.println("i'm here");

    	Statement stmt = con.createStatement();
    	System.out.println(con);
    	/*        
    	String data="CREATE columnfamily news (key int primary key, category text , linkcounts int ,url text)";
        Statement st = con.createStatement();
        st.execute(data);
  */      
        //  Drop Keyspace
        String dropKS = String.format("DROP KEYSPACE %s;",KEYSPACE);
        
        stmt.execute(dropKS);
       
        
        // Create KeySpace
        String createKS = String.format("CREATE KEYSPACE %s WITH strategy_class = SimpleStrategy AND strategy_options:replication_factor = 1;",KEYSPACE);
        stmt = con.createStatement();
        stmt.execute(createKS); }
 catch (Exception e){// Exception on DROP is OK 
        	
        } 
        /* / Use Keyspace
        String useKS = String.format("USE %s;",KEYSPACE);
        stmt.execute(useKS);
        
        // Create the target Column family
        String createCF = "CREATE COLUMNFAMILY RegressionTest (keyname text PRIMARY KEY," 
                        + "bValue boolean, "
                        + "iValue int "
                        + ") WITH comparator = ascii AND default_validation = bigint;";
        
        
        stmt.execute(createCF);
        stmt.close();
        con.close();
*/
        // open it up again to see the new CF
  //      con = DriverManager.getConnection(String.format("jdbc:cassandra://%s:%d/%s",HOST,PORT,KEYSPACE));
  //      System.out.println(con);
		return con;

    }
     

}