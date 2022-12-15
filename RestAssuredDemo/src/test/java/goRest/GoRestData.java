package goRest;

import java.util.Random;

public class GoRestData {
	
	static Random randomGenerator = new Random();
	static int randomNo = randomGenerator.nextInt(1000);
	
	public static GoRestPOJO goRestPayload() {
		
		GoRestPOJO pojo = new GoRestPOJO();
		pojo.setName("QA");
		pojo.setGender("Male");
		pojo.setEmail("qa"+randomNo+"@yopmail.com");
		pojo.setStatus("Active");
		
		return pojo;
	}

}
