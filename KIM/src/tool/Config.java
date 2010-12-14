package tool;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.yaml.snakeyaml.Yaml;

public class Config {
	private static Yaml yaml = null;
	private static Map<String, Object> map = null;
	private static String filename = "config.yaml";
	
	public static void setFile(String file) {
		filename = file;
		yaml = null;
		map = null;
	}
	
	public static Set<String> getListClass() {
		if (yaml==null) {
			loadFromFile();
		}
		return map.keySet();
	}
	
	public static double getPriority(String className, String property) {
		ArrayList<Map<String, Object>> e = getElementsByClass(className);
		Map<String, Object> p = null;
		for (int i=0; i<e.size(); i++) {
			Map<String, Object> m = e.get(i);
			if (m.containsKey(property)) {
				p = m;
			}
		}
		if (p==null) {
			return 0.5;
		}
		String v="0.5";
		Object[] l = p.values().toArray();
		for (int i=0; i<l.length; i++) {
			v = (String) l[i].toString();
		}
		return Double.valueOf(v);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Map<String, Object>> getElementsByClass(String className) {
		if (yaml==null) {
			loadFromFile();
		}
		return (ArrayList<Map<String, Object>>) map.get(className);
	}
	
	@SuppressWarnings("unchecked")
	private static void loadFromFile() {
		yaml = new Yaml();
		try {
			map = (Map<String, Object>) yaml.load(new FileReader(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
