/**
 * 
 */
package bham.trasformation.rules;

import metamodel.Constraint;
import metamodel.ConstraintType;
import metamodel.Table;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.PK;
import nosql.impl.ColumnFamilyImpl;
import nosql.impl.PKImpl;

import org.eclipse.emf.common.util.EList;

import bham.trasformation.Main;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;

/**
 * @author Manali
 * @modified by Zaina, Krishna
 */
public class Table2ColumnFamily implements Rule<Table, ColumnFamily> {

	public boolean check(Table source) {
		// TODO Auto-generated method stub
		return true;
	}

	public ColumnFamily build(Table source, Transformer t) {
		// TODO Auto-generated method stub
		ColumnFamily columnFamily = new ColumnFamilyImpl();
		return columnFamily;
	}

	public void setProperties(ColumnFamily target, Table source, Transformer t) {
		// TODO Auto-generated method stub
		try {
			// set the name of the column family
			target.setName(source.getName());
			target.setKeyspace(Main.mainKeySpace);
			// use for each loop to add the column and check it's constraints at
			// the same time.
			for (metamodel.Column col : source.getColumns()) {
				nosql.Column newCol = t.transform(SqlCol2NoSqlCol.class, col);
				newCol.setColumnFamily(target);
				checkConstraints(t, newCol, col);
				target.getColumns().add(newCol);

			}
			// target.setColumns((EList<Column>) t.transformAll(
			// SqlCol2NoSqlCol.class, source.getColumns()));

		} catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkConstraints(Transformer t, nosql.Column col,
			metamodel.Column sourceCol) {
		// to be impl by krishna
		// target.setPK(null);

		// for transforming rows
		// target.setRows(null);

		// get options from UI
		// target.setOptions(null);

		PK pkObj = null;
		for (Constraint constraint : sourceCol.getReferences()) {
			try {
				switch (constraint.getType().getValue()) {
				case ConstraintType.COMPOSITE_PRIMARY_KEY_VALUE:
					
					break;

				case ConstraintType.PRIMARY_KEY_VALUE:
					pkObj = new PKImpl();
					pkObj.getColumns().add(col);
					col.getColumnFamily().setPK(pkObj);
					break;
				case ConstraintType.UNIQUE_VALUE:
					// no corresponding implementation in Cassandra , not to be implemented
					break;

				case ConstraintType.FOREIGN_KEY_VALUE:

					// create new column family
					ColumnFamily ref = new ColumnFamilyImpl();
					// initialize the PK and set the reference table name
					pkObj = new PKImpl();

					// set the PK
					ref.setPK(pkObj);

					// add the column family to keyspace
					ref.setKeyspace(Main.mainKeySpace);

					// the assumption that each foreign key
					// should reference to one pk key in sql
					// but in case we have more than one pk in the reference
					for (metamodel.Column refCol : constraint.getReferences()) {

						// create primary key col.
						nosql.Column pkCol = new nosql.impl.ColumnImpl();
						// set properties
						pkCol.setDatatype(DatatypeMapping.getType(sourceCol
								.getType()));
						pkCol.setName(col.getName().concat("_")
								.concat(constraint.getName()));
						pkCol.setPK(true);
						pkCol.setSize(col.getSize());

						// add column to the family column.
						ref.getColumns().add(pkCol);
						// add the pkCol to pkObj list
						pkObj.getColumns().add(pkCol);

						// add the column to the column family
						pkCol.setColumnFamily(ref);

					}

					break;
				default:
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
