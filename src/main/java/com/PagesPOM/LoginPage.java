package com.PagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	//WebElement userName=driver.findElement(By.cssSelector("input[name*='username']"));
	//input[name*='username']

	@FindBy(css="input[name*='username']")
	WebElement userNameTxtBx;

	@FindBy(css="input[name*='password']")
	WebElement PasswrdTxtBx;

	@FindBy(css="button[type*='submit']")
	WebElement LoginBtn;

	public LoginPage() {
		//PageFactory.initElements(Keyword.driver, this); imp
	}
	public void UserName(String userName ) {
		userNameTxtBx.sendKeys(userName);
	}

	public void Password(String passWord ) {
		PasswrdTxtBx.sendKeys(passWord);
	}

	public void ClickOnLogin() {
		LoginBtn.click();
	}

}
