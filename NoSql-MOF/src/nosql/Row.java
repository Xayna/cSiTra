/**
 */
package nosql;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nosql.Row#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 *
 * @see nosql.NosqlPackage#getRow()
 * @model
 * @generated
 */
public interface Row extends ColumnFamily {
	/**
	 * Returns the value of the '<em><b>Cells</b></em>' containment reference list.
	 * The list contents are of type {@link nosql.Cell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cells</em>' containment reference list.
	 * @see nosql.NosqlPackage#getRow_Cells()
	 * @model type="nosql.Cell" containment="true" required="true"
	 * @generated
	 */
	EList getCells();

} // Row
