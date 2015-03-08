package bham.trasformation.rules;


import nosql.ColumnFamily;
import nosql.PK;
import nosql.impl.ColumnFamilyImpl;
import nosql.impl.PKImpl;
import metamodel.Column;
import metamodel.Constraint;
import metamodel.ConstraintType;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class SqlCol2NoSqlCol implements Rule<Column, nosql.Column> {


	public boolean check(Column source) {
	
		return true;
	}

	public nosql.Column build(Column source, Transformer t) {
		nosql.Column noSqlCol = new nosql.impl.ColumnImpl();
		
			
		return noSqlCol;
	}

	public void setProperties(nosql.Column target, Column source, Transformer t) {
		target.setName(source.getName());
		target.setSize(source.getSize());
		target.setPK(false);
		target.setDatatype(DatatypeMapping.getType(source.getType()));
		
		
		
	}

}
