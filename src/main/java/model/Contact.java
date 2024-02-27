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
	@Column(name="ID")
	private int ContactID;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="LNAME")
	private String lName;
	
	@Column(name="PHONENUM")
	private int PhoneNum;


	//Getter and Setters
	public int getContactID() {
		return ContactID;
	}
	public void setContactID(int contactID) {
		ContactID = contactID;
	}


	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}


	public int getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		PhoneNum = phoneNum;
	}

	//Constructors
	public Contact(int contactID, String fName, String lName, int phoneNum) {
		super();
		this.ContactID = contactID;
		this.fName = fName;
		this.lName = lName;
		this.PhoneNum = phoneNum;
	}
	
	public Contact() {
		super();
		
	}
	
	
	@Override
	public String toString() {
		return "Owner: " + this.fName + " " + this.lName + " Phone Number: " + this.PhoneNum;
	}
	
	
}
