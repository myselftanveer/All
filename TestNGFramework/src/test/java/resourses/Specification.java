package resourses;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

	public static RequestSpecification req;
	public static ResponseSpecification res;

	public static RequestSpecification request() throws IOException {

		req = new RequestSpecBuilder().setBaseUri(Utils.getConfig("baseURI")).addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		return req;
	}

	public static ResponseSpecification response() {

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return res;
	}

}
