package com.Pe.selenium;

import java.io.IOException;

public class reflector {

	public static String testcaseExecution(String testcase) throws IOException {
		
		if(testcase.equals("hitRootUrl"))
		{
			return TestCase.hitRootUrl();
		}
		
		if(testcase.equalsIgnoreCase("clickCreatePE"))
		{
			return TestCase.clickCreatePE();
		}
		if(testcase.equalsIgnoreCase("EnterInfoCreatePE"))
		{
			return TestCase.EnterInfoCreatePE();
		}
		if(testcase.equalsIgnoreCase("SkipUploadLogo"))
		{
			return TestCase.SkipUploadLogo();
		}
		
		
		
		return "test case not run";
		
		
	}

}
