package pojoApproch;

import static io.restassured.RestAssured.given;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.PayLoad;
import specificationBuilder.Specification;

public class PostUsingPOJO {

	public static void main(String[] args) throws IOException {

//		RestAssured.baseURI = "https://rahulshettyacademy.com";

		AddPlace add = new AddPlace();
		add.setAccuracy(50);
		add.setAddress("PUNE");
		add.setLanguage("Marathi");
		add.setPhone_number("(+91) 1231231234");
		add.setWebsite("https://xyz.com");
		add.setName("abc");

		List<String> list = new ArrayList<String>();
		list.add("ass");
		list.add("sasa");
		add.setTypes(list);

		Location loc = new Location();
		loc.setLat(94);
		loc.setLng(322);

		add.setLocation(loc);
		
		ObjectMapper mapper = new ObjectMapper();
		String mapJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(add);
		System.out.println("serialization"+mapJson);
		
		AddPlace addmapper = mapper.readValue(mapJson, AddPlace.class);
		System.out.println("Deserialization"+addmapper.getAccuracy());
		

		String response = given().log().all().spec(Specification.request()).body(mapJson).when()
				.post("/maps/api/place/add/json").then().log().all().spec(Specification.response()).extract().response()
				.asString();

		System.out.println("Responce=" + response);
		JsonPath js = new JsonPath(response);
		String PlaceID = js.getString("place_id");
		System.out.println("place id="+PlaceID);
		
//		AddPlace ad=given().spec(Specification.request()).queryParam("place_id", PlaceID).expect().defaultParser(Parser.JSON)
//				.when()
//				.get("/maps/api/place/get/json").as(AddPlace.class);
//		
//		System.out.println(ad.getAccuracy());
		//System.out.println(ad.getLocation());
		
	}

}
