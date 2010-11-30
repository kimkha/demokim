package tool;

import java.util.ArrayList;
import java.util.List;

import com.ontotext.kim.client.entity.EntityDescription;

import model.KIMEntity;

public class FMeasure {
	private ArrayList<Element> listEntities = new ArrayList<Element>();
	private int currentElement = -1;
	
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
		public boolean isRealDuplicate() {
			return this.isRealDupl;
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
