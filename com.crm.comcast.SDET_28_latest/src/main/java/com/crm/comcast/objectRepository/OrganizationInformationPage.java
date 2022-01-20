package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Organization Information pom class
 * @author kajal
 *
 */
public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoText;
	
	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	
	/**
	 * it will return the organization information text
	 * @return
	 */
	public String getOrgInformationText() {
		return orgInfoText.getText();
	}
	
}
