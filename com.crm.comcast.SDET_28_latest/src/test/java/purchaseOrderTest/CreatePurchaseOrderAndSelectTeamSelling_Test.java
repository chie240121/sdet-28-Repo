package purchaseOrderTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenricUtility.BaseClass;
import com.crm.comcast.GenricUtility.IpathConstants;
import com.crm.comcast.objectRepository.CreateProductsPage;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;
import com.crm.comcast.objectRepository.CreateVendorsPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.ProductsInformationPage;
import com.crm.comcast.objectRepository.ProductsPage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.PurchaseOrderPage;
import com.crm.comcast.objectRepository.VendorsInformationPage;
import com.crm.comcast.objectRepository.VendorsPage;

/**
 * 
 * @author kajal
 *
 */
@Listeners(com.crm.comcast.GenricUtility.ListenerImplementationClass.class)
public class CreatePurchaseOrderAndSelectTeamSelling_Test extends BaseClass {

	/**
	 * Create Purchase order and select Assigned to in that select Groups and select "Team selling"
	 * @param args
	 * @throws Throwable
	 */
	
	@Test(groups = {"smokeTest"})
	public void createPurchaseOrderAndSelectTeamSellingTest() throws Throwable {
		
		
		//fetch the data from excel sheet
		String expectedSelectTeamSelling = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 4, 4);
		String productName = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 7, 4);
		String vendorName = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 3, 4);
		String subject = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 2, 4);
		String billingAddress = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 5, 4);
		String shipngAddrss = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 6, 4);
		double qty = eutilpurchase.getNumericCellData(IpathConstants.SHEET_NAME, 8, 4);
		String parentWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 9, 4);
		String vendorWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 10, 4);
		String prodctWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME,11, 4);
		
		
		//create product 
		HomePage homePage = new HomePage(driver);
		homePage.clickProductsLink();
		
		ProductsPage productPg = new ProductsPage(driver);
		productPg.clickCreateproductImg();
		
		CreateProductsPage createProdctPg = new CreateProductsPage(driver);
		createProdctPg.createProducts(productName);
		
		ProductsInformationPage productsInfoPg = new ProductsInformationPage(driver);
		productsInfoPg.clickMoreLinkToGetVendorsLink(driver);
		
		//mouse-hover to Create Vendors page
		VendorsPage vendrPg = new VendorsPage(driver);
		vendrPg.clickCreateVendorsImg();
		
		
		CreateVendorsPage creatVendrPg = new CreateVendorsPage (driver);
		creatVendrPg.createVendors(vendorName);
		
		VendorsInformationPage vendrInfoPg = new VendorsInformationPage(driver);
		vendrInfoPg.clickMoreLinkToGetPurchaseOrderLink(driver);
		
		//mouse-hover to purchase order page
		PurchaseOrderPage purchOrdrPg = new PurchaseOrderPage(driver);
		purchOrdrPg.clickPurchaseOrderPlusImage();
		
		CreatePurchaseOrderPage createPurchOrdr = new CreatePurchaseOrderPage(driver);
		
		// subject
		createPurchOrdr.createsubjectTextField(subject);
		
		//mark on group bar
		createPurchOrdr.clickAssignToGroup();
		
		//select team selling from drop down
		createPurchOrdr.clickDropDownAndSelectTeamselling(expectedSelectTeamSelling);
		//switch to vendor window
		createPurchOrdr.clickVendorIcnAndSelectVendor(driver, vendorWinId, parentWinId);
		//switch to product window
		createPurchOrdr.clickProductIconAndSelectProduct(driver, prodctWinId, parentWinId);
		
		//billing address
		createPurchOrdr.createbillingAddress(billingAddress);
		//shippng address
		createPurchOrdr.createshippngAddress(shipngAddrss);
		
		//quantity of product
		createPurchOrdr.quantityOfProduct(qty);
		
		//save page
		createPurchOrdr.saveButton();
		
		//verification using hard assertion
		PurchaseOrderInformationPage purchOrdrIndoPg = new PurchaseOrderInformationPage(driver);
		String actualTeamSelling =  purchOrdrIndoPg.getpurchaseInformationText();
		Assert.assertEquals(actualTeamSelling.contains(expectedSelectTeamSelling), true);
		Reporter.log("Verified..assigned to group in which TEAM SELLING" , true);
	}
}
		
		
