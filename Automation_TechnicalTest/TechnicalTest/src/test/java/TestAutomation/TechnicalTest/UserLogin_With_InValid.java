package TestAutomation.TechnicalTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin_With_InValid {
	WebDriver driver;

	@BeforeMethod
	public void Lauch_Url() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");

	}
	//******************** user login with Invalid user id *********************
	@Test
	public void UserLogin_With_InValid_UserID() {
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("smith111@gmail.com");
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("tesco123");
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
		Assert.assertEquals("Authentication failed", "My account - My Store");

	}
}
