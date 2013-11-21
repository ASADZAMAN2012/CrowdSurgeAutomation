package com.cs.ui.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cs.support.BrowserDriver;

public class TicketPurchase_TestCase extends BaseTestCase
{
	
	
	@Test
	public void ticketPurchase() throws Exception
	{
		BrowserDriver.open("http://www.crowdsurge.com/store/?storeid=1193");
		List <WebElement> buybutton = BrowserDriver.getDriver().findElements(By.xpath("//a[@class='action_button']//div[contains(text(),'Buy')]"));
		for (WebElement e : buybutton)
		{
	       e.click();		
	       
			if(BrowserDriver.getDriver().getWindowHandles().size()>1)
			{
				String master = BrowserDriver.getDriver().getWindowHandle();
				Set<String> handles = BrowserDriver.getDriver().getWindowHandles();
				for ( String handle : handles )
				{
				    if(!handle.equals(master))
				    {
				    	Thread.sleep(3000);
				    	BrowserDriver.getDriver().switchTo().window(handle);
				    	
				    }
				}
				BrowserDriver.getDriver().close();
				Thread.sleep(3000);
				BrowserDriver.getDriver().switchTo().window(master);
			}
			else
			{
				if(BrowserDriver.isElementPresent(By.xpath("//form[@id='fanclub_signup']//input[contains(@class,'submit') and contains(@value,'Join')]")))
				{
					signIn();
					selectQuantity(2);
					findTickets();
					break;
				}
				else if(BrowserDriver.isElementPresent(By.xpath("//input[@id='find_tickets']")))
				{
					selectQuantity(2);
					findTickets();
					break;
				}
					
			}
			
	    }
		
		
	}
	
	public void signIn()
	{
		BrowserDriver.getDriver().findElement(By.xpath("//form[contains(@id,'fanclub_signin')]//div[contains(@class,'fc_email')]//input[@name='fc_email']")).sendKeys("personalchithi@gmail.com");
		BrowserDriver.getDriver().findElement(By.xpath("//form[contains(@id,'fanclub_signin')]//div[contains(@class,'fc_password')]//input[@name='fc_password']")).sendKeys("Myfamily01");
		BrowserDriver.getDriver().findElement(By.xpath("//form[@id='fanclub_signin']//input[contains(@class,'submit') and contains(@value,'Sign')]")).click();
		
	}
	
	public void selectQuantity(int q)
	{
		BrowserDriver.getDriver().findElement(By.xpath("//span[contains(@class,'quantity')]//span[contains(@class,'selectboxit-arrow-container')]")).click();
		BrowserDriver.getDriver().findElement(By.xpath("//form[@id='ticket_request']//li[@id='"+2+"']/a")).click();
		
	}
	
	public void findTickets()
	{
	
		BrowserDriver.getDriver().findElement(By.xpath("//input[@id='find_tickets']")).click();
		
	}
	
	
	

}
