package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Shoporder;
import model.Shopuser;
import customTools.DBUtil;

public class DBOrder
{
	public static Shoporder getOrder(long orderId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Shoporder order = em.find(Shoporder.class, orderId);
			return order;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<Shoporder> getAllOrders()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT o FROM Shoporder o ORDER BY o.orderDate DESC";
		List<Shoporder> orders = null;
		try
		{
			Query query = em.createQuery(queryStr);
			orders =  query.getResultList();
			System.out.println("size = " + orders.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return orders;
	}
	
	public static void insert(Shoporder order) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(order);
			trans.commit();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}

	public static void update(Shoporder order) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(order);
			trans.commit();
		} catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}

	public static void delete(Shoporder order) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(order));
			trans.commit();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} finally 
		{
			em.close();
		} 
	}
	
	public static long getActiveOrderId(Shopuser user)
	{
		//method to return the userId
		/*
		 * One user can have only one active order as a time (1 shopping cart as a time)
		 * User need to place order (change the status of the order from OPEN to PLACED in order to create another shopping cart
		 */
		//get active order id
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT o.orderId FROM Shoporder o WHERE o.shopuser = :user AND o.orderStatus='OPEN'";
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("user", user)
					.getSingleResult();
			return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			em.close();
		}
	}
}
