package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_1 {

	@BeforeTest
	void beforetest()
	{
		System.out.println("Before Test Test_1");
	}
	@BeforeClass
	void beforeclass() {
		System.out.println("Before class Test_1");
	}
	@BeforeMethod
	void beforemethod() {
		System.out.println("Before Method Test_1");
	}
	@Test(priority =12)
	void test_A() {
		System.out.println("Test_A Test_1");
	}
	@Test(priority =1)
	void test_B() {
		System.out.println("Test_B Test_1");
		
	}
	//Default priority is zero (priority=o)
	@Test
	void test_C() {
		System.out.println("Test_C Test_1");
	}
	@Test(priority =-3)
	void test_D() {
		System.out.println("Test_D Test_1");
	}
	@AfterMethod
	void aftermethod() {
		System.out.println("After Method Test_1");
	}
	@AfterClass
	void afterclass() {
		System.out.println("After Class Test_1");
	}
	@AfterTest
	void aftertest()
	{
		System.out.println("After Test Test_1");
	}
	
}
