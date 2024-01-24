package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener Interface of TestNG 
 */

public class ListenerImplementation implements ITestListener 
{

	ExtentReports report;	
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//start of @Test --> Test Methods --> Method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "------Test Execution Start---- " );

		//For extent reports to recognize the @Test
		test = report.createTest(methodName);
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Pass-----");
	
		//For logging the status of Test in extent reports
		test.log(Status.PASS, methodName+ "------Test Pass---- ");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Fail----");
		System.out.println(result.getThrowable());
	
		//For logging the status of Test in extent reports
		test.log(Status.FAIL, methodName+ "------Test Fail---- ");
		test.log(Status.INFO, result.getThrowable());
		
		//Capture the Screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenShotName = methodName+ "-"+j.getSystemDate();
		try
		{
			String path = s.captureScreenShot(BaseClass.sDriver, screenShotName);
			//For attaching the screenshot in extent report
			test.addScreenCaptureFromPath(path);
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "----Test Skipped----");
		System.out.println(result.getThrowable());
	

		//For logging the status of Test in extent reports
		test.log(Status.SKIP, methodName+ "------Test Skipped---- ");
		test.log(Status.INFO, result.getThrowable());
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	System.out.println("-----Test Suite Started----");
	
	//Extent Report Configuration
	ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
	esr.config().setDocumentTitle("Exection Report");
	esr.config().setReportName("Vtiger Execution Report");
	esr.config().setTheme(Theme.DARK);
	
	report = new ExtentReports();
	report.attachReporter(esr);
	report.setSystemInfo("Base Browser", "Edge");
	report.setSystemInfo("Base Platform", "Windows");
	report.setSystemInfo("Base Environment", "Testing");
	report.setSystemInfo("Base URL", "http://localhost:8888");
	report.setSystemInfo("Reporter", "Sunil Monga");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----Test Suite Finished----");

		//Extent Report Generation
		report.flush();
	
	}
	
	
	
}

