package sample;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("Create order");
	}
	
	@Test(enabled = false)
	public void billOrder() {
		System.out.println("Billing for created order");
	}

}
