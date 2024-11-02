package sample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic.baseUtility.BaseClass;
@Listeners(com.comcast.crm.listnerUtilty.ListnerImpl.class)
public class CreateInvoceTest extends BaseClass{
	
	@Test
	public void createInvoice() {
		System.out.println("Create invoce test");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		
	}
	@Test
	public void createInvoiceWithContact() {
		System.out.println("Create invoce test with contact");
	}

}
