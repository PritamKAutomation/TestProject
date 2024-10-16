package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_2 {

	@BeforeSuite
	void beforesuite()
	{
		System.out.println("Before Suite Test_2");
	}
	@BeforeTest
	void beforetest()
	{
		System.out.println("Before Test Test_2");
	}
	@BeforeClass
	void beforeclass() {
		System.out.println("Before class Test_2");
	}
	@BeforeMethod
	void beforemethod() {
		System.out.println("Before Method Test_2");
	}
	@Test(priority =12)
	void test_A() {
		System.out.println("Test_A Test_2");
	}
	@Test(priority =1,invocationCount = -5)
	void test_B() {
		System.out.println("Test_B Test_2");
		
	}
	//Default priority is zero (priority=o)
	@Test(priority =1,invocationCount = 0)
	void test_C() {
		System.out.println("Test_C Test_2");
	}
	@Test(priority =-3,invocationCount = 2)
	void test_D() {
		System.out.println("Test_D Test_2");
	}
	@AfterMethod
	void aftermethod() {
		System.out.println("After Method Test_2");
	}
	@AfterClass
	void afterclass() {
		System.out.println("After Class Test_2");
	}
	@AfterTest
	void aftertest()
	{
		System.out.println("After Test Test_2");
	}
	@AfterSuite
	void aftersuite()
	{
		System.out.println("After Suite Test_2");
	}

}
