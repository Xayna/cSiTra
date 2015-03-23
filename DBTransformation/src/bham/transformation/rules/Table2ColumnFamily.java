/**
 * 
 */
package bham.transformation.rules;

import java.util.Date;

import metamodel.Constraint;
import metamodel.ConstraintType;
import metamodel.Table;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.PK;
import nosql.impl.ColumnFamilyImpl;
import nosql.impl.PKImpl;

import org.eclipse.emf.common.util.EList;

import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;
import bham.transformation.Main;

/**
 * @author Manali
 * @modified by Zaina, Krishna
 */

/*
 * Mapping sql table into nosql table
 */
public class Table2ColumnFamily implements Rule<Table, ColumnFamily> {

	public boolean check(Table source) {
		return true;
	}

	public ColumnFamily build(Table source, Transformer t) {
		// Create ColumnFamily object
		ColumnFamily columnFamily = new ColumnFamilyImpl();
		return columnFamily;
	}

	@SuppressWarnings("unchecked")
	public void setProperties(ColumnFamily target, Table source, Transformer t) {
		try {
			// initializing ColumnFamily
			Main.times.add(System.currentTimeMillis());
			Main.totalTime = 0;
			System.out.println("\nTransforming table: " + source.getName());
			target.setName(source.getName());
			target.setKeyspace(Main.mainKeySpace);

			// transfare sql columns into nosql Columns
			for (metamodel.Column col : source.getColumns()) {
				// transfer
				nosql.Column newCol = t.transform(SqlCol2NoSqlCol.class, col);
				// set the columnfamily for this column
				newCol.setColumnFamily(target);
				// add the new column to columnfamily
				target.getColumns().add(newCol);

				// add constraints
				checkConstraints(t, newCol, col);

			}
			Main.times.add(System.currentTimeMillis());
			System.out.println(Main.calTimeDiff(true) + " ms Columns and constraints transformed.");
			// fill data
			fillData(source, target);
			Main.times.add(System.currentTimeMillis());
			System.out.println(Main.calTimeDiff(true) + " ms Data filled( with FK table, if present).");
			System.out.println(Main.totalTime + " ms " + target.getName() + " column family transformed.");
		} catch (RuleNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Map sql constraints into nosql constrains
	 * 
	 * @param Transformer,
	 * 
	 * @param targetCol, nosql col to apply the constrains
	 * 
	 * @param sourceCol , sql column to get related constrains from
	 */
	@SuppressWarnings("unchecked")
	private void checkConstraints(Transformer t, nosql.Column targetCol, metamodel.Column sourceCol) {

		PK pkObj;
		for (Constraint constraint : sourceCol.getReferences()) {
			try {
				switch (constraint.getType().getValue()) {

				case ConstraintType.PRIMARY_KEY_VALUE:
					// check if there is a previous pk object added before
					if (targetCol.getColumnFamily().getPK() == null)
						// initiate new pk object
						pkObj = new PKImpl();
					else
						// we have a composite pk object
						pkObj = targetCol.getColumnFamily().getPK();
					// Add the column to the pk columns list
					pkObj.getColumns().add(targetCol);
					// set the column family pk
					targetCol.getColumnFamily().setPK(pkObj);

					break;
				case ConstraintType.UNIQUE_VALUE:
					System.out.println("Cassandra does not support UNIQUE contraint");
					break;

				case ConstraintType.FOREIGN_KEY_VALUE:
					// create new column family
					ColumnFamily ref = new ColumnFamilyImpl();
					ref.setName(constraint.getReferenceTable().getName() + "_" + targetCol.getColumnFamily().getName());
					// initialize the PK and set the reference table name
					pkObj = new PKImpl();
					// create primary key col.
					nosql.Column pkCol = (nosql.Column) t.transform(SqlCol2NoSqlCol.class, constraint.getReferenceTable().getColumns().get(0));
					pkCol.setName(constraint.getReferenceTable().getName() + "_" + pkCol.getName());
					// add column to the family column.
					ref.getColumns().add(pkCol);
					// add the pkCol to pkObj list
					pkObj.getColumns().add(pkCol);
					// add the column to the column family
					pkCol.setColumnFamily(ref);
					// set the PK
					ref.setPK(pkObj);
					// add comment
					ref.setComment("Reference Table for Foreign Key");
					// add the column family to keyspace
					Main.mainKeySpace.getFamilies().add(ref);
					ref.setKeyspace(Main.mainKeySpace);
					Main.times.add(System.currentTimeMillis());
					System.out.println(Main.calTimeDiff(false) + " ms " + ref.getName() + " Foreign Key table added.");
					Main.times.remove(Main.times.size() - 1);
					break;
				default:
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/*
	 * Fill ColumnFamily with the corresponding data from sql table
	 */

	@SuppressWarnings("unchecked")
	public ColumnFamily fillData(Table table, ColumnFamily colFamily) {
		// geting sql rows from sql tabel
		for (metamodel.Row sqlRow : table.getRows()) {
			// create corresponding nosql row
			nosql.Row noSqlRow = new nosql.impl.RowImpl();
			noSqlRow.setComment(colFamily.getComment());
			noSqlRow.setKeyspace(colFamily.getKeyspace());
			noSqlRow.setName(colFamily.getName());

			// get cells form sql row
			for (metamodel.Cell sqlCell : sqlRow.getCells()) {
				// create the corresponding nosql cell
				nosql.Cell noSqlCell = new nosql.impl.CellImpl();
				noSqlCell.setValue(sqlCell.getValue());
				noSqlCell.setColumn(getNoSqlColumn(colFamily.getColumns(), sqlCell.getColumn().getName()));
				// add the cell to the nosql row
				noSqlRow.getCells().add(noSqlCell);
			}
			// add the row to the columnfamily
			colFamily.getRows().add(noSqlRow);

			// map the cells to the right columns
			AddFKCellData(table.getColumns(), noSqlRow.getCells(), table.getName(), colFamily.getPK());
			/*
			 * for (metamodel.Column col : table.getColumns()) {
			 * 
			 * for (Constraint cons : col.getReferences()) { if (cons.getType()
			 * == ConstraintType.FOREIGN_KEY) { ColumnFamily refTable =
			 * getColumnFamily(cons .getReferenceTable().getName() + "_" +
			 * table.getName()); if (refTable == null) System.err
			 * .println("FOREIGN KEY REFERENCE TABLE NOT FOUND!!"); else {
			 * String refValue = getCell(noSqlRow.getCells(),
			 * col.getName()).getValue();
			 * 
			 * boolean present = false; nosql.Row refTableRow = null,
			 * oldRefTableRow=null; for (nosql.Row rows : (EList<nosql.Row>)
			 * refTable .getRows()) { if (getCell( rows.getCells(),
			 * ((nosql.Column) refTable.getPK() .getColumns().get(0)).getName())
			 * .getValue().equals(refValue)) { present = true; refTableRow =
			 * rows; oldRefTableRow = rows; break; } } if (!present) {
			 * refTableRow = new nosql.impl.RowImpl();
			 * refTableRow.setKeyspace(refTable.getKeyspace());
			 * refTableRow.setName(refTable.getName()); //
			 * refTableRow.setPK(refTable.getPK());
			 * 
			 * nosql.Cell refTablePKCell = new nosql.impl.CellImpl();
			 * refTablePKCell.setValue(refValue); refTablePKCell
			 * .setColumn((nosql.Column) refTable .getPK().getColumns().get(0));
			 * refTableRow.getCells().add(refTablePKCell); }
			 * 
			 * nosql.Column refTableCol = new nosql.impl.ColumnImpl();
			 * refTableCol.setColumnFamily(refTableRow); refTableCol
			 * .setDatatype(((nosql.Column) colFamily
			 * .getPK().getColumns().get(0)) .getDatatype());
			 * refTableCol.setSize(((nosql.Column) colFamily
			 * .getPK().getColumns().get(0)).getSize());
			 * refTableCol.setName(((nosql.Column) colFamily
			 * .getPK().getColumns().get(0)).getName());
			 * 
			 * refTableRow.getAdditionalColumns().add(refTableCol);
			 * 
			 * nosql.Cell refTableCell = new nosql.impl.CellImpl();
			 * refTableCell.setValue(getCell( noSqlRow.getCells(),
			 * ((nosql.Column) colFamily.getPK()
			 * .getColumns().get(0)).getName()) .getValue());
			 * refTableCell.setColumn(refTableCol);
			 * refTableRow.getCells().add(refTableCell);
			 * 
			 * if(oldRefTableRow!=null)
			 * refTable.getRows().remove(oldRefTableRow);
			 * refTable.getRows().add(refTableRow);
			 * refTable.getColumns().add(refTableCol);
			 * 
			 * Main.colNameCounter++;
			 * 
			 * } } } }
			 */
		}
		return colFamily;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void AddFKCellData(EList<metamodel.Column> columns, EList cells, String name, PK pk) {
		// check if the col get FK reference
		for (metamodel.Column col : columns) {

			for (Constraint cons : col.getReferences()) {
				if (cons.getType() == ConstraintType.FOREIGN_KEY) {
					// get the corresponding fk nosql table
					ColumnFamily refTable = getColumnFamily(cons.getReferenceTable().getName() + "_" + name);
					if (refTable == null) {
						System.err.println("FOREIGN KEY REFERENCE TABLE NOT FOUND!!");
						return;
					}
					// get value
					Object refValue = getCell(cells, col.getName()).getValue();

					nosql.Row refTableRow = null, oldRefTableRow = null;
					// get the related nosql row if exist
					for (nosql.Row rows : (EList<nosql.Row>) refTable.getRows()) {
						if (getCell(rows.getCells(), ((nosql.Column) refTable.getPK().getColumns().get(0)).getName()).getValue().equals(refValue)) {

							refTableRow = rows;
							oldRefTableRow = rows;
							break;
						}
					}
					if (refTableRow == null) {
						// create new row
						refTableRow = new nosql.impl.RowImpl();
						refTableRow.setKeyspace(refTable.getKeyspace());
						refTableRow.setName(refTable.getName());

						// create new cell
						nosql.Cell refTablePKCell = new nosql.impl.CellImpl();
						refTablePKCell.setValue(refValue);
						refTablePKCell.setColumn((nosql.Column) refTable.getPK().getColumns().get(0));
						refTableRow.getCells().add(refTablePKCell);
					}
					// create new column
					nosql.Column refTableCol = new nosql.impl.ColumnImpl();
					refTableCol.setColumnFamily(refTableRow);
					refTableCol.setDatatype(((nosql.Column) pk.getColumns().get(0)).getDatatype());
					refTableCol.setSize(((nosql.Column) pk.getColumns().get(0)).getSize());
					refTableCol.setName(((nosql.Column) pk.getColumns().get(0)).getName());
					// add the new column to the row
					refTableRow.getAdditionalColumns().add(refTableCol);
					// create new cell
					nosql.Cell refTableCell = new nosql.impl.CellImpl();
					refTableCell.setValue(getCell(cells, ((nosql.Column) pk.getColumns().get(0)).getName()).getValue());
					refTableCell.setColumn(refTableCol);
					// add the cell to the row
					refTableRow.getCells().add(refTableCell);
					// add the row to the table
					if (oldRefTableRow != null)
						refTable.getRows().remove(oldRefTableRow);
					refTable.getRows().add(refTableRow);
					refTable.getColumns().add(refTableCol);

				}
			}
		}

	}

	/*
	 * Get noSql column by name
	 * 
	 * @param columns, Elist of nosql columns
	 * 
	 * @param name, name of the column
	 * 
	 * @return column
	 */
	@SuppressWarnings("rawtypes")
	private Column getNoSqlColumn(EList columns, String name) {
		for (Object object : columns) {
			if (((Column) object).getName().equalsIgnoreCase(name))
				return (Column) object;
		}
		return null;
	}

	/*
	 * Get columnfamily by name
	 * 
	 * @param name, name of the columnfamily
	 * 
	 * @retun ColumnFamily
	 */
	private ColumnFamily getColumnFamily(String name) {
		for (Object object : Main.mainKeySpace.getFamilies()) {
			if (((ColumnFamily) object).getName().equalsIgnoreCase(name))
				return (ColumnFamily) object;
		}
		return null;
	}

	/*
	 * Get cell object by name
	 * 
	 * @param cells, list of Elist of cells objects
	 * 
	 * @param name, name of the cell
	 * 
	 * @return Cell
	 */
	@SuppressWarnings("rawtypes")
	private nosql.Cell getCell(EList cells, String name) {

		for (Object object : cells) {
			if (((nosql.Cell) object).getColumn().getName().equalsIgnoreCase(name))
				return (nosql.Cell) object;
		}
		return null;
	}

}
