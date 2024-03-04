package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Contact;


/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Mar 1, 2024
 */
public class ContactHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");

	public void insertContact(Contact c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contact> showAllShoppers(){
		EntityManager em = emfactory.createEntityManager();
		List<Contact> allContacts = em.createQuery("SELECT c from Contact c").getResultList();
		return allContacts;
	}
	
	public Contact findContact(String ownerToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("select co from Contact co where co.ownerName = :selectedOwnerName",Contact.class);
		typedQuery.setParameter("selectedOwnerName", ownerToLookUp);
		typedQuery.setMaxResults(1);
		Contact foundContact;
		try {
			foundContact = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundContact = new Contact(ownerToLookUp);
		}
		em.close();

		return foundContact;
	}
}
