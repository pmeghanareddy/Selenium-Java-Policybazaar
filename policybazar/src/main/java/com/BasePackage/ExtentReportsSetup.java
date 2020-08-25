package com.BasePackage;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportsSetup {
	
	public  WebDriver driver;
	public  Properties prop;
	public  ExtentReports report;
	public  ExtentTest test;
	public  String dest;
	public  String time;
	
    @BeforeSuite
	public ExtentReports reportSetup()
	{
			report=new ExtentReports("report.html",true);
			report.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
			return report;
		
	}
	@AfterClass
	public void endreports(ExtentReports report)
	{
		report.flush();
		report.close();
	}
	
}
