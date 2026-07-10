package chethan.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {
	public static ExtentReports getReport() {
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Reports");
	reporter.config().setDocumentTitle("Test Results");
	ExtentReports er = new ExtentReports();
	er.attachReporter(reporter);
	er.setSystemInfo("Tester", "Chethan Dana");
	return er;
	}

}
