package com.cybit.GeM;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class gemLogin {

	ChromeDriver driver;
	private Object solicitation;
	private FluentWait<WebDriver> wait;
	
	@SuppressWarnings("null")
	@Test
	public void gem_login() throws InterruptedException, IOException{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://gem.gov.in/");
	driver.findElement(By.xpath("//div[@class='col-sm-3 col-md-4 col-xs-12  ']//ul//li[4]//a")).click();		//click on login 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='loginid']")).sendKeys("deepakcybit"); 		//enter id
	Thread.sleep(2000);
	
	try
	{
		WebElement code = driver.findElement(By.xpath("(//div[@class='col-md-4 col-xs-6']//following::img)[1]"));		//code string
		
		
		File src= code.getScreenshotAs(OutputType.FILE);
		String path= "C:\\Users\\Cybit\\TestAutomation\\WebAutomation\\capcherimages\\capcher.png";
		Thread.sleep(2000);
		FileHandler.copy(src, new File(path));
		
		Thread.sleep(2000);
		//Tesseract1 image = new Tesseract1();
		//ITesseract image = new Tesseract();
	
		//image.setDatapath("C:\\Users\\Cybit\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		
		//String sr = image.doOCR(new File(path));
		
		//System.out.println("Captcher code >>>>>>>>>>>>>" + sr);
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='captcha_math']")).sendKeys(sr);
		Thread.sleep(5000);
		
		System.out.println("captcher");
	
		driver.findElement(By.xpath("//*[@id='loginFrm']/div[4]/div[2]/button")).click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='password']")));
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1deeCybitpak@");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='loginFrm']/div[4]/div[1]/button")).click();
	
	}
		catch(Exception e){
			
			System.out.println("exception>>>>>>>>" + e.getMessage());
		}
	}
}





