package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * create vendors pom class
 * @author kajal
 *
 */
public class CreateVendorsPage {
public CreateVendorsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(name="vendorname")
	private WebElement vendorNameTextField;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	//getters
	public WebElement getvendorNameTextField() {
		return vendorNameTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this method  will create an vendors name
	 * @param orgName
	 */
	public void createVendors(String vendorName) {
		vendorNameTextField.sendKeys(vendorName);
		saveButton.click();
	}
	
	
}
