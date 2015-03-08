/**
 * 
 */
package bham.trasformation.rules;

import metamodel.Table;
import nosql.ColumnFamily;
import nosql.impl.ColumnFamilyImpl;
import uk.ac.bham.sitra.Rule;
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
		target.setName(source.getName());
		//target.setPK();
		//get options from UI
		//target.setOptions(null);
		
	}

}
