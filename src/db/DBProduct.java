package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;




import model.Shopproduct;
import model.Shopuser;
import customTools.DBUtil;

public class DBProduct
{
	
//	public static List<Post> searchPostsInProfile(long userId, String query)
//	{
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		String queryStr = "SELECT e FROM Post e WHERE e.bulluser.userId = :userId AND e.postContent LIKE :query ";
//		List<Post> posts = null;
//		try
//		{
//			Query q = em.createQuery(queryStr);
//			q.setParameter("query", '%' + query + '%');
//			q.setParameter("userId", userId);
//			posts =  q.getResultList();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			em.close();
//		}
//		return posts;
//	}
	
//	public static List<Post> searchPosts(String query)
//	{
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		String queryStr = "SELECT e FROM Post e WHERE e.postContent LIKE :query ";
//		List<Post> posts = null;
//		try
//		{
//			Query q = em.createQuery(queryStr);
//			q.setParameter("query", '%' + query + '%');
//			posts =  q.getResultList();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			em.close();
//		}
//		return posts;
//	}
	
	public static Shopproduct getProduct(long productId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Shopproduct product = em.find(Shopproduct.class, productId);
			return product;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<Shopproduct> getProductByUser(Shopuser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT p FROM Shopproduct p WHERE p.shopuser = :user ORDER BY p.productName";
		List<Shopproduct> products = null;
		try
		{
			Query query = em.createQuery(queryStr).setParameter("user", user);
			products =  query.getResultList();
			System.out.println("size = " + products.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return products;
	}
	
	public static List<Shopproduct> getAllProducts()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT p FROM Shopproduct p ORDER BY p.productName";
		List<Shopproduct> products = null;
		try
		{
			Query query = em.createQuery(queryStr);
			products =  query.getResultList();
			System.out.println("size = " + products.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return products;
	}
	
	public static void insert(Shopproduct product) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(product);
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

	public static void update(Shopproduct product) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(product);
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

	public static void delete(Shopproduct product) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(product));
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
