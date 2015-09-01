package test;

import static org.junit.Assert.*;
import model.Shopuser;

import org.junit.Test;

import db.DBOrder;
import db.DBUser;

public class DBOrderTest
{

//	@Test
//	public void testGetOrder()
//	{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllOrders()
//	{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsert()
//	{
//		fail("Not yet implemented");
//	}
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

//	@Test
	public void testGetActiveOrderId()
	{
		long userId = 5;
		Shopuser user = DBUser.getUser(userId);
		
		assertTrue(user.hasActiveOrder());
	}

}
