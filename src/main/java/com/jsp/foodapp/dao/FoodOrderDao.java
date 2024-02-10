package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entites.FoodOrder;
import com.jsp.foodapp.entites.Product;
import com.jsp.foodapp.entites.User;

@Repository
public class FoodOrderDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveFoodOrder(FoodOrder foodorder) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(foodorder);
		et.commit();
	}
	
	public FoodOrder getFoodOrderById(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(FoodOrder.class, id);

	}
	
	public List<FoodOrder> viewAllFoodOrder(){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select f from FoodOrder f");
		return query.getResultList();
	}
	
	public void updateFoodOrder(FoodOrder foodorder) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(foodorder);
		et.commit();
	}
	
	public void deleteFoodOrderById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		FoodOrder foodorder = em.find(FoodOrder.class, id);
		
		et.begin();
		em.remove(foodorder);
		et.commit();
	}

}
