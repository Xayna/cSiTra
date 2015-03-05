/**
 */
package metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link metamodel.Sequence#getName <em>Name</em>}</li>
 *   <li>{@link metamodel.Sequence#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link metamodel.Sequence#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link metamodel.Sequence#getIncrementby <em>Incrementby</em>}</li>
 *   <li>{@link metamodel.Sequence#getStartwith <em>Startwith</em>}</li>
 *   <li>{@link metamodel.Sequence#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link metamodel.Sequence#isCycle <em>Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see metamodel.MetamodelPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends EObject {
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
	 * @see metamodel.MetamodelPackage#getSequence_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(int)
	 * @see metamodel.MetamodelPackage#getSequence_MinValue()
	 * @model
	 * @generated
	 */
	int getMinValue();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(int value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(long)
	 * @see metamodel.MetamodelPackage#getSequence_MaxValue()
	 * @model
	 * @generated
	 */
	long getMaxValue();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(long value);

	/**
	 * Returns the value of the '<em><b>Incrementby</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incrementby</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incrementby</em>' attribute.
	 * @see #setIncrementby(int)
	 * @see metamodel.MetamodelPackage#getSequence_Incrementby()
	 * @model
	 * @generated
	 */
	int getIncrementby();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#getIncrementby <em>Incrementby</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incrementby</em>' attribute.
	 * @see #getIncrementby()
	 * @generated
	 */
	void setIncrementby(int value);

	/**
	 * Returns the value of the '<em><b>Startwith</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Startwith</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Startwith</em>' attribute.
	 * @see #setStartwith(long)
	 * @see metamodel.MetamodelPackage#getSequence_Startwith()
	 * @model
	 * @generated
	 */
	long getStartwith();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#getStartwith <em>Startwith</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Startwith</em>' attribute.
	 * @see #getStartwith()
	 * @generated
	 */
	void setStartwith(long value);

	/**
	 * Returns the value of the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Value</em>' attribute.
	 * @see #setCurrentValue(long)
	 * @see metamodel.MetamodelPackage#getSequence_CurrentValue()
	 * @model
	 * @generated
	 */
	long getCurrentValue();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#getCurrentValue <em>Current Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Value</em>' attribute.
	 * @see #getCurrentValue()
	 * @generated
	 */
	void setCurrentValue(long value);

	/**
	 * Returns the value of the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cycle</em>' attribute.
	 * @see #setCycle(boolean)
	 * @see metamodel.MetamodelPackage#getSequence_Cycle()
	 * @model
	 * @generated
	 */
	boolean isCycle();

	/**
	 * Sets the value of the '{@link metamodel.Sequence#isCycle <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycle</em>' attribute.
	 * @see #isCycle()
	 * @generated
	 */
	void setCycle(boolean value);

} // Sequence
