/**
 * 
 */
package bham.trasformation.rules;

import metamodel.Table;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.impl.ColumnFamilyImpl;

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
			target.setColumns((EList<Column>)t.transformAll(SqlCol2NoSqlCol.class, source.getColumns()));
			
			//to be impl by krishna
			//target.setPK(null);
			
			//for transforming rows
			//target.setRows(null);
			
			//get options from UI
			//target.setOptions(null);
		} catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
