package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Feb 19, 2024
 */
@Entity
@Table(name="addresses")

public class Address {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int addressID;
	
	@Column(name="STREETNAME")
	private String streetName;
	
	
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="HOUSENUMBER")
	private String houseNumber;


	//Getters and Setters
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}


	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getZip() {
		return zip;
	}	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	//Constructor
	public Address() {
		super();
	}
	
	public Address(String streetName, String zip, String houseNumber) {
		super();
		this.streetName = streetName;
		this.zip = zip;
		this.houseNumber = houseNumber;
	}
	
	
	public String returnAddressDetails() {
		return this.houseNumber + " "+  this.streetName + ": " + this.zip;
	}
	
	
}
