/**
 * 
 */
package jsportsreg.helper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import jsportsreg.entity.*;

/** This class is designed to handle all updates to the all member objects that are associated with a Player Registration.  This class
 * only takes the registration ID and will pull all corresponding data.  This class should only be used as a bean when pre-populating a 
 * registration form, otherwise the Registration Controller should send a new Player_Registration object. 
 * @author tseiler
 *
 */
public class RegistrationDBHelper {
	
	private String JDBC_URL = "jdbc:mysql://xlf.cqqc3wlbhkub.us-east-1.rds.amazonaws.com/sports_force";

	private PreparedStatement authPlayerRegistrationStatement;
	
	private PreparedStatement updatePlayerRegistrationStatement;
	private PreparedStatement updatePersonStatement;
	
	private PreparedStatement addPersonStatement;
	private PreparedStatement addPlayerRegistrationStatement;
	private PreparedStatement addPersonAddressStatement;
	private PreparedStatement addEmergency_ContactStatement;
	
	private PreparedStatement getPersonStatement;
	private PreparedStatement getPlayerRegistrationStatement;
	private PreparedStatement getEmergencyContactsStatement;
	private PreparedStatement getAddressesStatement;
	
	private PreparedStatement delPersonStatement;
	private PreparedStatement delPlayerRegistrationStatement;
	private PreparedStatement delPersonAddressStatement;
	private PreparedStatement delEmergency_ContactStatement;
	
	private PreparedStatement getDivisionStatement;
	private PreparedStatement getDivisionsStatement;
	private PreparedStatement getSportStatement;
	private PreparedStatement getSeasonStatement;
	
	private int registrationID;
	private String passPhrase;
	private Player_Registration player_registration;
	
	/**
	 * 
	 */
	public RegistrationDBHelper() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,
					"mist7570", "GoDAWGS2013");
			System.out.println("Connected to sports_force database");
			
			this.authPlayerRegistrationStatement = conn.prepareStatement("SELECT registrationID FROM Player_Registration " +
					"WHERE registrationID = ? AND pass_phrase = SHA1(?)" );
			
			this.addPlayerRegistrationStatement = conn.prepareStatement("INSERT INTO sports_force.Player_Registration" + 
					"( divisionID, personID, additional_position, code_of_conduct, primary_position, secondary_position, balance," +
					"base_fee, pitching_experience, catching_experience, catching_gear, by_laws_agreement, donation, " +
					"fundraising_fee, late_fee, out_of_county_fee, discount, hat_size, jersey_1, jersey_2, jersey_size, pant_size," +
					"liability_waiver, photo_waiver, refund_amount, refund_policy, seasons_played, total_fees, socks_size," +
					"uniform_camp_fee, pass_phrase)" +
					"VALUES" + 
					"(  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SHA1(?) )", 
					PreparedStatement.RETURN_GENERATED_KEYS );
			
			this.updatePlayerRegistrationStatement = conn.prepareStatement("UPDATE sports_force.Player_Registration " + 
					"SET divisionID = ?, personID = ?, additional_position = ?, code_of_conduct = ?, primary_position= ?, " +
					"secondary_position = ?, balance = ?, base_fee = ?, pitching_experience = ?, catching_experience = ?, " +
					"catching_gear = ?, by_laws_agreement = ?, donation = ?, fundraising_fee = ?, late_fee = ?, " +
					"out_of_county_fee = ?, discount = ?, hat_size = ?, jersey_1 = ?, jersey_2 = ?, jersey_size = ?, " +
					"pant_size = ?, liability_waiver = ?, photo_waiver = ?, refund_amount = ?, refund_policy = ?, " +
					"seasons_played = ?, total_fees = ?, socks_size = ?, uniform_camp_fee = ?, pass_phrase = SHA1(?) " +
					"WHERE registrationID = ?");
			
			this.delPlayerRegistrationStatement = conn.prepareStatement("DELETE FROM Player_Registration " + 
					"WHERE registrationID = ? AND pass_phrase = SHA1(?)");
			
			this.getPlayerRegistrationStatement = conn.prepareStatement("SELECT  " + 
					"divisionID, personID, additional_position, code_of_conduct, primary_position, " +
					"secondary_position, balance, base_fee, pitching_experience, catching_experience, " +
					"catching_gear, by_laws_agreement, donation, fundraising_fee, late_fee, " +
					"out_of_county_fee, discount, hat_size, jersey_1, jersey_2, jersey_size, " +
					"pant_size, liability_waiver, photo_waiver, refund_amount, refund_policy, " +
					"seasons_played, total_fees, socks_size, uniform_camp_fee FROM Player_Registration " +
					"WHERE registrationID = ? AND pass_phrase = SHA1(?)");
			
			this.addPersonStatement = conn.prepareStatement("INSERT INTO People " +
					"( first_name, middle_name, last_name, email_address, home_phone, birth_date, " + 
					"role, gender, work_phone, mobile_phone, nick_name, suffix_name )" +
					" VALUES " +
					"( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", PreparedStatement.RETURN_GENERATED_KEYS );
			
			this.updatePersonStatement = conn.prepareStatement("UPDATE People " +
					" SET first_name = ?, middle_name = ?, last_name = ?, email_address = ?, home_phone = ?, " +
					"birth_date = ?, role = ?, gender = ?, work_phone = ?, mobile_phone = ?, nick_name = ?, " +
					"suffix_name = ? " +
					" WHERE personID = ?" );
			
			this.delPersonStatement = conn.prepareStatement("DELETE FROM People " +
					"WHERE personID = ?");
			
			this.getPersonStatement = conn.prepareStatement("SELECT " +
					"first_name, middle_name, last_name, email_address, home_phone, birth_date, " + 
					"role, gender, work_phone, mobile_phone, nick_name, suffix_name FROM People" +
					" WHERE personID = ?");
			
			this.addEmergency_ContactStatement = conn.prepareStatement("INSERT INTO Emergency_Contacts " +
					"(personID, contactID) VALUES ( ?, ? )");
			
			this.delEmergency_ContactStatement = conn.prepareStatement("DELETE FROM Emergency_Contacts " +
					"WHERE personID = ?" );
			
			this.getEmergencyContactsStatement = conn.prepareStatement("SELECT contactID FROM Emergency_Contacts " +
					"WHERE personID = ?");
			
			this.addPersonAddressStatement = conn.prepareStatement("INSERT INTO Addresses " +
					"(address_street, address_city, address_state, address_county, address_postal_code, " +
					" personID) VALUES ( ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS );
			
			this.getAddressesStatement = conn.prepareStatement("SELECT address_street, address_city, " +
					"address_state, address_county, address_postal_code, personID, addressID " +
					"FROM Addresses WHERE personID = ?");
			
			this.delPersonAddressStatement = conn.prepareStatement("DELETE FROM Addresses " +
					"WHERE personID = ?" );
			
			
			
			this.getDivisionStatement = conn.prepareStatement( "SELECT divisionID, division_name, division_description, " +
					"sportID, seasonID FROM Divisions WHERE divisionID = ?" );
			this.getDivisionsStatement = conn.prepareStatement( "SELECT divisionID, division_name, division_description, " +
					"sportID, seasonID FROM Divisions" );
			this.getSportStatement = conn.prepareStatement( "SELECT sportID, sport_name, sport_description FROM Sports " +
					"WHERE sportID = ? ");
			this.getSeasonStatement = conn.prepareStatement( "SELECT seasonID, seasonName, seasonStartDate, seasonEndDate " +
					"FROM Season WHERE seasonID = ?" );
			
			this.registrationID = -1;
			this.passPhrase = "";
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
		this.player_registration = new Player_Registration();

		
		
	}
	
	/** Adds a person to the database and populates the Person object with the updated primary key field.
	 * @param person		Person object.
	 */ 
	private void addPerson(Person person){
	
		try{
			this.addPersonStatement.setString( 1, person.getFirstName() );
			this.addPersonStatement.setString( 2, person.getMiddleName() );
			this.addPersonStatement.setString( 3, person.getLastName() );
			this.addPersonStatement.setString( 4, person.getEmailAddress() );
			this.addPersonStatement.setString( 5, person.getHomePhone() );
			this.addPersonStatement.setDate( 6, new java.sql.Date(person.getBirthDate().getTime()) );
			this.addPersonStatement.setString( 7, person.getRole() );
			this.addPersonStatement.setString( 8, person.getGender() );
			this.addPersonStatement.setString( 9, person.getWorkPhone() );
			this.addPersonStatement.setString( 10, person.getMobilePhone() );
			this.addPersonStatement.setString( 11, person.getNickName() );
			this.addPersonStatement.setString( 12, person.getSuffixName() );
			
			this.addPersonStatement.executeUpdate();
			
			ResultSet rs = this.addPersonStatement.getGeneratedKeys();
			rs.next();
			person.setPersonID( rs.getInt(1) );
			
		}catch(Exception ex){ 
			ex.printStackTrace();
		}
		
	}

	/**
	 * Updates a person in the database.
	 * 
	 */
	private void updatePerson(Person person){
		try{
			this.updatePersonStatement.setString( 1, person.getFirstName() );
			this.updatePersonStatement.setString( 2, person.getMiddleName() );
			this.updatePersonStatement.setString( 3, person.getLastName() );
			this.updatePersonStatement.setString( 4, person.getEmailAddress() );
			this.updatePersonStatement.setString( 5, person.getHomePhone() );
			this.updatePersonStatement.setDate( 6, new java.sql.Date(person.getBirthDate().getTime()) );
			this.updatePersonStatement.setString( 7, person.getRole() );
			this.updatePersonStatement.setString( 8, person.getGender() );
			this.updatePersonStatement.setString( 9, person.getWorkPhone() );
			this.updatePersonStatement.setString( 10, person.getMobilePhone() );
			this.updatePersonStatement.setString( 11, person.getNickName() );
			this.updatePersonStatement.setString( 12, person.getSuffixName() );
			
			this.updatePersonStatement.setInt(13, person.getPersonID() );
			
			this.updatePersonStatement.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/** Retrieves the person from the database that is associated with the Player Registration. Uses the registrationID to look up the Person.
	 * @return
	 */
	
	
	
	private Person getPerson(int personID){
		Person person = new Person();

		try{
			this.getPersonStatement.setInt(1, personID);
			this.getPersonStatement.execute();
			ResultSet rs = this.getPersonStatement.getResultSet();
			if( rs.next() ){
				
				person.setPersonID(personID);
				person.setFirstName(rs.getString(1));
				person.setMiddleName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setEmailAddress(rs.getString(4));
				person.setHomePhone(rs.getString(5));
				person.setBirthDate(rs.getDate(6));
				person.setRole(rs.getString(7));
				person.setGender(rs.getString(8));
				person.setWorkPhone(rs.getString(9));
				person.setMobilePhone(rs.getString(10));
				person.setNickName(rs.getString(11));
				person.setSuffixName(rs.getString(12));
		
				/*
				 * Set Addresses to the person
				 */
				person.setAddresses(this.getAddresses(personID));
				
				/*
				 * Create list of Emergency Contacts;
				 */
				
				person.setEmergencyContacts(this.getEmergency_Contacts(personID));
				
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		
		return person;
	}
	
	/** Retrieves all addresses corresponding to the person associated with the player registration.  Utilizes the registration ID field.
	 *  Used to populated the Person and Player_Registration objects.
	 * @return
	 */
	private ArrayList<Address> getAddresses(int personID){
		ArrayList<Address> addresses = new ArrayList<Address>();
		
		try{
			this.getAddressesStatement.setInt(1, personID);
			this.getAddressesStatement.execute();
			
			ResultSet rs = this.getAddressesStatement.getResultSet();
			
			while(rs.next()){
				Address a0 = new Address();
				a0.setAddressStreet(rs.getString(1));
				a0.setAddressCity(rs.getString(2));
				a0.setAddressState(rs.getString(3));
				a0.setAddressCounty(rs.getString(4));
				a0.setAddressPostalCode(rs.getString(5));
				a0.setAddressID(rs.getInt(6));
				addresses.add(a0);
			}
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return addresses;
	}
	
	/** Updates all of the addresses corresponding to a specific person (based on the registration ID), by deleting all of the records and
	 * adding the new list back in.
	 * @param addresses		List of addresses to update.
	 * @return
	 * 
	 */
	private void updateAddresses( List<Address> addresses){
		
		try{
			this.delPersonAddressStatement.setInt(1, player_registration.getPerson().getPersonID() );
			this.delPersonAddressStatement.executeUpdate();
			this.addPersonAddressStatement.setInt(6, player_registration.getPerson().getPersonID() );
			for( Address a0 : addresses ){
				this.addPersonAddressStatement.setString(1, a0.getAddressStreet() );
				this.addPersonAddressStatement.setString(2, a0.getAddressCity() );
				this.addPersonAddressStatement.setString(3, a0.getAddressState() );
				this.addPersonAddressStatement.setString(4, a0.getAddressCounty() );
				this.addPersonAddressStatement.setString(5, a0.getAddressPostalCode() );
				this.addPersonAddressStatement.executeUpdate();
				
				ResultSet rs = this.addPersonAddressStatement.getGeneratedKeys();
				rs.next();
				a0.setAddressID( rs.getInt(1) );
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	/** Retrieves a list of people that are associated with a person as emergency contacts.  Because these are emergency contacts for a 
	 * specific person, not all fields are populated.  It utilizes the registrationID to find the parent relationship (Person). 
	 * @return
	 */
	private ArrayList<Person> getEmergency_Contacts(int personID){
		ArrayList<Person> emergencyContacts = new ArrayList<Person>();
		
		try{
			Person person = new Person();
			this.getEmergencyContactsStatement.setInt(1, personID);
			this.getEmergencyContactsStatement.execute();
			ResultSet rs0 = this.getPersonStatement.getResultSet();
			if( rs0.next() ){
				
				this.getPersonStatement.setInt(1, rs0.getInt(1));
				this.getPersonStatement.execute();
				
				ResultSet rs1 = this.getPersonStatement.getResultSet();
				
				if( rs1.next() ){
					person.setFirstName(rs1.getString(1));
					person.setMiddleName(rs1.getString(2));
					person.setLastName(rs1.getString(3));
					person.setEmailAddress(rs1.getString(4));
					person.setHomePhone(rs1.getString(5));
					person.setBirthDate(rs1.getDate(6));
					person.setRole(rs1.getString(7));
					person.setGender(rs1.getString(8));
					person.setWorkPhone(rs1.getString(9));
					person.setMobilePhone(rs1.getString(10));
					person.setNickName(rs1.getString(11));
					person.setSuffixName(rs1.getString(12));
				}
				emergencyContacts.add(person);
			}
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return emergencyContacts;
	}
	
	/** Updates all of the emergency contacts associated with a person (based on the registration ID), by deleting all of the records and then 
	 * adding them back into the database.
	 * @param emergencyContacts		List of People (Person) to be updated.
	 */
	private void updateEmergencyContacts( List<Person> emergencyContacts ){
		
		try{
			this.delEmergency_ContactStatement.setInt( 1, this.player_registration.getPerson().getPersonID() );
			this.delEmergency_ContactStatement.executeUpdate();
			this.addEmergency_ContactStatement.setInt( 1, this.player_registration.getPerson().getPersonID() );
			
			for( Person p0 : emergencyContacts ){
				this.updatePerson(p0);
				this.addEmergency_ContactStatement.setInt(2, p0.getPersonID() );
				this.addEmergency_ContactStatement.executeUpdate();
			}
		}catch( Exception ex ){
			ex.printStackTrace();
		}
	}
	
	private void updatePlayer_Registration(){
		try{
			
			/* Update the person associated with the player registration
			 * 
			 */
			this.updatePerson( this.player_registration.getPerson() );
			
			
			/*
			 * Create all of the emergency contact references for each person.
			 */
			this.updateEmergencyContacts( this.player_registration.getPerson().getEmergencyContacts() );
			
			/*
			 * Create all of the addresses that are related to the player.
			 */
			this.updateAddresses( this.player_registration.getPerson().getAddresses() );
			
			
			this.updatePlayerRegistrationStatement.setInt( 1, this.player_registration.getDivision().getDivisionID() );
			this.updatePlayerRegistrationStatement.setInt( 2, this.player_registration.getPerson().getPersonID() );
			this.updatePlayerRegistrationStatement.setString(3, this.player_registration.getAdditionalPosition() );
			this.updatePlayerRegistrationStatement.setBoolean(4, this.player_registration.getCodeOfConduct() );
			this.updatePlayerRegistrationStatement.setString(5, this.player_registration.getPrimaryPosition() );
			this.updatePlayerRegistrationStatement.setString(6, this.player_registration.getSecondaryPosition() );
			this.updatePlayerRegistrationStatement.setDouble(7, this.player_registration.getBalance() );
			this.updatePlayerRegistrationStatement.setDouble(8, this.player_registration.getBaseFee() );
			this.updatePlayerRegistrationStatement.setBoolean(9, this.player_registration.getPitchingExperience() );
			this.updatePlayerRegistrationStatement.setBoolean(10, this.player_registration.getCatchingExperience() );
			this.updatePlayerRegistrationStatement.setBoolean(11, this.player_registration.getCatchingGear() );
			this.updatePlayerRegistrationStatement.setBoolean(12, this.player_registration.getByLawsAgreement() );
			this.updatePlayerRegistrationStatement.setDouble(13, this.player_registration.getDonation() );
			this.updatePlayerRegistrationStatement.setDouble(14, this.player_registration.getFundraisingFee() );
			this.updatePlayerRegistrationStatement.setDouble(15, this.player_registration.getLateFee() );
			this.updatePlayerRegistrationStatement.setDouble(16, this.player_registration.getOutOfCountyFee() );
			this.updatePlayerRegistrationStatement.setDouble(17, this.player_registration.getDiscount() );
			this.updatePlayerRegistrationStatement.setString(18, this.player_registration.getHatSize() );
			this.updatePlayerRegistrationStatement.setInt(19, this.player_registration.getJersey1() );
			this.updatePlayerRegistrationStatement.setInt(20, this.player_registration.getJersey2() );
			this.updatePlayerRegistrationStatement.setString(21, this.player_registration.getJerseySize() );
			this.updatePlayerRegistrationStatement.setString(22, this.player_registration.getPantSize() );
			this.updatePlayerRegistrationStatement.setBoolean(23, this.player_registration.getLiabilityWaiver() );
			this.updatePlayerRegistrationStatement.setBoolean(24, this.player_registration.getPhotoWaiver() );
			this.updatePlayerRegistrationStatement.setDouble(25, this.player_registration.getRefundAmount() );
			this.updatePlayerRegistrationStatement.setBoolean(26, this.player_registration.getRefundPolicy() );
			this.updatePlayerRegistrationStatement.setInt(27, this.player_registration.getSeasonsPlayed() );
			this.updatePlayerRegistrationStatement.setDouble(28, this.player_registration.getTotalFees() );
			this.updatePlayerRegistrationStatement.setString(29, this.player_registration.getSocksSize() );
			this.updatePlayerRegistrationStatement.setDouble(30, this.player_registration.getUniformCampFee() );
			this.updatePlayerRegistrationStatement.setString(31, this.passPhrase );
			this.updatePlayerRegistrationStatement.setInt(32, this.registrationID );
			
			
			this.updatePlayerRegistrationStatement.executeUpdate();
			
		}catch( Exception ex ){
			ex.printStackTrace();
		}

	}
	
	/** Adds a player registration to the database and populates the populated primary key.
	 * 
	 * @param player_registration
	 */
	private void addPlayer_Registration(){
		
		try{
			
		
			/*
			 * Create person record for the specific player.
			 */
			this.addPerson( player_registration.getPerson() );
			
			/*
			 * TODO:  Create records for all of the people that are emergency contacts.  Extracting the 
			 * newly generated key after each key.
			 */
			
			for( Person p0 : this.player_registration.getPerson().getEmergencyContacts() ){
				this.addPerson(p0);
			}
			
			/*
			 * TODO:  Create all of the emergency contact references for each person.
			 */
			this.updateEmergencyContacts( this.player_registration.getPerson().getEmergencyContacts() );
			
			/*
			 * TODO:  Create all of the addresses that are related to the player.
			 */
			this.updateAddresses( this.player_registration.getPerson().getAddresses() );
			
			this.addPlayerRegistrationStatement.setInt( 1, this.player_registration.getDivision().getDivisionID() );
			this.addPlayerRegistrationStatement.setInt( 2, this.player_registration.getPerson().getPersonID() );
			this.addPlayerRegistrationStatement.setString(3, this.player_registration.getAdditionalPosition() );
			this.addPlayerRegistrationStatement.setBoolean(4, this.player_registration.getCodeOfConduct() );
			this.addPlayerRegistrationStatement.setString(5, this.player_registration.getPrimaryPosition() );
			this.addPlayerRegistrationStatement.setString(6, this.player_registration.getSecondaryPosition() );
			this.addPlayerRegistrationStatement.setDouble(7, this.player_registration.getBalance() );
			this.addPlayerRegistrationStatement.setDouble(8, this.player_registration.getBaseFee() );
			this.addPlayerRegistrationStatement.setBoolean(9, this.player_registration.getPitchingExperience() );
			this.addPlayerRegistrationStatement.setBoolean(10, this.player_registration.getCatchingExperience() );
			this.addPlayerRegistrationStatement.setBoolean(11, this.player_registration.getCatchingGear() );
			this.addPlayerRegistrationStatement.setBoolean(12, this.player_registration.getByLawsAgreement() );
			this.addPlayerRegistrationStatement.setDouble(13, this.player_registration.getDonation() );
			this.addPlayerRegistrationStatement.setDouble(14, this.player_registration.getFundraisingFee() );
			this.addPlayerRegistrationStatement.setDouble(15, this.player_registration.getLateFee() );
			this.addPlayerRegistrationStatement.setDouble(16, this.player_registration.getOutOfCountyFee() );
			this.addPlayerRegistrationStatement.setDouble(17, this.player_registration.getDiscount() );
			this.addPlayerRegistrationStatement.setString(18, this.player_registration.getHatSize() );
			this.addPlayerRegistrationStatement.setInt(19, this.player_registration.getJersey1() );
			this.addPlayerRegistrationStatement.setInt(20, this.player_registration.getJersey2() );
			this.addPlayerRegistrationStatement.setString(21, this.player_registration.getJerseySize() );
			this.addPlayerRegistrationStatement.setString(22, this.player_registration.getPantSize() );
			this.addPlayerRegistrationStatement.setBoolean(23, this.player_registration.getLiabilityWaiver() );
			this.addPlayerRegistrationStatement.setBoolean(24, this.player_registration.getPhotoWaiver() );
			this.addPlayerRegistrationStatement.setDouble(25, this.player_registration.getRefundAmount() );
			this.addPlayerRegistrationStatement.setBoolean(26, this.player_registration.getRefundPolicy() );
			this.addPlayerRegistrationStatement.setInt(27, this.player_registration.getSeasonsPlayed() );
			this.addPlayerRegistrationStatement.setDouble(28, this.player_registration.getTotalFees() );
			this.addPlayerRegistrationStatement.setString(29, this.player_registration.getSocksSize() );
			this.addPlayerRegistrationStatement.setDouble(30, this.player_registration.getUniformCampFee() );
			this.addPlayerRegistrationStatement.setString(31, this.passPhrase );
			
			this.addPlayerRegistrationStatement.executeUpdate();
			
			ResultSet rs = this.addPlayerRegistrationStatement.getGeneratedKeys();
			rs.next();
			this.registrationID = rs.getInt(1);
			this.player_registration.setRegistrationID(this.registrationID);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/** Deletes the registration associated with the registration ID and passphrase.
	 * 
	 */
	public void delPlayer_Registration(){
		try{
			
			if( this.authenticateRegistration() ){

				/*
				 * First delete all addresses.
				 */

				this.delPersonAddressStatement.setInt(1, this.registrationID);
				this.delPersonAddressStatement.executeUpdate();

				/*
				 * Delete all Emergency Contacts and People
				 */
				
				this.delEmergency_ContactStatement.setInt(1, this.registrationID);
				this.delEmergency_ContactStatement.executeUpdate();

				/* 
				 * Delete the Player Registration.
				 */

				this.delPlayerRegistrationStatement.setInt(1, this.registrationID);
				this.delPlayerRegistrationStatement.setString(2, this.passPhrase);
				this.delPlayerRegistrationStatement.executeUpdate();

				/*
				 * Delete the Person.
				 */
				
				this.delPersonStatement.setInt(1, this.registrationID);
				this.delPersonStatement.executeUpdate();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/** Returns the registration ID to be displayed to the registrant on the Thank You page.
	 * @return
	 */
	public int getRegistrationID(){
		return this.registrationID;
	}
	
	/** Sets the registration ID variable to populate a Player Registration object
	 * @param registrationID
	 */
	public void setRegistrationID(int registrationID){
		this.registrationID = registrationID;

		try{
			this.getPlayerRegistrationStatement.setInt(1, this.registrationID);
			this.getPlayerRegistrationStatement.setString(2, this.passPhrase);
			this.getPlayerRegistrationStatement.execute();
			
			ResultSet rs = this.getPlayerRegistrationStatement.getResultSet();
			if( !rs.next() ){
				this.registrationID = -1;
			}else{
				this.player_registration.setRegistrationID(registrationID);
				this.player_registration.setDivision(this.getDivision(rs.getInt(1)));
				this.player_registration.setPerson(this.getPerson(rs.getInt(2)));
				this.player_registration.setAdditionalPosition(rs.getString(3));
				this.player_registration.setCodeOfConduct(rs.getBoolean(4));
				this.player_registration.setPrimaryPosition(rs.getString(5));
				this.player_registration.setSecondaryPosition(rs.getString(6));
				this.player_registration.setBalance(rs.getDouble(7));
				this.player_registration.setBaseFee(rs.getDouble(8));
				this.player_registration.setPitchingExperience(rs.getBoolean(9));
				this.player_registration.setCatchingExperience(rs.getBoolean(10));
				this.player_registration.setCatchingGear(rs.getBoolean(11));
				this.player_registration.setByLawsAgreement(rs.getBoolean(12));
				this.player_registration.setDonation(rs.getDouble(13));
				this.player_registration.setFundraisingFee(rs.getDouble(14));
				this.player_registration.setLateFee(rs.getDouble(15));
				this.player_registration.setOutOfCountyFee(rs.getDouble(16));
				this.player_registration.setDiscount(rs.getDouble(17));
				this.player_registration.setHatSize(rs.getString(18));
				this.player_registration.setJersey1(rs.getInt(19));
				this.player_registration.setJersey2(rs.getInt(20));
				this.player_registration.setJerseySize(rs.getString(21));
				this.player_registration.setPantSize(rs.getString(22));
				this.player_registration.setLiabilityWaiver(rs.getBoolean(23));
				this.player_registration.setPhotoWaiver(rs.getBoolean(24));
				this.player_registration.setRefundAmount(rs.getDouble(25));
				this.player_registration.setRefundPolicy(rs.getBoolean(26));
				this.player_registration.setSeasonsPlayed(rs.getInt(27));
				this.player_registration.setTotalFees(rs.getDouble(28));
				this.player_registration.setSocksSize(rs.getString(29));
				this.player_registration.setUniformCampFee(rs.getDouble(30));
			}
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		
	}
	
	/** Returns the player registration object associated with the registrationID.
	 * @return
	 */
	public Player_Registration getPlayer_Registration(){
		return this.player_registration;
	}
	
	/** Sets the player_registration variable and writes the object to the database.  It also writes the value of the primary key (through 
	 * addPlayer_Registration) to the registration ID value to be display to the registrant on the Thank You page.
	 * @param player_registration		Player_Registration object fully populated.
	 */
	public void setPlayer_Registration(Player_Registration player_registration){
		this.player_registration = player_registration;
		if( player_registration.getRegistrationID() == -1 ){
			this.addPlayer_Registration();
		}else{
			this.updatePlayer_Registration();
		}
	}
	
	/** Returns a Division available to be displayed in the form.
	 * @return division		Division associated with the player registration. 
	 */
	private Division getDivision(int divisionID){
		Division division = new Division();
		
		try{
			this.getDivisionStatement.setInt(1, divisionID);
			this.getDivisionStatement.execute();
			
			ResultSet rs0 = this.getDivisionStatement.getResultSet();
			
			if( rs0.next() ){
				Division dTemp = new Division();
				dTemp.setDivisionID( rs0.getInt(1) );
				dTemp.setDivisionName( rs0.getString(2) );
				dTemp.setDivisionDescription( rs0.getString(3) );
				
				Sport s0Temp = new Sport();
				
				s0Temp.setSportID( rs0.getInt(4) );
				
				this.getSportStatement.setInt(1, s0Temp.getSportID() );
				this.getSportStatement.execute();
				
				ResultSet rs1 = this.getSportStatement.getResultSet();
				rs1.next();
				
				s0Temp.setSportName( rs1.getString(2) );
				s0Temp.setSportDescription( rs1.getString(3) );
				s0Temp.addDivision(dTemp);
				
				Season s1Temp = new Season();
				
				s1Temp.setSeasonID( rs0.getInt(5) );
				this.getSeasonStatement.setInt(1, s1Temp.getSeasonID() );
				this.getSeasonStatement.execute();
				
				ResultSet rs2 = this.getSeasonStatement.getResultSet();
				rs2.next();
				
				s1Temp.setSeasonName( rs2.getString(2) );
				s1Temp.setSeasonStartDate( rs2.getDate(3) );
				s1Temp.setSeasonEndDate(rs2.getDate(4) );
				s1Temp.addDivision(dTemp);
				
				dTemp.setSport(s0Temp);
				dTemp.setSeason(s1Temp);
				
				division = dTemp;
			}
			
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		
		return division;
	}
	
	/** Returns a list of Divisions available to be displayed in the form.
	 * @return divisions		List of divisions, which encompass all sports and seasons availab.e 
	 */
	public ArrayList<Division> getDivisions(){
		ArrayList<Division> divisions = new ArrayList<Division>();
		
		try{
			this.getDivisionsStatement.execute();
			
			ResultSet rs0 = this.getDivisionsStatement.getResultSet();
			
			while( rs0.next() ){
				Division dTemp = new Division();
				dTemp.setDivisionID( rs0.getInt(1) );
				dTemp.setDivisionName( rs0.getString(2) );
				dTemp.setDivisionDescription( rs0.getString(3) );
				
				Sport s0Temp = new Sport();
				
				s0Temp.setSportID( rs0.getInt(4) );
				
				this.getSportStatement.setInt(1, s0Temp.getSportID() );
				this.getSportStatement.execute();
				
				ResultSet rs1 = this.getSportStatement.getResultSet();
				rs1.next();
				
				s0Temp.setSportName( rs1.getString(2) );
				s0Temp.setSportDescription( rs1.getString(3) );
				s0Temp.addDivision(dTemp);
				
				Season s1Temp = new Season();
				
				s1Temp.setSeasonID( rs0.getInt(5) );
				this.getSeasonStatement.setInt(1, s1Temp.getSeasonID() );
				this.getSeasonStatement.execute();
				
				ResultSet rs2 = this.getSeasonStatement.getResultSet();
				rs2.next();
				
				s1Temp.setSeasonName( rs2.getString(2) );
				s1Temp.setSeasonStartDate( rs2.getDate(3) );
				s1Temp.setSeasonEndDate(rs2.getDate(4) );
				s1Temp.addDivision(dTemp);
				
				dTemp.setSport(s0Temp);
				dTemp.setSeason(s1Temp);
				
				divisions.add(dTemp);
			}
			
		}catch( Exception ex ){
			ex.printStackTrace();
		}
		
		return divisions;
	}

	/**
	 * @param passPhrase the passPhrase to set
	 */
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}
	
	/**
	 * Authenticate User.
	 */
	public boolean authenticateRegistration(){
		try{
			this.authPlayerRegistrationStatement.setInt(1, this.registrationID);
			this.authPlayerRegistrationStatement.setString(2, this.passPhrase);
			this.authPlayerRegistrationStatement.execute();
			
			ResultSet rs = this.authPlayerRegistrationStatement.getResultSet();
			
			if( rs.next() ){
				return true;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return false;
	}
	
	
}
