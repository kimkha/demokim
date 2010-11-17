package model;

import java.util.HashSet;
import java.util.Set;

public class SimilaryResultImpl implements SimilaryResult {
	private Set<KIMAttribute> activeSimilaryList = new HashSet<KIMAttribute>();
	private Set<KIMAttribute> passiveSimilaryList = new HashSet<KIMAttribute>();
	
	private Set<KIMAttribute> activeDifferenceList = null;
	private Set<KIMAttribute> passiveDifferenceList = null;

	@Override
	public void addToSimilaryList(KIMAttribute activeAttr,
			KIMAttribute passiveAttr) {
		this.activeSimilaryList.add(activeAttr);
		this.passiveSimilaryList.add(passiveAttr);
	}

	@Override
	public void generateDifferenceList(Set<KIMAttribute> activeList,
			Set<KIMAttribute> passiveList) {
		this.activeDifferenceList = activeList;
		this.activeDifferenceList.removeAll(this.activeSimilaryList);
		
		this.passiveDifferenceList = passiveList;
		this.passiveDifferenceList.removeAll(this.passiveSimilaryList);
	}

	@Override
	public int getNumOfSimilaryCouple() {
		return this.activeSimilaryList.size();
	}

	@Override
	public Set<KIMAttribute> getSimilaryActiveList() {
		return this.activeSimilaryList;
	}

	@Override
	public Set<KIMAttribute> getSimilaryPassiveList() {
		return this.passiveSimilaryList;
	}

	@Override
	public int getNumOfDifference() {
		if (this.activeDifferenceList == null || this.passiveDifferenceList == null) {
			return 0;
		}
		return (this.activeDifferenceList.size() + this.passiveDifferenceList.size());
	}

	@Override
	public int getNumOfDifferenceCouple() {
		if (this.activeDifferenceList == null || this.passiveDifferenceList == null) {
			return 0;
		}
		//TODO Su dung ham min khong biet co dung ko...
		return Math.min(this.activeDifferenceList.size(), this.passiveDifferenceList.size());
	}

	@Override
	public Set<KIMAttribute> getActiveDifferenceList() {
		return this.activeDifferenceList;
	}

	@Override
	public Set<KIMAttribute> getPassiveDifferenceList() {
		return this.passiveDifferenceList;
	}

}
