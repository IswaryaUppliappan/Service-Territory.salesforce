package serviceterritories.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ServiceAppointments {

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
		WebElement b = driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		driver.executeScript("arguments[0].click();", b);
		WebElement c = driver.findElement(By.xpath("//div[@class='slds-page-header__name-title']"));
		driver.executeScript("arguments[0].click();", c);
		WebElement d = driver.findElement(By.xpath("(//span[@class=' virtualAutocompleteOptionText'])[1]"));
		driver.executeScript("arguments[0].click();", d);
		WebElement e = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		driver.executeScript("arguments[0].click();", e);
		driver.findElement(By.xpath("//a[@title='Cancel Service Appointment']")).click();
		WebElement y = driver.findElement(By.xpath("//button[text()='Confirm Cancellation']"));
		driver.executeScript("arguments[0].click();", y);
		WebElement z = driver.findElement(By.xpath("//input[@name='ServiceAppointment-search-input']"));
		z.clear();
		z.sendKeys("SA-0012");
		z.sendKeys(Keys.ENTER);
		String actual_Result=driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'])[2]")).getText();
	     String  expected_Result=actual_Result ;
	     Assert.assertEquals(actual_Result,expected_Result);
		
	}

}
