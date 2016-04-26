package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Pe.Dao.testDao;

public class Element {
	 public static String sPageObject;
	static String sElementLocator="jhsg";
	public static Properties or;
	public static WebElement by;
	
	public static WebElement ElementLocator(String ElementName,WebDriver driver) throws IOException{

	 try{
		 sElementLocator=testDao.ElementType(ElementName);
		 sPageObject=testDao.ElementPath(ElementName);
		if(sElementLocator!=null && sElementLocator.equalsIgnoreCase("xpath")){
        	 by =driver.findElement(By.xpath(sPageObject));         }
         else if(sElementLocator!=null && sElementLocator.equalsIgnoreCase("id")){
        	 by =driver.findElement(By.id(sPageObject));         }
         else if(sElementLocator!=null && sElementLocator.equalsIgnoreCase("name")){
        	 by =driver.findElement(By.name(sPageObject));         }
         else if(sElementLocator!=null && sElementLocator.equalsIgnoreCase("linktext")){
        	 by =driver.findElement(By.linkText(sPageObject));         }
         else if(sElementLocator!=null && sElementLocator.equalsIgnoreCase("partiallinktext")){
             by =driver.findElement(By.partialLinkText(sPageObject));
         }
         else if(sElementLocator!=null && sElementLocator.equalsIgnoreCase("class")){
        	 by =driver.findElement(By.className(sPageObject));         }
     }
     catch(final Exception e){
         System.out.println("Exception - By object");
        
        
     }
	return by;				    
}}
