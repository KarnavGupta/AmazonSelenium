package com.org.base;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.utility.ProjectProperties;

public class TestBase {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static Set<String> windowhandlers;
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", ProjectProperties.prop.getProperty("chromedriver"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.get(ProjectProperties.prop.getProperty("UrlLink"));
		
		htmlReporter= new ExtentHtmlReporter(ProjectProperties.prop.getProperty("ReportPath"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		
		windowhandlers=driver.getWindowHandles();
		System.out.println("Base Window:" + windowhandlers);
		
		
	}
	@AfterClass
	public static void teardown()
	{
		driver.close();
		extentReports.flush();
	}

}
