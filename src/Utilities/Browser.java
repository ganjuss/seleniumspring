package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Browser {

	public static WebDriver driver;

	public static WebDriver openBrowser(String browser){
	
			if(browser.equals("Mozilla"))
			{
				driver=new FirefoxDriver();

				return driver;

			}
			if(browser.equals("IE"))
			{
				driver=new InternetExplorerDriver();

				return driver;


			}
			if(browser.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
				driver=new ChromeDriver();

				return driver;

			}
			return driver;

		}
//		catch (Exception e){
//			Log.getLogger("jhgj");
//		}
//		return null;
//	}
	public static void quit(){
		driver.quit();

	}
	public static String getscreenshot(WebDriver driver,String Screenshotname) throws Exception 
    {
		
		try{
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
            String File="/Users/Muni.Ganji/Documents/workspace/Springhello/WebContent/WEB-INF/screenshots/"+Screenshotname+".png";
            
            FileUtils.copyFile(scrFile, new File(File));
            
            return File;
		}
		catch(Exception e){
			System.out.println("Unable to take screen shot"+e.getMessage());
			return e.getMessage();
		}
    }
}	



