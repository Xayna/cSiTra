/**
 */
package nosql.impl;

import nosql.Column;
import nosql.ColumnFamily;
import nosql.NosqlPackage;
import nosql.Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nosql.impl.ColumnImpl#getName <em>Name</em>}</li>
 *   <li>{@link nosql.impl.ColumnImpl#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link nosql.impl.ColumnImpl#getSize <em>Size</em>}</li>
 *   <li>{@link nosql.impl.ColumnImpl#getColumnFamily <em>Column Family</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends MinimalEObjectImpl.Container implements Column {
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
	 * The default value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected static final Type DATATYPE_EDEFAULT = Type.ASCII_LITERAL;

	/**
	 * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected Type datatype = DATATYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected String size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumnFamily() <em>Column Family</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnFamily()
	 * @generated
	 * @ordered
	 */
	protected ColumnFamily columnFamily;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NosqlPackage.Literals.COLUMN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getDatatype() {
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatatype(Type newDatatype) {
		Type oldDatatype = datatype;
		datatype = newDatatype == null ? DATATYPE_EDEFAULT : newDatatype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN__DATATYPE, oldDatatype, datatype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(String newSize) {
		String oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnFamily getColumnFamily() {
		if (columnFamily != null && columnFamily.eIsProxy()) {
			InternalEObject oldColumnFamily = (InternalEObject)columnFamily;
			columnFamily = (ColumnFamily)eResolveProxy(oldColumnFamily);
			if (columnFamily != oldColumnFamily) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NosqlPackage.COLUMN__COLUMN_FAMILY, oldColumnFamily, columnFamily));
			}
		}
		return columnFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnFamily basicGetColumnFamily() {
		return columnFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnFamily(ColumnFamily newColumnFamily) {
		ColumnFamily oldColumnFamily = columnFamily;
		columnFamily = newColumnFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN__COLUMN_FAMILY, oldColumnFamily, columnFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NosqlPackage.COLUMN__NAME:
				return getName();
			case NosqlPackage.COLUMN__DATATYPE:
				return getDatatype();
			case NosqlPackage.COLUMN__SIZE:
				return getSize();
			case NosqlPackage.COLUMN__COLUMN_FAMILY:
				if (resolve) return getColumnFamily();
				return basicGetColumnFamily();
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
			case NosqlPackage.COLUMN__NAME:
				setName((String)newValue);
				return;
			case NosqlPackage.COLUMN__DATATYPE:
				setDatatype((Type)newValue);
				return;
			case NosqlPackage.COLUMN__SIZE:
				setSize((String)newValue);
				return;
			case NosqlPackage.COLUMN__COLUMN_FAMILY:
				setColumnFamily((ColumnFamily)newValue);
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
			case NosqlPackage.COLUMN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NosqlPackage.COLUMN__DATATYPE:
				setDatatype(DATATYPE_EDEFAULT);
				return;
			case NosqlPackage.COLUMN__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case NosqlPackage.COLUMN__COLUMN_FAMILY:
				setColumnFamily((ColumnFamily)null);
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
			case NosqlPackage.COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NosqlPackage.COLUMN__DATATYPE:
				return datatype != DATATYPE_EDEFAULT;
			case NosqlPackage.COLUMN__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case NosqlPackage.COLUMN__COLUMN_FAMILY:
				return columnFamily != null;
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
		result.append(", datatype: ");
		result.append(datatype);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //ColumnImpl
