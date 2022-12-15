package pojo;

import java.util.Random;

public class PojoCreateUserData {
	
	static Random randomGenerator = new Random();
	static int randomNo = randomGenerator.nextInt(1000);
	
	public PojoCreateUser createUser() {
		
		
		PojoCreateUser pojo = new PojoCreateUser();
		pojo.setName("QA");
		pojo.setEmail("qa"+randomNo+"@yopmail.com");
		pojo.setGender("Male");
		pojo.setStatus("Active");
		return pojo;
	}

}
