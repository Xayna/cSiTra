/**
 */
package nosql;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nosql.Column#getName <em>Name</em>}</li>
 *   <li>{@link nosql.Column#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link nosql.Column#getSize <em>Size</em>}</li>
 *   <li>{@link nosql.Column#getColumnFamily <em>Column Family</em>}</li>
 * </ul>
 * </p>
 *
 * @see nosql.NosqlPackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nosql.NosqlPackage#getColumn_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nosql.Column#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' attribute.
	 * The literals are from the enumeration {@link nosql.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatype</em>' attribute.
	 * @see nosql.Type
	 * @see #setDatatype(Type)
	 * @see nosql.NosqlPackage#getColumn_Datatype()
	 * @model required="true"
	 * @generated
	 */
	Type getDatatype();

	/**
	 * Sets the value of the '{@link nosql.Column#getDatatype <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype</em>' attribute.
	 * @see nosql.Type
	 * @see #getDatatype()
	 * @generated
	 */
	void setDatatype(Type value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(String)
	 * @see nosql.NosqlPackage#getColumn_Size()
	 * @model
	 * @generated
	 */
	String getSize();

	/**
	 * Sets the value of the '{@link nosql.Column#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(String value);

	/**
	 * Returns the value of the '<em><b>Column Family</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Family</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Family</em>' reference.
	 * @see #setColumnFamily(ColumnFamily)
	 * @see nosql.NosqlPackage#getColumn_ColumnFamily()
	 * @model
	 * @generated
	 */
	ColumnFamily getColumnFamily();

	/**
	 * Sets the value of the '{@link nosql.Column#getColumnFamily <em>Column Family</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Family</em>' reference.
	 * @see #getColumnFamily()
	 * @generated
	 */
	void setColumnFamily(ColumnFamily value);

} // Column
