package serviceterritories.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DeleteService {

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
		WebElement c = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		driver.executeScript("arguments[0].click();", c);
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='All Service Territories']")).click();
		WebElement s = driver.findElement(By.xpath("//input[@name='ServiceTerritory-search-input']"));
		s.sendKeys("Iswarya");
		s.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement d = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		d.click();
		WebElement e = driver.findElement(By.xpath("//div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", e); 
		 driver.findElement(By.xpath("//span[text()='Delete']")).click();
		 String actual_Result=driver.findElement(By.xpath("//div[@class='emptyContentInner slds-text-align_center']")).getText();
			String expected_Result="No items to display.";
			Assert.assertEquals(actual_Result,expected_Result);

	}

}
