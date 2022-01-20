package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenricUtility.WebDriverUtility;
/**
 * Vendors Information pom class
 * @author kajal
 *
 */
public class VendorsInformationPage extends WebDriverUtility {
	WebDriver driver;
	public VendorsInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@style='padding-left:5px']")
	private WebElement moreImg;
	
	@FindBy(name = "Purchase Order")
	private WebElement purchaseOrderLink;
	
	
	public WebElement getpurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getmoreImg() {
		return moreImg;
	}
	
	/**
	 *  this method will perform click to purchase order link action
	 */
	
	public void clickMoreLinkToGetPurchaseOrderLink(WebDriver driver) {
		mouseOver(driver, moreImg);
		purchaseOrderLink.click();
	
}
}