package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Feb 27, 2024
 */

@Entity
public class AddressDetails {
	@Id
	@GeneratedValue
	private int id;
	
	private String addressBook;
	private LocalDate printDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Contact contact;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Address> listOfAddresses;
	
	
	//Constructors
	public AddressDetails() {
		super();
	}

	public AddressDetails(int id, String addressBook, LocalDate printDate, Contact contact,
			List<Address> listOfAddresses) {
		super();
		this.id = id;
		this.addressBook = addressBook;
		this.printDate = printDate;
		this.contact = contact;
		this.listOfAddresses = listOfAddresses;
	}

	
	public AddressDetails(String addressBook, LocalDate printDate, Contact contact, List<Address> listOfAddresses) {
		super();
		this.addressBook = addressBook;
		this.printDate = printDate;
		this.contact = contact;
		this.listOfAddresses = listOfAddresses;
	}


	public AddressDetails(String addressBook, LocalDate printDate, Contact contact) {
		super();
		this.addressBook = addressBook;
		this.printDate = printDate;
		this.contact = contact;
	}


	//Getter and Setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(String addressBook) {
		this.addressBook = addressBook;
	}


	public LocalDate getPrintDate() {
		return printDate;
	}
	public void setPrintDate(LocalDate printDate) {
		this.printDate = printDate;
	}


	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	
	@Override
	public String toString() {
		String msgFirstHalf = "Contact [id=" + id +
				", AddressBook=" + addressBook +
				", PrintDate=" + printDate +
				", " + contact;
		
		return msgFirstHalf + ", " + listOfAddresses + "]";
	}
	
	
	
}
