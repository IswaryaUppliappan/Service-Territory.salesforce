package serviceterritories.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateParentTerritory {

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
		WebElement a = driver.findElement(By.xpath("//span[text()='Edit Parent Territory: Item 1']"));
		driver.executeScript("arguments[0].click();", a);
		driver.findElement(By.xpath("//span[@title='New Service Territory']")).click();
		WebElement b = driver.findElement(By.xpath("(//input[@class=' input'])[1]"));
		b.sendKeys("Mukesh Ambani");
		 JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,3000)");
			Thread.sleep(2000);
			WebElement d = driver.findElement(By.xpath("//input[@title='Search Operating Hours']"));
			driver.executeScript("arguments[0].scrollIntoView(true)", d);
		driver.executeScript("arguments[0].click();", d);
		 JavascriptExecutor js2=(JavascriptExecutor)driver;
			js2.executeScript("window.scrollBy(0,3000)");
			Thread.sleep(2000);
			WebElement l = driver.findElement(By.xpath("//span[@title='New Operating Hours']"));
			driver.executeScript("arguments[0].scrollIntoView(true)", l);
		driver.executeScript("arguments[0].click();", l);
		WebElement f = driver.findElement(By.xpath("(//input[@class=' input'])[2]"));
		f.sendKeys("Mukesh Ambani");
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		js3.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		WebElement g = driver.findElement(By.xpath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", g);
	g.click();
		WebElement h = driver.findElement(By.xpath("(//a[@title='(GMT+05:30) India Standard Time (Asia/Colombo)'])[1]"));
		driver.executeScript("arguments[0].click();", h);
		Thread.sleep(2000);
		WebElement i = driver.findElement(By.xpath("(//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton'])[2]"));
		driver.executeScript("arguments[0].click();", i);
		WebElement j = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']"));
		driver.executeScript("arguments[0].click();", j);
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Operating Hours \"Mukesh Ambani\" was created.";
		Assert.assertEquals(actual_Result,expected_Result);
		WebElement k = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral test-saveButton uiButton--default uiButton--brand uiButton']"));
		driver.executeScript("arguments[0].click();", k);
		Thread.sleep(2000);
		String actual_Result1=driver.findElement(By.xpath("//a[@title='Mukesh Ambani']")).getText();
		String expected_Result1=actual_Result1;
		Assert.assertEquals(actual_Result1,expected_Result1);
		System.out.println(actual_Result1);
	}

}
