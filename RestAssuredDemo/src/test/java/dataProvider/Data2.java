package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data2 {
	
	
	@Test(dataProvider = "getData")
	public void Basic(Object[] s)
	{
		System.out.println(s[0] +"-------"+s[1]);
	}
	/********************************************OR************************************/
	@Test(dataProvider = "getData")
	public void Basic(String a,String b)
	{
		System.out.println("A="+a +"--------B="+b);
	}
	
	@DataProvider(name="getData")
	public Object[][] dp1() {
		Object[][] data=new Object[][] {
				{"xyz","123"},
					{"abc","456"},
					{"pqr","789"}
		};
		return data;
	}

}
