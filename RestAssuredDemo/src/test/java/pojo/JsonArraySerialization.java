package pojo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonArraySerialization {
	
	public String completeJson;
	
	@Test
	public void createJsonArrayFromPOJO() throws JsonProcessingException {
		
		JsonArrayPOJO mark =new JsonArrayPOJO();
		mark.setFirstName("Mark");
		mark.setLastName("Waugh");
		mark.setGender("Male");
		mark.setAge(30);
		mark.setSalary(10000);
		mark.setMaritialStatus(true);
		
		JsonArrayPOJO steve =new JsonArrayPOJO();
		steve.setFirstName("Steve");
		steve.setLastName("Waugh");
		steve.setGender("Male");
		steve.setAge(32);
		steve.setSalary(20000);
		steve.setMaritialStatus(true);
		
		JsonArrayPOJO shane =new JsonArrayPOJO();
		shane.setFirstName("Shane");
		shane.setLastName("Waugh");
		shane.setGender("Male");
		shane.setAge(33);
		shane.setSalary(30000);
		shane.setMaritialStatus(true);
		
		List<JsonArrayPOJO> allemp = new ArrayList<JsonArrayPOJO>();
		allemp.add(mark);
		allemp.add(steve);
		allemp.add(shane);
		
		ObjectMapper mapper =new ObjectMapper();
		completeJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allemp);
		System.out.println("Serialization="+completeJson);
	}
	@Test
	public void getPOJOFromObject() throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper =new ObjectMapper();
		List<JsonArrayPOJO> allemp =mapper.readValue(completeJson, new TypeReference<List<JsonArrayPOJO>>() {});
		for(JsonArrayPOJO emp:allemp) {
			System.out.println("===============================================");
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getGender());
			System.out.println(emp.getAge());
			System.out.println(emp.getSalary());
			System.out.println(emp.isMaritialStatus());
			System.out.println("===============================================");
		}
		
	}
	
	

}
