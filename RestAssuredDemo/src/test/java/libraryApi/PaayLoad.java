package libraryApi;

import java.util.Random;

public class PaayLoad {
	
	static Random randomGenerator = new Random();
	static int randomNo = randomGenerator.nextInt(1000);

	public static String AddBook(String isbn, String author) {
		
		return "{\r\n"
				+ "	\"name\": \"RestAssured with TestNG\",\r\n"
				+ "	\"isbn\": \""+isbn+"\",\r\n"
				+ "	\"aisle\": \""+randomNo+"\",\r\n"
				+ "	\"author\": \""+author+"\"\r\n"
				+ "}";

	}
	
	public static String DeleteBookByID(String id) {
		
		return"{\r\n"
				+ "    \"ID\": \""+id+"\"\r\n"
				+ "}";
	}

}
