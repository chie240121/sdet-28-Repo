package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author kajal
 *
 */
public class PurchaseOrderPage {
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseOrderPlusImage;

	//getters method
	public WebElement getcreatePurchaseOrderPlusImage() {
		return createPurchaseOrderPlusImage;
	}
	
	//business logic
	/**
	 * this method will click on purchase order plusImage
	 */
	public void clickPurchaseOrderPlusImage() {
		createPurchaseOrderPlusImage.click();
	}
	
}
