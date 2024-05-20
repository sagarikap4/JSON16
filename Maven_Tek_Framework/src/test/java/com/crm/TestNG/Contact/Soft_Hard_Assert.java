package com.crm.TestNG.Contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Hard_Assert {

	@Test
	public void AssertTest() {
		SoftAssert sa= new SoftAssert();
		System.out.println("Test-1");
		System.out.println("Test-2");
		sa.assertNotEquals("test", "teste");
		System.out.println("Test-3");
		Assert.assertEquals("home", "homee");
		System.out.println("Test-4");
		System.out.println("Test-5");
		
		
	}
}
