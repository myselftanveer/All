package logging;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRestApi {
	
	@Test
	public void createUser() {
		RestAssured.baseURI="https://gorest.co.in";

/***************************Create User ************************************************/		
				RequestSpecification res = given().relaxedHTTPSValidation().log().all().header("authorization", "Bearer f98e81806c6b3e3e1b55690c89bf0269a5ecaa2ac5fa9b01ece4cc5b2429ddc2")
				.accept(ContentType.JSON).contentType(ContentType.JSON).body("{\r\n"
						+ "  \"name\": \"pqr\",\r\n"
						+ "  \"gender\": \"male\",\r\n"
						+ "  \"email\": \"p1qwesd1r.xyz@15ce.com\",\r\n"
						+ "  \"status\": \"active\"\r\n"
						+ "}");
				String response = res.when().post("/public/v2/users/")
				.then().log().all().assertThat().statusCode(201)
				.body("name", equalTo("pqr"),"status",equalTo("active"))
				.extract().response().asString();
				System.out.println(res);
				
				JsonPath js =new JsonPath(response);
				int ID = js.get("id");
				System.out.println(ID);
				
				Response r = res.when().post("/public/v2/users/");
				
				System.out.println("======================================================="+r.getStatusCode());
				System.out.println("======================================================="+r.getStatusLine());
				System.out.println("======================================================="+r.getBody());
				
	}

}
