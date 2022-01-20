package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgPlusImage;

	//getters method
	public WebElement getCreateOrgPlusImage() {
		return createOrgPlusImage;
	}
	
	//business logic
	/**
	 * this method will click on createOrg plusImage
	 */
	public void clickCreateOrgImg() {
		createOrgPlusImage.click();
	}

	
	
}
