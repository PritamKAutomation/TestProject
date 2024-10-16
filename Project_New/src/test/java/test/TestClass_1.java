package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass_1 {
	
	@BeforeClass
	void beforeclass() {
		System.out.println("Launch the Browser");
	}
	@BeforeMethod
	void beforemethod() {
		System.out.println("Open the Application");
		System.out.println("Login");
	}
	@Test
	void test_A()
	{
		System.out.println("Verify Order");
	}
	@Test
	void test_B()
	{
		System.out.println("Verify Account");
	}
	@Test
	void test_C()
	{
		System.out.println("Verify Cart");
	}
	@AfterMethod
	void aftermethod() {
		System.out.println("Logout");
	}
	@AfterClass
	void afterclass() {
		System.out.println("Close the Browser");
	}
}
