package apiTestCases;

import static io.restassured.RestAssured.given;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import listener.Listeners;
import pojo.AddPlaceData;
import pojo.DeletePlaceData;
import resourses.Specification;
import resourses.Utils;

public class CrudTestUsingPOJO extends Listeners {

	static String PlaceID = "";
	String response = "";

	AddPlaceData data = new AddPlaceData();

	DeletePlaceData delete = new DeletePlaceData();

	@Test(priority = 1)
	public void AddPlaceApi() throws Exception {

		String payload = Utils.StringtoJSON(data.payload());
		test.info(MarkupHelper.createCodeBlock(payload, CodeLanguage.JSON));
//		RestAssured.baseURI = "https://rahulshettyacademy.com";

		PrintStream addPlaceLog = new PrintStream(new FileOutputStream("./reports/addPlace.txt"));

		response = given().spec(Specification.request()).body(payload)
				.filter(RequestLoggingFilter.logRequestTo(addPlaceLog))
				.filter(ResponseLoggingFilter.logResponseTo(addPlaceLog))
				.when().post("/maps/api/place/add/json").then()
				.spec(Specification.response()).extract().response().asString();

		test.info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
		System.out.println("Responce=" + response);

		JsonPath js = Utils.convertRawToJson(response);
		PlaceID = js.getString("place_id");
		System.out.println("place id=" + PlaceID);
	}

	@Test(priority = 2)
	public void ExtractPlaceApi() throws IOException {

		String payload = Utils.StringtoJSON(delete.DeletePlacePayload(PlaceID));
		test.info(MarkupHelper.createCodeBlock(payload, CodeLanguage.JSON));

		PrintStream extractPlaceApi = new PrintStream(new FileOutputStream("./reports/extractPlaceApi.txt"));

		String getPlcae = given().spec(Specification.request()).queryParam("place_id", PlaceID)
				.header("Content_Type", "application/json")
				.filter(RequestLoggingFilter.logRequestTo(extractPlaceApi))
				.filter(ResponseLoggingFilter.logResponseTo(extractPlaceApi))
				.when().get("/maps/api/place/get/json")
				.then().spec(Specification.response()).extract().response().asString();

		test.info(MarkupHelper.createCodeBlock(getPlcae, CodeLanguage.JSON));
		System.out.println("Get Place API:" + getPlcae);

		JsonPath js = Utils.convertRawToJson(getPlcae);
		String Accuracy = js.getString("accuracy");
		System.out.println("Accuracy=" + Accuracy);

	}

	@Test(priority = 3)
	public void DeletePlaceApi() throws IOException {

		String payload = Utils.StringtoJSON(delete.DeletePlacePayload(PlaceID));
		test.info(MarkupHelper.createCodeBlock(payload, CodeLanguage.JSON));

		PrintStream deletePlaceApi = new PrintStream(new FileOutputStream("./reports/deletePlaceApi.txt"));

		String deletePlcae = given().log().all().spec(Specification.request())
				// .body("{\r\n" + " \"place_id\":\"" + PlaceID + "\"\r\n" + "}")
				.body(delete.DeletePlacePayload(PlaceID)).filter(RequestLoggingFilter.logRequestTo(deletePlaceApi))
				.filter(ResponseLoggingFilter.logResponseTo(deletePlaceApi))
				.when().get("/maps/api/place/delete/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();

		test.info(MarkupHelper.createCodeBlock(deletePlcae, CodeLanguage.JSON));
		System.out.println("Delete Place API:" + deletePlcae);

		JsonPath js = Utils.convertRawToJson(deletePlcae);
		String StatusOFDelete = js.getString("status");
		System.out.println("Status=" + StatusOFDelete);
	}

}
