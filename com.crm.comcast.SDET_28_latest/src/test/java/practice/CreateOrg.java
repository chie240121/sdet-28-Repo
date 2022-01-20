package practice;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrg {
	
@BeforeClass
public void beforeClass() {
	System.out.println("launch the browser");
}

@AfterClass
public void afterClass() {
	System.out.println("close the browser");
}

@BeforeMethod
public void beforeMethod() {
	System.out.println("login to the application");
}
@AfterMethod
public void afterMethod() {
	System.out.println("logout from the application");
}

@Test(priority = 1)
public void org() {
	System.out.println("navigate to the organization");
	System.out.println("create organization");
	System.out.println("verify the organization");
}
@Test(priority = 2)
public void contact() {
	System.out.println("navigate to the contacts");
	System.out.println("create contacts");
	System.out.println("verify the contacts");
}
@Test(priority = 3)
public void products() {
	System.out.println("navigate to the products");
	System.out.println("create products");
	System.out.println("verify the products");
}
}
