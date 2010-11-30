package tool;

import java.util.ArrayList;

import model.KIMEntity;

public class FMeasure {
	private ArrayList<Element> listEntities = new ArrayList<Element>();
	private int currentElement = -1;
	
	public void setCurrentEntity(KIMEntity entity, String targetURI) {
		Element el = new Element();
		el.setEntity(entity, targetURI);
		
		listEntities.add(el);
		this.currentElement = listEntities.size()-1;
	}
	
	public void addRelatedEntity(String relatedURI, double similary) {
		Element el = listEntities.get(currentElement);
		el.add(relatedURI, similary);
	}
	
	private class Element {
		private String entityURI;
		private KIMEntity entity;
		private ArrayList<Item> listTarget = new ArrayList<Item>();
		public void setEntity(KIMEntity entity, String entityURI) {
			this.entityURI = entityURI;
			this.entity = entity;
		}
		public KIMEntity getEntity() {
			return entity;
		}
		public String getEntityURI() {
			return entityURI;
		}
		public void add(String relatedURI, double sim) {
			Item i = new Item();
			i.setEntity(relatedURI);
			i.setSimilaryRate(sim);
			listTarget.add(i);
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