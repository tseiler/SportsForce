/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */


package jsportsreg.entity;


/** Address Class for different address tied to people.
 * @author tseiler
 *
 */
public class Address{

	/** The primary key tied to a specific address.
	 * 
	 */
	private int addressID;
	
	/** The city tied to the address.
	 * 
	 */
	private String addressCity;
	/** The postal or zip code tied to the address.
	 * 
	 */
	private String addressPostalCode;

	/** The state associated with the address.
	 * 
	 */
	private String addressState;

	/** The street specification associated with the address.
	 * 
	 */
	private String addressStreet;

	/** The county associated with the address.
	 * 
	 */
	private String adressCounty;

	/** The person tied to this address.
	 * 
	 */
	private Person person;

	/** General constructor creating an empty Address object.
	 * 
	 */
	public Address() {
	}

	/** Returns the addressID, the primary key, of the of address in the database.
	 * @return
	 */
	public int getAddressID() {
		return this.addressID;
	}

	/** Sets the addressID, the primary key, of the address in the database.
	 * @param addressID
	 */
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressPostalCode() {
		return this.addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	public String getAddressState() {
		return this.addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressStreet() {
		return this.addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAdressCounty() {
		return this.adressCounty;
	}

	public void setAdressCounty(String adressCounty) {
		this.adressCounty = adressCounty;
	}

	public Person getPeople() {
		return this.people;
	}

	public void setPeople(Person people) {
		this.people = people;
	}

}