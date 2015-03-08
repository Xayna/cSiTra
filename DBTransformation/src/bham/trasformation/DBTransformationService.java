package bham.trasformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBTransformationService {

	static List<String> tables = null;
	static List<String> columns = null;
	static Connection conn = null;
	
	public static void main(String[] args){
		String databaseName = "axw412_aam";
		String url = "jdbc:postgresql://localhost/" + databaseName;
		Properties props = new Properties();
		props.setProperty("user","axw412");
		props.setProperty("password","Tembok1991");
		
		try {
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readTable(databaseName);
		
		for(String table: tables){
			System.out.println("Table name: "+table);
			readColumn(table);
			System.out.println("Column:");
			for(String column: columns){
				System.out.println(column);
			}
			System.out.println("====");
		}
		
		
	}
	public static void readTable(String databaseName){
		tables = new ArrayList<String>();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT table_name "
					+ "FROM information_schema.tables "
					+ "WHERE table_schema = 'public'"
					+ "ORDER BY table_name");
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				tables.add(rs.getString("table_name"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readColumn(String tableName){
		columns = new ArrayList<String>();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT column_name "
					+ "FROM information_schema.columns "
					+ "WHERE table_name = ?");
			st.setString(1, tableName);
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				columns.add(rs.getString("column_name"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
