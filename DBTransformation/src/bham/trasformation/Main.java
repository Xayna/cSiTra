package bham.trasformation;

import java.sql.Connection;

import metamodel.Database;
import nosql.Column;
import nosql.ColumnFamily;
import nosql.KeySpace;

import org.eclipse.emf.common.util.EList;

import com.datastax.driver.core.Session;

import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.SimpleTransformerImpl;
import bham.trasformation.rules.Database2Keyspace;
import bham.trasformation.rules.SQLCell2NoSQLCell;
import bham.trasformation.rules.SQLCons2NoSQLCons;
import bham.trasformation.rules.SqlCol2NoSqlCol;
import bham.trasformation.rules.Table2ColumnFamily;

public class Main {
	public static KeySpace mainKeySpace = null ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			SimpleTransformerImpl converter = new SimpleTransformerImpl(null);
			converter.addRuleType(Database2Keyspace.class);
			converter.addRuleType(Table2ColumnFamily.class);
			converter.addRuleType(SqlCol2NoSqlCol.class);
			converter.addRuleType(SQLCell2NoSQLCell.class);
			converter.addRuleType(SQLCons2NoSQLCons.class);
			
			
			DBTransformationService dbConnector = new DBTransformationService();
			Database db = dbConnector.generate();
			
			
			KeySpace keyspace = converter.transform(Database2Keyspace.class, db);
			
			System.out.println("Keyspace: "+keyspace.getName());
			System.out.println("---------------------------------------");
			for(ColumnFamily colFam: (EList<ColumnFamily>)keyspace.getFamilies()){
				System.out.println("Column Family: "+colFam.getName());
				for(Column col: (EList<Column>)colFam.getColumns()){
					System.out.println("--Column: "+col.getName());
					System.out.println("--Datatype: "+col.getDatatype().getName());
					System.out.println("--Size: "+col.getSize());
					System.out.println();
				}
				System.out.println("----------------------------------------------");
			}
			
		} 
		catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
