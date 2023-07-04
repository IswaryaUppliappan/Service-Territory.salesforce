package serviceterritories.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateNewServiceAppointment {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement b = driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		driver.executeScript("arguments[0].click();", b);
		WebElement a = driver.findElement(By.xpath("//a[@title='New']"));
		driver.executeScript("arguments[0].click();", a);
		WebElement c = driver.findElement(By.xpath("//textarea[@class=' textarea']"));
		c.sendKeys("Creating Service Appointments");
		WebElement d = driver.findElement(By.xpath("//input[@title='Search Accounts']"));
		driver.executeScript("arguments[0].click();", d);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//span[@title='New Account']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", e);
		driver.executeScript("arguments[0].click();", e);
		WebElement f = driver.findElement(By.xpath("((//label[@class='label inputLabel uiLabel-left form-element__label uiLabel'])/following-sibling::input)[9]"));
		f.sendKeys("Iswarya");
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		String actual_Result=driver.findElement(By.xpath("(//span[@class='pillText'])[1]")).getText();
		String expected_Result=actual_Result;
		Assert.assertEquals(actual_Result,expected_Result);
		WebElement f1 = driver.findElement(By.xpath("(//input[@class=' input'])[1]"));
		f1.sendKeys("7/4/2023");
		WebElement f2 = driver.findElement(By.xpath("(//input[@class=' input'])[3]"));
		f2.sendKeys("7/9/2023");
		driver.findElement(By.xpath("(//button[@title='Save'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement b1 = driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		driver.executeScript("arguments[0].click();", b1);
		WebElement d1 = driver.findElement(By.xpath("//input[@name='ServiceAppointment-search-input']"));
		d1.sendKeys("SA-0017");
		d1.sendKeys(Keys.ENTER);
		String actual_Result1=driver.findElement(By.xpath("//a[@title='SA-0017']")).getText();
		String expected_Result1=actual_Result1;
		Assert.assertEquals(actual_Result1,expected_Result1);

	}
}

