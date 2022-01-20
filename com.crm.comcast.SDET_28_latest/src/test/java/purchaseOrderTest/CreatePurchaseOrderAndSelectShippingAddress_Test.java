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
public class CreatePurchaseOrderAndSelectShippingAddress_Test extends BaseClass {
	/**
	 * Create Purchase order and select "Shipping Address"
	 * @param args
	 * @throws Throwable
	 */
	
	@Test(groups = {"smokeTest"})
	
	public  void createPurchaseOrderAndSelectShippingAddressTest() throws Throwable {
			
			//fetch the data from excel sheet
			String productName = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 28, 4);
			String vendorName = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 25, 4);
			String subject = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 24, 4);
			String billingAddress = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 26, 4);
			String expectedShipngAddrss = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 27, 4);
			double qty = eutilpurchase.getNumericCellData(IpathConstants.SHEET_NAME, 29, 4);
			String parentWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 30, 4); 
			String vendorWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 31, 4);
			String prodctWinId = eutilpurchase.getStringData(IpathConstants.SHEET_NAME, 32, 4);
	
			
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
			
			//switch to vendor window
			createPurchOrdr.clickVendorIcnAndSelectVendor(driver, vendorWinId, parentWinId);
			
			//switch to product window
			createPurchOrdr.clickProductIconAndSelectProduct(driver, prodctWinId, parentWinId);
			
			//billing address
			createPurchOrdr.createbillingAddress(billingAddress);
	
			//shippng address
			createPurchOrdr.createshippngAddress(expectedShipngAddrss);
			
			//quantity of product
			createPurchOrdr.quantityOfProduct(qty);
			
			//save page
			createPurchOrdr.saveButton();
			
			//verification using hard assertion
			PurchaseOrderInformationPage purchOrdrInfoPg = new PurchaseOrderInformationPage(driver);
			String actualShppngAdrssTxt = purchOrdrInfoPg.getShippngAddrssInfoTxt();
			Assert.assertEquals(actualShppngAdrssTxt.contains(expectedShipngAddrss), true);
			Reporter.log("verified ..shipping address" , true);
	}
}