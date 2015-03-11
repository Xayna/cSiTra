/**
 */
package nosql;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see nosql.NosqlFactory
 * @model kind="package"
 * @generated
 */
public interface NosqlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nosql";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://nosql/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nosql";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NosqlPackage eINSTANCE = nosql.impl.NosqlPackageImpl.init();

	/**
	 * The meta object id for the '{@link nosql.impl.KeySpaceImpl <em>Key Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.KeySpaceImpl
	 * @see nosql.impl.NosqlPackageImpl#getKeySpace()
	 * @generated
	 */
	int KEY_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Idexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE__IDEXES = 1;

	/**
	 * The feature id for the '<em><b>Families</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE__FAMILIES = 2;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE__EREFERENCE0 = 3;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE__OPTIONS = 4;

	/**
	 * The feature id for the '<em><b>Has PK</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE__HAS_PK = 5;

	/**
	 * The number of structural features of the '<em>Key Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_SPACE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link nosql.impl.IndexImpl <em>Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.IndexImpl
	 * @see nosql.impl.NosqlPackageImpl#getIndex()
	 * @generated
	 */
	int INDEX = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__NAME = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Apply To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__APPLY_TO = 2;

	/**
	 * The number of structural features of the '<em>Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link nosql.impl.ColumnFamilyImpl <em>Column Family</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.ColumnFamilyImpl
	 * @see nosql.impl.NosqlPackageImpl#getColumnFamily()
	 * @generated
	 */
	int COLUMN_FAMILY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__COLUMNS = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__OPTIONS = 3;

	/**
	 * The feature id for the '<em><b>PK</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__PK = 4;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__ROWS = 5;

	/**
	 * The feature id for the '<em><b>Keyspace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__KEYSPACE = 6;

	/**
	 * The number of structural features of the '<em>Column Family</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link nosql.impl.OptionsImpl <em>Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.OptionsImpl
	 * @see nosql.impl.NosqlPackageImpl#getOptions()
	 * @generated
	 */
	int OPTIONS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link nosql.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.ColumnImpl
	 * @see nosql.impl.NosqlPackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = 0;

	/**
	 * The feature id for the '<em><b>PK</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__PK = 1;

	/**
	 * The feature id for the '<em><b>Datatype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__DATATYPE = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__SIZE = 3;

	/**
	 * The feature id for the '<em><b>Column Family</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__COLUMN_FAMILY = 4;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link nosql.impl.PKImpl <em>PK</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.PKImpl
	 * @see nosql.impl.NosqlPackageImpl#getPK()
	 * @generated
	 */
	int PK = 5;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PK__COLUMNS = 0;

	/**
	 * The number of structural features of the '<em>PK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PK_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link nosql.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.RowImpl
	 * @see nosql.impl.NosqlPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__NAME = COLUMN_FAMILY__NAME;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__COLUMNS = COLUMN_FAMILY__COLUMNS;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__COMMENT = COLUMN_FAMILY__COMMENT;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__OPTIONS = COLUMN_FAMILY__OPTIONS;

	/**
	 * The feature id for the '<em><b>PK</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__PK = COLUMN_FAMILY__PK;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__ROWS = COLUMN_FAMILY__ROWS;

	/**
	 * The feature id for the '<em><b>Keyspace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__KEYSPACE = COLUMN_FAMILY__KEYSPACE;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CELLS = COLUMN_FAMILY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = COLUMN_FAMILY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link nosql.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.impl.CellImpl
	 * @see nosql.impl.NosqlPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__COLUMN = 1;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link nosql.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nosql.Type
	 * @see nosql.impl.NosqlPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 8;


	/**
	 * Returns the meta object for class '{@link nosql.KeySpace <em>Key Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Space</em>'.
	 * @see nosql.KeySpace
	 * @generated
	 */
	EClass getKeySpace();

	/**
	 * Returns the meta object for the attribute '{@link nosql.KeySpace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nosql.KeySpace#getName()
	 * @see #getKeySpace()
	 * @generated
	 */
	EAttribute getKeySpace_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.KeySpace#getIdexes <em>Idexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Idexes</em>'.
	 * @see nosql.KeySpace#getIdexes()
	 * @see #getKeySpace()
	 * @generated
	 */
	EReference getKeySpace_Idexes();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.KeySpace#getFamilies <em>Families</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Families</em>'.
	 * @see nosql.KeySpace#getFamilies()
	 * @see #getKeySpace()
	 * @generated
	 */
	EReference getKeySpace_Families();

	/**
	 * Returns the meta object for the reference '{@link nosql.KeySpace#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see nosql.KeySpace#getEReference0()
	 * @see #getKeySpace()
	 * @generated
	 */
	EReference getKeySpace_EReference0();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.KeySpace#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see nosql.KeySpace#getOptions()
	 * @see #getKeySpace()
	 * @generated
	 */
	EReference getKeySpace_Options();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.KeySpace#getHasPK <em>Has PK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Has PK</em>'.
	 * @see nosql.KeySpace#getHasPK()
	 * @see #getKeySpace()
	 * @generated
	 */
	EReference getKeySpace_HasPK();

	/**
	 * Returns the meta object for class '{@link nosql.Index <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index</em>'.
	 * @see nosql.Index
	 * @generated
	 */
	EClass getIndex();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Index#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nosql.Index#getName()
	 * @see #getIndex()
	 * @generated
	 */
	EAttribute getIndex_Name();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Index#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see nosql.Index#getReference()
	 * @see #getIndex()
	 * @generated
	 */
	EAttribute getIndex_Reference();

	/**
	 * Returns the meta object for the containment reference '{@link nosql.Index#getApplyTo <em>Apply To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Apply To</em>'.
	 * @see nosql.Index#getApplyTo()
	 * @see #getIndex()
	 * @generated
	 */
	EReference getIndex_ApplyTo();

	/**
	 * Returns the meta object for class '{@link nosql.ColumnFamily <em>Column Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column Family</em>'.
	 * @see nosql.ColumnFamily
	 * @generated
	 */
	EClass getColumnFamily();

	/**
	 * Returns the meta object for the attribute '{@link nosql.ColumnFamily#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nosql.ColumnFamily#getName()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EAttribute getColumnFamily_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.ColumnFamily#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see nosql.ColumnFamily#getColumns()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EReference getColumnFamily_Columns();

	/**
	 * Returns the meta object for the attribute '{@link nosql.ColumnFamily#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see nosql.ColumnFamily#getComment()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EAttribute getColumnFamily_Comment();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.ColumnFamily#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see nosql.ColumnFamily#getOptions()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EReference getColumnFamily_Options();

	/**
	 * Returns the meta object for the containment reference '{@link nosql.ColumnFamily#getPK <em>PK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PK</em>'.
	 * @see nosql.ColumnFamily#getPK()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EReference getColumnFamily_PK();

	/**
	 * Returns the meta object for the reference list '{@link nosql.ColumnFamily#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rows</em>'.
	 * @see nosql.ColumnFamily#getRows()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EReference getColumnFamily_Rows();

	/**
	 * Returns the meta object for the containment reference '{@link nosql.ColumnFamily#getKeyspace <em>Keyspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Keyspace</em>'.
	 * @see nosql.ColumnFamily#getKeyspace()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EReference getColumnFamily_Keyspace();

	/**
	 * Returns the meta object for class '{@link nosql.Options <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Options</em>'.
	 * @see nosql.Options
	 * @generated
	 */
	EClass getOptions();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Options#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nosql.Options#getName()
	 * @see #getOptions()
	 * @generated
	 */
	EAttribute getOptions_Name();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Options#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see nosql.Options#getValue()
	 * @see #getOptions()
	 * @generated
	 */
	EAttribute getOptions_Value();

	/**
	 * Returns the meta object for class '{@link nosql.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see nosql.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Column#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nosql.Column#getName()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Column#isPK <em>PK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PK</em>'.
	 * @see nosql.Column#isPK()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_PK();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Column#getDatatype <em>Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Datatype</em>'.
	 * @see nosql.Column#getDatatype()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Datatype();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Column#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see nosql.Column#getSize()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Size();

	/**
	 * Returns the meta object for the reference '{@link nosql.Column#getColumnFamily <em>Column Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column Family</em>'.
	 * @see nosql.Column#getColumnFamily()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_ColumnFamily();

	/**
	 * Returns the meta object for class '{@link nosql.PK <em>PK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PK</em>'.
	 * @see nosql.PK
	 * @generated
	 */
	EClass getPK();

	/**
	 * Returns the meta object for the reference list '{@link nosql.PK#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Columns</em>'.
	 * @see nosql.PK#getColumns()
	 * @see #getPK()
	 * @generated
	 */
	EReference getPK_Columns();

	/**
	 * Returns the meta object for class '{@link nosql.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see nosql.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link nosql.Row#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cells</em>'.
	 * @see nosql.Row#getCells()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cells();

	/**
	 * Returns the meta object for class '{@link nosql.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see nosql.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the attribute '{@link nosql.Cell#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see nosql.Cell#getValue()
	 * @see #getCell()
	 * @generated
	 */
	EAttribute getCell_Value();

	/**
	 * Returns the meta object for the reference '{@link nosql.Cell#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see nosql.Cell#getColumn()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Column();

	/**
	 * Returns the meta object for enum '{@link nosql.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see nosql.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NosqlFactory getNosqlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link nosql.impl.KeySpaceImpl <em>Key Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.KeySpaceImpl
		 * @see nosql.impl.NosqlPackageImpl#getKeySpace()
		 * @generated
		 */
		EClass KEY_SPACE = eINSTANCE.getKeySpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_SPACE__NAME = eINSTANCE.getKeySpace_Name();

		/**
		 * The meta object literal for the '<em><b>Idexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_SPACE__IDEXES = eINSTANCE.getKeySpace_Idexes();

		/**
		 * The meta object literal for the '<em><b>Families</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_SPACE__FAMILIES = eINSTANCE.getKeySpace_Families();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_SPACE__EREFERENCE0 = eINSTANCE.getKeySpace_EReference0();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_SPACE__OPTIONS = eINSTANCE.getKeySpace_Options();

		/**
		 * The meta object literal for the '<em><b>Has PK</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_SPACE__HAS_PK = eINSTANCE.getKeySpace_HasPK();

		/**
		 * The meta object literal for the '{@link nosql.impl.IndexImpl <em>Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.IndexImpl
		 * @see nosql.impl.NosqlPackageImpl#getIndex()
		 * @generated
		 */
		EClass INDEX = eINSTANCE.getIndex();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX__NAME = eINSTANCE.getIndex_Name();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX__REFERENCE = eINSTANCE.getIndex_Reference();

		/**
		 * The meta object literal for the '<em><b>Apply To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX__APPLY_TO = eINSTANCE.getIndex_ApplyTo();

		/**
		 * The meta object literal for the '{@link nosql.impl.ColumnFamilyImpl <em>Column Family</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.ColumnFamilyImpl
		 * @see nosql.impl.NosqlPackageImpl#getColumnFamily()
		 * @generated
		 */
		EClass COLUMN_FAMILY = eINSTANCE.getColumnFamily();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_FAMILY__NAME = eINSTANCE.getColumnFamily_Name();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_FAMILY__COLUMNS = eINSTANCE.getColumnFamily_Columns();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_FAMILY__COMMENT = eINSTANCE.getColumnFamily_Comment();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_FAMILY__OPTIONS = eINSTANCE.getColumnFamily_Options();

		/**
		 * The meta object literal for the '<em><b>PK</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_FAMILY__PK = eINSTANCE.getColumnFamily_PK();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_FAMILY__ROWS = eINSTANCE.getColumnFamily_Rows();

		/**
		 * The meta object literal for the '<em><b>Keyspace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_FAMILY__KEYSPACE = eINSTANCE.getColumnFamily_Keyspace();

		/**
		 * The meta object literal for the '{@link nosql.impl.OptionsImpl <em>Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.OptionsImpl
		 * @see nosql.impl.NosqlPackageImpl#getOptions()
		 * @generated
		 */
		EClass OPTIONS = eINSTANCE.getOptions();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIONS__NAME = eINSTANCE.getOptions_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIONS__VALUE = eINSTANCE.getOptions_Value();

		/**
		 * The meta object literal for the '{@link nosql.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.ColumnImpl
		 * @see nosql.impl.NosqlPackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NAME = eINSTANCE.getColumn_Name();

		/**
		 * The meta object literal for the '<em><b>PK</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__PK = eINSTANCE.getColumn_PK();

		/**
		 * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__DATATYPE = eINSTANCE.getColumn_Datatype();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__SIZE = eINSTANCE.getColumn_Size();

		/**
		 * The meta object literal for the '<em><b>Column Family</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__COLUMN_FAMILY = eINSTANCE.getColumn_ColumnFamily();

		/**
		 * The meta object literal for the '{@link nosql.impl.PKImpl <em>PK</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.PKImpl
		 * @see nosql.impl.NosqlPackageImpl#getPK()
		 * @generated
		 */
		EClass PK = eINSTANCE.getPK();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PK__COLUMNS = eINSTANCE.getPK_Columns();

		/**
		 * The meta object literal for the '{@link nosql.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.RowImpl
		 * @see nosql.impl.NosqlPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CELLS = eINSTANCE.getRow_Cells();

		/**
		 * The meta object literal for the '{@link nosql.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.impl.CellImpl
		 * @see nosql.impl.NosqlPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL__VALUE = eINSTANCE.getCell_Value();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__COLUMN = eINSTANCE.getCell_Column();

		/**
		 * The meta object literal for the '{@link nosql.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nosql.Type
		 * @see nosql.impl.NosqlPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //NosqlPackage
