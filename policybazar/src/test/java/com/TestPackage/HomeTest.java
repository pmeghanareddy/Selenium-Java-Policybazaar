package com.TestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BasePackage.BrowserFactory;
import com.BasePackage.ExtentReportsSetup;
import com.BasePackage.Screenshots;
import com.PagePackage.GetPricesDetails;
import com.PagePackage.TravelInsurancePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomeTest extends BrowserFactory{
	
	//pages objects
	
	GetPricesDetails gpd;
	TravelInsurancePage tip;
	Screenshots util;
	WebDriver driver;
	ExtentReportsSetup ers;
	public ExtentReports report;
	public ExtentTest test;
	
	@Parameters("browser")
	@BeforeTest(groups= {"smoke","regression"})
	public void beforeMethod(@Optional("name")String browser) throws IOException
	
	{
		driver = launchApplication(browser);
		ers= new ExtentReportsSetup();
		report = ers.reportSetup();
		tip = new TravelInsurancePage(driver);
		gpd = new GetPricesDetails(driver);
		util = new Screenshots(driver);
	}
	
	@Test(priority=1,groups= {"smoke","regression"})
	public void Test1() throws InterruptedException{
		test=report.startTest("Test1");
		test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
		tip.selectTravelIns();
		test.log(LogStatus.PASS, "Test Case passed");
		report.endTest(test);
		util.takeSnapShot(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\pb1.png");
		
	}
	@Test(priority=2,groups= {"smoke","regression"})
	public void Test2() throws InterruptedException{
		test=report.startTest("Test2");
		test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
		gpd.enterTravelDetails();
		test.log(LogStatus.PASS, "Test Case passed");
		report.endTest(test);
		util.takeSnapShot(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\pb2.png");
		
	}
	
	@Test(priority=3,groups= {"smoke","regression"})
	public void Test3() throws InterruptedException, IOException{
		test=report.startTest("Test3");
		test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
		gpd.enterPersonDetails();
		gpd.getLowestPrices();
		test.log(LogStatus.PASS, "Test Case passed");
		report.endTest(test);
		util.takeSnapShot(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\pb3.png");
	}
	
	@AfterTest(groups= {"smoke","regression"})
	public void close() throws InterruptedException
	{		
		ers.endreports(report);
		driver.close();
	}
}
