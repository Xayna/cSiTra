package bham.transformation;

import java.util.Calendar;

import metamodel.Database;
import nosql.KeySpace;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.SimpleTransformerImpl;
import bham.transformation.rules.Database2Keyspace;
import bham.transformation.rules.SqlCol2NoSqlCol;
import bham.transformation.rules.Table2ColumnFamily;

public class Main {

	public static KeySpace mainKeySpace = null;
	public static int colNameCounter = 0;

	public static void main(String[] args) {
		try {
			System.out.println("Started :"
					+ Calendar.getInstance().getTime().toString());
			// initializing rules
			SimpleTransformerImpl converter = new SimpleTransformerImpl(null);
			converter.addRuleType(Database2Keyspace.class);
			converter.addRuleType(Table2ColumnFamily.class);
			converter.addRuleType(SqlCol2NoSqlCol.class);
	

			// converting sql db into objects using the sql meta model
			System.out.println("starting generate Sql MM objects :"
					+ Calendar.getInstance().getTime().toString());
			DBTransformationService dbConnector = new DBTransformationService();
			Database db = dbConnector.generate();
			// converting sql meta module into no-sql meta model using sitra
			System.out.println("converting Sql to NoSql MM objects :"
					+ Calendar.getInstance().getTime().toString());
			KeySpace keyspace = converter
					.transform(Database2Keyspace.class, db);

			/*
			 * System.out.println("Keyspace: "+keyspace.getName());
			 * System.out.println("---------------------------------------");
			 * System
			 * .out.println("---------------------- NO OF COLUMN FAMILES: "
			 * +keyspace.getFamilies().size()); for(ColumnFamily colFam:
			 * (EList<ColumnFamily>)keyspace.getFamilies()){
			 * System.out.println("Column Family: "+colFam.getName());
			 * for(Column col: (EList<Column>)colFam.getColumns()){
			 * System.out.println("--Column: "+col.getName());
			 * System.out.println("--Datatype: "+col.getDatatype().getName());
			 * System.out.println("--Size: "+col.getSize());
			 * System.out.println(); } System.out.println(); for(nosql.Row row:
			 * (EList<nosql.Row>)colFam.getRows()){ for(nosql.Cell cell:
			 * (EList<nosql.Cell>)row.getCells()){
			 * System.out.print(cell.getValue
			 * ()+"("+cell.getColumn().getName()+")\t"); } System.out.println();
			 * } System.out.print("Primary Key ------- "); for(Column col:
			 * (EList<Column>)colFam.getPK().getColumns()){
			 * System.out.print(col.getName()+"\t"); } System.out.println();
			 * System
			 * .out.println("----------------------------------------------"); }
			 */
			// Genarating no-sql db from the converted model
			System.out.println("inserting to casandra :"
					+ Calendar.getInstance().getTime().toString());
			CDBTransformationService t = new CDBTransformationService();
			t.generate(keyspace);

			System.out.println("finished :"
					+ Calendar.getInstance().getTime().toString());

		} catch (RuleNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
