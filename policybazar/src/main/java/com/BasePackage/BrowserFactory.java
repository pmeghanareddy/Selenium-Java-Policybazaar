package com.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{

    WebDriver driver;
	
	public WebDriver launchApplication(String browser) throws IOException
	{

		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configurationproperty/config.property");
	    Properties prop = new Properties();
		prop.load(fis);
		//String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		try {
			 if(browser.equals("firefox"))
			    {
			    System.setProperty("webdriver.gecko.driver",
			    		System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
			    driver=new FirefoxDriver();
			   
			    }
			    
			    else if(browser.equals("ie"))
			    {
			    System.setProperty("webdriver.ie.driver", 
			    		System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\IEDriverServer.exe");
			    driver= new InternetExplorerDriver();
			    }
			    else
			    {
			    System.setProperty("webdriver.chrome.driver",
			    		System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
			    driver= new ChromeDriver();
			   
			    }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
		}
		catch(WebDriverException e)
		{
			System.out.println("browser could not be launched");
		}
		return driver;
	}
	public void quit()
	{
		driver.close();
	}
}
