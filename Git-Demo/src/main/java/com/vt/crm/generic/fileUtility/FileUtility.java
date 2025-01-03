package com.vt.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/vtigercommondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String value = prop.getProperty(key);
	return value;
	
}
}
