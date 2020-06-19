package com.org.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.base.TestBase;
import com.org.pageobjects.HomePageElements;
import com.org.utility.GetExcelData;
import com.org.utility.MyLogger;
import com.org.utility.ProjectProperties;
import com.org.utility.Screenshot;

public class Headerboxtests extends TestBase {
	
	static Logger logs = MyLogger.getLogger(Headerboxtests.class.getName());
	static HomePageElements hmpelements= new HomePageElements();
	
	@Test(dataProvider = "searchboxdata", priority = 2)
	public static void validateSearchBoxTest(String SearchboxText, String Random)throws InterruptedException, IOException { 
		
		String TestcaseName ="validateSearchBoxTest";
	  
	  logs.info("-----------------------------------------"); logs.info("Starting"+
	  TestcaseName + "Case");
	  logs.info("-----------------------------------------");
	  
	  extentTest =extentReports.createTest("validateSearchBoxTest"+" "+SearchboxText); 
	  boolean Result; 
	  try {
	  logs.info("Writing data in search box and clicking on search button");
	  
	  hmpelements.getSearchBox().sendKeys(SearchboxText);
	  hmpelements.getSearchButton().click();
	  hmpelements.getSearchBox().clear();
	  Result = true;
	  Screenshot.screenshot(TestcaseName + SearchboxText+".jpeg");
	  } 
	  catch (Exception e) 
	  {
	  e.printStackTrace(); 
	  Result= false;
	  logs.error("SearchBox Not found or the click is not working"); }
	  
	  if (Result==  false) {
	  Screenshot.screenshot(TestcaseName + SearchboxText+".jpeg"); 
	  extentTest.fail("Searchbox text not working"); 
	  } 
	  else if (Result ==true) {
	  extentTest.pass("Searchbox is running fine"); 
	  }
	  
	  String ScreenshotPath =ProjectProperties.prop.getProperty("ScreenshotPath")+TestcaseName+SearchboxText+".jpeg"; 
	  extentTest.addScreenCaptureFromPath(ScreenshotPath);
	  assertEquals(Result, true);
	  logs.info("-----------------------------------------"); logs.info("Closing"+
	  TestcaseName + "Case");
	  logs.info("-----------------------------------------");
	  
	  }
	 
	
	@Test(priority = 1)
	public static void validateOpenMenu() throws IOException, InterruptedException
	{
		String Testcasename="validateOpenMenu";
		boolean isExist;
		logs.info("-----------------------------------------");
		logs.info("Starting"+ Testcasename + "Case");
		logs.info("-----------------------------------------");
		
		extentTest = extentReports.createTest(Testcasename);
	
		try {
			
			hmpelements.getopenMenuButton().click();
			Thread.sleep(2000);
			Screenshot.screenshot(Testcasename+".jpg");
			hmpelements.getCloseMenuButton().click();		
			isExist=true;
			logs.info("Test Menu Button clickable");
		} catch (Exception e) {
			e.printStackTrace();
			isExist=false;
		}
		
			if(isExist==true)
			{
				extentTest.pass("Menu Button clicked functionality working fine");
				logs.info(Testcasename+" Pass");
				
				  String screenshotPath=ProjectProperties.prop.getProperty("ScreenshotPath")+Testcasename+".jpg";				  
				  extentTest.addScreenCaptureFromPath(screenshotPath);
				 
			}
			else
			{
				extentTest.fail("Button not found or can not be clicked");
				String screenshotPath=ProjectProperties.prop.getProperty("ScreenshotPath")+Testcasename+".jepg";				  
				extentTest.addScreenCaptureFromPath(screenshotPath);
				logs.error(Testcasename + " failed");
			}
			
	
	}
	
	
	
	@DataProvider(name="searchboxdata")
	public Object [][] searchboxdata() throws InvalidFormatException, IOException
	{
		Object[][] data= GetExcelData.getData("Data", ProjectProperties.prop.getProperty("ExcelPath"));
		return data;
		
	}

}
