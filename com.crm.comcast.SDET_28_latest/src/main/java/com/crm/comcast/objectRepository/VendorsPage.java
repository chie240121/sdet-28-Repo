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
public class VendorsPage {
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorsPlusImage;

	//getters method
	public WebElement getcreateVendorsPlusImage() {
		return createVendorsPlusImage;
	}
	
	//business logic
	/**
	 * this method will click on vendors plusImage
	 */
	public void clickCreateVendorsImg() {
		createVendorsPlusImage.click();
	}
	
}
