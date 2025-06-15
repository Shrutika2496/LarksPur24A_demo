package com.TestingShastra;

import static org.testng.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

//keyword=create one method for every action
// 1 keyword= 1 method
// keywords src/main/java me banate he
public class KeyWord {
	public static RemoteWebDriver driver=null;
	public static FluentWait wait =null;

	public void LaunchBrowser(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			System.out.println("Launched Chrome Browser");
		}else if(BrowserName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
			System.out.println("Launched Edge Browser");
		}else if(BrowserName.equalsIgnoreCase("FireFox")) {
			driver=new FirefoxDriver();
			System.out.println("Launched FirefoxDriver Browser");
		}
		else if(BrowserName.equalsIgnoreCase("Safari")) {
			driver=new SafariDriver();
			System.out.println("Launched SafariDriver Browser");
		}else {
			System.out.println("You have entered browser name");
			driver=new ChromeDriver();
			System.out.println("Due to invalid browser bydefault Launched Chrome Browser");		
		}
	}

	public void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void ExplicitWait() {
		wait= new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofSeconds(50));
		wait.ignoring(Exception.class);
		wait.withMessage("Element is not available to perform action");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"username\"]")));

	}

	public void waitElementToBeClickable(WebElement xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(xpath));
	}

	public void enterText(String xpath, String textValue) {
		driver.findElement(By.xpath(xpath)).sendKeys(textValue);
	}

	public void clickable(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public String getActualText(String xpath) {
		String ActualText=driver.findElement(By.xpath(xpath)).getText();
		return ActualText;
	}

	public void assertExpectedWithActual(String actualText, String expectedText) {
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Assertion is pass");	
	}

	public void launchURL(String url) {
		driver.get(url);
	}

/**
 * This method used to return the current date and time
 * @return formattedNow date and Time
 */
	
	public static String getCurrentTimeDate() {
		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();
		// Define the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		// Format the current date and time
		String formattedNow = now.format(formatter);
		System.out.println(formattedNow);
		return formattedNow;
	}
	
	/**
	 * This method take the Screenshot under src/ScreenShots folder
	 */
	public static void ScreenShotUsingAshot() {
		//using the Ashot constructor we are going to create object of screen shot
		Screenshot scr=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);//ye static level pe declare kr skte he

		BufferedImage ImageFile = scr.getImage();

		try {
			ImageIO.write(ImageFile, "png", new File("src/ScreenShots/" +getCurrentTimeDate() +"ScreenshotUsingAshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
