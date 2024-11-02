package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	@Test(dataProvider = "getData")
	public void createContact(String firstName, String lastname) {
		System.out.println("FirstName: " + firstName + ", LastName: " + lastname);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "Rahul";
		objArr[0][1] = "UJ";
		
		objArr[1][0] ="Chethan";
		objArr[1][1] ="IS";
		
		objArr[2][0] ="Tejus";
		objArr[2][1] ="Kashyap";
		return objArr;

	}

}
