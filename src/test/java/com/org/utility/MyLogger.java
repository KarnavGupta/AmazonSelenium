package com.org.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
	
	private static Properties props;
	private static FileInputStream fis;
	public static Logger Log;
	
	static 
	{
	
		props = new Properties();
		try {
			fis= new FileInputStream("log4j.properties");
			props.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure(props);
	}
	
	public static Logger getLogger(String name)
	{
		Log= Logger.getLogger(name);
		return Log;
	}

}
