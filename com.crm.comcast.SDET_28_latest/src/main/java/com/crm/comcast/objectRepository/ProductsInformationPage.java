package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenricUtility.WebDriverUtility;
/**
 * Product Information pom class
 * @author kajal
 *
 */
public class ProductsInformationPage extends WebDriverUtility {
	WebDriver driver;
	public ProductsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@border='0'])[7]")
	private WebElement moreImg;
	
	@FindBy(name = "Vendors")
	private WebElement vendorsLink;
	
	
	
	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getmoreImg() {
		return moreImg;
	}
	
	/**
	 *  this method will perform click to vendors link action
	 */
	
	public void clickMoreLinkToGetVendorsLink(WebDriver driver) {
		mouseOver(driver, moreImg);
		vendorsLink.click();
	
}
}