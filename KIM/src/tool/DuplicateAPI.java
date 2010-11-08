package tool;

import java.util.List;

import org.openrdf.model.Literal;

import com.ontotext.kim.client.query.KIMQueryException;

import tool.jaro.JaroWinklerDistance;

import model.KIMAttribute;
import model.KIMEntity;

public class DuplicateAPI {
	private static JaroWinklerDistance jaro = JaroWinklerDistance.JARO_WINKLER_DISTANCE;
	
	public static double Similarity(KIMEntity e1, KIMEntity e2){
		return 0;
	}
	
	public static double getAttributeStrength(KIMAttribute a){
		return 1;
	}
	
	public static double getSimilarity(String s1, String s2, KIMAttribute a){
		double prox = jaro.proximity(s1, s2);
		return prox;
	}
	
	public static double getSimilarity(List<Literal> values1, List<Literal> values2, KIMAttribute a){
		double total = 0;
		int num = 0;
		for (int i=0; i<values1.size(); i++) {
			Literal v1 = values1.get(i);
			for (int j=0; j<values2.size(); j++) {
				Literal v2 = values2.get(j);
				total += getSimilarity(v1.stringValue(), v2.stringValue(), a); 
				num++;
			}
		}
		if (num<=0) {
			return 0;
		}
		return total/num*getAttributeStrength(a);
	}
	
	public static double getSimilarity(KIMAttribute a1, KIMAttribute a2){
		return getSimilarity(a1.values, a2.values, a1);
	}
	
	public static double getSimilarity(List<KIMAttribute> val1, List<KIMAttribute> val2) {
		double total = 0;
		int num = 0;
		
		for (int i=0; i<val1.size(); i++) {
			KIMAttribute a1 = val1.get(i);
			for (int j=0; j<val2.size(); j++) {
				KIMAttribute a2 = val2.get(i);
				if (a1.getLabel().equals(a2.getLabel())) {
					total += getSimilarity(a1, a2);
					num++;
				}
			}
		}
		
		if (num <= 0) {
			return 0;
		}
		return total/num;
	}
	
	public static double getSimilarityInAttribute(KIMEntity e1, KIMEntity e2){
		if (!e1.isExtracted) {
			try {
				e1.extract();
			} catch (KIMQueryException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		if (e2.isExtracted) {
			try {
				e2.extract();
			} catch (KIMQueryException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		return getSimilarity(e1.attributes, e2.attributes);
	}
	
	public static double getDifferentInAttribute(KIMEntity e1, KIMEntity e2){
		return (1-getSimilarityInAttribute(e1, e2));
	}
	
	public boolean isComparable(KIMAttribute a1, KIMAttribute a2){
		if(a1.getLabel() == a2.getLabel())
			return true;
		return false;
	}
}
