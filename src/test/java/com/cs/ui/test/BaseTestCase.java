package com.cs.ui.test;

import org.junit.After;
import org.junit.Before;

import com.cs.support.BrowserDriver;

public class BaseTestCase
{
	@Before
	public void start() 
	{		
		BrowserDriver.start();
		BrowserDriver.maximizeWindow();
		
	}
	
	@After
	public void stop() 
	{
		BrowserDriver.stop();
	}

}
