package react.project;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class ReactTestRunner {
	
	static ExtentReports report;
	
	@BeforeClass
	public static void startReport(){
		report = new ExtentReports(Constant.REPORTPATH + Constant.REPORTFILE, true);
	}
	
	@AfterClass
	public static void finishReport() {
		report.flush();
	}
		

}
