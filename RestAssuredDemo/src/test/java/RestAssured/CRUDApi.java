package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resources.PayLoad;

public class CRUDApi {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
/********************POST Request============AddPlaceApi****************************/
		
		String response = given().queryParam("key", "qaclick123").header("Content_Type", "application/json")
				.body(PayLoad.AddPlaceApi()).when().post("/maps/api/place/add/json")
				.then().assertThat()
				.statusCode(200).extract().response().asString();
		
		System.out.println("Responce="+response);
		
//		String ref = response.substring((response.indexOf("\"reference\":\"")+("\"reference\":\""));
		
		String ref=response.split("\"reference\":\"")[1];
		System.out.println(ref);
		String reference=ref.split("\",\"id")[0];
		System.out.println("Refrence="+reference);
		
//		JSONObject json=new JSONObject(response);
//		System.out.println("Reference="+json.getString("reference"));
//		
		
		JsonPath js = new JsonPath(response);
		String PlaceID = js.getString("place_id");
		System.out.println("place id="+PlaceID);


/********************Update Request============UpdatePlaceApi****************************/
		
		String newAdd="Pune";
		
		String updateApi=given().log().all().queryParam("key", "qaclick123").header("Content_Type", "application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+PlaceID+"\",\r\n"
						+ "\"address\":\""+newAdd+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}")
				.when().put("/maps/api/place/update/json")
				.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Updated Address:"+updateApi);
				
		

/********************GET Request============GetPlaceApi****************************/
		
		String getPlcae=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceID).header("Content_Type", "application/json")
				.when().get("/maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Get Place API:"+ getPlcae);
		
		JsonPath js1 = new JsonPath(getPlcae);
		
		String actualAddress=js1.get("address");
		Assert.assertEquals(newAdd,actualAddress);
		
/********************Delete Request============DeletePlaceApi****************************/
		
		String deletePlcae=given().log().all().queryParam("key", "qaclick123").header("Content_Type", "application/json")
				.body("{\r\n"
						+ "    \"place_id\":\""+PlaceID+"\"\r\n"
						+ "}")
				.when().get("/maps/api/place/delete/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Delete Place API:"+deletePlcae);
	}

}
