package resourses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

public class Utils {

	public static String getConfig(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/java/resourses/config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	public static JsonPath convertRawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	public static String StringtoJSON(Object obj) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		String request = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		return request;
	}

}
