/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 * The class for People database table. This will match all of the fields
 * in the SportsForce people table, single instance being a person.  
 * 
 */
public class Person {

	/** 
	 * Primary key for the Person entity.
	 */
	private int personID;

	/**
	 *	Birthdate of the Person entity. 
	 */
	private Date birthDate;

	/**
	 * Email Address of the Person entity.
	 */
	private String emailAddress;

	/**
	 * First Name of the Person entity.
	 */
	private String firstName;
	
	/**
	 * Gender of the Person entity.
	 */
	private String gender;

	/**
	 * Home phone number of the Person entity.
	 */
	private String homePhone;

	/**
	 * Last name of the Person entity. 
	 */
	private String lastName;

	/**
	 * Middle name of the Person entity.
	 */
	private String middleName;

	/**
	 * Mobile phone number of the Person entity.
	 */
	private String mobilePhone;

	/**
	 * Nick name of the Person entity.
	 */
	private String nickName;

	/**
	 * Role of the Person entity.  Person/Guardian, Player, Coach, etc.
	 */
	private String role;

	/**
	 * Suffix component of the name of the Person entity. 
	 */
	private String suffixName;

	/**
	 * Work phone number of the Person entity.
	 */
	private String workPhone;

	/**
	 * List of all Addresses associated with the Person entity.
	 */
	private List<Address> addresses;

	/**
	 * List of all Emergency Contacts associated with the Person entity. 
	 */
	private List<Person> emergencyContacts;

	/**
	 * List of all Player Registrations associated with the Person Entity. 
	 * This denotes all the Seasons and Divisions a Person has participated.
	 */
	private List<Player_Registration> playerRegistrations;

	/**
	 * Empty Person constructor to create blank object.
	 */
	public Person() {
		this.personID = -1;
		this.firstName = "";
		this.lastName = "";
		this.middleName = "";
		this.nickName = "";
		this.suffixName = "";
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		try{
			this.birthDate = df.parse("01-01-1900");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.emailAddress = "";
		this.gender = "";
		this.role = "";
		this.homePhone = "";
		this.workPhone = "";
		this.mobilePhone = "";
		this.addresses = new ArrayList<Address>();
		this.emergencyContacts = new ArrayList<Person>();
		this.playerRegistrations = new ArrayList<Player_Registration>();
	}
	
	/***
	 * Person constructor to create a Person object fully populated.  Will be called
	 * from Database helper entity with all data.
	 * 
	 * @param personID
	 * @param birthDate
	 * @param emailAddress
	 * @param firstName
	 * @param gender
	 * @param homePhone
	 * @param lastName
	 * @param middleName
	 * @param mobilePhone
	 * @param nickName
	 * @param role
	 * @param suffixName
	 * @param workPhone
	 * @param addresses
	 * @param emergencyContacts
	 * @param playerRegistrations
	 */
	public Person(int personID, Date birthDate, String emailAddress,
			String firstName, String gender, String homePhone, String lastName,
			String middleName, String mobilePhone, String nickName,
			String role, String suffixName, String workPhone,
			List<Address> addresses, List<Person> emergencyContacts,
			List<Player_Registration> playerRegistrations) {
		this.personID = personID;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.gender = gender;
		this.homePhone = homePhone;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobilePhone = mobilePhone;
		this.nickName = nickName;
		this.role = role;
		this.suffixName = suffixName;
		this.workPhone = workPhone;
		this.addresses = addresses;
		this.emergencyContacts = emergencyContacts;
		this.playerRegistrations = playerRegistrations;
	}



	/**
	 * Returns the personID of the Person entity object.
	 * @return personID		The primary key of the Person entity.
	 */
	public int getPersonID() {
		return this.personID;
	}

	/**
	 * Sets the personID of the Person entity object.
	 * @param personID		The primary key of the Person entity.
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	/**
	 * Returns the Birth Date of the Person entity object.
	 * @return birthDate	The birth date of the Person entity.
	 */
	public Date getBirthDate() {
		return this.birthDate;
	}

	/**
	 * Sets the Birth Date of the Person entity object.
	 * @param birthDate		The birth data of the Person entity. 
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Returns the Email Address of the Person entity object.
	 * @return emailAddress		The email address of the Person entity.
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * Sets the Email Address of the Person entity object.
	 * @param emailAddress		The email address of the Person entity.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Returns the First Name of the Person entity object.
	 * @return		The first name of the Person entity.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets the First Name of the Person entity object.
	 * @param 		The first name of the Person entity.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the Gender of the Person entity object.
	 * @return 		The gender of the Person entity.
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Sets the Gender of the Person entity object.
	 * @param gender		The gender of the Person entity.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns the Home Phone Number of the Person entity object.
	 * @return homePhone 		The home phone number of the Person entity.
	 */
	public String getHomePhone() {
		return this.homePhone;
	}

	/**
	 * Sets the Home Phone Number of the Person entity object.
	 * @param homePhone		The home phone number of the Person entity.
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * Returns the Last Name of the Person entity object.
	 * @return lastName			The last name of the Person entity.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets the Last Name of the Person entity object.
	 * @param last Name			The last name of the Person entity.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the Middle Name of the Person entity object.
	 * @return middleName		The middle name of the Person entity.
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * Sets the Middle Name of the Person entity object.
	 * @param middleName		The middle name of the Person entity.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Returns the Mobile Phone Number of the Person entity object.
	 * @return mobilePhone		The mobile phone number of the Person entity.
	 */
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	/**
	 * Sets the Mobile Phone Number of the Person entity object.
	 * @param mobilePhone		The mobile phone number of the Person entity.
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * Returns the Nick Name of the Person entity object.
	 * @return nickName			The nick name of the Person entity.
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * Sets the Nick Name of the Person entity object.
	 * @param nickName 			The nick name of the Person entity.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Returns the Role of the Person entity object.
	 * @return role				The role of the Person entity.
	 */
	public String getRole() {
		return this.role;
	}
	
	/**
	 * Sets the Role of the Person entity object.
	 * @param role				The role of the Person entity.
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Returns the Suffix portion of the name of the Person entity object.
	 * @return suffixName		The suffix of the Person entity's name.
	 */
	public String getSuffixName() {
		return this.suffixName;
	}
	
	/**
	 * Sets the Suffix portion of the name of the Person entity object.
	 * @param suffixName		The suffix of the Person entity's name.
	 */
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	/**
	 * Returns the Work Phone Number of the Person entity object.
	 * @return workPhone		The work phone number of the Person entity.
	 */
	public String getWorkPhone() {
		return this.workPhone;
	}

	/**
	 * Sets the Work Phone Number of the Person entity object.
	 * @param workPhone			The work phone number of the Person entity.
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * Returns a list of the Addresses associated with the Person entity object.
	 * @return addresses		The list of addresses associated with the Person entity.
	 */
	public List<Address> getAddresses() {
		return this.addresses;
	}

	/**
	 * Sets a list of the Addresses associated with Person entity object.
	 * @param addresses			The list of addresses associated with the Person entity.
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Adds an Address to the list of Addresses associated with the Person entity object.
	 * @param address			The address to be added to the list of addresses.
	 */
	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setPerson(this);

		return address;
	}

	/**
	 * Removes an Address from the list of Address associated with the Person entity object.
	 * @param address			The address to be removed from the list of addresses.
	 */
	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setPerson(null);

		return address;
	}

	/**
	 * Returns a list of People associated as Emergency Contacts.  This is a list of Person objects.
	 * @return emergencyContacts	A list of Person objects.
	 */
	public List<Person> getEmergencyContacts() {
		return this.emergencyContacts;
	}

	/**
	 * Sets a list of People associated as Emergency Contacts.  This is a list of Person objects.
	 * @param emergencyContacts		A list of Person objects.
	 */
	public void setEmergencyContacts(List<Person> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}
	
	/** Adds an Emergency Contact to the list.
	 * @param person		A person to add to the Emergency Contacts list.
	 */
	public void addEmergencyContact(Person person){
		this.emergencyContacts.add(person);
	}
	

	/**
	 * Returns a list Player_Registration objects associated with the Person.  These denote all Seasons and
	 * Divisions the person has participated in.
	 * @return playerRegistrations	A list of Player Registration objects.
	 */
	public List<Player_Registration> getPlayerRegistrations() {
		return this.playerRegistrations;
	}

	/**
	 * Sets a list of Player_Registration objects associated with the Person. 
	 * @param playerRegistrations	A list of Player Registration objects.
	 */
	public void setPlayerRegistrations(List<Player_Registration> playerRegistrations) {
		this.playerRegistrations = playerRegistrations;
	}

	/**
	 * Adds a Player_Registration object to the associated Person.
	 * @param playerRegistration	A Player Registration object.
	 */
	public Player_Registration addPlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().add(playerRegistration);
		playerRegistration.setPerson(this);

		return playerRegistration;
	}

	/**
	 * Removes a Player_Registration object from the associated Person.
	 * @param playerRegistration	A Player Registration object to be removed from the list. 
	 */
	public Player_Registration removePlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().remove(playerRegistration);
		playerRegistration.setPerson(null);

		return playerRegistration;
	}

}