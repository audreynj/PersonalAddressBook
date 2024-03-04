package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Feb 27, 2024
 */

@Entity
@Table(name="contacts")
public class Contact {

	@Id
	@GeneratedValue
	private int contactID;
	
	private String ownerName;
	
	private String phoneNum;


	//Getter and Setters
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}





	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	//Constructors
	public Contact() {
		super();
		
	}
	
	public Contact(int contactID, String ownerName, String phoneNum) {
		super();
		this.contactID = contactID;
		this.ownerName = ownerName;
		this.phoneNum = phoneNum;
	}
	
	public Contact(String ownerName, String phoneNum) {
		super();
		this.ownerName = ownerName;
		this.phoneNum = phoneNum;
	}
	
	public Contact(String ownerName) {
		super();
		this.ownerName = ownerName;
	}
	
	
	
	@Override
	public String toString() {
		return "Owner: " + this.ownerName + " Phone Number: " + this.phoneNum;
	}
	
	
}
