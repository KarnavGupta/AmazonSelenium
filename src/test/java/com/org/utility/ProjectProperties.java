package com.org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ProjectProperties {

	public static Properties prop = new Properties();
	
	static
	{
		File FileProp = new File("C:\\Users\\B. G. Drafting\\eclipse-workspace\\AmazonTesting\\config\\ProjectProperties.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(FileProp);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}

