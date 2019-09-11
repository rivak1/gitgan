package com.metacube.metaparking.dao;

import javax.validation.constraints.NotBlank;

public class Employee {
	@NotBlank()
	private String name;
	
	@NotBlank(message = "{blackemail}" )
	private String email;
	
	@NotBlank(message = "{password}")
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String organisation;
	
	@NotBlank
	private String mobileNumber;
	
	
	public Employee() {
	}

	
	public Employee( String name, String email, String password,
			String confirmPassword, String gender, String organisation,
			String mobileNumber) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.gender = gender;
		this.organisation = organisation;
		this.mobileNumber = mobileNumber;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
