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
	String serverName = null;

	DBConnection dbConnection = null;

	/*
	 * @return database , sql database meta model object
	 */
	@SuppressWarnings("finally")
	public Database generate() throws SQLException {

		// initialize database
		Database db = new DatabaseImpl();
		try {
			// connecting to sql database
			dbConnection = new DBConnection();
			conn = dbConnection.connect();

			// geting db properties
			schemaName = dbConnection.getProps().getProperty(
					DBConnection.DB_SCHEMA_PROP);
			serverName = conn.getCatalog();

			db.setName(schemaName);
			System.out.println("MY SCHEMA :" + schemaName);
			getTables(db);

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
			st = conn
					.prepareStatement("SELECT table_name "
							+ "FROM information_schema.tables "
							+ "WHERE table_schema = ? AND table_catalog = ? ORDER BY table_name");
			st.setString(1, schemaName);
			st.setString(2, serverName);

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

				/** add the table **/
				tables.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
		}
	}

	/**
	 * Read column from database
	 * 
	 * @throws SQLException
	 **/
	protected void getColumns(TableImpl table, String columnName,
			boolean oneColumn) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// selecting info for multiple columns
			if (!oneColumn) {
				st = conn
						.prepareStatement("SELECT "
								+ "column_name, data_type, character_maximum_length, is_nullable "
								+ "FROM information_schema.columns "
								+ "WHERE table_name = ? "
								+ "AND table_schema = ? "
								+ "AND table_catalog = ? ");
				st.setString(1, table.getName());
				st.setString(2, schemaName);
				st.setString(3, serverName);
			} else {
				// selecting info for specific columns
				st = conn
						.prepareStatement("SELECT "
								+ "column_name, data_type, character_maximum_length, is_nullable "
								+ "FROM information_schema.columns "
								+ "WHERE table_name = ? AND column_name = ?"
								+ "AND table_schema = ? "
								+ "AND table_catalog = ? ");
				st.setString(1, table.getName());
				st.setString(2, columnName);
				st.setString(3, schemaName);
				st.setString(4, serverName);
			}

			// executing and read values
			rs = st.executeQuery();
			while (rs.next()) {

				// creating new column
				Column column = new ColumnImpl();
				column.setName(rs.getString("column_name"));
				switch (rs.getString("data_type").toLowerCase()) {
				case "int":
				case "integer":
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
				default:
					column.setType(Datatype.TEXT);
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

	/*
	 * 
	 * Read rows in table
	 * @throws SQLException
	 */
	protected void getRows(TableImpl table) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Cell cell = null;
		//get list of columns
		EList<Column> cols = table.getColumns();
		try {
			//getting data within a table
			st = conn.prepareStatement("SELECT * " + "FROM " + schemaName + "."
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

	/*
	 * Get FK and PK for the given table
	 * @param table
	 * @return 
	 */
	public void getTableKeys(TableImpl table) throws SQLException {
		DatabaseMetaData metaData = null;
		ResultSet keys = null;
		try {
			// getting database meta data
			metaData = conn.getMetaData();
			
			//get foreign key
			keys = metaData.getImportedKeys(conn.getCatalog(), schemaName,
					table.getName());

			//creating table for each fk constraint
			while (keys.next()) {
				//create new constraint object
				Constraint cons = new ConstraintImpl();
				String fkName = keys.getString("FK_NAME");
				String fkTableName = keys.getString("FKTABLE_NAME");
				String fkColumnName = keys.getString("FKCOLUMN_NAME");
				String pkTableName = keys.getString("PKTABLE_NAME");
				String pkColumnName = keys.getString("PKCOLUMN_NAME");
				cons.setName(fkName);
				cons.setType(ConstraintType.FOREIGN_KEY);

				//create new table for the constraint
				TableImpl refTable = new TableImpl();
				refTable.setName(pkTableName);
				getColumns(refTable, pkColumnName, true);
				cons.setReferenceTable(refTable);
				// System.out.println("!!!!!!!!!!!!!!");
				Column tempCol = getColumnByName(table, fkColumnName);
				if (tempCol != null) {
					cons.getReferences().add(tempCol);

					table.getConstraints().add(cons);
					int index = 0;
					if (table.getColumns().contains(tempCol)) {
						index = table.getColumns().indexOf(tempCol);
						table.getColumns().remove(tempCol);
					}
					tempCol.getReferences().add(cons);

					table.getColumns().add(index, tempCol);
				}
				// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+cons.getReferences().size());
			}
			keys.close();

			keys = metaData.getPrimaryKeys(conn.getCatalog(), schemaName,
					table.getName());
			while (keys.next()) {

				String pkName = keys.getString("PK_NAME");
				String pkColumnName = keys.getString("COLUMN_NAME");
				/*
				 * System.out.println(); System.out.println(
				 * "--------------------Primary key Constraints-----------------"
				 * ); System.out.println("PKName.PKColumn");
				 * System.out.println(pkName + "." + pkColumnName);
				 * 
				 * System.out.println("getTablekey  at the middle: # of col" +
				 * table.getColumns().size());
				 */
				Column tempCol = getColumnByName(table, pkColumnName);
				if (tempCol != null) {
					Constraint cons = new ConstraintImpl();
					cons.setName(pkName);
					cons.setType(ConstraintType.PRIMARY_KEY);
					cons.getReferences().add(tempCol);

					table.getConstraints().add(cons);
					int index = 0;
					if (table.getColumns().contains(tempCol)) {
						index = table.getColumns().indexOf(tempCol);
						table.getColumns().remove(tempCol);
					}
					tempCol.getReferences().add(cons);

					table.getColumns().add(index, tempCol);

				}
				/*
				 * for(Column col:table.getColumns()){
				 * if(col.getName().equalsIgnoreCase(pkColumnName)){
				 * System.out.println("inside pk adding it cons and col "+
				 * pkColumnName); cons.getReferences().add(col);
				 * col.getReferences().add(cons);
				 * 
				 * System.out.println("inside pk adding it cons and col "+
				 * pkColumnName);
				 * 
				 * break; } }
				 */

				// System.out.println("getTablekey  at the end: # of col" +
				// table.getColumns().size());

			}
		} catch (SQLException e) {
			System.err.println("ERROR!");
			e.printStackTrace();
		} finally {
			keys.close();

		}
	}

	/*
	 * Get column object from the given table and column name
	 * @param table
	 * @param name, column name
	 * @return Column
	 */
	private Column getColumnByName(Table table, String name) {
		Column temp = null;
		for (Column col : table.getColumns()) {
			if (col.getName().equalsIgnoreCase(name)) {
				temp = col;
				break;
			}
		}
		return temp;

	}

}

