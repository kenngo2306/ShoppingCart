package test;

import static org.junit.Assert.*;
import model.Shopuser;

import org.junit.Test;

import db.DBUser;

public class DBUserTest
{
//	@Test
	public void testInsert()
	{
		Shopuser user = new Shopuser();
		user.setEmail("admin@infosys.com");
		user.setFullName("admin");
		user.setUserName("admin");
		user.setUserRole("0");
		user.setUserPassword("admin");
		
		DBUser.insert(user);
	}
	
	@Test
	public void testUpdateCredit()
	{
		Shopuser user = DBUser.getUser(2);
		user.setStoreCredit(50);
		
		DBUser.update(user);
	}
	
//	@Test
	public void testLogin()
	{
		Shopuser user = new Shopuser();
		user.setUserName("admin");
		user.setUserPassword("admin");
		
		System.out.println(DBUser.login(user));
	}
	
//	@Test
	public void testHasActiveOrder()
	{
		Shopuser user = DBUser.getUser(5);
		assertTrue(user.hasActiveOrder());
	}
	
//	@Test
	public void testHasNoReview()
	{
		assertFalse(DBUser.hasNoReview(8, 3));
		assertTrue(DBUser.hasNoReview(8, 2));
	}
	
//	@Test
	public void testIsAvailable()
	{
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
	
//	@Test
//	public void testGetUser()
//	{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllUsers()
//	{
//		fail("Not yet implemented");
//	}
//
//
//
//	@Test
//	public void testUpdate()
//	{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete()
//	{
//		fail("Not yet implemented");
//	}

}
