package com.crm.comcast.GenricUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * this is a base class consists of all configuration annotations
 */
public class BaseClass {
	
		//create object for utilities
		public WebDriver driver;
		public static WebDriver sdriver;
		public JavaUtility jUtility = new JavaUtility();
		public FileUtility fUtil = new FileUtility();
		public WebDriverUtility wUtil =new WebDriverUtility();
		public ExcelUtilityPurchase eutilpurchase = new ExcelUtilityPurchase();
		public ExcelUtility eUtility = new ExcelUtility();
		
		@BeforeSuite (groups = {"smokeTest", "regressionTest"})
		public void configBs() {
			//connection to the DB
			System.out.println("=======connect to db=====");
		}
		
		//	@Parameters("browser")
	
		
		@BeforeClass (groups = {"smokeTest", "regressionTest"})
		public void configBc() throws Throwable {
			//launch the browser
			String browser = fUtil.getPropertyFileData("browser");
			String url = fUtil.getPropertyFileData("url");
			if(browser.equals("chrome")) {
				
				System.setProperty(IpathConstants.CHROME_KEY , IpathConstants.CHROME_PATH);
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox")) {
				System.setProperty(IpathConstants.FIREFOX_KEY , IpathConstants.FIREFOX_PATH);
				driver = new FirefoxDriver();
			}
			else {
				System.out.println("browser is not supported");
			}
			
			sdriver=driver;
			driver.manage().window().maximize();
			wUtil.waitForPageLoad(driver);
			driver.get(url);
			}
	
			@BeforeMethod (groups = {"smokeTest", "regressionTest"})
			public void configBm() throws Throwable {
				
			//fetch the data from property file
			String username = fUtil.getPropertyFileData("username");
			String password = fUtil.getPropertyFileData("password");
			
			//login to new application
			LoginPage login =  new LoginPage(driver);
			login.loginToApplication(username, password);
			}
			
			@AfterMethod (groups = {"smokeTest", "regressionTest"})
			public void configAm() {
			//logout
			HomePage homePage = new HomePage(driver);
			homePage.logout();
			}

			@AfterClass (groups = {"smokeTest", "regressionTest"})
			public void configAc() {
				//closing the browser
				driver.quit();
			}

			@AfterSuite (groups = {"smokeTest", "regressionTest"})
			public void configAs() {
				//closing the database connection
				System.out.println("==============Database connection is closed=====");
			}
			}
