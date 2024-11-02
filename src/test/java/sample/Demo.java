package sample;

import org.testng.annotations.Test;

public class Demo {
	
	public static void m1() {
		System.out.println("Am a static method");
	}
	
	public void m2() {
		System.out.println("Am a non static method");
	}
	@Test
	public static void m3() {
		System.out.println("@test static");
	}
	@Test
	public void m4() {
		System.out.println("@test non static");
	}
	public static void main(String[] args) {
		m1();
		Demo demo = new Demo();
		demo.m2();
	}

}
