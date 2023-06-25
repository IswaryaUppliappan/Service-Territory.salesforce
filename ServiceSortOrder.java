package serviceterritories.salesforce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ServiceSortOrder {

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
		WebElement b = driver.findElement(By.xpath("(//span[text()='Get Started'])[7]"));
		 driver.executeScript("arguments[0].click();", b);
		 Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstname=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstname.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Compliance']")).click();
		WebElement a = driver.findElement(By.xpath("//a[text()='Services']"));
		a.click();
		ArrayList<String> obtainedList = new ArrayList<String>(); 
		List<WebElement> elementList= driver.findElements(By.xpath("//div[@class='container px-10 container--fluid']"));
		List<String> sortedNames =  obtainedList;           
		Collections.sort(sortedNames);                                                 
		boolean areSorted =  elementList.equals(sortedNames); 

	}

}
