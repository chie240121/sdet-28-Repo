package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsHard {
@Test
public void demo() {
	System.out.println("launch the browser");
	System.out.println("login to application");
	System.out.println("create organization");
	
	int a  = 10;
	int b = 20;
	Assert.assertEquals(a, b);
	
	int[] arr = {1,2,3,4,4};
	int[] arr1 = {1,2,3,4};
	Assert.assertEquals(arr, arr1);
	Assert.assertEquals(false, true);
	String expextedName = "kajal";
	String actualName = "kajal sharma";
	Assert.assertEquals(actualName, expextedName);
	
	System.out.println("logout from application");
	System.out.println("quit the browser");
	
}
}
