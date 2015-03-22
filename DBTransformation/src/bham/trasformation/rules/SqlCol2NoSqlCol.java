package bham.trasformation.rules;


import metamodel.Column;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;
/*
 * Mapping Sql Column database to Cassandra Nosql column
 */
public class SqlCol2NoSqlCol implements Rule<Column, nosql.Column> {


	public boolean check(Column source) {
	
		return true;
	}

	
	public nosql.Column build(Column source, Transformer t) {
		//create new nosql column  object
		nosql.Column noSqlCol = new nosql.impl.ColumnImpl();
		
			
		return noSqlCol;
	}

	public void setProperties(nosql.Column target, Column source, Transformer t) {
	//initializing the column
		target.setName(source.getName());
		target.setSize(source.getSize());
		target.setDatatype(DatatypeMapping.getType(source.getType()));
		
		
		
	}

}
