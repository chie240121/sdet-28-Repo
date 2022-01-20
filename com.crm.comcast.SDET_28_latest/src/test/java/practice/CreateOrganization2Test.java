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

import com.crm.comcast.GenricUtility.ExcelUtility;
import com.crm.comcast.GenricUtility.FileUtility;
import com.crm.comcast.GenricUtility.IpathConstants;
import com.crm.comcast.GenricUtility.JavaUtility;
import com.crm.comcast.GenricUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

public class CreateOrganization2Test {

	public static void main(String[] args) throws Throwable {
		
		//create object for utilities
		FileUtility fUtility = new FileUtility();
		JavaUtility jUtility = new JavaUtility();
		ExcelUtility eUtility = new ExcelUtility();
		WebDriverUtility wUtil =new WebDriverUtility();
		
		//get the data from property file
		String browser = fUtility.getPropertyFileData("browser");
		String url = fUtility.getPropertyFileData("url");
		String username = fUtility.getPropertyFileData("username");
		String password = fUtility.getPropertyFileData("password");
		
		
		//generate random number
		int randomNumber = jUtility.getRandomNumber();
		
		//get the data from excel sheet 
		String ExpectedorganizationName = eUtility.getStringData("Sheet1", 1, 2);
		ExpectedorganizationName = ExpectedorganizationName + randomNumber;
		
		//how to use browse value and launch the browser
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			
			System.setProperty(IpathConstants.CHROME_KEY , IpathConstants.CHROME_PATH);
			driver = new ChromeDriver();
		}
		else {
			System.out.println("browser is not supported pls try again");
		}
		
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		
		//login to application
		driver.get(url);
		LoginPage login =  new LoginPage(driver);
		login.loginToApplication(username, password);
		
		//create organization 
   		HomePage homePage = new HomePage(driver);
   		homePage.clickOrganizationLink();
   		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(ExpectedorganizationName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();
		
		//organization verification
		if(actualOrgName.contains(ExpectedorganizationName)) {
			System.out.println("organization is created");
		}
		else {
			System.out.println("organization is not created");
		}
		
		//logout action
		homePage.logout();
		//quit the browser
		driver.quit();
		
		
	
		
	}

}
