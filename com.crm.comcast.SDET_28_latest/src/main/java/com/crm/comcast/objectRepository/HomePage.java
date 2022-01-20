package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenricUtility.WebDriverUtility;
/**
 * Homepage POM design
 * @author kajal
 *
 */
	public class HomePage extends WebDriverUtility {
	//initialization of element
		WebDriver driver;
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		//declaration of elements
		@FindBy(linkText="Organizations")
		private WebElement organizationLink;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactsLink;
		
		@FindBy(linkText = "Products")
		private WebElement productLink;
		
		@FindBy(xpath="//img [@src='themes/softed/images/user.PNG']")
		private WebElement logoutImg;
		
		@FindBy(xpath = "//img[@style='padding-left:5px']")
		private WebElement moreImg;
		
		
		@FindBy(xpath="(//a[@class='drop_down_usersettings'])[2]")
		private WebElement signOutLink;
		
	
		//getters methods
	
	public WebElement getmoreImg() {
			return moreImg;
		}
	public WebElement getProductLink() {
		return productLink;
	}
		
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business logics
	/**
	 * this method will click on Products link
	 */
	public void clickProductsLink() {
		productLink.click();
	}
	
	/**
	 * this method will click on organization link
	 */
	public void clickOrganizationLink() {
		organizationLink.click();
	}
	
	/**
	 * this method will perform logout action
	 */
	
	public void logout() {
		mouseOver(driver, logoutImg);
		signOutLink.click();
	}
	}
	
	
	
	
	