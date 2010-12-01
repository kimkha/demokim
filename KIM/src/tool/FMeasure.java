package tool;

import java.util.ArrayList;
import java.util.List;

import com.ontotext.kim.client.entity.EntityDescription;

import model.KIMEntity;

public class FMeasure {
	private ArrayList<Element> listEntities = new ArrayList<Element>();
	private int currentElement = -1;
	private int bNum = 0;
	private int dNum = 0;
	private int bdNum = 0;
	private boolean isCalc = false;
	
	public double getFMeasure(double threshold) {
		double recall = this.getRecall(threshold);
		double precision = this.getPrecision(threshold);
		
		isCalc = false;
		
		if (recall==0 && precision==0) {
			return 0;
		}
		return (2*recall*precision)/(recall+precision);
	}
	
	private double getRecall(double threshold) {
		if (!this.isCalc) {
			this.calculate(threshold);
		}
		return ((double) this.bdNum)/this.bNum;
	}
	private double getPrecision(double threshold) {
		if (!this.isCalc) {
			this.calculate(threshold);
		}
		return ((double) this.bdNum)/this.dNum;
	}
	private void calculate(double threshold) {
		this.bdNum = 0;
		this.bNum = 0;
		this.dNum = 0;
		for (int i=0; i<this.listEntities.size(); i++) {
			Element el = this.listEntities.get(i);
			if (el.isRealDuplicate()) {
				this.bNum++;
				if (el.isDuplicate(threshold)) {
					this.bdNum++;
				}
			}
			this.dNum += el.maybeDuplicate(threshold);
		}
		isCalc = true;
	}
	
	public void addCurrentEntity(EntityDescription entity, String targetURI, boolean isRealDupl) {
		Element el = new Element();
		el.setEntity(entity, targetURI, isRealDupl);
		
		listEntities.add(el);
		this.currentElement = listEntities.size()-1;
	}
	public void setActive(int activeItem) {
		this.currentElement = activeItem;
	}
	
	public void addRelatedEntity(String relatedURI, double similary) {
		Element el = listEntities.get(currentElement);
		el.add(relatedURI, similary);
	}
	
	public List<Element> getEntities() {
		return this.listEntities;
	}
	public EntityDescription getEntity(int i) {
		return this.listEntities.get(i).getEntity();
	}
	public int countEntities() {
		return this.listEntities.size();
	}
	
	private class Element {
		private String entityURI;
		private EntityDescription entity;
		private boolean isRealDupl;
		private ArrayList<Item> listTarget = new ArrayList<Item>();
		private double max = 0;
		private String maxURI = "";
		private int mayDupl = -1;
		public void setEntity(EntityDescription entity, String entityURI, boolean isRealDupl) {
			this.entityURI = entityURI;
			this.entity = entity;
			this.isRealDupl = isRealDupl;
		}
		public EntityDescription getEntity() {
			return entity;
		}
		public String getEntityURI() {
			return entityURI;
		}
		public boolean isDuplicate(double threshold) {
			return (this.max>threshold)
				&& this.maxURI.toLowerCase().equals(this.entityURI.toLowerCase());
		}
		public boolean isRealDuplicate() {
			return this.isRealDupl;
		}
		public int maybeDuplicate(double threshold) {
			this.mayDupl = 0;
			for (int i=0; i<this.listTarget.size(); i++) {
				if (this.listTarget.get(i).similaryRate >= threshold) {
					this.mayDupl++;
				}
			}
			return mayDupl;
		}
		public void add(String relatedURI, double sim) {
			Item i = new Item();
			i.setEntity(relatedURI);
			i.setSimilaryRate(sim);
			listTarget.add(i);
			if (sim>max) {
				this.max = sim;
				this.maxURI = relatedURI;
			}
		}
		public ArrayList<Item> getListTarget() {
			return listTarget;
		}
	}
	
	private class Item {
		private double similaryRate;
		private String entity;
		public void setEntity(String relatedURI) {
			this.entity = relatedURI;
		}
		public String getEntity() {
			return entity;
		}
		public void setSimilaryRate(double similaryRate) {
			this.similaryRate = similaryRate;
		}
		public double getSimilaryRate() {
			return similaryRate;
		}
	}
}
