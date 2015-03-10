package bham.trasformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import metamodel.Database;
import metamodel.impl.DatabaseImpl;
import bham.transformation.model.Cell;
import bham.transformation.model.Column;
import bham.transformation.model.Constraint;
import bham.transformation.model.Reference;
import bham.transformation.model.Row;
import bham.transformation.model.Table;

public class DBTransformationService {

	static Connection conn = null;
	
	public Database generate(){
		String databaseName = "axw412_aam_spring";
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
		
		Database db = new DatabaseImpl();
		db.setName(databaseName);
		
		List<Table> tables = getTables(databaseName);
		db.setTable((EList)tables);
		
		if(tables != null){
			for(Table table : tables){
				System.out.println("------------------");
				System.out.println(table.getName());
				System.out.println("------------------");
				for(Column column : table.getColumns()){
					System.out.println(column.getName()
							+" "+column.getType()+" "
							+column.getSize()+" "
							+Boolean.toString(column.isNullable()));
				}
				
				System.out.println("Values: ");
				for(Row row : table.getRows()){
					for(Cell cell : row.getCells()){
						System.out.println(cell.getValue());
					}
					System.out.println("");
				}
				
				System.out.println("++++++++");
				System.out.println("Constraints: ");
				for(Constraint constraint : table.getConstraints()){
					System.out.println(constraint.getName());
					System.out.println(constraint.getType());
					System.out.println(constraint.getReference().getColumnName());
				}
			}
		} else {
			System.out.println("no tables found");
		}
		return db;
	}

	/** Read table from database **/
	protected List<Table> getTables(String databaseName){
		List<Table> tables = new ArrayList<Table>();
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
				
				/** get table rows & set into tables **/
				List<Row> rows = getRows(table);
				table.setRows(rows);
				
				/** get table constraints & set into tables **/
				List<Constraint> constraints = getConstraints(table);
				table.setConstraints(constraints);
				
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
	protected List<Column> getColumns(Table table){
		List<Column> columns = new ArrayList<Column>();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT "
					+ "column_name, data_type, character_maximum_length, is_nullable "
					+ "FROM information_schema.columns "
					+ "WHERE table_name = ?");
			st.setString(1, table.getName());
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				Column column = new Column();
				column.setName(rs.getString("column_name"));
				column.setType(rs.getString("data_type"));
				column.setSize(rs.getString("character_maximum_length"));
				column.setNullable(rs.getBoolean("is_nullable"));
				columns.add(column);
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
	
	protected List<Row> getRows(Table table){
		List<Row> rows = new ArrayList<Row>();
		List<Column> columns = table.getColumns();
		List<Cell> cells = new ArrayList<Cell>();
		Cell cell = null;
		try {
			PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) "
					+ "FROM "+table.getName()+"");
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				Row row = new Row();
				for(int index=0; index<rs.getInt(1); index++)
				{
					for(Column column : columns){
						cell = getCell(table, column, index);
						cells.add(cell);
					}
					
				}
				row.setCells(cells);
				rows.add(row);
			}
			rs.close();
			st.close();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected Cell getCell(Table table, Column column, int offset){
		Cell cell = new Cell();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT "+column.getName()
					+ " FROM "+table.getName()
					+ " LIMIT"+ 1 +" OFFSET "+offset);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				cell.setColumn(column);
				cell.setValue(rs.getString(1));
			}
			rs.close();
			st.close();
			return cell;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected List<Constraint> getConstraints(Table table){
		List<Constraint> constraints = new ArrayList<Constraint>();
		Reference reference = null;
		Constraint constraint = null;
		try {
			PreparedStatement st = conn.prepareStatement("SELECT constraint_name, constraint_type "
					+ "FROM information_schema.table_constraints "
					+ "WHERE table_name = ?");
			st.setString(1, table.getName());
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{
				reference = getReference(rs.getString("constraint_name"));
				constraint = new Constraint();
				constraint.setName(rs.getString("constraint_name"));
				constraint.setType(rs.getString("constraint_type"));
				constraint.setReferences(reference);
				constraints.add(constraint);
			}
			rs.close();
			st.close();
			return constraints;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected Reference getReference(String constraintName){
		Reference reference = new Reference();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT column_name "
					+ "FROM information_schema.constraint_column_usage "
					+ "WHERE constraint_name = ?");
			st.setString(1, constraintName);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				reference.setConstraintName(constraintName);
				reference.setColumnName(rs.getString("column_name"));
			}
			rs.close();
			st.close();
			return reference;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
