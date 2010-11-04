import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.KIMEntity;
import tool.KIMAPI;

import com.ontotext.kim.client.CompareStyleConstants;
import com.ontotext.kim.client.model.WKBConstants;
import com.ontotext.kim.client.query.KIMQueryException;
import com.ontotext.kim.client.query.SemanticQuery;

public class Test {
	public static void main(String args[]) {

		try {
			KIMAPI.start();
			System.out.println("QueryAPI obtained successful");
			SemanticQuery seq1 = new SemanticQuery();

			seq1.addRequestedVar("ORG"); // add variable ORG of class
			// Organization
			seq1.addRequestedVar("PERS"); // add variable PERS of class Person
			seq1.addRequestedVar("POS"); // add variable POS of class Position
			seq1.setClass("ORG", WKBConstants.CLASS_ORGANIZATION);
			seq1.setClass("PERS", WKBConstants.CLASS_PERSON);
			seq1.setClass("POS", WKBConstants.CLASS_JOB_POSITION);
			seq1.addNameRestriction("POS",
					CompareStyleConstants.COMPARE_STYLE_CONTAINS, "manager"); // restrict
			// position
			// to
			// contain
			// 'manager'
			seq1.addNameRestriction("PERS",
					CompareStyleConstants.COMPARE_STYLE_STARTS_WITH, "John"); // restrict
			// person
			// to
			// start
			// with
			// 'John'
			seq1.addPatternRestriction("PERS",
					WKBConstants.PROPERTY_HAS_POSITION, "POS"); // restrict
			// person to has
			// position in
			// "POS"
			// variable
			seq1.addPatternRestriction("POS",
					WKBConstants.PROPERTY_WITHIN_ORGANIZATION, "ORG"); // restrict
			// entities to be returned with labels
			// ----------------------------------------------------------------------------------
			List<KIMEntity> listEntities = KIMAPI.getEntities(seq1);

			FileWriter file = new FileWriter("entity.txt");
			System.out.println("[ Entity Result (begin) ]");
			file.write("[ Entity Result (begin) ]\n");
			System.out.println("Entity Result size : " + listEntities.size());
			file.write("Entity Result size : " + listEntities.size() + "\n");
			file.write("----------------------------\n");

			for (int i=0; i<listEntities.size(); i++) {
				// TODO Do something
				System.out.println(listEntities.get(i).getMainLabel());
				file.write(listEntities.get(i).getMainLabel()+"\n");
			}
			
			file.close();
			System.out.println("---------------------------");
			System.out.println("[ Entity Result (end) ]");
		} catch (KIMQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
