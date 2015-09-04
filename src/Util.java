import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


import customTools.DBUtil;

public class Util<T> {

	public void insert(T obj) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(obj);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public void update(T obj) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(obj);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public void delete(T obj) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(obj));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	
	public List<T> getList( String nString)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		String qString = nString;
		
		
		TypedQuery<Object> q =  em.createQuery(qString, Object.class);
		
		List<Object> temp_doneitems = new ArrayList<Object>();
		List<T> doneitems = new ArrayList<T>();
		try{
			temp_doneitems = q.getResultList();
			doneitems = (List<T>) temp_doneitems;
		}
		catch(Exception e){
			System.out.println("err with gettin list from db");
		}
		finally{
			em.close();	
		}
		return doneitems;
		
		
	}
	
	
	public T getResult( String nString)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		String qString = nString;
		
		
		TypedQuery<Object> q =  em.createQuery(qString, Object.class);
		
		Object temp_doneitem;
		T doneitem = null;
		try{
			temp_doneitem = q.getSingleResult();
			doneitem =  (T) temp_doneitem;
		}
		catch(Exception e){
			System.out.println("err with gettin list from db");
		}
		finally{
			em.close();	
		}
		
		return doneitem;
		
		
	}
	
	

}