package RestAssured;

public class SubstringExample3 {
	
	public static void main(String argvs[])  
	{  
	String str[] =  
	{  
	"Praveen Kumar",  
	"Yuvraj Singh",  
	"Harbhajan Singh",  
	"Gurjit Singh",  
	"Virat Kohli",  
	"Rohit Sharma",  
	"Sandeep Singh",  
	"Milkha Singh"  
	};  
	  
	String surName = "Singh";  
	
	for(int j = 0; j < str.length; j++)  
	{  
	    // extracting the surname  
	    String subStr = str[j].substring(str[j].length() - surName.length());  
	      
	    // checks whether the surname is equal to "Singh" or not  
	    if(!subStr.equals(surName))  
	    {  
	        System.out.println(str[j]);  
	    }  
	}  
	  
	}  

}
