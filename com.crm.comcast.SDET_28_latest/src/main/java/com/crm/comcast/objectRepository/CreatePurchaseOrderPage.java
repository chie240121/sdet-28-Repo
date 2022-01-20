package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenricUtility.WebDriverUtility;
/**
 * create Create Purchase Order Page pom class
 * @author kajal
 *
 */
public class CreatePurchaseOrderPage extends WebDriverUtility {
	WebDriver driver;
public CreatePurchaseOrderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(name="subject")
	private WebElement subjectTextField;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement assignToGroup;
	
	@FindBy(name="bill_street")
	private WebElement billngAddrss;
	
	@FindBy(name="ship_street")
	private WebElement shippngAddrss;
	
	@FindBy(id = "qty1")
	private WebElement quantityOfProduct;
	
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;

	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement clickonVendorIcon;
	
	@FindBy(linkText= "Viraj")
	private WebElement selectVendor;
	
	@FindBy(xpath = "//img[@title='Products']")
	private WebElement clickOnProductIcon;
	
	
	@FindBy(linkText= "One Plus Mobile Phone")
	private WebElement selectProduct;
	
	@FindBy(xpath="//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement copyShippingaddressBar;
	
	
	
	
	
	
	public WebElement getCopyShippingaddressBar() {
		return copyShippingaddressBar;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	public WebElement getSelectVendor() {
		return selectVendor;
	}
	public WebElement getClickOnProductIcon() {
		return clickOnProductIcon;
	}
	public WebElement getClickonVendorIcon() {
		return clickonVendorIcon;
	}
	public WebElement getQuantityOfProduct() {
		return quantityOfProduct;
	}
	public WebElement getShippngAddrss() {
		return shippngAddrss;
	}
	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getBillngAddrss() {
		return billngAddrss;
	}
	public WebElement getAssignToGroup() {
		return assignToGroup;
	}
	public WebElement getsubjectTextField() {
		return subjectTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 *  this method  will create an subject
	 * @param subject
	 */
	public void createsubjectTextField(String subject) {
		subjectTextField.sendKeys(subject);
	}
	/**
	 * this method will click to group bar
	 */
	public void clickAssignToGroup() {
		assignToGroup.click();
	}
	/**
	 * this method  will create an billing address
	 * @param billngAddrss
	 */
	public void createbillingAddress(String billingAddress) {
		billngAddrss.sendKeys(billingAddress);
	}
	
	/**
	 * this method  will create an shipping address
	 * @param shipngAddrss
	 */
	public void createshippngAddress(String shipngAddrss) {
		shippngAddrss.sendKeys(shipngAddrss);
		
	}
	/**
	 * this method will enter the req quantity of product
	 * @param qty
	 */
	public void quantityOfProduct(double qty) {
		quantityOfProduct.sendKeys(qty+"");
	}
	
	/**
	 * this method will click to drop down and select team selling
	 */
	public void clickDropDownAndSelectTeamselling(String selectTeamSelling) {
		selectOption(selectTeamSelling, dropdown);
	}
	/**
	 * this method will click on vendor icon and select name of vendor
	 */
	public void clickVendorIcnAndSelectVendor(WebDriver driver , String childText, String parentID) {
		clickonVendorIcon.click();
		switchWindow(driver, childText);
		selectVendor.click();
		switchWindow(driver, parentID);
		
		
	}
	/**
	 * this method will click on product icon and select name of product
	 */
	public void clickProductIconAndSelectProduct(WebDriver driver , String childText, String parentID) {
		clickOnProductIcon.click();
		switchWindow(driver, childText);
		selectProduct.click();
		switchWindow(driver, parentID);
	
	}
	public void saveButton() {
		saveButton.click();
		
	}
	public void clickOnCopyShippingaddressBar() {
		copyShippingaddressBar.click();
	}
}
