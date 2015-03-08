package bham.trasformation.rules;

import java.util.HashMap;

import nosql.Type;
import metamodel.Datatype;

public  class DatatypeMapping {
	
	private static HashMap<Datatype, Type> datatypeMap = new HashMap<Datatype, Type>();
	private DatatypeMapping() {
		
		FillHashMap();
		
	}
	
	private void FillHashMap()
	{
		try 
		{
			datatypeMap.put(Datatype.BIGINT_LITERAL, Type.BIGINT_LITERAL);
			datatypeMap.put(Datatype.BLOB_LITERAL,Type.BLOB_LITERAL);
			datatypeMap.put(Datatype.BOOLEAN_LITERAL,Type.BOOLEAN_LITERAL);
			datatypeMap.put(Datatype.CHAR_LITERAL,Type.ASCII_LITERAL);
			datatypeMap.put(Datatype.DATE_LITERAL,Type.TIMESTAMP_LITERAL);
			datatypeMap.put(Datatype.DATETIME_LITERAL,Type.TIMESTAMP_LITERAL);
			datatypeMap.put(Datatype.DECIMAL_LITERAL,Type.DECIMAL_LITERAL);
			datatypeMap.put(Datatype.DOUBLE_LITERAL,Type.DOUBLE_LITERAL);
			datatypeMap.put(Datatype.FLOAT_LITERAL,Type.FLOAT_LITERAL);
			datatypeMap.put(Datatype.INT_LITERAL,Type.INT_LITERAL);
			datatypeMap.put(Datatype.LONGTEXT_LITERAL,Type.ASCII_LITERAL);
			datatypeMap.put(Datatype.SMALLINT_LITERAL,Type.TEXT_LITERAL);
			datatypeMap.put(Datatype.STRING_LITERAL,Type.TEXT_LITERAL);
			datatypeMap.put(Datatype.TEXT_LITERAL,Type.TEXT_LITERAL);
			datatypeMap.put(Datatype.TIMESTAMP_LITERAL,Type.TIMESTAMP_LITERAL);
			datatypeMap.put(Datatype.TINYTEXT_LITERAL,Type.TEXT_LITERAL);
			datatypeMap.put(Datatype.VARCHAR_LITERAL,Type.VARCHAR_LITERAL);
			
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public static HashMap<Datatype, Type> getTypesMap ()
	{
		if (datatypeMap.isEmpty())
			new DatatypeMapping(); // if this did not work use (new DatatypeMapping).getHashMap();
		
		return datatypeMap;
		
	}
	
	public static Type getType (Datatype datatype)
	{
		if (datatypeMap.isEmpty())
			new DatatypeMapping(); // if this did not work use (new DatatypeMapping).getHashMap();
		
		return datatypeMap.get(datatype);
		
	}
	

}
