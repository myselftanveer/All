package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LibraryApiExtentReport {

	static ExtentReports extent;

	public static ExtentReports getApiReport() {
		
		String path = System.getProperty("user.dir") + "\\reports\\library.html";

		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Library Api Automation");
		spark.config().setDocumentTitle("Library Api Test Result");

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Tanveer");
		return extent;

	}

}
