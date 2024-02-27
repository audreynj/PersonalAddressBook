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
	private int AddressID;
	
	@Column(name="STREETNAME")
	private String StreetName;
	
	@Column(name="OWNERNAME")
	private String OwnerName;
	
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="HOUSENUMBER")
	private String HouseNumber;


	//Getters and Setters
	public int getAddressID() {
		return AddressID;
	}
	public void setAddressID(int addressID) {
		AddressID = addressID;
	}


	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}


	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}


	public String getZip() {
		return zip;
	}	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHouseNumber() {
		return HouseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		HouseNumber = houseNumber;
	}

	//Constructor
	public Address() {
		super();
	}
	
	public Address(String streetName, String ownerName, String zip, String houseNumber) {
		super();
		this.StreetName = streetName;
		this.OwnerName = ownerName;
		this.zip = zip;
		this.HouseNumber = houseNumber;
	}
	
	
	public String returnAddressDetails() {
		return this.HouseNumber + " "+  this.StreetName + ": " + this.zip + " Owner: " + this.OwnerName;
	}
	
	
}
