package com.Securus.Radius23_TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.Log;

public class Dummy2 extends TestBaseSetup{
	

	
	@Test
	public void test1()
	{
		Log.log.info("Testing with dummy2.test1 test");

		assertTrue(false);
	}
	@Test
	public void test2()
	{
		Log.log.info("Testing with dummy2.test2 test");

		assertTrue(true);
	}
 

}
