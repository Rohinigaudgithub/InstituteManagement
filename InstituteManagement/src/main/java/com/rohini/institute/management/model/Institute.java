package com.rohini.institute.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Institute {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(min=3, message = "Name should be minimum 3 characters")
	private String name;
	@NotBlank
	@Size(min=10,max=30, message = "Location should be minimum 10 characters & max 30 characters")
	private String location;
	@NotBlank
	@Size(min=10,max=30, message = "contactInfo should be minimum 10 characters & max 30 characters")
	private String contactInfo;
	@NotBlank
	@Size(max=10, message = "Website should be maximum 10 characters")
	private String website;
//	@NotNull(message = "Establishment year must not be null")
//    @Size(min = 4, max = 4, message = "Establishment year must be exactly 4 characters")
    private int establishmentYear;
	//getter and setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getEstablishmentYear() {
		return establishmentYear;
	}
	public void setEstablishmentYear(int establishmentYear) {
		this.establishmentYear = establishmentYear;
	}
	
}
