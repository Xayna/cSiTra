/**
 * 
 */
package bham.trasformation.rules;
import metamodel.Database;
import nosql.KeySpace;

import org.eclipse.emf.common.util.EList;

import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;
/**
 * @author kris
 *
 */
public class Database2Keyspace implements Rule<metamodel.Database ,nosql.KeySpace >{

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#check(java.lang.Object)
	 */
	public boolean check(Database source) {
		
		return true;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#build(java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public KeySpace build(Database source, Transformer t) {
		
		try {
			nosql.KeySpace keySpace = new nosql.impl.KeySpaceImpl();
			if(source.getName()!= null){
				keySpace.setName(source.getName());
			}
			keySpace.setFamilies((EList)t.transformAll(Table2ColumnFamily.class, source.getTable()));
			return keySpace;
		} catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#setProperties(java.lang.Object, java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public void setProperties(KeySpace target, Database source, Transformer t) {
				
	}

}
