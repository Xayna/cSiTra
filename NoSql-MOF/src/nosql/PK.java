/**
 */
package nosql;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PK</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nosql.PK#getColumns <em>Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see nosql.NosqlPackage#getPK()
 * @model
 * @generated
 */
public interface PK extends EObject {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link nosql.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see nosql.NosqlPackage#getPK_Columns()
	 * @model type="nosql.Column"
	 * @generated
	 */
	EList getColumns();

} // PK
