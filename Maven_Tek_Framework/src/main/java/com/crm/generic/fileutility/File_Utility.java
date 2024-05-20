package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./configAppData/commendata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}
