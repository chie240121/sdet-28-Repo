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
public class ProductsPage {
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductsPlusImage;

	//getters method
	public WebElement getcreateProductsPlusImage() {
		return createProductsPlusImage;
	}
	
	//business logic
	/**
	 * this method will click on createOrg plusImage
	 */
	public void clickCreateproductImg() {
		createProductsPlusImage.click();
	}
	
}
