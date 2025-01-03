package com.vt.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForWebElementToLoad(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchToWindow(WebDriver driver, String title)
	{
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().equals(title))
				break;
		}
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameelement)
	{
		driver.switchTo().frame(frameelement);
	}
	
	
	public void switchToAlertAccpet(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertData(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void seletDropDownByVisibleText(WebElement element,String text)
	{
		Select opt=new Select(element);
		opt.selectByVisibleText(text);
	}
	
	public void seletDropDownByIndex(WebElement element,int index)
	{
		Select opt=new Select(element);
		opt.selectByIndex(index);
	}
	
	public void seletDropDownByValue(WebElement element,String value)
	{
		Select opt=new Select(element);
		opt.selectByValue(value);
	}
	
	public void srollToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void srollByAmount(WebDriver driver, int x,int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x,y).perform();
	}
	
	
	public void moveByOffset(WebDriver driver, int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x,y).perform();
	}
	
	public void takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/image.png");
		FileHandler.copy(temp, dest);
	}
	
	
}
