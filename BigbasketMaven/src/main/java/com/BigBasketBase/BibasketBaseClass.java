package com.BigBasketBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BibasketBaseClass {
	
	public static WebDriver driver;

	protected WebDriver browserLaunch(String name) {
		
		if (name.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
			
		} else if (name.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		} else if (name.equalsIgnoreCase("FireFox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;

	}
	
	protected void launchUrl(WebDriver driver , String url , int sec) {
		
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			System.out.println("Error Occurs On the LaunchUrl Method : 38 ");
			e.printStackTrace();
		}	
		
	}
	
	protected void clickTheElement(WebDriver driver , WebElement element , int sec) {
		
		try {
			new WebDriverWait(driver,Duration.ofSeconds(sec))
			.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void inputvalues(WebDriver driver , WebElement element , int sec , String value) {
		
		try {
			new WebDriverWait(driver,Duration.ofSeconds(sec))
			.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void staticwait(int msec) {
		
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void screenShot(WebDriver driver,String name) {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\A\\Postman\\BigbasketMaven\\Screenshot\\"+name+".png");
		try {
			FileHandler.copy(scrfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void selectFromDropDown(WebDriver driver,WebElement element, String option, String value) {

		try {
			Select s = new Select(element);
			
			if (option.equalsIgnoreCase("index")) {
				
				s.selectByIndex(Integer.parseInt(value));
				
			} else if (option.equalsIgnoreCase("value")) {
				
				s.selectByValue(value);
				
			} else if (option.equalsIgnoreCase("visibleText")) {
				
				s.selectByVisibleText(value);
			
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	protected void terminateBrowser() {
		driver.quit();
	}
	
	
}
