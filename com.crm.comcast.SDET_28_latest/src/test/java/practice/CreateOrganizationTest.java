package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//get the data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver" , "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("browser is not supported pls try again");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
   		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys("Kaju1");
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		
		//organization verification
		String actualOrganizationName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrganizationName.contains("Kaju1")) {
			System.out.println("organization is created");
		}
		else {
			System.out.println("organization is not created");
		}
		WebElement profileImg = driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(profileImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
	
		
	}

}
