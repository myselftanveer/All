package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data1 {
	
	
	@Test(dataProvider = "getData")
	public void Basic(String s)
	{
		System.out.println(s);
	}
	
	@DataProvider(name="getData")
	public String[] dp1() {
		String[] data=new String[] {
				"xyz",
				"abc",
				"pqr"
		};
		return data;
	}

}
