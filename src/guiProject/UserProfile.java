package guiProject;

import java.io.Serializable;

public class UserProfile implements Serializable {

	/**
	 * SerialID for saving
	 */
	private static final long serialVersionUID = -538587548626851691L;
	
	private String firstName;
	private String lastName;
	private String adress;
	private String postalCode;
	private String phone;
	private String email; 
	private CreditCard creditCard;
	private String paymentOption;
	private String username;
	private String password;
	private String town;
	
	public UserProfile(String username, String password){
		this.username = username;
		this.setPassword(password);

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the email
	 */
	public CreditCard getCard() {
		return creditCard;
	}

	/**
	 * @param email the email to set
	 */
	public void setCard(CreditCard card) {
		this.creditCard = card;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the paymentOption
	 */
	public String getPaymentOption() {
		return paymentOption;
	}

	/**
	 * @param paymentOption the paymentOption to set
	 */
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

}
