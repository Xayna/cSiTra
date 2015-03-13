/**
 */
package nosql.impl;

import java.util.Collection;

import nosql.ColumnFamily;
import nosql.Index;
import nosql.KeySpace;
import nosql.NosqlPackage;
import nosql.Options;
import nosql.PK;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nosql.impl.KeySpaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link nosql.impl.KeySpaceImpl#getIdexes <em>Idexes</em>}</li>
 *   <li>{@link nosql.impl.KeySpaceImpl#getFamilies <em>Families</em>}</li>
 *   <li>{@link nosql.impl.KeySpaceImpl#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link nosql.impl.KeySpaceImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link nosql.impl.KeySpaceImpl#getHasPK <em>Has PK</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeySpaceImpl extends MinimalEObjectImpl.Container implements KeySpace {
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
	 * The cached value of the '{@link #getIdexes() <em>Idexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdexes()
	 * @generated
	 * @ordered
	 */
	protected EList idexes;

	/**
	 * The cached value of the '{@link #getFamilies() <em>Families</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamilies()
	 * @generated
	 * @ordered
	 */
	protected EList families;

	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected Options eReference0;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList options;

	/**
	 * The cached value of the '{@link #getHasPK() <em>Has PK</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasPK()
	 * @generated
	 * @ordered
	 */
	protected EList hasPK;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeySpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NosqlPackage.Literals.KEY_SPACE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.KEY_SPACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getIdexes() {
		if (idexes == null) {
			idexes = new EObjectContainmentEList(Index.class, this, NosqlPackage.KEY_SPACE__IDEXES);
		}
		return idexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFamilies() {
		if (families == null) {
			families = new EObjectContainmentEList(ColumnFamily.class, this, NosqlPackage.KEY_SPACE__FAMILIES);
		}
		return families;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Options getEReference0() {
		if (eReference0 != null && eReference0.eIsProxy()) {
			InternalEObject oldEReference0 = (InternalEObject)eReference0;
			eReference0 = (Options)eResolveProxy(oldEReference0);
			if (eReference0 != oldEReference0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NosqlPackage.KEY_SPACE__EREFERENCE0, oldEReference0, eReference0));
			}
		}
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Options basicGetEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(Options newEReference0) {
		Options oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.KEY_SPACE__EREFERENCE0, oldEReference0, eReference0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList(Options.class, this, NosqlPackage.KEY_SPACE__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getHasPK() {
		if (hasPK == null) {
			hasPK = new EObjectContainmentEList(PK.class, this, NosqlPackage.KEY_SPACE__HAS_PK);
		}
		return hasPK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NosqlPackage.KEY_SPACE__IDEXES:
				return ((InternalEList)getIdexes()).basicRemove(otherEnd, msgs);
			case NosqlPackage.KEY_SPACE__FAMILIES:
				return ((InternalEList)getFamilies()).basicRemove(otherEnd, msgs);
			case NosqlPackage.KEY_SPACE__OPTIONS:
				return ((InternalEList)getOptions()).basicRemove(otherEnd, msgs);
			case NosqlPackage.KEY_SPACE__HAS_PK:
				return ((InternalEList)getHasPK()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NosqlPackage.KEY_SPACE__NAME:
				return getName();
			case NosqlPackage.KEY_SPACE__IDEXES:
				return getIdexes();
			case NosqlPackage.KEY_SPACE__FAMILIES:
				return getFamilies();
			case NosqlPackage.KEY_SPACE__EREFERENCE0:
				if (resolve) return getEReference0();
				return basicGetEReference0();
			case NosqlPackage.KEY_SPACE__OPTIONS:
				return getOptions();
			case NosqlPackage.KEY_SPACE__HAS_PK:
				return getHasPK();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NosqlPackage.KEY_SPACE__NAME:
				setName((String)newValue);
				return;
			case NosqlPackage.KEY_SPACE__IDEXES:
				getIdexes().clear();
				getIdexes().addAll((Collection)newValue);
				return;
			case NosqlPackage.KEY_SPACE__FAMILIES:
				getFamilies().clear();
				getFamilies().addAll((Collection)newValue);
				return;
			case NosqlPackage.KEY_SPACE__EREFERENCE0:
				setEReference0((Options)newValue);
				return;
			case NosqlPackage.KEY_SPACE__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection)newValue);
				return;
			case NosqlPackage.KEY_SPACE__HAS_PK:
				getHasPK().clear();
				getHasPK().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case NosqlPackage.KEY_SPACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NosqlPackage.KEY_SPACE__IDEXES:
				getIdexes().clear();
				return;
			case NosqlPackage.KEY_SPACE__FAMILIES:
				getFamilies().clear();
				return;
			case NosqlPackage.KEY_SPACE__EREFERENCE0:
				setEReference0((Options)null);
				return;
			case NosqlPackage.KEY_SPACE__OPTIONS:
				getOptions().clear();
				return;
			case NosqlPackage.KEY_SPACE__HAS_PK:
				getHasPK().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NosqlPackage.KEY_SPACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NosqlPackage.KEY_SPACE__IDEXES:
				return idexes != null && !idexes.isEmpty();
			case NosqlPackage.KEY_SPACE__FAMILIES:
				return families != null && !families.isEmpty();
			case NosqlPackage.KEY_SPACE__EREFERENCE0:
				return eReference0 != null;
			case NosqlPackage.KEY_SPACE__OPTIONS:
				return options != null && !options.isEmpty();
			case NosqlPackage.KEY_SPACE__HAS_PK:
				return hasPK != null && !hasPK.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //KeySpaceImpl
