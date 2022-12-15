package complexJson;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class IndCourses2 {

	public static void main(String[] args) {
		
		int total=0;
		
		JsonPath js = new JsonPath(Courses2.indCourse());
		System.out.println(js.get("player[3].name"));
//		int purchaseAmount = js.get("dashboard.purchaseAmount");
//		System.out.println(purchaseAmount);
//		
//		int courseSize=js.get("courses.size()");
//		System.out.println(courseSize);
//		
//		for(int i=0;i<courseSize;i++) {
//			
//			int coursePrice=js.getInt("courses["+i+"].price");
//			//System.out.println(coursePrice);
//			int courseCopies=js.getInt("courses["+i+"].copies");
//			//System.out.println(courseCopies);
//			int product = coursePrice * courseCopies;
//			//System.out.println(product);
//			
//			total=total+product;
//			
//		}
//		System.out.println(total);
//		Assert.assertEquals(total, purchaseAmount);

	}

}
