package bham.trasformation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metamodel.Cell;
import metamodel.Column;
import metamodel.Constraint;
import metamodel.ConstraintType;
import metamodel.Database;
import metamodel.Datatype;
import metamodel.Row;
import metamodel.Table;
import metamodel.impl.CellImpl;
import metamodel.impl.ColumnImpl;
import metamodel.impl.ConstraintImpl;
import metamodel.impl.DatabaseImpl;
import metamodel.impl.RowImpl;
import metamodel.impl.TableImpl;

import org.eclipse.emf.common.util.EList;

public class DBTransformationService {

	Connection conn = null;
	String schemaName = null;
	DBConnection dbConnection = null;
	@SuppressWarnings("finally")
	public Database generate() throws SQLException {
		/*String databaseName = "postgres";
		 schemaName ="zxm491";
		String url = "jdbc:postgresql://localhost/" + databaseName;
		// dev.mysql.com/doc/employee/en
		Properties props = new Properties();
		props.setProperty("user", "zxm491");
		props.setProperty("password", "zxm491");
		*/
		Database db = new DatabaseImpl();
		try {
			dbConnection = new DBConnection();
			conn =dbConnection.connect();
			
			schemaName = dbConnection.getProps().getProperty(DBConnection.DB_SCHEMA_PROP);
			db.setName(dbConnection.getProps().getProperty(DBConnection.DB_NAME_PROP));

			getTables(db);

			if (db.getTable() != null) {
				for (Table table : db.getTable()) {
					System.out.println("------------------");
					System.out.println(table.getName());
					System.out.println("------------------");
					for (metamodel.Column column : table.getColumns()) {
						System.out.println(column.getName() + " "
								+ column.getType() + " " + column.getSize()
								+ " " + Boolean.toString(column.isNullable()));
					}

					System.out.println("Values: ");
					for (Row row : table.getRows()) {
						for (metamodel.Cell cell : row.getCells()) {
							System.out.println(cell.getValue()+"\t");
						}
						System.out.println("");
					}
					for(Constraint con: table.getConstraints()){
						System.out.print(con.getName()+" with type "+con.getType() +" on");
						for(metamodel.Column col: con.getReferences()){
							System.out.print(col.getName()+", ");
						}
						System.out.print("\nReference: Table: "+con.getReferenceTable().getName()+ "( "+con.getReferenceTable().getColumns().get(0).getName()+" )\n\n");
					}

					/*
					 * System.out.println("++++++++");
					 * System.out.println("Constraints: "); for(Constraint
					 * constraint : table.getConstraints()){
					 * System.out.println(constraint.getName());
					 * System.out.println(constraint.getType());
					 * System.out.println(constraint.getReferenceTable()); }
					 */
				}
			} else {
				System.out.println("no tables found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnection.close();
			return db;
		}

	}

	/**
	 * Read table from database
	 * 
	 * @param db
	 * @throws SQLException 
	 **/
	protected void getTables(Database db) throws SQLException {
		EList<Table> tables = db.getTable();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT table_name "
					+ "FROM information_schema.tables "
					+ "WHERE table_schema = '"+ schemaName +"'" + "ORDER BY table_name");
			rs = st.executeQuery();
			while (rs.next()) {
				TableImpl table = new TableImpl();
				
				/** set table name & set its columns **/
				table.setName(rs.getString("table_name"));
				getColumns(table, null, false);

				/** get table rows & set into tables **/
				getRows(table);

				/** get table constraints & set into tables **/
				getTableKeys(table);

				tables.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			rs.close();
			st.close();
		}
	}

	/** Read column from database 
	 * @throws SQLException **/
	protected void getColumns(TableImpl table, String columnName, boolean oneColumn) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			if(!oneColumn){
				st = conn.prepareStatement("SELECT "
						+ "column_name, data_type, character_maximum_length, is_nullable "
						+ "FROM information_schema.columns "
						+ "WHERE table_name = ?");
				st.setString(1, table.getName());
			} else {
				st = conn.prepareStatement("SELECT "
						+ "column_name, data_type, character_maximum_length, is_nullable "
						+ "FROM information_schema.columns "
						+ "WHERE table_name = ? AND column_name = ?");
				st.setString(1, table.getName());
				st.setString(2, columnName);
			}
			rs = st.executeQuery();
			while (rs.next()) {

				Column column = new ColumnImpl();
				column.setName(rs.getString("column_name"));
				switch (rs.getString("data_type").toLowerCase()) {
				case "int":
					column.setType(Datatype.INT);
					break;
				case "bigint":
					column.setType(Datatype.BIGINT);
					break;
				case "boolean":
					column.setType(Datatype.BOOLEAN);
					break;
				case "blob":
					column.setType(Datatype.BLOB);
					break;
				case "char":
					column.setType(Datatype.CHAR);
					break;
				case "date":
					column.setType(Datatype.DATE);
					break;
				case "datetime":
					column.setType(Datatype.DATETIME);
					break;
				case "decimal":
					column.setType(Datatype.DECIMAL);
					break;
				case "double":
					column.setType(Datatype.DOUBLE);
					break;
				case "float":
					column.setType(Datatype.FLOAT);
					break;
				case "longtext":
					column.setType(Datatype.LONGTEXT);
					break;
				case "smallint":
					column.setType(Datatype.SMALLINT);
					break;
				case "string":
					column.setType(Datatype.STRING);
					break;
				case "text":
					column.setType(Datatype.TEXT);
					break;
				case "timestamp":
					column.setType(Datatype.TIMESTAMP);
					break;
				case "tinytext":
					column.setType(Datatype.TINYTEXT);
					break;
				case "varchar":
					column.setType(Datatype.VARCHAR);
					break;
				}

				column.setSize(rs.getString("character_maximum_length"));
				column.setNullable(rs.getBoolean("is_nullable"));
				table.getColumns().add(column);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
		}
	}

	protected void getRows(TableImpl table) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Cell cell = null;
		EList<Column> cols = table.getColumns();
		try {
			st = conn.prepareStatement("SELECT *" + "FROM "
					+ table.getName() + "");
			rs = st.executeQuery();
			while (rs.next()) {

				Row row = new RowImpl();
				for (Column col : cols) {
					cell = new CellImpl();
					cell.setValue(rs.getString(col.getName()));
					cell.setColumn(col);
					row.getCells().add(cell);
				}
				table.getRows().add(row);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
		}
	}

	

	public void getTableKeys(TableImpl table) throws SQLException {
		DatabaseMetaData metaData = null;
		ResultSet keys = null;
		try {
			metaData = conn.getMetaData();
			keys = metaData.getImportedKeys(conn.getCatalog(), null,
					table.getName());

			while (keys.next()) {
				
				Constraint cons = new ConstraintImpl();
				String fkName = keys.getString("FK_NAME");
				String fkTableName = keys.getString("FKTABLE_NAME");
				String fkColumnName = keys.getString("FKCOLUMN_NAME");
				String pkTableName = keys.getString("PKTABLE_NAME");
				String pkColumnName = keys.getString("PKCOLUMN_NAME");
				System.out.println();
				System.out
				.println("--------------------Foreign KEY Constraints-----------------");
				System.out
				.println("FKTableName.FKColumn -> PKTableName.PKColumn");
				System.out.println(fkTableName + "." + fkColumnName + " -> "
						+ pkTableName + "." + pkColumnName);

				cons.setName(fkName);
				cons.setType(ConstraintType.FOREIGN_KEY);
				TableImpl refTable = new TableImpl();
				refTable.setName(pkTableName);
				getColumns(refTable, pkColumnName, true);
				cons.setReferenceTable(refTable);
				for(Column col:table.getColumns()){
					if(col.getName().equalsIgnoreCase(fkColumnName)){
						cons.getReferences().add(col);
						col.getReferences().add(cons);
						break;
					}
				}
				table.getConstraints().add(cons);
			}
			keys.close();

			keys = metaData.getPrimaryKeys(conn.getCatalog(), null,
					table.getName());
			while (keys.next()) {

				Constraint cons = new ConstraintImpl();
				String pkName = keys.getString("PK_NAME");
				String pkColumnName = keys.getString("COLUMN_NAME");
				System.out.println();
				System.out.println("--------------------Primary key Constraints-----------------");
				System.out.println("PKName.PKColumn");
				System.out.println(pkName + "." + pkColumnName);

				cons.setName(pkName);
				cons.setType(ConstraintType.PRIMARY_KEY);
				for(Column col:table.getColumns()){
					if(col.getName().equalsIgnoreCase(pkColumnName)){
						cons.getReferences().add(col);
						col.getReferences().add(cons);
						break;
					}
				}
				table.getConstraints().add(cons);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			keys.close();

		}
	}
	
}

/*
 * PreparedStatement st =
 * conn.prepareStatement("SELECT constraint_name, constraint_type " +
 * "FROM information_schema.table_constraints " + "WHERE table_name = ?");
 * st.setString(1, table.getName()); ResultSet rs = st.executeQuery(); while
 * (rs.next()) { constraint = new ConstraintImpl();
 * constraint.setName(rs.getString("constraint_name"));
 * switch(rs.getString("constraint_type").toLowerCase()) { case "int" :
 * constraint.setType(ConstraintType.FOREIGN_KEY); break; case "bigint" :
 * constraint.setType(ConstraintType.UNIQUE); break; case "boolean" :
 * constraint.setType(ConstraintType.COMPOSITE_PRIMARY_KEY); break; case "blob"
 * : constraint.setType(ConstraintType.PRIMARY_KEY); break; }
 * constraint.setReferenceTable(table); constraints.add(constraint); }
 * rs.close(); st.close();
 */
/*
 * protected Cell getCell(TableImpl table, Column column, int offset){ Cell
 * cell = new CellImpl(); try { PreparedStatement st =
 * conn.prepareStatement("SELECT "+column.getName() +
 * " FROM "+table.getName() + " LIMIT"+ 1 +" OFFSET "+offset); ResultSet rs
 * = st.executeQuery(); if (rs.next()) { cell.setColumn(column);
 * cell.setValue(rs.getString(1)); } rs.close(); st.close(); return cell; }
 * catch (SQLException e) { e.printStackTrace(); } return null; }
 

protected Reference getReference(String constraintName) {
	Reference reference = new Reference();
	try {
		PreparedStatement st = conn.prepareStatement("SELECT column_name "
				+ "FROM information_schema.constraint_column_usage "
				+ "WHERE constraint_name = ?");
		st.setString(1, constraintName);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			reference.setConstraintName(constraintName);
			reference.setColumnName(rs.getString("column_name"));
		}
		rs.close();
		st.close();
		return reference;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
*/