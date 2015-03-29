package bham.transformation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
	public static ArrayList<Long> times = new ArrayList<Long>();
	public static long totalTime=0;

	public static void main(String[] args) {
		try {
			times.add(System.currentTimeMillis());
			System.out.println(times.get(0)+ " Started");
			// initializing rules
			SimpleTransformerImpl converter = new SimpleTransformerImpl(null);
			converter.addRuleType(Database2Keyspace.class);
			converter.addRuleType(Table2ColumnFamily.class);
			converter.addRuleType(SqlCol2NoSqlCol.class);
	
			times.set(0, System.currentTimeMillis());
			// converting sql db into objects using the sql meta model
			System.out.println(new Date()+ " starting generate Sql MM objects.....");
			DBTransformationService dbConnector = new DBTransformationService();
			Database db = dbConnector.generate();
			// converting sql meta module into no-sql meta model using sitra
			
			System.out.println("\n"+new Date()+" converting Sql to NoSql MM objects.....\n");
			KeySpace keyspace = converter.transform(Database2Keyspace.class, db);

			// Genarating no-sql db from the converted model
			System.out.println("\n"+new Date()+" inserting to casandra...\n");
			times.add(System.currentTimeMillis());
			totalTime=0;
			CDBTransformationService t = new CDBTransformationService();
			t.generate(keyspace);

			System.out.println("\n"+new Date()+" COMPLETED. ");

		} catch (RuleNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static long calTimeDiff(boolean addToTotal){
		long ans = times.get(times.size()-1)- times.get(times.size()-2);
		if(addToTotal)
			totalTime+=ans;
		return ans;
	}
}
