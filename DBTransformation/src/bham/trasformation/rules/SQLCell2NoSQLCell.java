/**
 * 
 */
package bham.trasformation.rules;

import nosql.impl.CellImpl;
import metamodel.Cell;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

/**
 * @author kris
 *
 */
public class SQLCell2NoSQLCell implements Rule<metamodel.Cell , nosql.Cell> {

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#check(java.lang.Object)
	 */
	public boolean check(Cell source) {
		return true;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#build(java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public nosql.Cell build(Cell source, Transformer t) {
		nosql.Cell cell = new CellImpl();
		cell.setValue(source.getValue());	
		return cell;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#setProperties(java.lang.Object, java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public void setProperties(nosql.Cell target, Cell source, Transformer t) {
		
	}
	

}
