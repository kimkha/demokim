package tool;

import java.util.List;

import org.openrdf.model.Literal;

import model.KIMAttribute;
import model.KIMEntity;

public class DuplicateAPI {
	public static double Similarity(KIMEntity e1, KIMEntity e2){
		return 0;
	}
	
	public static double getAttributeStrength(KIMAttribute a){
		return 0;
	}
	
	public static double getSimilarity(String s1, String s2, KIMAttribute a){
		return 0;
	}
	
	public static double getSimilarity(List<Literal> values1, List<Literal> values2, KIMAttribute a){
		return 0;
	}
	
	public static double getSimilarity(KIMAttribute a1, KIMAttribute a2){
		return 0;
	}
	
	public static double getSimilarityInAttribute(KIMEntity e1, KIMEntity e2){
		return 0;
	}
	
	
	
	public static double getDifferentInAttribute(KIMEntity e1, KIMEntity e2){
		return 0;
	}
	
	public boolean isComparable(KIMAttribute a1, KIMAttribute a2){
		if(a1.getLabel() == a2.getLabel())
			return true;
		return false;
	}
}
