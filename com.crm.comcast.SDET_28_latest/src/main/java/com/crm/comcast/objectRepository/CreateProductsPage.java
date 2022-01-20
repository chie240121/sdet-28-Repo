package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * create products pom class
 * @author kajal
 *
 */
public class CreateProductsPage {
public CreateProductsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	//getters
	public WebElement getproductNameTextField() {
		return productNameTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this method  will create an Product name
	 * @param orgName
	 */
	public void createProducts(String productName) {
		productNameTextField.sendKeys(productName);
		saveButton.click();
	}
	
	
}
