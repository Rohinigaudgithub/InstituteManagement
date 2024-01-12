package com.rohini.institute.management.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InstituteUpdateDTO {
	@NotBlank
    @Size(min=3, message = "Name should be minimum 3 characters")
    private String name;

    @NotBlank
    @Size(min=10, max=30, message = "Location should be minimum 10 characters & max 30 characters")
    private String location;

    @NotBlank
    @Size(min=10, max=30, message = "ContactInfo should be minimum 10 characters & max 30 characters")
    private String contactInfo;

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
    
}
