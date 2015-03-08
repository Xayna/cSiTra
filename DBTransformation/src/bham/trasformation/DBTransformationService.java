package bham.trasformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import bham.transformation.model.Column;
import bham.transformation.model.Table;

public class DBTransformationService {

	static List<Table> tables = null;
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
		
		getTables(databaseName);
		
	}

	/** Read table from database **/
	public static List<Table> getTables(String databaseName){
		tables = new ArrayList<Table>();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT table_name "
					+ "FROM information_schema.tables "
					+ "WHERE table_schema = 'public'"
					+ "ORDER BY table_name");
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				Table table = new Table();
				
				/** set table name **/
				table.setName(rs.getString("table_name"));
				
				/** get table columns & set into tables **/
				List<Column> columns = getColumns(table);
				table.setColumns(columns);
				
				tables.add(table);
			}
			rs.close();
			st.close();
			return tables;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/** Read column from database **/
	public static List<Column> getColumns(Table tableName){
		List<Column> columns = new ArrayList<Column>();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT column_name, data_type, character_maximum_length, is_nullable "
					+ "FROM information_schema.columns "
					+ "WHERE table_name = ?");
			st.setString(1, tableName.getName());
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				Column column = new Column();
				column.setName(rs.getString("column_name"));
				column.setType(rs.getString("data_type"));
				column.setSize(rs.getString("character_maximum_length"));
				column.setNullable(rs.getBoolean("is_nullable"));
			}
			rs.close();
			st.close();
			return columns;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
