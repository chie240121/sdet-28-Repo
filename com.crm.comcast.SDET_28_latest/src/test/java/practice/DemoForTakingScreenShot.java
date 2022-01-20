package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenricUtility.BaseClass;

@Listeners(com.crm.comcast.GenricUtility.ListenerImplementationClass.class)
public class DemoForTakingScreenShot extends BaseClass {
@Test
public void sample() {
	String expectedName = "kajal";
	String actualName = "Kajal sharma";
	Assert.assertEquals(actualName, expectedName);
}
}