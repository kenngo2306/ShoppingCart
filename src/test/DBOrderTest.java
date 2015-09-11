package test;

import static org.junit.Assert.*;
import model.Shoplineitem;
import model.Shoporder;
import model.Shopproduct;
import model.Shopuser;

import org.junit.Test;

import db.DBLineItem;
import db.DBOrder;
import db.DBProduct;
import db.DBUser;

public class DBOrderTest
{
	@Test
	public void testGetActiveOrderId()
	{
		System.out.println("test active order");
		long userId = 5;
		Shopuser user = DBUser.getUser(userId);
		
		assertTrue(user.hasActiveOrder());
	}

	@Test
	public void testAddItem()
	{
		System.out.println("test add item");
		long userId = 3;
		Shopuser user = DBUser.getUser(userId);
		
		Shoporder order = DBOrder.getOrder(3);
		System.out.println("initial order item size = " + order.getShoplineitems().size());
		
		Shoplineitem lineItem =  new Shoplineitem();
		lineItem.setQuantity(2);
		lineItem.setShoporder(order);
		
		Shopproduct product = DBProduct.getProduct(5);
		lineItem.setShopproduct(product);
		
		DBLineItem.insert(lineItem);
		
		Shoporder order2 = DBOrder.getOrder(3);
		System.out.println("after insert order item size = " + order2.getShoplineitems().size());
		
		
	}
}
