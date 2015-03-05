/**
 */
package nosql;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see nosql.NosqlPackage#getType()
 * @model
 * @generated
 */
public final class Type extends AbstractEnumerator {
	/**
	 * The '<em><b>Ascii</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ascii</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASCII_LITERAL
	 * @model name="ascii"
	 * @generated
	 * @ordered
	 */
	public static final int ASCII = 0;

	/**
	 * The '<em><b>Blob</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Blob</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLOB_LITERAL
	 * @model name="blob"
	 * @generated
	 * @ordered
	 */
	public static final int BLOB = 2;

	/**
	 * The '<em><b>Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_LITERAL
	 * @model name="boolean"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN = 3;

	/**
	 * The '<em><b>Counter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Counter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COUNTER_LITERAL
	 * @model name="counter"
	 * @generated
	 * @ordered
	 */
	public static final int COUNTER = 4;

	/**
	 * The '<em><b>Decimal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decimal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECIMAL_LITERAL
	 * @model name="decimal"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMAL = 5;

	/**
	 * The '<em><b>Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_LITERAL
	 * @model name="double"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE = 6;

	/**
	 * The '<em><b>Float</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Float</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOAT_LITERAL
	 * @model name="float"
	 * @generated
	 * @ordered
	 */
	public static final int FLOAT = 7;

	/**
	 * The '<em><b>Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT_LITERAL
	 * @model name="int"
	 * @generated
	 * @ordered
	 */
	public static final int INT = 9;

	/**
	 * The '<em><b>Text</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Text</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_LITERAL
	 * @model name="text"
	 * @generated
	 * @ordered
	 */
	public static final int TEXT = 10;

	/**
	 * The '<em><b>Timestamp</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Timestamp</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMESTAMP_LITERAL
	 * @model name="timestamp"
	 * @generated
	 * @ordered
	 */
	public static final int TIMESTAMP = 11;

	/**
	 * The '<em><b>Uuid</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Uuid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UUID_LITERAL
	 * @model name="uuid"
	 * @generated
	 * @ordered
	 */
	public static final int UUID = 12;

	/**
	 * The '<em><b>Timeuuid</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Timeuuid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMEUUID_LITERAL
	 * @model name="timeuuid"
	 * @generated
	 * @ordered
	 */
	public static final int TIMEUUID = 16;

	/**
	 * The '<em><b>Varchar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Varchar</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VARCHAR_LITERAL
	 * @model name="varchar"
	 * @generated
	 * @ordered
	 */
	public static final int VARCHAR = 13;

	/**
	 * The '<em><b>Varint</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Varint</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VARINT_LITERAL
	 * @model name="varint"
	 * @generated
	 * @ordered
	 */
	public static final int VARINT = 14;

	/**
	 * The '<em><b>Bigint</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bigint</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BIGINT_LITERAL
	 * @model name="bigint"
	 * @generated
	 * @ordered
	 */
	public static final int BIGINT = 1;

	/**
	 * The '<em><b>Ascii</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASCII
	 * @generated
	 * @ordered
	 */
	public static final Type ASCII_LITERAL = new Type(ASCII, "ascii", "ascii");

	/**
	 * The '<em><b>Blob</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOB
	 * @generated
	 * @ordered
	 */
	public static final Type BLOB_LITERAL = new Type(BLOB, "blob", "blob");

	/**
	 * The '<em><b>Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @generated
	 * @ordered
	 */
	public static final Type BOOLEAN_LITERAL = new Type(BOOLEAN, "boolean", "boolean");

	/**
	 * The '<em><b>Counter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COUNTER
	 * @generated
	 * @ordered
	 */
	public static final Type COUNTER_LITERAL = new Type(COUNTER, "counter", "counter");

	/**
	 * The '<em><b>Decimal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMAL
	 * @generated
	 * @ordered
	 */
	public static final Type DECIMAL_LITERAL = new Type(DECIMAL, "decimal", "decimal");

	/**
	 * The '<em><b>Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE
	 * @generated
	 * @ordered
	 */
	public static final Type DOUBLE_LITERAL = new Type(DOUBLE, "double", "double");

	/**
	 * The '<em><b>Float</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOAT
	 * @generated
	 * @ordered
	 */
	public static final Type FLOAT_LITERAL = new Type(FLOAT, "float", "float");

	/**
	 * The '<em><b>Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @generated
	 * @ordered
	 */
	public static final Type INT_LITERAL = new Type(INT, "int", "int");

	/**
	 * The '<em><b>Text</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT
	 * @generated
	 * @ordered
	 */
	public static final Type TEXT_LITERAL = new Type(TEXT, "text", "text");

	/**
	 * The '<em><b>Timestamp</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMESTAMP
	 * @generated
	 * @ordered
	 */
	public static final Type TIMESTAMP_LITERAL = new Type(TIMESTAMP, "timestamp", "timestamp");

	/**
	 * The '<em><b>Uuid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UUID
	 * @generated
	 * @ordered
	 */
	public static final Type UUID_LITERAL = new Type(UUID, "uuid", "uuid");

	/**
	 * The '<em><b>Timeuuid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMEUUID
	 * @generated
	 * @ordered
	 */
	public static final Type TIMEUUID_LITERAL = new Type(TIMEUUID, "timeuuid", "timeuuid");

	/**
	 * The '<em><b>Varchar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARCHAR
	 * @generated
	 * @ordered
	 */
	public static final Type VARCHAR_LITERAL = new Type(VARCHAR, "varchar", "varchar");

	/**
	 * The '<em><b>Varint</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARINT
	 * @generated
	 * @ordered
	 */
	public static final Type VARINT_LITERAL = new Type(VARINT, "varint", "varint");

	/**
	 * The '<em><b>Bigint</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIGINT
	 * @generated
	 * @ordered
	 */
	public static final Type BIGINT_LITERAL = new Type(BIGINT, "bigint", "bigint");

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Type[] VALUES_ARRAY =
		new Type[] {
			ASCII_LITERAL,
			BLOB_LITERAL,
			BOOLEAN_LITERAL,
			COUNTER_LITERAL,
			DECIMAL_LITERAL,
			DOUBLE_LITERAL,
			FLOAT_LITERAL,
			INT_LITERAL,
			TEXT_LITERAL,
			TIMESTAMP_LITERAL,
			UUID_LITERAL,
			TIMEUUID_LITERAL,
			VARCHAR_LITERAL,
			VARINT_LITERAL,
			BIGINT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Type result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Type result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type get(int value) {
		switch (value) {
			case ASCII: return ASCII_LITERAL;
			case BLOB: return BLOB_LITERAL;
			case BOOLEAN: return BOOLEAN_LITERAL;
			case COUNTER: return COUNTER_LITERAL;
			case DECIMAL: return DECIMAL_LITERAL;
			case DOUBLE: return DOUBLE_LITERAL;
			case FLOAT: return FLOAT_LITERAL;
			case INT: return INT_LITERAL;
			case TEXT: return TEXT_LITERAL;
			case TIMESTAMP: return TIMESTAMP_LITERAL;
			case UUID: return UUID_LITERAL;
			case TIMEUUID: return TIMEUUID_LITERAL;
			case VARCHAR: return VARCHAR_LITERAL;
			case VARINT: return VARINT_LITERAL;
			case BIGINT: return BIGINT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Type(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Type
