package com.loginPageTC;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestingShastra.KeyWord;
import com.TestingShastra.Locators;
import com.TestingShastra.PropertiesUtil;
import com.TestingShastra.TestBase;
import com.TestingShastra.TestData;
import static com.TestingShastra.PropertiesUtil.*;
public class LoginPageTestCase extends TestBase {
	
	private static final Logger log=Logger.getLogger(LoginPageTestCase.class);
	KeyWord key=new KeyWord();
	@Test
	
	public void ToVerifySuccessfulLoginWithValidCred() {
		RemoteWebDriver driver=new ChromeDriver();
		log.info("Launch Chrome Browser");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"username\"]")));

		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin1");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		String ExpectedTextAfterLogin="Dashboard";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Dashboard']")));

		String ActualTextAfterLogin=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(ActualTextAfterLogin, ExpectedTextAfterLogin,"User is not able to login");
	}

	@Test
	public void ToVerifySuccessfulLoginWithInValidCred() {
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"username\"]")));

		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin12");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		String ExpectedTextAfterLogin="Invalid credentials";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Invalid credentials']")));

		String ActualTextAfterLogin=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(ActualTextAfterLogin, ExpectedTextAfterLogin,"User is able to login");
	}

//***********************USING kEYWORD DIRIVEN***************************************
	@Test
	public void ToVerifySuccessfulLoginWithValidCredWithFrameWork() {
		key.ImplicitWait();
		key.enterText(Locators.userName,TestData.ValiduserName);
		key.enterText(Locators.passWord,TestData.Validpassword);
		key.clickable(Locators.loginBtn);
		String ExpectedTextAfterLogin="Dashboard";
		//driver.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Dashboard']")));
		String ActualTextAfterLogin= key.getActualText(Locators.dashBoard);
		key.assertExpectedWithActual(ActualTextAfterLogin, ExpectedTextAfterLogin);
		log.info("user is able to logging");
		key.ScreenShotUsingAshot();
	}
	
	@Test
	public void ToVerifySuccessfulLoginWithInValidCredWithFrameWork() {
		key.ImplicitWait();
		key.enterText(Locators.userName, TestData.InvaliduserName);
		key.enterText(Locators.passWord, TestData.Invalidpassword);
		//key.ImplicitWait();
		key.clickable(Locators.loginBtn);
		//key.clickable(Locators.LoginErrorMsg);
		String ExpectedErrorMsg="Invalid credentials";
		String ActualErrorMsg=key.getActualText(Locators.LoginErrorMsg);
		key.assertExpectedWithActual(ActualErrorMsg, ExpectedErrorMsg);
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg,"User is able to login");
		log.info("user is not able to logging");
		key.ScreenShotUsingAshot();
	}
	
//***********************USING PROPERTIES FILE********************************************
	
	@Test
	public void ToVerifySuccessfulLoginWithValidCredWithPropertiesFile() {
		//PropertiesUtil propUtl=new PropertiesUtil();
		key.ImplicitWait();
		//yaha pe class name kyo call krna pd rha he
		key.enterText(getValueFromPropertyFile(locatorFile, "userName"), getValueFromPropertyFile(appProperties, "ValiduserName"));
		key.enterText(getValueFromPropertyFile(locatorFile, "passWord"),getValueFromPropertyFile(appProperties, "Validpassword"));
		key.clickable(getValueFromPropertyFile(locatorFile, "loginBtn"));
		String ExpectedTextAfterLogin="Dashboard";
		//driver.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Dashboard']")));
		String ActualTextAfterLogin= key.getActualText(getValueFromPropertyFile(locatorFile, "dashBoard"));
		key.assertExpectedWithActual(ActualTextAfterLogin, ExpectedTextAfterLogin);
		key.ScreenShotUsingAshot();
	}

	
	

}
