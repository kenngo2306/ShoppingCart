package test;

import static org.junit.Assert.*;
import model.Shopuser;

import org.junit.Test;

import db.DBUser;

public class DBUserTest
{
	
	@Test
	public void testUpdateCredit()
	{
		System.out.println("test update credit");
		Shopuser user = DBUser.getUser(2);
		user.setStoreCredit(50);
		
		DBUser.update(user);
		
		user = DBUser.getUser(2);
		assertTrue(user.getStoreCredit() == 50);
		
		user.setStoreCredit(100);
		DBUser.update(user);
		
		user = DBUser.getUser(2);
		assertFalse(user.getStoreCredit() == 50);
		assertTrue(user.getStoreCredit() == 100);
	}
	
	@Test
	public void testLogin()
	{
		System.out.println("test login");
		Shopuser user = new Shopuser();
		user.setUserName("admin");
		user.setUserPassword("admin");
		
		long adminId = DBUser.login(user);
		
		user = DBUser.getUser(adminId);
		
		assertTrue(user.getUserName().equals("admin"));
	}
	
	@Test
	public void testHasActiveOrder()
	{
		System.out.println("test has active order");
		Shopuser user = DBUser.getUser(5);
		assertTrue(user.hasActiveOrder());
	}
	
	@Test
	public void testIsAvailable()
	{
		System.out.println("test is available");
		Shopuser user = new Shopuser();
		
		user.setUserName("admin");
		user.setEmail("admin@infosys.com");
		assertFalse(DBUser.isAvailable(user));
		
		user.setUserName("admin2");
		user.setEmail("admin@infosys.com");
		assertFalse(DBUser.isAvailable(user));
		
		user.setUserName("admin");
		user.setEmail("admin2@infosys.com");
		assertFalse(DBUser.isAvailable(user));
		
		user.setUserName("admin2");
		user.setEmail("admin2@infosys.com");
		assertTrue(DBUser.isAvailable(user));
		
		user.setUserName("admiN");
		user.setEmail("admin2@infosys.com");
		assertFalse(DBUser.isAvailable(user));
	}
	

}
