package com.rb.payload;

/**
 * This class represents the User entity that is used as the payload for various
 * API operations such as creating, updating, and retrieving user details. It
 * contains user-related fields, along with their respective getters and
 * setters.
 */
public class User {

	String[] occupationArr = new String[] { "Doctor", "Student", "Engineer", "Scientist" };

	// Fields representing the user's properties
	private String firstName; // First name of the user
	private String lastName; // Last name of the user
	private String email; // Email address of the user
	private String phone; // Contact number of the user
	private String occupation; // Occupation of the user
	private String password; // Password of the user

	/**
	 * Gets the first name of the user.
	 * 
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 * 
	 * @param firstName The user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the user.
	 * 
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 * 
	 * @param lastName The user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email address of the user.
	 * 
	 * @return The user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 * 
	 * @param email The user's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password of the user.
	 * 
	 * @return The user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 * 
	 * @param password The user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the phone number of the user.
	 * 
	 * @return The user's phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone number of the user.
	 * 
	 * @param phone The user's phone number
	 */
	public String setPhone(long phone) {
		return this.phone = Long.toString(phone);
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(int index) {
		this.occupation = occupationArr[index];
	}
}