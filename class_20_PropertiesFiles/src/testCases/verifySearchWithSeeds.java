package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;


public class verifySearchWithSeeds {
	@Test
	public void verifyTotalSearchWithSeeds() {

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Chromedrive\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver;

		driver = new ChromeDriver();

		driver.get("https://www.craigslist.org");

		driver.findElement(By.xpath("//a[@href='/d/farm-garden-services/search/fgs']")).click();

		driver.findElement(By.xpath("//input[@id='query']")).sendKeys("seeds");
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		
		String result = driver.findElement(By.xpath("//div[@class='search-legend']/div/span/span/span[@class=\"totalcount\"]")).getText();
		
		Assert.assertTrue(Integer.parseInt(result)<100);
		
		
		 driver.close();

	}
}