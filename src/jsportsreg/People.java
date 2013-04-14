/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the People database table.
 * 
 */
public class People {

	private int personID;

	private Date birthDate;

	private String emailAddress;

	private String firstName;

	private String gender;

	private String homePhone;

	private String lastName;

	private String middleName;

	private String mobilePhone;

	private String nickName;

	private String role;

	private String suffixName;

	private String workPhone;

	//bi-directional many-to-one association to Address

	private List<Address> addresses;


	private List<People> peoples1;

	private List<People> peoples2;

	private List<Player_Registration> playerRegistrations;

	public People() {
	}

	public int getPersonID() {
		return this.personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSuffixName() {
		return this.suffixName;
	}

	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setPeople(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setPeople(null);

		return address;
	}

	public List<People> getPeoples1() {
		return this.peoples1;
	}

	public void setPeoples1(List<People> peoples1) {
		this.peoples1 = peoples1;
	}

	public List<People> getPeoples2() {
		return this.peoples2;
	}

	public void setPeoples2(List<People> peoples2) {
		this.peoples2 = peoples2;
	}

	public List<Player_Registration> getPlayerRegistrations() {
		return this.playerRegistrations;
	}

	public void setPlayerRegistrations(List<Player_Registration> playerRegistrations) {
		this.playerRegistrations = playerRegistrations;
	}

	public Player_Registration addPlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().add(playerRegistration);
		playerRegistration.setPeople(this);

		return playerRegistration;
	}

	public Player_Registration removePlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().remove(playerRegistration);
		playerRegistration.setPeople(null);

		return playerRegistration;
	}

}