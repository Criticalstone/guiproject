package guiProject;

import java.io.Serializable;

/**
 * 
 * @author Anton
 *
 */
public class CreditCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3577667414961236488L;
	
	private String cardType;
	private String cardNo;
	private String cardHolder;
	private String expiryYear;
	private String expiryMonth;
	private String cvc;

	public CreditCard(String cardType, String cardNo, String cardHolder, String expiryYear, String expiryMonth, String cvc){
		setCardHolder(cardHolder);
		setCardNo(cardNo);
		setCardType(cardType);
		setCvc(cvc);
		setExpiryMonth(expiryMonth);
		setExpiryYear(expiryYear);
	}

	/**
	 * @return the cvc
	 */
	public String getCvc() {
		return cvc;
	}

	/**
	 * @param cvc the cvc to set
	 */
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	/**
	 * @return the expiryMonth
	 */
	public String getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * @param expiryMonth the expiryMonth to set
	 */
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	/**
	 * @return the expiryYear
	 */
	public String getExpiryYear() {
		return expiryYear;
	}

	/**
	 * @param expiryYear the expiryYear to set
	 */
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	/**
	 * @return the cardHolder
	 */
	public String getCardHolder() {
		return cardHolder;
	}

	/**
	 * @param cardHolder the cardHolder to set
	 */
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getCardType(){
		return cardType;
	}
	
	public void setCardType(String cardType){
		this.cardType = cardType;
	}
}
