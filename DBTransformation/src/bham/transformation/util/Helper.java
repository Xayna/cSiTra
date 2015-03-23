package bham.transformation.util;

public class Helper {
	
	// Sql db properties
	public static final String NEW_PROPERTIES_FILE_NAME = "newdatabase.properties";
	public static final String PROPERTIES_FILE_NAME = "database.properties";
	public static final String DB_NAME_PROP = "database.name";
	public static final String DB_DRIVER_PROP = "jdbc.drivers";
	public static final String DB_USER_NAME_PROP = "database.user";
	public static final String DB_PASSWORD_PROP = "database.password";
	public static final String DB_SCHEMA_PROP = "database.schema";
	public static final String DB_URL = "database.url";
	// this should be dynamic ,used as  static for testing only
	public static final String TEMP_FILE_PATH = "src/bham/transformation/";	
	public static final String GET_DB_USER_NAME = "Enter your database username:";
	public static final String GET_DB_USER_PASS = "Enter your database password:";
	public static final String GET_DB_URL = "Enter your database URL:";
	public static final String GET_DB_NAME = "Enter your database name:";
	public static final String GET_DB_SCHEMA = "Enter your database schema:";
	public static final String GET_DB_DRIVER = "Enter your database driver:";
	//no sql db properties
	public static final String NDB_HOST_PROP = "NoSQL.Host";
	public static final String NDB_PORT_PROP = "NoSQL.Port";
	public static final Object GET_NDB_HOST = "Enter cassandra db host address:";
	public static final Object GET_NDB_PORT = "Enter cassandra db port:";
	

}
