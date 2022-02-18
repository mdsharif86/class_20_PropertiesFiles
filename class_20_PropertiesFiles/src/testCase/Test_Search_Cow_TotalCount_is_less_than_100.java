package testCase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.Base;


public class Test_Search_Cow_TotalCount_is_less_than_100 {
	WebDriver driver;
	@BeforeSuite
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Chromedrive\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

	}
	@Test
	public void verifyTotalSearchWithSeeds() {

		driver.get("https://www.craigslist.org");
		driver.findElement(By.xpath("//a[@href='/d/farm-garden-services/search/fgs']")).click();
		driver.findElement(By.xpath("//input[@id='query']")).sendKeys("seeds");
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		String result = driver.findElement(By.xpath("//div[@class='search-legend']/div/span/span/span[@class=\"totalcount\"]")).getText();
		Assert.assertTrue(Integer.parseInt(result)<100);
		driver.close();

	}
}