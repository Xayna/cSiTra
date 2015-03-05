/**
 */
package metamodel.impl;

import metamodel.MetamodelPackage;
import metamodel.Sequence;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link metamodel.impl.SequenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link metamodel.impl.SequenceImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link metamodel.impl.SequenceImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link metamodel.impl.SequenceImpl#getIncrementby <em>Incrementby</em>}</li>
 *   <li>{@link metamodel.impl.SequenceImpl#getStartwith <em>Startwith</em>}</li>
 *   <li>{@link metamodel.impl.SequenceImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link metamodel.impl.SequenceImpl#isCycle <em>Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceImpl extends MinimalEObjectImpl.Container implements Sequence {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected int minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected long maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncrementby() <em>Incrementby</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrementby()
	 * @generated
	 * @ordered
	 */
	protected static final int INCREMENTBY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIncrementby() <em>Incrementby</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrementby()
	 * @generated
	 * @ordered
	 */
	protected int incrementby = INCREMENTBY_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartwith() <em>Startwith</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartwith()
	 * @generated
	 * @ordered
	 */
	protected static final long STARTWITH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartwith() <em>Startwith</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartwith()
	 * @generated
	 * @ordered
	 */
	protected long startwith = STARTWITH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentValue() <em>Current Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected static final long CURRENT_VALUE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCurrentValue() <em>Current Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected long currentValue = CURRENT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isCycle() <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCycle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CYCLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCycle() <em>Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCycle()
	 * @generated
	 * @ordered
	 */
	protected boolean cycle = CYCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(int newMinValue) {
		int oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(long newMaxValue) {
		long oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIncrementby() {
		return incrementby;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrementby(int newIncrementby) {
		int oldIncrementby = incrementby;
		incrementby = newIncrementby;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__INCREMENTBY, oldIncrementby, incrementby));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartwith() {
		return startwith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartwith(long newStartwith) {
		long oldStartwith = startwith;
		startwith = newStartwith;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__STARTWITH, oldStartwith, startwith));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCurrentValue() {
		return currentValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentValue(long newCurrentValue) {
		long oldCurrentValue = currentValue;
		currentValue = newCurrentValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__CURRENT_VALUE, oldCurrentValue, currentValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCycle() {
		return cycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCycle(boolean newCycle) {
		boolean oldCycle = cycle;
		cycle = newCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SEQUENCE__CYCLE, oldCycle, cycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SEQUENCE__NAME:
				return getName();
			case MetamodelPackage.SEQUENCE__MIN_VALUE:
				return getMinValue();
			case MetamodelPackage.SEQUENCE__MAX_VALUE:
				return getMaxValue();
			case MetamodelPackage.SEQUENCE__INCREMENTBY:
				return getIncrementby();
			case MetamodelPackage.SEQUENCE__STARTWITH:
				return getStartwith();
			case MetamodelPackage.SEQUENCE__CURRENT_VALUE:
				return getCurrentValue();
			case MetamodelPackage.SEQUENCE__CYCLE:
				return isCycle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.SEQUENCE__NAME:
				setName((String)newValue);
				return;
			case MetamodelPackage.SEQUENCE__MIN_VALUE:
				setMinValue((Integer)newValue);
				return;
			case MetamodelPackage.SEQUENCE__MAX_VALUE:
				setMaxValue((Long)newValue);
				return;
			case MetamodelPackage.SEQUENCE__INCREMENTBY:
				setIncrementby((Integer)newValue);
				return;
			case MetamodelPackage.SEQUENCE__STARTWITH:
				setStartwith((Long)newValue);
				return;
			case MetamodelPackage.SEQUENCE__CURRENT_VALUE:
				setCurrentValue((Long)newValue);
				return;
			case MetamodelPackage.SEQUENCE__CYCLE:
				setCycle((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.SEQUENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetamodelPackage.SEQUENCE__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case MetamodelPackage.SEQUENCE__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
				return;
			case MetamodelPackage.SEQUENCE__INCREMENTBY:
				setIncrementby(INCREMENTBY_EDEFAULT);
				return;
			case MetamodelPackage.SEQUENCE__STARTWITH:
				setStartwith(STARTWITH_EDEFAULT);
				return;
			case MetamodelPackage.SEQUENCE__CURRENT_VALUE:
				setCurrentValue(CURRENT_VALUE_EDEFAULT);
				return;
			case MetamodelPackage.SEQUENCE__CYCLE:
				setCycle(CYCLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.SEQUENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetamodelPackage.SEQUENCE__MIN_VALUE:
				return minValue != MIN_VALUE_EDEFAULT;
			case MetamodelPackage.SEQUENCE__MAX_VALUE:
				return maxValue != MAX_VALUE_EDEFAULT;
			case MetamodelPackage.SEQUENCE__INCREMENTBY:
				return incrementby != INCREMENTBY_EDEFAULT;
			case MetamodelPackage.SEQUENCE__STARTWITH:
				return startwith != STARTWITH_EDEFAULT;
			case MetamodelPackage.SEQUENCE__CURRENT_VALUE:
				return currentValue != CURRENT_VALUE_EDEFAULT;
			case MetamodelPackage.SEQUENCE__CYCLE:
				return cycle != CYCLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", minValue: ");
		result.append(minValue);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", incrementby: ");
		result.append(incrementby);
		result.append(", startwith: ");
		result.append(startwith);
		result.append(", currentValue: ");
		result.append(currentValue);
		result.append(", cycle: ");
		result.append(cycle);
		result.append(')');
		return result.toString();
	}

} //SequenceImpl
