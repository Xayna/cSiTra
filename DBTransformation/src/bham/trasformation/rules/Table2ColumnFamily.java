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

import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;

/**
 * @author Manali
 * 
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
			target.setName(source.getName());
			target.setColumns((EList<Column>) t.transformAll(
					SqlCol2NoSqlCol.class, source.getColumns()));

			// to be impl by krishna
			// target.setPK(null);

			// for transforming rows
			// target.setRows(null);

			// get options from UI
			// target.setOptions(null);

			for (Constraint constraint : source.getConstraints()) {
				switch (constraint.getType().getValue()) {
				case ConstraintType.COMPOSITE_PRIMARY_KEY_VALUE:
					// to be implemented
					break;

				case ConstraintType.PRIMARY_KEY_VALUE:
					// to be implemented
					break;
				case ConstraintType.UNIQUE_VALUE:
					// to be implemented
					break;

				case ConstraintType.FOREIGN_KEY_VALUE:
					// create new column family
					ColumnFamily ref = new ColumnFamilyImpl();

					// initialize the PK and set the reference table name
					PK primeyKey = new PKImpl();
					
					// the assumption that each foreign key 
					// should reference to one pk key in sql
					// but in case we have more than one pk in the reference
					for (metamodel.Column col : constraint.getReferences()) {
						// the column name to primary key list
						primeyKey.getReference().add(col.getName());
						
						// create primary key col.
						nosql.Column pkCol = new nosql.impl.ColumnImpl();
						pkCol.setDatatype(DatatypeMapping.getType(col.getType()));
						pkCol.setName(col.getName());
						pkCol.setPK(true);
						pkCol.setSize(col.getSize());
						pkCol.setSth(ref);
						
						// add column to the family column.
						ref.getColumns().add(pkCol);
					}

					ref.setPK(primeyKey);
					break;
				default:
					break;
				}

			}
		} catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
