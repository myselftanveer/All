package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CrudApiTest {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://gorest.co.in";

/***************************Create User ************************************************/		
		String res = given().relaxedHTTPSValidation().log().all().header("authorization", "Bearer f98e81806c6b3e3e1b55690c89bf0269a5ecaa2ac5fa9b01ece4cc5b2429ddc2")
		.accept(ContentType.JSON).contentType(ContentType.JSON).body("{\r\n"
				+ "    \"name\": \"xyz\",\r\n"
				+ "    \"email\": \"wqqasawewrcxcv@yopmail.com\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"active\"\r\n"
				+ "}")
		.when().post("/public/v2/users")
		.then().log().all().assertThat().statusCode(201)
		.body("name", equalTo("xyz")).extract().response().asString();
		System.out.println(res);
		
		JsonPath js =new JsonPath(res);
		int ID = js.get("id");
		System.out.println(ID);
		
/***************************Get User list************************************************/
		
		String getUser = given().relaxedHTTPSValidation().log().all().header("authorization", "Bearer f98e81806c6b3e3e1b55690c89bf0269a5ecaa2ac5fa9b01ece4cc5b2429ddc2")
		.accept(ContentType.JSON).contentType(ContentType.JSON)
		.when().get("/public/v2/users")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("GetUsers"+getUser);
		
/***************************Get Single User from list************************************************/
		
		String getCreatedUser = given().queryParam("id", ID).relaxedHTTPSValidation().log().all().header("authorization", "Bearer f98e81806c6b3e3e1b55690c89bf0269a5ecaa2ac5fa9b01ece4cc5b2429ddc2")
		.accept(ContentType.JSON).contentType(ContentType.JSON)
		.when().get("/public/v2/users")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Get single Users"+getCreatedUser);
		
/***************************Update User************************************************/

		String updateCreatedUser = given().relaxedHTTPSValidation().log().all().header("authorization", "Bearer f98e81806c6b3e3e1b55690c89bf0269a5ecaa2ac5fa9b01ece4cc5b2429ddc2")
				.accept(ContentType.JSON).contentType(ContentType.JSON)
				.body("{\r\n"
						+ "  \"name\": \"Al12434l Pena\",\r\n"
						+ "  \"email\": \"nic2321e.one@15ce.com\",\r\n"
						+ "  \"status\": \"active\"\r\n"
						+ "}")
				.when().patch("/public/v2/users/"+ID+"")
				.then().log().all().extract().response().asString();
				System.out.println("UpdateUser"+updateCreatedUser);
				
/***************************Get Delete User from list************************************************/
				
				String deleteCreatedUser = given().relaxedHTTPSValidation().log().all().header("authorization", "Bearer f98e81806c6b3e3e1b55690c89bf0269a5ecaa2ac5fa9b01ece4cc5b2429ddc2")
				.accept(ContentType.JSON).contentType(ContentType.JSON)
				.when().delete("/public/v2/users/"+ID+"")
				.then().log().all().extract().response().asString();
				System.out.println("Delete Users"+deleteCreatedUser);
	}

}
