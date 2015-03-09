/**
 * 
 */
package bham.trasformation.rules;
import metamodel.Database;
import nosql.KeySpace;
import uk.ac.bham.sitra.Rule;
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
		nosql.KeySpace keySpace = new nosql.impl.KeySpaceImpl();
		if(source.getName()!= null){
			keySpace.setName(source.getName());
		}
		return keySpace;		
	}

	/* (non-Javadoc)
	 * @see uk.ac.bham.sitra.Rule#setProperties(java.lang.Object, java.lang.Object, uk.ac.bham.sitra.Transformer)
	 */
	public void setProperties(KeySpace target, Database source, Transformer t) {
				
	}

}
