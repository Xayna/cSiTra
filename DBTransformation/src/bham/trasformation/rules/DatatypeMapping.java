package bham.trasformation.rules;

import java.sql.Types;
import java.util.HashMap;

import nosql.Type;
import metamodel.Datatype;

public class DatatypeMapping {

	private static HashMap<Datatype, Type> typesMap = null;

	//

	public DatatypeMapping() {

	}

	public static Type getType(Datatype datatype) {
		if (typesMap == null || typesMap.isEmpty())
			setTypes();

		return typesMap.get(datatype);

	}
	

	public static boolean isStringType(Type type) {
		boolean result = false;
		switch (type.getValue()) {
		case Type.ASCII:
		case Type.TIMESTAMP:
		case Type.TEXT:
		case Type.VARCHAR:
			result = true;
			break;

		}

		return result;
	}

	private static void setTypes() {
		try {
			typesMap = new HashMap<Datatype, Type>();

			typesMap.put(Datatype.BIGINT, Type.INT_LITERAL);
			typesMap.put(Datatype.BLOB, Type.BLOB_LITERAL);
			typesMap.put(Datatype.BOOLEAN, Type.BOOLEAN_LITERAL);
			typesMap.put(Datatype.CHAR, Type.ASCII_LITERAL);
			typesMap.put(Datatype.DATE, Type.TIMESTAMP_LITERAL);
			typesMap.put(Datatype.DATETIME, Type.TIMESTAMP_LITERAL);
			typesMap.put(Datatype.DECIMAL, Type.DECIMAL_LITERAL);
			typesMap.put(Datatype.DOUBLE, Type.DOUBLE_LITERAL);
			typesMap.put(Datatype.FLOAT, Type.FLOAT_LITERAL);
			typesMap.put(Datatype.INT, Type.INT_LITERAL);
			typesMap.put(Datatype.LONGTEXT, Type.TEXT_LITERAL);
			typesMap.put(Datatype.SMALLINT, Type.INT_LITERAL);
			typesMap.put(Datatype.STRING, Type.TEXT_LITERAL);
			typesMap.put(Datatype.TEXT, Type.TEXT_LITERAL);
			typesMap.put(Datatype.TIMESTAMP, Type.TIMESTAMP_LITERAL);
			typesMap.put(Datatype.TINYTEXT, Type.TEXT_LITERAL);
			typesMap.put(Datatype.VARCHAR, Type.VARCHAR_LITERAL);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
