package com.TestingShastra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//property file 1st we have to load in our program then we have to read using Properties class
//to load a file we have to use FileInputStream

public class PropertiesUtil {

	public static String locatorFile="\\src\\main\\resources\\propertiesFile\\Locators.properties";
	public static String appProperties="\\src\\main\\resources\\propertiesFile\\app.properties";
	//public static String testData="\\src\\main\\resources\\propertiesFile\\app.properties";
	
	/* This method is used to read .properties file
	 * @param filepath{@code pass and read that perticular file}
	 * @param key{@code it returns the value of that key}
	 * @return key value
	 */
	
	
	public static String getValueFromPropertyFile(String filePath, String key) {
		FileInputStream fis=null;
		String baseDir=System.getProperty("user.dir");
		System.out.println(baseDir + " this is directory");

		try {
			//1st way=fis=new FileInputStream("D:\\TSLarkspur24\\Larkspur24AFramework\\src\\main\\resources\\propertiesFile\\Locators.properties");
		//2nd way=fis=new FileInputStream(baseDir +"\\src\\main\\resources\\propertiesFile\\Locators.properties"); //append
		//3rd and reduced code way=
		fis=new FileInputStream(baseDir+filePath); //append
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return prop.getProperty(key);	
	}
	public static void main(String[] args) {
		String keyValue=getValueFromPropertyFile(locatorFile ,"dashBoard");
		System.out.println(keyValue);
		
		String keyValue1=getValueFromPropertyFile(appProperties ,"appURLQA");
		System.out.println(keyValue1);
	}

}
