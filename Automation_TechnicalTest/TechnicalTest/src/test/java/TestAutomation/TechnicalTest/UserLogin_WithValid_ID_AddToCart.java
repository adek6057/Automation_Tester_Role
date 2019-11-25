package TestAutomation.TechnicalTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin_WithValid_ID_AddToCart {

	WebDriver driver;

	@BeforeMethod
	public void Lauch_Url_ForLogin_AddToCart() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");
	}

	//******************** user login with valid user id *********************
	@Test
	public void UserLogin_With_Valid_UserID() {
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("azeez111@gmail.com");
		driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("Tesco123");
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();

		// ******* ******************Add Item To Cart//******************************//

		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")).click();

		// *************************select quality*****************
		int i = 1;
		while (i < 2) {
			driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]")).click();
			i++;
		}

		Select size = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
		size.selectByValue("2");

		driver.findElement(By.xpath("//*[@id='color_14']")).click();
		driver.findElement(By.xpath("//*[@id='add_to_cart']")).click();
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/form/p/button")).click();
		driver.findElement(By.xpath("//*[@id='cgv']")).click();
		driver.findElement(By.xpath("//*[@id='form']/p/button")).click();
		driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p")).click();

	}

}
