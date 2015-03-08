package bham.trasformation.rules;


import nosql.Type;
import metamodel.Column;
import metamodel.impl.ColumnImpl;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class SqlCol2NoSqlCol implements Rule<Column, nosql.Column> {


	public boolean check(Column source) {
	
		return false;
	}

	public nosql.Column build(Column source, Transformer t) {
		nosql.Column noSqlCol = new nosql.impl.ColumnImpl();
		
		noSqlCol.setName(source.getName());
		noSqlCol.setSize(source.getSize());
		noSqlCol.setPK(false);
		//we need to set the datatype
		//noSqlCol.setDatatype(value);
		
		return noSqlCol;
	}

	public void setProperties(nosql.Column target, Column source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
