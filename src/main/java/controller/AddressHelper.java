package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;
import model.ListItem;


/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Feb 27, 2024
 */
public class AddressHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertItem(Address ad) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ad);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Address> showAllAddresses(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddresses = em.createQuery("SELECT i FROM Addresses i").getResultList();
		
		return allAddresses;
	}
	
	
	public void deleteAddress(Address toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery(
				"select ad from Address ad where"
				+ " ad.StreetName = :selectedStreetName"
				+ " and ad.OwnerName = :selectedOwnerName"
				+ " and ad.zip = :selectedzip"
				+ " and ad.HouseNumber = :selectedHouseNumber",
				Address.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStreetName", toDelete.getStreetName());
		typedQuery.setParameter("selectedOwnerName", toDelete.getOwnerName());
		typedQuery.setParameter("selectedzip", toDelete.getZip());
		typedQuery.setParameter("selectedHouseNumber", toDelete.getHouseNumber());

		
		
		//KEEP FINISHING THIS//
		
		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Address result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
}
