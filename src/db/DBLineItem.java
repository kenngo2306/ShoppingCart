package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Shoplineitem;
import model.Shopproduct;
import customTools.DBUtil;

public class DBLineItem
{
	
	public static Shoplineitem getLineItem(long lineItemId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Shoplineitem lineItem = em.find(Shoplineitem.class, lineItemId);
			return lineItem;
		}
		finally
		{
			em.close();
		}
	}
	public static long getCount()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT COUNT(l.lineItemId) FROM Shoplineitem l";
		long count = 0;
		try
		{
			Query query = em.createQuery(queryStr);
			count = (long) query.getSingleResult();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return count;
	}
	
	
//	public static Shopproduct getProduct(long productId)
//	{
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		try
//		{
//			Shopproduct product = em.find(Shopproduct.class, productId);
//			return product;
//		}
//		finally
//		{
//			em.close();
//		}
//	}
//	
	public static List<Shoplineitem> getAllLineItems()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT l FROM Shoplineitem l";
		List<Shoplineitem> lineItems = null;
		try
		{
			Query query = em.createQuery(queryStr);
			lineItems =  query.getResultList();
			System.out.println("size = " + lineItems.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return lineItems;
	}
//	
	public static void insert(Shoplineitem lineItem) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(lineItem);
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
//
//	public static void update(Shopproduct product) 
//	{
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		trans.begin(); 
//		try 
//		{
//			em.merge(product);
//			trans.commit();
//		} catch (Exception e) 
//		{
//			System.out.println(e);
//			trans.rollback();
//		} 
//		finally 
//		{
//			em.close();
//		}
//	}
//
	public static void delete(Shoplineitem lineItem) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(lineItem));
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
}
