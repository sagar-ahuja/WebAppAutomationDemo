package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtilities;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener listener;
	public static EventFiringWebDriver e_driver;
	
	public TestBase(){
		
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void intitialisation()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\STUDY MATERIAL\\SELENIUM\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "F:\\STUDY MATERIAL\\SELENIUM\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Select a browser...");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		listener = new WebEventListener();
		e_driver.register(listener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
			
	}
	
	

}
