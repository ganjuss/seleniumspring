package com.Pe.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.Constant;
import Utilities.POI;

public class petest {
public static void main(String[] args) throws Exception {
	WebDriver driver = new FirefoxDriver();
	POI.setExcelFile("/Users/Muni.Ganji/Documents/workspace/SeleniumPEmuni/src/DataEngine/petest.xlsx","Sheet 1" );
for(int v=1;v<=189;v++)	{
	String peurl=POI.getCellData(v, 0);
	if(peurl.contains("http"))
	driver.get(peurl);
	else
	driver.get("https://"+peurl);
	
	try{
		driver.findElement(By.xpath(".//*[@id='sign-in']"));
		try{
			driver.findElement(By.className("btn-hps-primary"));
		}
		catch(Exception e){
			System.out.println(peurl+" no next button");
		}
		
	}catch(Exception e){
		System.out.println(peurl+" invalid url");
	}

}
	
}
}
