package com.Pe.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Browser;
import Utilities.Constant;
import Utilities.Element;
import Utilities.POI;

public class TestCase {
	
	static ExtentReports report;
	static ExtentTest logger;
	static String p="pass";
	static String f="fail";
	static String fa="fatal";
	static String w="warning";
	static String browser=null;
	static WebDriver driver=null;
	
	public static void getBrowser(String browser1){
		browser=browser1;
		System.out.println(browser);
		driver=Browser.openBrowser(browser);
		driver.manage().window().maximize();
	}
	@Test
	public static String hitRootUrl() {
		try{			
			driver.get("http://test.myplanlink.com");
			if(driver.getTitle().contains("Welcome"))
		
			return p;}
		catch(Exception a){
			
		}
		return fa;
	}

	public static String clickCreatePE() {
		String dependency=hitRootUrl();
		try{
		if(dependency==p){
			Element.ElementLocator("btn_create_pe", driver).click();
			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().equalsIgnoreCase(Constant.PEurl))
			{
				return p;
			}
		}
		return f;}
		catch(Exception a){
			return fa;
		}

	}
	
	public static String EnterInfoCreatePE() throws IOException {
		String dependency=clickCreatePE();
		if(dependency==p){
		Element.ElementLocator("firstname",driver).sendKeys("muni");
		Element.ElementLocator("lastname", driver).sendKeys("muni");
		Element.ElementLocator("phoneno", driver).sendKeys("1234567890");
		Element.ElementLocator("emailid", driver).sendKeys("muni@mailinator.com");
		Element.ElementLocator("businessname", driver).sendKeys("automation");
		Element.ElementLocator("btn_next", driver).click();
		try{
			Element.ElementLocator("logo_holder", driver);
			return p;
		}
		catch(Exception e){
			return f;
		}
		}
		return fa;
	
	}

	public static String SkipUploadLogo() throws IOException {
		String dependency=EnterInfoCreatePE();
		if(dependency==p){
		try{
			Element.ElementLocator("skip_logo_link", driver).click();

			Element.ElementLocator("slip_logo_test", driver);
			return p;
		}
		catch(Exception e){
			return f;
		}
		
		}
		return fa;
	
	}
	public static String PeTest() throws Exception {
		
		POI.setExcelFile(Constant.PePath_TestData,"ajay" );
		for(int v=1;v<3;v++){
		String peurl=POI.getCellData(v, 0);
		driver.get(peurl);
		try{
		driver.findElement(By.partialLinkText("GENDER"));
		}
		catch(Exception e){
			POI.setCellData("url invalid", v, 1);
		}
		try{
			driver.findElement(By.partialLinkText("NEXT"));
			}
			catch(Exception e){
				POI.setCellData("next button not present", v, 1);
			}
		}
		
return p;
	}


	
@AfterMethod
public static void Aftermethod(ITestResult result) throws Exception{
	if(result.getStatus()==ITestResult.FAILURE){
		String screenshotpath=Browser.getscreenshot(driver, result.getName());
		logger.log(LogStatus.FAIL, "CREATE PE PAGE OPENING",screenshotpath);
	}
	report.endTest(logger);
	report.flush();
	driver.get("file:///Users/Muni.Ganji/Documents/workspace/Springhello/WebContent/WEB-INF/report/report.html");
}


}

