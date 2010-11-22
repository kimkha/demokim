package hcmut.kim.model;

import java.util.Set;

public interface SimilaryResult {
	void addToSimilaryList(KIMAttribute activeAttr, KIMAttribute passiveAttr);
	void generateDifferenceList(Set<KIMAttribute> activeList, Set<KIMAttribute> passiveList);
	
	int getNumOfSimilaryCouple();
	Set<KIMAttribute> getSimilaryActiveList();
	Set<KIMAttribute> getSimilaryPassiveList();
	
	int getNumOfDifference();
	int getNumOfDifferenceCouple();
	Set<KIMAttribute> getActiveDifferenceList();
	Set<KIMAttribute> getPassiveDifferenceList();
}
