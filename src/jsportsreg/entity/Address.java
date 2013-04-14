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

	/** Returns the city associated with the address.
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
	 */
	public String getAdressCounty() {
		return this.adressCounty;
	}

	/** Sets the county associated with the address.
	 * @param adressCounty
	 */
	public void setAdressCounty(String adressCounty) {
		this.adressCounty = adressCounty;
	}

	/** Returns the person associated with the address.
	 * @return
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