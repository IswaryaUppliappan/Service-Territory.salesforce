package serviceterritories.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateService {

	public static void main(String[] args) {
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
		WebElement c = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		driver.executeScript("arguments[0].click();", c);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement s = driver.findElement(By.xpath("//input[@name='Name']"));
		s.sendKeys("Iswarya");
		WebElement e = driver.findElement(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right'])[2]"));
		driver.executeScript("arguments[0].click();", e);
		driver.findElement(By.xpath("(//span[@title='UK Shift'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='IsActive']")).click();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@name='province']")).sendKeys("Tamilnadu");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("600100");
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Service Territory \"Iswarya\" was created.";
		Assert.assertEquals(actual_Result,expected_Result);
		
	
	}

}
