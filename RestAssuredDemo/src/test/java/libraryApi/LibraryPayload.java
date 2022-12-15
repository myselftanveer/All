package libraryApi;

import java.util.Random;

public class LibraryPayload {
	
	
	public static String AddBook() {
		
		return "{\r\n"
				+ "	\"name\": \"RestAssured with TestNG\",\r\n"
				+ "	\"isbn\": \"abc\",\r\n"
				+ "	\"aisle\": \"715439\",\r\n"
				+ "	\"author\": \"James New\"\r\n"
				+ "}";

	}
	
	public static String DeleteBookByID() {
		
		return"{\r\n"
				+ "    \"ID\": \"bcd2926\"\r\n"
				+ "}";
	}

}
