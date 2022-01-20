package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInformationPage {
	public PurchaseOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Team Selling")
	private WebElement purchOrderInfoText;
	
	@FindBy(id = "mouseArea_Billing Address")
	private WebElement bllngAddrssText;
	
	@FindBy(id= "mouseArea_Shipping Address")
	private WebElement shippngAddrssText;
	
	
	
	
	
	
	
	
	
	
	public WebElement getShippngText() {
		return shippngAddrssText;
	}

	public WebElement getBllngAddrssText() {
		return bllngAddrssText;
	}
	
	public WebElement getpurchOrderInfoText() {
		return purchOrderInfoText;
	}
	
	
	
	/**
	 * this method will return team selling text
	 * @return
	 */
	
	public String getpurchaseInformationText() {
		return purchOrderInfoText.getText();
	}
	/**
	 * this method will return billing address text
	 * @return
	 */
	
	public String getBllngAddrsInfoText() {
		return bllngAddrssText.getText();
	}
	/**
	 * this method will return shippng address text
	 * @return
	 */
	
	public String getShippngAddrssInfoTxt() {
		return shippngAddrssText.getText();
	}
	
}


