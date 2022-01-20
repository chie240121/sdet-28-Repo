package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
@Test
public void sample() {
	String expectedName ="Kajal";
	String actualName = "Kajal sharma";
	Reporter.log("this is a soft assert class ", true);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(expectedName, actualName);
	sa.assertAll();   // this is to chch where the error is to verify failures
}
}
