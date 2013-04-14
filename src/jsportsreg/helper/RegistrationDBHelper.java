/**
 * 
 */
package jsportsreg.helper;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.ArrayList;

import jsportsreg.entity.*;


/** This class is designed to handle all updates to the all member objects that are associated with a Player Registration.  This class
 * only takes the registration ID and will pull all corresponding data.  This class should only be used as a bean when pre-populating a 
 * registration form, otherwise the Registration Controller should send a new Player_Registration object. 
 * @author tseiler
 *
 */
public class RegistrationDBHelper {
	
	private String JDBC_URL;

	private PreparedStatement addPersonStatentment;
	private PreparedStatement addPlayerRegistrationStatentment;
	private PreparedStatement addPersonAddressStatentment;
	private PreparedStatement addEmergency_ContactStatentment;
	
	private PreparedStatement getPersonStatentment;
	private PreparedStatement getPlayer_RegistrationStatentment;
	private PreparedStatement getEmergencyContactsStatentment;
	private PreparedStatement getAddressesStatentment;
	
	private PreparedStatement getDivisionsStatentment;
	private PreparedStatement getSportStatentment;
	private PreparedStatement getSeasonStatentment;
	
	private PreparedStatement updatePersonStatentment;
	private PreparedStatement updatePlayer_RegistrationStatentment;
	
	private int registrationID;
	
	/**
	 * 
	 */
	public RegistrationDBHelper() {
	}
	
	/** Adds a person to the database and populates the Person object with the updated primary key field.
	 * @param person		Person object.
	 */ 
	private void addPerson(Person person){
	
	}
	
	/** Retrieves the person from the database that is associated with the Player Registration. Uses the registrationID to look up the Person.
	 * @return
	 */
	private Person getPerson(){
		Person person = new Person();
		return person;
	}
	
	/** Retrieves all addresses corresponding to the person associated with the player registration.  Utilizes the registration ID field.
	 *  Used to populated the Person and Player_Registration objects.
	 * @return
	 */
	private ArrayList<Address> getAddresses(){
		ArrayList<Address> addresses = new ArrayList<Address>();
		return addresses;
	}
	
	/** Updates all of the addresses corresponding to a specific person (based on the registration ID), by deleting all of the records and
	 * adding the new list back in.
	 * @param addresses		List of addresses to update.
	 * @return
	 * 
	 */
	private void updateAddresses(ArrayList<Address> addresses){
		
	}
	
	/** Retrieves a list of people that are associated with a person as emergency contacts.  Because these are emergency contacts for a 
	 * specific person, not all fields are populated.  It utilizes the registrationID to find the parent relationship (Person). 
	 * @return
	 */
	private ArrayList<Person> getEmergency_Contacts(){
		ArrayList<Person> emergencyContacts = new ArrayList<Person>();
		return emergencyContacts;
	}
	
	/** Updates all of the emergency contacts associated with a person (based on the registration ID), by deleting all of the records and then 
	 * adding them back into the database.
	 * @param emergencyContacts		List of People (Person) to be updated.
	 */
	private void updateEmergencyContacts(ArrayList<Person> emergencyContacts){
		
	}
	
	/** Adds a player registration to the database and populates the populated primary key.
	 * 
	 * @param player_registration
	 */
	private void addPlayer_Registration(Player_Registration player_registration){
	
	}
	
	
	
	
}
