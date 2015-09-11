package test;

import static org.junit.Assert.*;
import model.Shoplineitem;
import model.Shoporder;
import model.Shopproduct;
import model.Shopuser;

import org.junit.Test;

import db.DBLineItem;
import db.DBProduct;
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
	
	@Test
	public void testLoginAndAddItemToCart()
	{
		//this test is used to login, add an item to the active ordeR(cart), and check if the size of the cart increase
		System.out.println("Test login and add one line item...");
		Shopuser user = DBUser.getUser(3);
		System.out.println(user.getFullName());
		
		//test has active order
		assertTrue(user.hasActiveOrder());
		
		//get active order
		Shoporder activeCart = user.getActiveOrder();
		
		//get current size of cart
		int numItems = activeCart.getShoplineitems().size();
		System.out.println("current numItems = " + numItems);
		
		System.out.println("adding one line to the cart ....");
		//get product from db
		Shopproduct product = DBProduct.getProduct(2);
		
		//add one item to the cart
		Shoplineitem newLine = new Shoplineitem();
		newLine.setQuantity(7);
		newLine.setReturned("No");
		newLine.setShoporder(activeCart);
		newLine.setShopproduct(product);
		
		DBLineItem.insert(newLine);
		System.out.println("Added");
		//get active order again
		activeCart = user.getActiveOrder();
		System.out.println("new NumItems is = " + activeCart.getShoplineitems().size());
		assertTrue(activeCart.getShoplineitems().size() == (numItems + 1));
	}
	

}
