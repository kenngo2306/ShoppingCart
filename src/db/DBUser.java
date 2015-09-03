package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import model.Shopuser;
import customTools.DBUtil;

public class DBUser
{
	/*
	 * This method accepts an username and a password then return a userId (if any) 
	 * If there's no user match the username and password then return 0
	 */
	public static long login(Shopuser user)
	{
		//method to return the userId
		
		//get user name
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT d.userId FROM Shopuser d WHERE d.userName = :userName AND d.userPassword = :password";
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("userName", user.getUserName())
					.setParameter("password", user.getUserPassword())
					.getSingleResult();
			return l;
		}
		catch(Exception e)
		{
			return 0;
		}
		finally
		{
			em.close();
		}
	}
	
	public static boolean hasNoReview(long productId, long userId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(r.reviewId) FROM Shopreview r WHERE r.shopproduct.productId = :productId AND r.shopuser.userId = :userId";
		
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("productId", productId)
					.setParameter("userId", userId)
					.getSingleResult();
			if (l>0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			em.close();
		}
	}
	
	public static boolean isAvailable(Shopuser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(d.userId) FROM Shopuser d WHERE UPPER(d.userName) = :userName OR UPPER(d.email) = :email";
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("userName", user.getUserName().toUpperCase())
					.setParameter("email", user.getEmail().toUpperCase())
					.getSingleResult();
			if (l>0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			em.close();
		}
	}
	
	public static Shopuser getUser(long userId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Shopuser order = em.find(Shopuser.class, userId);
			return order;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<Shopuser> getAllUsers()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT u FROM Shopuser u";
		List<Shopuser> users = null;
		try
		{
			Query query = em.createQuery(queryStr);
			users =  query.getResultList();
			System.out.println("size = " + users.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return users;
	}
	
	public static void insert(Shopuser user) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(user);
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

	public static void update(Shopuser user) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(user);
			trans.commit();
		} catch (Exception e) 
		{
			e.printStackTrace();
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}

	public static void delete(Shopuser user) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.remove(em.merge(user));
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
