/**
 */
package nosql.impl;

import java.util.Collection;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.NosqlPackage;
import nosql.Options;
import nosql.PK;
import nosql.Row;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Family</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nosql.impl.ColumnFamilyImpl#getName <em>Name</em>}</li>
 *   <li>{@link nosql.impl.ColumnFamilyImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link nosql.impl.ColumnFamilyImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link nosql.impl.ColumnFamilyImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link nosql.impl.ColumnFamilyImpl#getPK <em>PK</em>}</li>
 *   <li>{@link nosql.impl.ColumnFamilyImpl#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnFamilyImpl extends MinimalEObjectImpl.Container implements ColumnFamily {
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
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList columns;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

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
	 * The cached value of the '{@link #getPK() <em>PK</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPK()
	 * @generated
	 * @ordered
	 */
	protected PK pk;

	/**
	 * The cached value of the '{@link #getRows() <em>Rows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRows()
	 * @generated
	 * @ordered
	 */
	protected EList rows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnFamilyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NosqlPackage.Literals.COLUMN_FAMILY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN_FAMILY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList(Column.class, this, NosqlPackage.COLUMN_FAMILY__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN_FAMILY__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList(Options.class, this, NosqlPackage.COLUMN_FAMILY__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PK getPK() {
		return pk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPK(PK newPK, NotificationChain msgs) {
		PK oldPK = pk;
		pk = newPK;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN_FAMILY__PK, oldPK, newPK);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPK(PK newPK) {
		if (newPK != pk) {
			NotificationChain msgs = null;
			if (pk != null)
				msgs = ((InternalEObject)pk).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NosqlPackage.COLUMN_FAMILY__PK, null, msgs);
			if (newPK != null)
				msgs = ((InternalEObject)newPK).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NosqlPackage.COLUMN_FAMILY__PK, null, msgs);
			msgs = basicSetPK(newPK, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NosqlPackage.COLUMN_FAMILY__PK, newPK, newPK));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRows() {
		if (rows == null) {
			rows = new EObjectResolvingEList(Row.class, this, NosqlPackage.COLUMN_FAMILY__ROWS);
		}
		return rows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NosqlPackage.COLUMN_FAMILY__COLUMNS:
				return ((InternalEList)getColumns()).basicRemove(otherEnd, msgs);
			case NosqlPackage.COLUMN_FAMILY__OPTIONS:
				return ((InternalEList)getOptions()).basicRemove(otherEnd, msgs);
			case NosqlPackage.COLUMN_FAMILY__PK:
				return basicSetPK(null, msgs);
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
			case NosqlPackage.COLUMN_FAMILY__NAME:
				return getName();
			case NosqlPackage.COLUMN_FAMILY__COLUMNS:
				return getColumns();
			case NosqlPackage.COLUMN_FAMILY__COMMENT:
				return getComment();
			case NosqlPackage.COLUMN_FAMILY__OPTIONS:
				return getOptions();
			case NosqlPackage.COLUMN_FAMILY__PK:
				return getPK();
			case NosqlPackage.COLUMN_FAMILY__ROWS:
				return getRows();
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
			case NosqlPackage.COLUMN_FAMILY__NAME:
				setName((String)newValue);
				return;
			case NosqlPackage.COLUMN_FAMILY__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection)newValue);
				return;
			case NosqlPackage.COLUMN_FAMILY__COMMENT:
				setComment((String)newValue);
				return;
			case NosqlPackage.COLUMN_FAMILY__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection)newValue);
				return;
			case NosqlPackage.COLUMN_FAMILY__PK:
				setPK((PK)newValue);
				return;
			case NosqlPackage.COLUMN_FAMILY__ROWS:
				getRows().clear();
				getRows().addAll((Collection)newValue);
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
			case NosqlPackage.COLUMN_FAMILY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NosqlPackage.COLUMN_FAMILY__COLUMNS:
				getColumns().clear();
				return;
			case NosqlPackage.COLUMN_FAMILY__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case NosqlPackage.COLUMN_FAMILY__OPTIONS:
				getOptions().clear();
				return;
			case NosqlPackage.COLUMN_FAMILY__PK:
				setPK((PK)null);
				return;
			case NosqlPackage.COLUMN_FAMILY__ROWS:
				getRows().clear();
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
			case NosqlPackage.COLUMN_FAMILY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NosqlPackage.COLUMN_FAMILY__COLUMNS:
				return columns != null && !columns.isEmpty();
			case NosqlPackage.COLUMN_FAMILY__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case NosqlPackage.COLUMN_FAMILY__OPTIONS:
				return options != null && !options.isEmpty();
			case NosqlPackage.COLUMN_FAMILY__PK:
				return pk != null;
			case NosqlPackage.COLUMN_FAMILY__ROWS:
				return rows != null && !rows.isEmpty();
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
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //ColumnFamilyImpl
