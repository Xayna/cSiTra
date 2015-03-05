/**
 */
package nosql;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Family</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nosql.ColumnFamily#getName <em>Name</em>}</li>
 *   <li>{@link nosql.ColumnFamily#getColumns <em>Columns</em>}</li>
 *   <li>{@link nosql.ColumnFamily#getComment <em>Comment</em>}</li>
 *   <li>{@link nosql.ColumnFamily#getOptions <em>Options</em>}</li>
 *   <li>{@link nosql.ColumnFamily#getPK <em>PK</em>}</li>
 *   <li>{@link nosql.ColumnFamily#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see nosql.NosqlPackage#getColumnFamily()
 * @model
 * @generated
 */
public interface ColumnFamily extends EObject {
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
	 * @see nosql.NosqlPackage#getColumnFamily_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nosql.ColumnFamily#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link nosql.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see nosql.NosqlPackage#getColumnFamily_Columns()
	 * @model type="nosql.Column" containment="true" required="true"
	 * @generated
	 */
	EList getColumns();

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see nosql.NosqlPackage#getColumnFamily_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link nosql.ColumnFamily#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

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
	 * @see nosql.NosqlPackage#getColumnFamily_Options()
	 * @model type="nosql.Options" containment="true"
	 * @generated
	 */
	EList getOptions();

	/**
	 * Returns the value of the '<em><b>PK</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PK</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PK</em>' containment reference.
	 * @see #setPK(PK)
	 * @see nosql.NosqlPackage#getColumnFamily_PK()
	 * @model containment="true"
	 * @generated
	 */
	PK getPK();

	/**
	 * Sets the value of the '{@link nosql.ColumnFamily#getPK <em>PK</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PK</em>' containment reference.
	 * @see #getPK()
	 * @generated
	 */
	void setPK(PK value);

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' reference list.
	 * The list contents are of type {@link nosql.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' reference list.
	 * @see nosql.NosqlPackage#getColumnFamily_Rows()
	 * @model type="nosql.Row"
	 * @generated
	 */
	EList getRows();

} // ColumnFamily
