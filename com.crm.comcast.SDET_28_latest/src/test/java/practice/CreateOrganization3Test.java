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
import org.testng.annotations.Test;

import com.crm.comcast.GenricUtility.BaseClass;
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

public class CreateOrganization3Test extends BaseClass {
	@Test
	public void createOrg() throws Throwable {
		
		//generate random number
		int randomNumber = jUtility.getRandomNumber();
		
		//get the data from excel sheet 
		String ExpectedorganizationName = eUtility.getStringData("Sheet1", 1, 2);
		ExpectedorganizationName = ExpectedorganizationName + randomNumber;
		
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
		System.out.println("these all were waste..!!");	
		
	}

}
