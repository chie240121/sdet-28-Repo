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
public class CreatePurchaseOrderAndCopyShippingAddrs_Test extends BaseClass{
	/**
	 * Create Purchase order and select "Copy Shipping Address" in this case "Billing address" is empty
	 * @param args
	 * @throws Throwable
	 * @throws Throwable
	 */
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
		
		//verification using hard assertion
		PurchaseOrderInformationPage purrchOrdrInfoPg = new PurchaseOrderInformationPage(driver);
		String actualShippngAddrsTxt = purrchOrdrInfoPg.getShippngAddrssInfoTxt();
		String actualBllngAddrsTxt = purrchOrdrInfoPg.getBllngAddrsInfoText();
		Assert.assertEquals(actualBllngAddrsTxt, actualShippngAddrsTxt);
		Reporter.log("verified ? both shipping address and billing address is same" , true);
		}
}
