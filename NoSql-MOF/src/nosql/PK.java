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
 *   <li>{@link nosql.PK#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see nosql.NosqlPackage#getPK()
 * @model
 * @generated
 */
public interface PK extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute list.
	 * @see nosql.NosqlPackage#getPK_Reference()
	 * @model
	 * @generated
	 */
	EList getReference();

} // PK
