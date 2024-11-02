package sample;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(priority = 1)
	public void createContactTest() {
		System.out.println("Create contact.");
	}
	@Test(priority = 2)
	public void modifyContactTest() {
		System.out.println("Modify Contact.");
	}
	@Test(priority = 3)
	public void deleteContactTest() {
		System.out.println("Delete Contact test");
	}

}
