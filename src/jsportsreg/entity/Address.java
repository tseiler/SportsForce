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
	private String addressCounty;

	/** The person tied to this address.
	 * 
	 */
	private Person person;

	/** General constructor creating an empty Address object.
	 * 
	 */
	public Address() {
		this.addressID = -1;
		this.addressStreet = "";
		this.addressCity = "";
		this.addressCounty = "";
		this.addressPostalCode = "";
		this.addressState = "";
		this.person = null;
	}

	/** Constructor to provide fully populated address
	 * @param addressID
	 * @param addressCity
	 * @param addressPostalCode
	 * @param addressState
	 * @param addressStreet
	 * @param addressCounty
	 * @param person
	 */
	public Address(int addressID, String addressStreet, String addressCity, String addressState, 
			String addressPostalCode, String addressCounty, Person person) {
		this.addressID = addressID;
		this.addressCity = addressCity;
		this.addressPostalCode = addressPostalCode;
		this.addressState = addressState;
		this.addressStreet = addressStreet;
		this.addressCounty = addressCounty;
		this.person = person;
	}

	/** Constructor to provide fully populated address without an ID.
	 * @param addressCity
	 * @param addressPostalCode
	 * @param addressState
	 * @param addressStreet
	 * @param addressCounty
	 * @param person
	 */
	protected Address(String addressStreet, String addressCity, String addressState, 
			String addressPostalCode, String addressCounty, Person person) {
		this.addressCity = addressCity;
		this.addressPostalCode = addressPostalCode;
		this.addressState = addressState;
		this.addressStreet = addressStreet;
		this.addressCounty = addressCounty;
		this.person = person;
		this.addressID = -1;
	}

	/** Returns the addressID, the primary key, of the of address in the database.
	 * @return addressID		The primary key of the address record.
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

	/** Returns the city associated with the address.
	 * @return addressCity 		The city the address is associated with.
	 */
	public String getAddressCity() {
		return this.addressCity;
	}

	/** Sets the city associated with the address.
	 * @param addressCity
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	/** Returns the zip or postal code associated with the address.
	 * @return addressPostalCode	String representing the zip or postal code.
	 */
	public String getAddressPostalCode() {
		return this.addressPostalCode;
	}

	/** Sets the zip or postal code associated with the address.
	 * @param addressPostalCode
	 */
	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	/** Returns the state associated with the address.
	 * @return addressState		The state associated with the address.
	 */
	public String getAddressState() {
		return this.addressState;
	}

	/** Sets the state associated with the address.
	 * @param addressState
	 */
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	/** Returns the street and number associated with the address.
	 * @return addressStreet	The number and street associated with the address.
	 */
	public String getAddressStreet() {
		return this.addressStreet;
	}

	/** Sets the street and number associated to the address.
	 * @param addressStreet
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/** Returns the county associated with the address.
	 * @return address
	 */
	public String getAddressCounty() {
		return this.addressCounty;
	}

	/** Sets the county associated with the address.
	 * @param adressCounty
	 */
	public void setAddressCounty(String adressCounty) {
		this.addressCounty = adressCounty;
	}

	/** Returns the person associated with the address.
	 * @return person		The person this address is associated to.
	 */
	public Person getPerson() {
		return this.person;
	}

	/** Sets the person associated with the address.
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}