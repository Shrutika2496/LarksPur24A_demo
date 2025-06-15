package com.TestingShastra;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.TestingShastra.PropertiesUtil.*;

public class TestBase {
	KeyWord key=new KeyWord();
	
	@BeforeMethod
	public void BrowserSetUp() {
		//key.LaunchBrowser(TestData.browserName); //using Keyword
		//USING PROPERTIES FILE
		key.LaunchBrowser(getValueFromPropertyFile(appProperties, "browserName"));
		//key.driver.get(TestData.appURL); //using Keyword
		key.driver.get(getValueFromPropertyFile(appProperties, "appURLQA")); //USING PROPERTIES FILE
		key.driver.manage().window().maximize(); //using Keyword
	}
	
	@AfterMethod
	public void TearDown() {
		key.driver.quit();
	}
}
