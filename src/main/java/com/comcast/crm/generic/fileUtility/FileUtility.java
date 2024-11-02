package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream stream = new FileInputStream("./configAppData/commondata.properties");
		Properties properties = new Properties();
		properties.load(stream);
		String data = properties.getProperty(key);
		return data;
	}

}
