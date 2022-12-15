package libraryApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CRUDBookApi {
	
	String id="";
	String author="";

	@BeforeMethod
	public void BaseURI() {
		
		RestAssured.baseURI = "http://216.10.245.166";
	}
	@Test(priority = 1,dataProvider = "getBooksData")
	public void AddBookApi(String isbn, String author ) {

		String addBook = given().log().all().header("Content_Type", "application/json")
				.body(PaayLoad.AddBook(isbn,author))
				.when()
				.post("/Library/Addbook.php")
				.then().log().all()
				.assertThat().statusCode(200).extract().response()
				.asString();

			System.out.println("addBook="+addBook);
			
			JsonPath js = new JsonPath(addBook);
			id=js.get("ID");
			System.out.println(id);
	}
	
	@DataProvider(name="getBooksData")
		public Object[][] dp1() {
			Object[][] data=new Object[][] {
					{"Nikola","Tesla"},
						
			};
			return data;
	}
		
	
	@Test(priority = 2)
	public void GetBookByID() {
		
		String getBookById=given().log().all().queryParam("ID", id).header("Content_Type", "application/json")
		.when().get("Library/GetBook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("getBookById="+getBookById);
		
		String ref=getBookById.split("\"author\":\"")[1];
		System.out.println(ref);
		author=ref.replaceAll("\"}]", "");
		System.out.println("Author="+author);

		
	}
	
	@Test(priority = 3)
	public void GetBookByAuthor() {
		
		String getBookByAuthor=given().log().all().queryParam("AuthorName",author)
		.when().get("/Library/GetBook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("getBookByAuthor="+getBookByAuthor);
		
	}
	
	@Test(priority = 4)
	public void DeleteBookApi() {
		
		
		String deleteBook=given().log().all().header("Content_Type", "application/json")
				.body("{\r\n"
						+ "	\"ID\": \""+id+"\"\r\n"
						+ "}")
				.when().post("/Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("deleteBook"+deleteBook);
	}
	
	
}
