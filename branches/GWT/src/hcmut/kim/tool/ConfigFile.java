package hcmut.kim.tool;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.yaml.snakeyaml.Yaml;

public class ConfigFile {
	private static Yaml yaml = null;
	private static Map<String, Object> map = null;
	
	public static Set<String> getListClass() {
		if (yaml==null) {
			loadFromFile();
		}
		return map.keySet();
	}
	
	public static Map<String, Object> getElementsByClass(String className) {
		return (Map<String, Object>) map.get(className);
	}
	
	@SuppressWarnings("unchecked")
	private static void loadFromFile() {
		yaml = new Yaml();
		try {
			Map<String, Object> map = (Map<String, Object>) yaml.load(new FileReader("config.yaml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
