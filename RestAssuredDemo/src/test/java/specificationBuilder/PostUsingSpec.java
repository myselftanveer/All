package specificationBuilder;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import resources.PayLoad;

public class PostUsingSpec {
	
public static void main(String[] args) throws IOException {
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		
/********************POST Request without Spec============AddPlaceApi****************************/
		
				
				/*String response = given().queryParam("key", "qaclick123").header("Content_Type", "application/json")
						.body(PayLoad.AddPlaceApi())
						.when().post("/maps/api/place/add/json")
						.then().log().all().assertThat()
						.statusCode(200).extract().response().asString();
				
				System.out.println("Responce="+response);*/

/********************POST Request with Spec============AddPlaceApi****************************/
	
	String response = given()
						.spec(Specification.request()).body(PayLoad.AddPlaceApi())
			         .when()
			         	.post("/maps/api/place/add/json")
			         .then().log().all().spec(Specification.response()).extract().response().asString();
	
	System.out.println("Responce="+response);
	}


}
