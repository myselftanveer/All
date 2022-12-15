package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GoogleMapApiExtentReport {

	static ExtentReports extent;

	public static ExtentReports getMapApiReport() {
		
		String path = System.getProperty("user.dir") + "\\reports\\mapExtentReport.html";

		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Map Api Automation");
		spark.config().setDocumentTitle("Map Api Test Result");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Tanveer");
		return extent;

	}

//	private String payload;
//	private String response;
//	
//	public void ReportingData( String payload, String response) {
//	    
//	    this.payload = payload;
//	    this.response = response;
//	}

}
