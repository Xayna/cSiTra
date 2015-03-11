/**
 */
package nosql;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nosql.KeySpace#getName <em>Name</em>}</li>
 *   <li>{@link nosql.KeySpace#getIdexes <em>Idexes</em>}</li>
 *   <li>{@link nosql.KeySpace#getFamilies <em>Families</em>}</li>
 *   <li>{@link nosql.KeySpace#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link nosql.KeySpace#getOptions <em>Options</em>}</li>
 *   <li>{@link nosql.KeySpace#getHasPK <em>Has PK</em>}</li>
 * </ul>
 * </p>
 *
 * @see nosql.NosqlPackage#getKeySpace()
 * @model
 * @generated
 */
public interface KeySpace extends EObject {
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
	 * @see nosql.NosqlPackage#getKeySpace_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nosql.KeySpace#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Idexes</b></em>' containment reference list.
	 * The list contents are of type {@link nosql.Index}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idexes</em>' containment reference list.
	 * @see nosql.NosqlPackage#getKeySpace_Idexes()
	 * @model type="nosql.Index" containment="true"
	 * @generated
	 */
	EList getIdexes();

	/**
	 * Returns the value of the '<em><b>Families</b></em>' containment reference list.
	 * The list contents are of type {@link nosql.ColumnFamily}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Families</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Families</em>' containment reference list.
	 * @see nosql.NosqlPackage#getKeySpace_Families()
	 * @model type="nosql.ColumnFamily" containment="true" required="true"
	 * @generated
	 */
	EList getFamilies();

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(Options)
	 * @see nosql.NosqlPackage#getKeySpace_EReference0()
	 * @model
	 * @generated
	 */
	Options getEReference0();

	/**
	 * Sets the value of the '{@link nosql.KeySpace#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(Options value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link nosql.Options}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see nosql.NosqlPackage#getKeySpace_Options()
	 * @model type="nosql.Options" containment="true"
	 * @generated
	 */
	EList getOptions();

	/**
	 * Returns the value of the '<em><b>Has PK</b></em>' containment reference list.
	 * The list contents are of type {@link nosql.PK}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has PK</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has PK</em>' containment reference list.
	 * @see nosql.NosqlPackage#getKeySpace_HasPK()
	 * @model type="nosql.PK" containment="true"
	 * @generated
	 */
	EList getHasPK();

} // KeySpace
