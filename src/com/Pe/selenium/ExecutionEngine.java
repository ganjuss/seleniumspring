package com.Pe.selenium;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.Pe.Dao.testDao;
import Utilities.Browser;
public class ExecutionEngine {
	static String browser=null;
	public static void Testcycle(){


	}

	public static List<String> results(String browsera) throws Exception {
browser=browsera;

		TestCase.getBrowser(browser);
		List testresults=new ArrayList<>();
		List testcases,testresultsview=new ArrayList<>();
		testcases=testDao.checkTestSTatus();
		TestCase testcase=new TestCase();
		
		
		Iterator<String> Iterator = testcases.iterator();
		while (Iterator.hasNext()) {
			String a=Iterator.next();
			testresults.add(reflector.testcaseExecution(a));
			
			
			
		}
		testresultsview=testDao.insertTestResults(testresults);
		return testresultsview;
	}
	public static String setBrowser(){
		return browser;
	}
}
