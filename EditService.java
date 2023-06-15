package serviceterritories.salesforce;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditService {

	public static void main(String[] args) throws InterruptedException, IOException {
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
		WebElement s = driver.findElement(By.xpath("//input[@name='ServiceTerritory-search-input']"));
		s.sendKeys("Iswarya");
		s.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement d = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		d.click();
		WebElement e = driver.findElement(By.xpath("//div[@title='Edit']"));
		driver.executeScript("arguments[0].click();", e); 
		WebElement f = driver.findElement(By.xpath("((//span[contains(@class,'displayLabel')])[2])/slot"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		driver.executeScript("arguments[0].scrollIntoView(true)", f);   
		String text = f.getText();
		System.out.println("Created By "+ text);
		WebElement g = driver.findElement(By.xpath("((//span[contains(@class,'displayLabel')])[3])/slot"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		driver.executeScript("arguments[0].scrollIntoView(true)", g);   
		String text1 = f.getText();
		System.out.println("Modified By "+ text1);
		WebElement h = driver.findElement(By.xpath("((//span[contains(@class,'displayLabel')])[1])/slot"));
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		driver.executeScript("arguments[0].scrollIntoView(true)", h);   
		String text2 = h.getText();
		if ((text.equals(text1))  && (text1.equals(text2))) {
		    System.out.println("Name Matched");
		}
		else  {
		    System.out.println("Name not Matched");
		}  
		WebElement z = driver.findElement(By.xpath("//input[@name='country']"));
		z.clear();
		z.sendKeys("North America");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
	     String  expected_Result= "Service Territory \"Iswarya\" was saved.";
	     Assert.assertEquals(actual_Result,expected_Result);
		   WebElement o = driver.findElement(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
		    String t = o.getText();
		    System.out.println(t);
		    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    Date date = new Date();
		    String date1= dateFormat.format(date);
		    
		    if (t!=date1) {
				System.out.println("Date Not matched");
			}
		    else {
		    	System.out.println("Date Matched");
		    }
		     
	}
	
	}


