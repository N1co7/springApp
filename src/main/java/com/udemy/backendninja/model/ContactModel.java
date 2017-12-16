package com.udemy.backendninja.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class ContactModel {

	private int id;
	@NotBlank
	@Size(min= 10, max= 30)
	private String firstName;
	@NotBlank
	@Size(min= 10, max= 30)
	private String lastName;
	@NotNull
	private String telephone;
	@NotBlank
	@Size(min= 10, max= 30)
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ContactModel(int id, String firstName, String lastName, String telephone, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.city = city;
	}

	public ContactModel() {
	}

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telephone="
				+ telephone + ", city=" + city + "]";
	}
	

}
