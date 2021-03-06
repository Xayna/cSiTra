/**
 */
package metamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Constraint Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see metamodel.MetamodelPackage#getConstraintType()
 * @model
 * @generated
 */
public final class ConstraintType extends  AbstractEnumerator {
	
	public static final int PRIMARY_KEY_VALUE = 0;


	/**
	 * The '<em><b>FOREIGN KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOREIGN KEY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOREIGN_KEY_VALUE = 1;

	/**
	 * The '<em><b>UNIQUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIQUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIQUE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIQUE_VALUE = 2;

	/**
	 * The '<em><b>COMPOSITE PRIMARY KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPOSITE PRIMARY KEY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE_PRIMARY_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_PRIMARY_KEY_VALUE = 3;

	/**
	 * An array of all the '<em><b>Constraint Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	/**
	 * The '<em><b>PRIMARY KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	public static ConstraintType PRIMARY_KEY = new ConstraintType (PRIMARY_KEY_VALUE, "PRIMARY_KEY", "PRIMARY_KEY");

	/**
	 * The '<em><b>FOREIGN KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	public static ConstraintType FOREIGN_KEY = new ConstraintType(FOREIGN_KEY_VALUE, "FOREIGN_KEY", "FOREIGN_KEY");

	/**
	 * The '<em><b>UNIQUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIQUE_VALUE
	 * @generated
	 * @ordered
	 */
	public static ConstraintType UNIQUE = new ConstraintType(UNIQUE_VALUE, "UNIQUE", "UNIQUE");

	/**
	 * The '<em><b>COMPOSITE PRIMARY KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE_PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	public static ConstraintType COMPOSITE_PRIMARY_KEY = new ConstraintType(COMPOSITE_PRIMARY_KEY_VALUE, "COMPOSITE_PRIMARY_KEY", "COMPOSITE_PRIMARY_KEY");

	/**
	 * The '<em><b>PRIMARY KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRIMARY KEY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIMARY_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	private static final ConstraintType[] VALUES_ARRAY =
		new ConstraintType[] {
			PRIMARY_KEY,
			FOREIGN_KEY,
			UNIQUE,
			COMPOSITE_PRIMARY_KEY,
		};

	/**
	 * A public read-only list of all the '<em><b>Constraint Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConstraintType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Constraint Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConstraintType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConstraintType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Constraint Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConstraintType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConstraintType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Constraint Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConstraintType get(int value) {
		switch (value) {
			case PRIMARY_KEY_VALUE: return PRIMARY_KEY;
			case FOREIGN_KEY_VALUE: return FOREIGN_KEY;
			case UNIQUE_VALUE: return UNIQUE;
			case COMPOSITE_PRIMARY_KEY_VALUE: return COMPOSITE_PRIMARY_KEY;
		}
		return null;
	}

	
	private ConstraintType(int value, String name, String literal) {
		super (value , name , literal);
	}


	
} //ConstraintType
