package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenricUtility.BaseClass;
import com.crm.comcast.GenricUtility.ExcelUtility;
import com.crm.comcast.GenricUtility.FileUtility;
import com.crm.comcast.GenricUtility.IpathConstants;
import com.crm.comcast.GenricUtility.JavaUtility;
import com.crm.comcast.GenricUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.CreateProductsPage;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;
import com.crm.comcast.objectRepository.CreateVendorsPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;
import com.crm.comcast.objectRepository.ProductsInformationPage;
import com.crm.comcast.objectRepository.ProductsPage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.PurchaseOrderPage;
import com.crm.comcast.objectRepository.VendorsInformationPage;
import com.crm.comcast.objectRepository.VendorsPage;

public class CreateOrganization1Test extends BaseClass {

	@Test
	public void createOrg() throws Throwable {
		
		//generate random number
		int randomNumber = jUtility.getRandomNumber();
		
		//get the data from excel sheet 
		String ExpectedorganizationName = eUtility.getStringData("Sheet1", 1, 2);
		ExpectedorganizationName = ExpectedorganizationName + randomNumber;
		
		//create organization 
   		HomePage homePage = new HomePage(driver);
   		homePage.clickOrganizationLink();
   		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(ExpectedorganizationName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();
		
		//organization verification
		if(actualOrgName.contains(ExpectedorganizationName)) {
			System.out.println("organization is created");
		}
		else {
			System.out.println("organization is not created");
		}		
	}
	
	
@Test(groups = {"regressionTest"})
	
	public  void createPurchaseOrderAndCopyShippingAddrsTest() throws Throwable {

		//fetch the data from excel sheet
		String shippngAddrs = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 36, 4);
		String subject = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 34, 4); 
		double qty = eutilpurchase.getNumericCellData(IpathConstants.SHEET_NAME, 38, 4);
		String productName = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 37, 4);
		String vendorName = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 35, 4);
		String parentWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 39, 4); 
		String vendorWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 40, 4);
		String prodctWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 41, 4);
				
		
		//create Products
		HomePage homPg = new HomePage(driver);
		homPg.clickProductsLink();
				
		ProductsPage prodctsPg = new ProductsPage(driver);
		prodctsPg.clickCreateproductImg();
				
		CreateProductsPage creatProdctsPg = new CreateProductsPage(driver);
		creatProdctsPg.createProducts(productName);
				
		ProductsInformationPage productsInfoPg = new ProductsInformationPage(driver);
		productsInfoPg.clickMoreLinkToGetVendorsLink(driver);
				
		//mouse-hover to Create Vendors page
		VendorsPage vendrPg = new VendorsPage(driver);
		vendrPg.clickCreateVendorsImg();
				
				
		CreateVendorsPage creatVendrPg = new CreateVendorsPage (driver);
		creatVendrPg.createVendors(vendorName);
				
		//mouse-hover to purchase order page
		VendorsInformationPage vendrInfoPg = new VendorsInformationPage(driver);
		vendrInfoPg.clickMoreLinkToGetPurchaseOrderLink(driver);
				
		PurchaseOrderPage purchOrdrPg = new PurchaseOrderPage(driver);
		purchOrdrPg.clickPurchaseOrderPlusImage();
				
		CreatePurchaseOrderPage createPurchOrdr = new CreatePurchaseOrderPage(driver);
				
		// subject
		createPurchOrdr.createsubjectTextField(subject);
				
		//switch to vendor window
		createPurchOrdr.clickVendorIcnAndSelectVendor(driver, vendorWinId, parentWinId);
				
		//switch to product window
		createPurchOrdr.clickProductIconAndSelectProduct(driver, prodctWinId, parentWinId);
				
		//Enter "Billing address" and select "copy Shipping address" then "shipping address" is copy to "Billing address" in this case 
		createPurchOrdr.createshippngAddress(shippngAddrs);
				
		//click on "copy shipping address bar"
	    createPurchOrdr.clickOnCopyShippingaddressBar();
				
		//quantity of product
		createPurchOrdr.quantityOfProduct(qty);
				
		//save page
		createPurchOrdr.saveButton();
				
		//verification
		PurchaseOrderInformationPage purrchOrdrInfoPg = new PurchaseOrderInformationPage(driver);
		String actualShippngAddrsTxt = purrchOrdrInfoPg.getShippngAddrssInfoTxt();
		String actualBllngAddrsTxt = purrchOrdrInfoPg.getBllngAddrsInfoText();
				
		if(actualBllngAddrsTxt.equals(actualShippngAddrsTxt)) {
			System.out.println("sucessfully verified...that billing addrs is same as shippng addrs ...!!");
			                                                	}
			else {
					System.out.println("not verified");
				}
		}

}
