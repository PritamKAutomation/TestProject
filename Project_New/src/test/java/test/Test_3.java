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

public class Test_3 {
	
	@BeforeSuite
	void beforesuite()
	{
		System.out.println("Before Suite Test_3");
	}
	@BeforeTest
	void beforetest()
	{
		System.out.println("Before Test Test_3");
	}
	@BeforeClass
	void beforeclass() {
		System.out.println("Before class Test_3");
	}
	@BeforeMethod
	void beforemethod() {
		System.out.println("Before Method Test_3");
	}
	@Test
	void test_A() {
		System.out.println("Test_A Test_3");
	}
	@Test
	void test_B() {
		System.out.println("Test_B Test_3");
		
	}
	//Default priority is zero (priority=o)
	@Test
	void test_C() {
		System.out.println("Test_C Test_3");
	}
	@Test
	void test_D() {
		System.out.println("Test_D Test_3");
	}
	@AfterMethod
	void aftermethod() {
		System.out.println("After Method Test_3");
	}
	@AfterClass
	void afterclass() {
		System.out.println("After Class Test_3");
	}
	@AfterTest
	void aftertest()
	{
		System.out.println("After Test Test_3");
	}
	@AfterSuite
	void aftersuite()
	{
		System.out.println("After Suite Test_3");
	}


}
