package jsportsreg;



/**
 * The persistent class for the Addresses database table.
 * 
 */

public class Address{
	private static final long serialVersionUID = 1L;


	private int addressID;


	private String addressCity;

	private String addressPostalCode;

	private String addressState;

	private String addressStreet;

	private String adressCounty;

	//bi-directional many-to-one association to People

	private People people;

	public Address() {
	}

	public int getAddressID() {
		return this.addressID;
	}

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

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}