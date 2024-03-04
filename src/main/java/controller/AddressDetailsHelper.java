package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AddressDetails;

/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Mar 1, 2024
 */

public class AddressDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertAddressDetails(AddressDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<AddressDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<AddressDetails> allDetails = em.createQuery("SELECT d FROM AddressDetails d").getResultList();
		return allDetails;
	}

	public AddressDetails searchForAddressDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AddressDetails found = em.find(AddressDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteList(AddressDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AddressDetails> typedQuery = em.createQuery("SELECT detail from AddressDetails detail where detail.id= :selectedId", AddressDetails.class);
		
		//substitute parameter with actual data from toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		//get result and save it into a new list item
		AddressDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateList(AddressDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
