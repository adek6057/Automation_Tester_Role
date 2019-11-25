package TestAutomation.TechnicalTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewUser_Registration {

	WebDriver driver;

	@BeforeMethod
	public void Lauch_Url_for_Registration() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");
	}

	@Test
	public void New_Registration() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("azeez111@gmail.com");
		driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();

		//
		driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys("Ibrahim");
		driver.findElement(By.xpath("//*[@id='customer_lastname']")).sendKeys("Azeez");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tesco123");

		Select day = new Select(driver.findElement(By.xpath("//*[@id='days']")));
		day.selectByValue("5");

		Select month = new Select(driver.findElement(By.xpath("//*[@id='months']")));
		month.selectByValue("6");

		Select year = new Select(driver.findElement(By.xpath("//*[@id='years']")));
		year.selectByValue("1986");

		// address details
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("John");

		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Smith");

		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("13 Ravine Grove");
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys("London");
		Select state = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
		state.selectByValue("1");
		driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("35005");

		driver.findElement(By.xpath("//*[@id='other']")).sendKeys("N/A");
		driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("07544566591");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='alias']")).clear();
		driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("adekunle6057@gmail.com");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='submitAccount']")).click();

	}

}
