package com.org.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.org.base.TestBase;

public class Screenshot {
	
	public static void screenshot(String ScreenshotTestName) throws IOException
	{

	TakesScreenshot MainScreenshot = (TakesScreenshot)TestBase.driver;
	File ScreenshotPath = new File(ProjectProperties.prop.getProperty("ScreenshotPath")+ScreenshotTestName);
	File TempScreenshot = MainScreenshot.getScreenshotAs(OutputType.FILE);
	Files.copy(TempScreenshot, ScreenshotPath);
	
	}
}
