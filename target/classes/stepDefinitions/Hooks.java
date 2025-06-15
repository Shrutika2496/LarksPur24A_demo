package com.features;

import com.TestingShastra.KeyWord;

public class Hooks {
	KeyWord key=new KeyWord();

	public void setUpBrowser() {
		key.LaunchBrowser("Chrome");
		key.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		key.ImplicitWait();
	}
	
	public void tearDown() {
		key.driver.quit();
	}
}
