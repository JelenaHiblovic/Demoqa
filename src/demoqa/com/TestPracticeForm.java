package demoqa.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPracticeForm {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jelenin Dellic\\chrome driver\\ChromeDriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 1)

	public void testRegistrationForm() {

		driver.navigate().to("https://demoqa.com/automation-practice-form");
	
		driver.findElement(By.id("firstName")).sendKeys("Jelena");
		driver.findElement(By.id("lastName")).sendKeys("Hiblovic");
		driver.findElement(By.id("userEmail")).sendKeys("elena@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();

		driver.findElement(By.id("userNumber")).sendKeys("1234567890");
		driver.findElement(By.id("dateOfBirthInput")).click();

		WebElement year = driver.findElement(
				By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
		year.sendKeys(Keys.ARROW_DOWN);
		year.sendKeys(Keys.ARROW_DOWN);
		year.sendKeys(Keys.ARROW_DOWN);
		year.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebElement month = driver.findElement(
				By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		month.sendKeys(Keys.ARROW_DOWN);
		month.sendKeys(Keys.ARROW_DOWN);
		month.sendKeys(Keys.ARROW_DOWN);
		month.sendKeys(Keys.ARROW_DOWN);
		month.sendKeys(Keys.ARROW_DOWN);
		month.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// The subject field doesn't accept data
		// driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[6]/div[2]/div/div/div[1]")).sendKeys("Geology");
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.manage().window().maximize();
		WebElement UploadImg = driver.findElement(By.id("uploadPicture"));
		UploadImg.sendKeys("C:\\Screenshot\\zaposleni.jpg");

		
		driver.findElement(By.id("currentAddress")).sendKeys("Dobracina 75");

		WebElement state = driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]"));
		state.sendKeys("Hary");
		state.sendKeys(Keys.ENTER);

		WebElement city = driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
		city.sendKeys("Kar");
		city.sendKeys(Keys.ENTER);

		driver.findElement(By.id("submit")).click();

		driver.close();
	}

}
