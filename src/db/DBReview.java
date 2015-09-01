package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Shopreview;
import customTools.DBUtil;

public class DBReview
{
	public static Shopreview getReview(long reviewId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Shopreview order = em.find(Shopreview.class, reviewId);
			return order;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<Shopreview> getAllReviews()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT r FROM Shopreview r";
		List<Shopreview> reviews = null;
		try
		{
			Query query = em.createQuery(queryStr);
			reviews =  query.getResultList();
			System.out.println("size = " + reviews.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return reviews;
	}
	
	public static void insert(Shopreview review) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(review);
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

	public static void update(Shopreview review) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(review);
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

	public static void delete(Shopreview review) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(review));
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
