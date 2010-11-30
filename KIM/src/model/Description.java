package model;

import org.openrdf.model.URI;
import org.openrdf.model.Value;

public class Description implements Comparable {
	private String property;
	private String value;
	public Description(URI uri, Value value){
		this.property = uri.getLocalName();
		this.value = value.toString();
	}
	
	public Description(String property, String value){
		this.property = property;
		this.value = value;
	}
	

	public String getProperty(){
		return property;
	}
	public String getValue(){
		return value;
	}

	@Override
	public int compareTo(Object arg0) {
		Description obj = (Description) arg0;
		if (this.equals(obj)) {
			return 0;
		}
		return -1;
	}
}