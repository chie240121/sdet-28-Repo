package com.crm.comcast.GenricUtility;

import java.io.FileInputStream;

import java.util.Properties;
/**
 * Utility for property file
 * @author kajal
 *
 */
public class FileUtility {
	/**
	 * This method will fetch the data from property file based on the key passed
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable {
		FileInputStream file = new FileInputStream(IpathConstants.PROPERTY_FILE_PATH);
		Properties property = new Properties();
		property.load(file);
		return property.getProperty(key);
	}
		

	
}
