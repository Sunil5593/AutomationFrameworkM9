package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface of TestNG
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
int count = 0;
int retrycount = 3;
@Override
public boolean retry(ITestResult result) {
	//0<3, 
	while(count<retrycount)
	{
		count++;
		return true;
	}
	return false;
}
}
