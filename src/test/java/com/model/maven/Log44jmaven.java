package com.model.maven;



import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class Log44jmaven {
	public WebDriver driver;
	
	static Logger logger=Logger.getLogger(Log44jmaven.class);
  @Test(priority=1)
  public void openbrowser() {
	  PropertyConfigurator.configure("D:\\EclipseWorkSpace\\log4jtestmaven\\src\\test\\resources\\log4j.properties");
	  System.setProperty("webdriver.chrome.driver","F:\\selenium software\\chromedriver_win32\\chromedriver.exe");
      driver= new ChromeDriver();
      logger.info("browser opened successfully");
  }
  @Test(priority=2)
  public void enterurl()
  {
	driver.get("http://newtours.demoaut.com/");
	logger.debug("debugging the url");
	driver.manage().window().maximize();
  }
  @Test(priority=3)
  public void loginwithvalidds()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("464037");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mahendra123");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  logger.info("login successfull");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @Test(priority=4)
  public void loginwithinvalidds()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("464037");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mahendra1");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  logger.warn("enter valid password");
	  logger.error("password is wrong");
	    }
  
  @AfterMethod
  public void capturescreenshot()
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileUtils.copyToDirectory(src, new File("D:\\EclipseWorkSpace\\log4jtestmaven\\src\\test\\resources\\screenshoooot\\"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		logger.fatal("catch messeges");
		e.printStackTrace();
	}
  }
}
