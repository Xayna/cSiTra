package bham.trasformation.rules;

import nosql.impl.PKImpl;
import metamodel.ConstraintType;
import metamodel.impl.ConstraintImpl;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

/**
 * @author kris
 *
 */

public class SQLCons2NoSQLCons implements Rule<metamodel.impl.ConstraintImpl , nosql.impl.PKImpl> {


	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#check(java.lang.Object)
	 */
	public boolean check(ConstraintImpl source) {
		return true;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#build(java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public PKImpl build(ConstraintImpl source, Transformer t) {
		nosql.impl.PKImpl PKList = new nosql.impl.PKImpl();
		ConstraintType key = source.getType();
		//if(key.getValue() == 0 ) //0 represents the primary key
		//{PKList.setReference((source.getReferences()));}
		return PKList;
	
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#setProperties(java.lang.Object, java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public void setProperties(PKImpl target, ConstraintImpl source,
			Transformer t) {
		
	}
	

}

