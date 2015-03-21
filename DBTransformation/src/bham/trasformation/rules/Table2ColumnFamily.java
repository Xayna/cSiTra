/**
 * 
 */
package bham.trasformation.rules;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import metamodel.Constraint;
import metamodel.ConstraintType;
import metamodel.Table;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.PK;
import nosql.impl.ColumnFamilyImpl;
import nosql.impl.PKImpl;

import org.eclipse.emf.common.util.EList;

import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;
import bham.trasformation.Main;

/**
 * @author Manali
 * @modified by Zaina, Krishna
 */
public class Table2ColumnFamily implements Rule<Table, ColumnFamily> {

	public boolean check(Table source) {
		// TODO Auto-generated method stub
		return true;
	}

	public ColumnFamily build(Table source, Transformer t) {
		// TODO Auto-generated method stub
		ColumnFamily columnFamily = new ColumnFamilyImpl();
		return columnFamily;
	}

	public void setProperties(ColumnFamily target, Table source, Transformer t) {
		// TODO Auto-generated method stub
		try {
			// set the name of the column family
			
			//System.out.println("Setting properties for: "+source.getName() +" with constraints: "+source.getConstraints().size());
			
			target.setName(source.getName());
			target.setKeyspace(Main.mainKeySpace);
			// use for each loop to add the column and check it's constraints at
			// the same time.
			for (metamodel.Column col : source.getColumns()) {
				nosql.Column newCol = t.transform(SqlCol2NoSqlCol.class, col);
				newCol.setColumnFamily(target);
				target.getColumns().add(newCol);
				//System.out.println("Before constraint");
				checkConstraints(t, newCol, col);
				//System.out.println("After constraint");
				/*System.out.print("The columns: ");
				for(nosql.Column col2: (EList<nosql.Column>)target.getPK().getColumns()){
					System.out.print(col2.getName()+" ");
				}
				System.out.println();*/

			}
			
			//remain the fk fill data part
			//System.out.println(" --- No of constraints: "+source.getConstraints().size());
			fillData(source, target);
			
			
			/*for(nosql.Column col2: (EList<nosql.Column>)target.getPK().getColumns()){
				System.out.println(col2.getName()+" at last");
			}
			System.out.println();
*/
			// target.setColumns((EList<Column>) t.transformAll(
			// SqlCol2NoSqlCol.class, source.getColumns()));

		} catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkConstraints(Transformer t, nosql.Column targetCol, metamodel.Column sourceCol) {
		// to be impl by krishna
		// target.setPK(null);

		// for transforming rows
		// target.setRows(null);

		// get options from UI
		// target.setOptions(null);

		PK pkObj;
		for (Constraint constraint : sourceCol.getReferences()) {
			try {
				//System.out.println("in side constraint " + constraint.getName() + " " + constraint.getType().getName());
				switch (constraint.getType().getValue()) {
				// there is no composite primary key type in my sql
				// case ConstraintType.COMPOSITE_PRIMARY_KEY_VALUE:
				//
				// break;

				case ConstraintType.PRIMARY_KEY_VALUE:
					//System.out.println("Hiii I am  PK in " + targetCol.getColumnFamily().getName() );
					if (targetCol.getColumnFamily().getPK() == null)
						pkObj = new PKImpl();
					else
						pkObj = targetCol.getColumnFamily().getPK();
					//System.out.println("Adding "+targetCol.getName());
					pkObj.getColumns().add(targetCol);
					targetCol.getColumnFamily().setPK(pkObj);
					/*System.out.print("The columns: ");
					for(nosql.Column col: (EList<nosql.Column>)targetCol.getColumnFamily().getPK().getColumns()){
						System.out.print(col.getName()+" ");
					}
					System.out.println();*/
					break;
				case ConstraintType.UNIQUE_VALUE:
					// no corresponding implementation in Cassandra , not to be
					// implemented
					//System.out.println("Hiii I am  UNIQUE_VALUE " + targetCol.getColumnFamily().getName() );
					
					break;

				case ConstraintType.FOREIGN_KEY_VALUE:
					//System.out.println("Hiii I am FK " + targetCol.getColumnFamily().getName() );
					//System.out.println(constraint.getName()+" with type "+constraint.getType() +" on "+constraint.getReferences().get(0));
					//System.out.println("Reference: Table: "+constraint.getReferenceTable().getName()+ "( "+constraint.getReferenceTable().getColumns().get(0).getName()+" )\n\n");
					// create new column family
					ColumnFamily ref = new ColumnFamilyImpl();
					ref.setName(constraint.getReferenceTable().getName()+"_"+targetCol.getColumnFamily().getName());
					// initialize the PK and set the reference table name
					pkObj = new PKImpl();
					// create primary key col.
					nosql.Column pkCol = (nosql.Column)t.transform(SqlCol2NoSqlCol.class, constraint.getReferenceTable().getColumns().get(0));
					pkCol.setName(constraint.getReferenceTable().getName()+"_"+pkCol.getName());
					// add column to the family column.
					ref.getColumns().add(pkCol);
					// add the pkCol to pkObj list
					pkObj.getColumns().add(pkCol);
					// add the column to the column family
					pkCol.setColumnFamily(ref);
					// set the PK
					ref.setPK(pkObj);
					// add the column family to keyspace
					Main.mainKeySpace.getFamilies().add(ref);
					ref.setKeyspace(Main.mainKeySpace);
					/*for(nosql.Column c: (EList<Column>)ref.getColumns()){
						System.out.print(c.getName()+"\t");
					}*/
					//System.out.println();
					break;
				default:
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public ColumnFamily fillData (Table table , ColumnFamily colFamily)
	{
		//System.out.println(" ---- No of constraints: "+table.getConstraints().size());
		//System.out.println("~~~~~~~~~~~~ Fill Data for table: "+table.getName());
		for (metamodel.Row sqlRow : table.getRows()) {
			nosql.Row noSqlRow = new nosql.impl.RowImpl();
			noSqlRow.setComment(colFamily.getComment());
			noSqlRow.setKeyspace(colFamily.getKeyspace());
			noSqlRow.setName(colFamily.getName());
			//noSqlRow.setPK(colFamily.getPK());
			
			for (metamodel.Cell sqlCell : sqlRow.getCells()) {
				nosql.Cell noSqlCell = new nosql.impl.CellImpl();
				noSqlCell.setValue(sqlCell.getValue());
				noSqlCell.setColumn(getNoSqlColumn(colFamily.getColumns() , sqlCell.getColumn().getName()));
				noSqlRow.getCells().add(noSqlCell);
			}
			colFamily.getRows().add(noSqlRow);
			
			
			for(metamodel.Column col: table.getColumns()){
			
				
				for(Constraint cons: col.getReferences()){
					//System.out.println(" -----Cons of type: "+cons.getType().getName());
					if(cons.getType() == ConstraintType.FOREIGN_KEY){
						//System.out.println(" @@@@@@@@@@@@ IN FOREIGN KEY @@@@@@@@@@@@@@@@@@@");
						ColumnFamily refTable = getColumnFamily(cons.getReferenceTable().getName()+"_"+table.getName());
						if(refTable == null)
							System.err.println("FOREIGN KEY REFERENCE TABLE NOT FOUND!!");
						else{
							//System.out.println("Finding column: "+col.getName());
							String refValue = getCell(noSqlRow.getCells(), col.getName()).getValue();
							//System.out.println("RefValue----> "+refValue);
							
							boolean present = false;
							nosql.Row refTableRow = null;
							for(nosql.Row rows: (EList<nosql.Row>)refTable.getRows()){
								if(getCell(rows.getCells(), ((nosql.Column)refTable.getPK().getColumns().get(0)).getName()).getValue().equals(refValue)){
									present = true;
									//System.out.println("Its present.... will add additional column to same row");
									refTableRow = rows;
									break;
								}
							}
							if(!present){
								refTableRow = new nosql.impl.RowImpl();
								refTableRow.setKeyspace(refTable.getKeyspace());
								refTableRow.setName(refTable.getName());
								//refTableRow.setPK(refTable.getPK());
								
								nosql.Cell refTablePKCell = new nosql.impl.CellImpl();
								refTablePKCell.setValue(refValue);
								refTablePKCell.setColumn((nosql.Column)refTable.getPK().getColumns().get(0));
								refTableRow.getCells().add(refTablePKCell);
							}
							
							nosql.Column refTableCol = new nosql.impl.ColumnImpl();
							refTableCol.setColumnFamily(refTableRow);
							refTableCol.setDatatype(((nosql.Column)colFamily.getPK().getColumns().get(0)).getDatatype());
							refTableCol.setSize(((nosql.Column)colFamily.getPK().getColumns().get(0)).getSize());
							refTableCol.setName(((nosql.Column)colFamily.getPK().getColumns().get(0)).getName()+"_"+new SimpleDateFormat("yyyyMddHHmmss").format(Calendar.getInstance().getTime())+"_"+ Main.colNameCounter);
											
							refTableRow.getAdditionalColumns().add(refTableCol);
							
							nosql.Cell refTableCell = new nosql.impl.CellImpl();
							refTableCell.setValue(getCell(noSqlRow.getCells(), ((nosql.Column)colFamily.getPK().getColumns().get(0)).getName()).getValue());
							refTableCell.setColumn(refTableCol);
							refTableRow.getCells().add(refTableCell);
							
							refTable.getRows().add(refTableRow);
							refTable.getColumns().add(refTableCol);
							//System.out.println("name of ref col " + refTableCol.getName());
							
							Main.colNameCounter++;
							
					
						}
					}
				}
			}
		}/*
		System.out.println(" ************ LETS TRY AGAIN");
		for(nosql.Column col2: (EList<nosql.Column>)colFamily.getPK().getColumns()){
			System.out.print(col2.getName()+" ");
		}
		System.out.println();*/

		return colFamily;
		
	}

	private Column getNoSqlColumn(EList columns, String name) {
		for (Object object : columns) {
			if(((Column)object).getName().equalsIgnoreCase(name))
				return (Column)object;
		}
		return null;
	}

	private ColumnFamily getColumnFamily(String name) {
		for (Object object : Main.mainKeySpace.getFamilies()) {
			if(((ColumnFamily)object).getName().equalsIgnoreCase(name))
				return (ColumnFamily)object;
		}
		return null;
	}

	private nosql.Cell getCell(EList cells, String name) {
		//System.out.println("\n\n");
		for (Object object : cells) {
			//System.out.println("                      Matching : "+ ((nosql.Cell)object).getColumn().getName()+ " --> "+name);
			if(((nosql.Cell)object).getColumn().getName().equalsIgnoreCase(name))
				return (nosql.Cell)object;
		}
		return null;
	}

}
