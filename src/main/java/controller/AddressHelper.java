package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;




/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Feb 27, 2024
 */
public class AddressHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertAddress(Address ad) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ad);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Address> showAllAddresses(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddresses = em.createQuery("SELECT i FROM Address i").getResultList();
		
		return allAddresses;
	}
	
	
	public void deleteAddress(Address toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery(
				"select ad from Address ad where"
				+ " ad.streetName = :selectedStreetName"
				+ " and ad.zip = :selectedZip"
				+ " and ad.houseNumber = :selectedHouseNumber",
				Address.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStreetName", toDelete.getStreetName());
		typedQuery.setParameter("selectedZip", toDelete.getZip());
		typedQuery.setParameter("selectedHouseNumber", toDelete.getHouseNumber());

		
		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Address result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Address searchForAddressById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return found;
	}

	public void updateAddress(Address toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Address> searchForAddressByStreetName(String streetName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select ad from Address ad where ad.StreetName = :selectedStreetName", Address.class);
		typedQuery.setParameter("selectedStreetName", streetName);

		List<Address> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	
	public List<Address> searchForAddressByZip(String zip) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select ad from Address ad where ad.Zip = :selectedZip", Address.class);
		typedQuery.setParameter("selectedZip", zip);

		List<Address> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Address> searchForAddressByHouseNumber(String houseNumber) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address> typedQuery = em.createQuery("select ad from Address ad where ad.HouseNumber = :selectedHouseNumber", Address.class);
		typedQuery.setParameter("selectedHouseNumber", houseNumber);


		List<Address> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
	
}
