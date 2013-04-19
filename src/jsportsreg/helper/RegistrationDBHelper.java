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

import jsportsreg.entity.*;


/** This class is designed to handle all updates to the all member objects that are associated with a Player Registration.  This class
 * only takes the registration ID and will pull all corresponding data.  This class should only be used as a bean when pre-populating a 
 * registration form, otherwise the Registration Controller should send a new Player_Registration object. 
 * @author tseiler
 *
 */
public class RegistrationDBHelper {
	
	private String JDBC_URL = "jdbc:mysql://xlf.cqqc3wlbhkub.us-east-1.rds.amazonaws.com/sports_force";

	private PreparedStatement addPersonStatement;
	private PreparedStatement addPlayerRegistrationStatement;
	private PreparedStatement addPersonAddressStatement;
	private PreparedStatement addEmergency_ContactStatement;
	
	private PreparedStatement getPersonStatement;
	private PreparedStatement getPlayer_RegistrationStatement;
	private PreparedStatement getEmergencyContactsStatement;
	private PreparedStatement getAddressesStatement;
	
	private PreparedStatement delPersonStatement;
	private PreparedStatement delPlayerRegistrationStatement;
	private PreparedStatement delPersonAddressStatement;
	private PreparedStatement delEmergency_ContactStatement;
	
	private PreparedStatement getDivisionsStatement;
	private PreparedStatement getSportStatement;
	private PreparedStatement getSeasonStatement;
	
	private int registrationID;
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
			
			this.addPlayerRegistrationStatement = conn.prepareStatement("INSERT INTO sports_force.Player_Registration" + 
					"( divisionID, personID, additional_position, code_of_conduct, primary_position, secondary_position, balance," +
					"base_fee, pitching_experience, catching_experience, catching_gear, by_laws_agreement, donation, " +
					"fundraising_fee, late_fee, out_of_county_fee, discount, hat_size, jersey_1, jersey_2, jersey_size, pant_size," +
					"liability_waiver, photo_waiver, refund_amount, refund_policy, seasons_played, total_fees, socks_size," +
					"uniform_camp_fee)" +
					"VALUES" + 
					"(  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", 
					PreparedStatement.RETURN_GENERATED_KEYS );
			
			this.addPersonStatement = conn.prepareStatement("INSERT INTO People " +
					"( first_name, middle_name, last_name, email_address, home_phone, birth_date, " + 
					"role, gender, work_phone, mobile_phone, nick_name, suffix_name )" +
					" VALUES " +
					"( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", PreparedStatement.RETURN_GENERATED_KEYS );
			
			this.getDivisionsStatement = conn.prepareStatement( "SELECT divisionID, division_name, division_description, " +
					"sportID, seasonID FROM Divisions" );
			this.getSportStatement = conn.prepareStatement( "SELECT sportID, sport_name, sport_description FROM Sports " +
					"WHERE sportID = ? ");
			this.getDivisionsStatement = conn.prepareStatement( "SELECT seasonID, seasonName, seasonStartDate, seasonEndDate " +
					"FROM Season WHERE seasonID = ?" );
			
			}catch(Exception ex){
				ex.printStackTrace();
			}

		
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
			this.addPersonStatement.setDate( 6, (Date) person.getBirthDate() );
			this.addPersonStatement.setString( 7, person.getRole() );
			this.addPersonStatement.setString( 8, person.getGender() );
			this.addPersonStatement.setString( 9, person.getWorkPhone() );
			this.addPersonStatement.setString( 10, person.getMobilePhone() );
			this.addPersonStatement.setString( 11, person.getNickName() );
			this.addPersonStatement.setString( 12, person.getSuffixName() );
			
			this.addPersonStatement.executeUpdate();
			
			ResultSet rs = this.addPersonStatement.getGeneratedKeys();
			rs.next();
			this.setRegistrationID( rs.getInt(1) );
			
		}catch(Exception ex){ 
			ex.printStackTrace();
		}
		
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
		
		try{
			this.addPlayerRegistrationStatement.setInt( 1, player_registration.getDivision().getDivisionID() );
			this.addPlayerRegistrationStatement.setInt( 2, player_registration.getPerson().getPersonID() );
			this.addPlayerRegistrationStatement.setString(3, player_registration.getAdditionalPosition() );
			this.addPlayerRegistrationStatement.setBoolean(4, player_registration.getCodeOfConduct() );
			this.addPlayerRegistrationStatement.setString(5, player_registration.getPrimaryPosition() );
			this.addPlayerRegistrationStatement.setString(6, player_registration.getSecondaryPosition() );
			this.addPlayerRegistrationStatement.setDouble(7, player_registration.getBalance() );
			this.addPlayerRegistrationStatement.setDouble(8, player_registration.getBaseFee() );
			this.addPlayerRegistrationStatement.setBoolean(9, player_registration.getPitchingExperience() );
			this.addPlayerRegistrationStatement.setBoolean(10, player_registration.getCatchingExperience() );
			this.addPlayerRegistrationStatement.setBoolean(11, player_registration.getByLawsAgreement() );
			this.addPlayerRegistrationStatement.setDouble(12, player_registration.getDonation() );
			this.addPlayerRegistrationStatement.setDouble(13, player_registration.getFundraisingFee() );
			this.addPlayerRegistrationStatement.setDouble(14, player_registration.getLateFee() );
			this.addPlayerRegistrationStatement.setDouble(15, player_registration.getOutOfCountyFee() );
			this.addPlayerRegistrationStatement.setDouble(16, player_registration.getDiscount() );
			this.addPlayerRegistrationStatement.setString(17, player_registration.getHatSize() );
			this.addPlayerRegistrationStatement.setInt(18, player_registration.getJersey1() );
			this.addPlayerRegistrationStatement.setInt(19, player_registration.getJersey2() );
			this.addPlayerRegistrationStatement.setString(20, player_registration.getJerseySize() );
			this.addPlayerRegistrationStatement.setString(21, player_registration.getPantSize() );
			this.addPlayerRegistrationStatement.setBoolean(22, player_registration.getLiabilityWaiver() );
			this.addPlayerRegistrationStatement.setBoolean(23, player_registration.getPhotoWaiver() );
			this.addPlayerRegistrationStatement.setDouble(24, player_registration.getRefundAmount() );
			this.addPlayerRegistrationStatement.setBoolean(25, player_registration.getRefundPolicy() );
			this.addPlayerRegistrationStatement.setInt(26, player_registration.getSeasonsPlayed() );
			this.addPlayerRegistrationStatement.setDouble(27, player_registration.getTotalFees() );
			this.addPlayerRegistrationStatement.setString(28, player_registration.getSocksSize() );
			this.addPlayerRegistrationStatement.setDouble(29, player_registration.getUniformCampFee() );
		

			this.addPlayerRegistrationStatement.executeUpdate();
			
			ResultSet rs = this.addPlayerRegistrationStatement.getGeneratedKeys();
			rs.next();
			this.registrationID = rs.getInt(1);
			this.player_registration.setRegistrationID(this.registrationID);
			
		}catch(Exception ex){
			
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
		this.addPlayer_Registration(player_registration);
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
				
				s0Temp.setSportName( rs1.getString(2) );
				s0Temp.setSportDescription( rs1.getString(3) );
				s0Temp.addDivision(dTemp);
				
				Season s1Temp = new Season();
				
				s1Temp.setSeasonID( rs0.getInt(5) );
				 
				this.getSportStatement.execute();
				
				ResultSet rs2 = this.getSportStatement.getResultSet();
				
				s1Temp.setSeasonName( rs2.getString(2) );
				s1Temp.setSeasonStartDate( rs2.getDate(3) );
				s1Temp.setSeasonEndDate(rs2.getDate(4) );
				s1Temp.addDivision(dTemp);
				
				dTemp.setSport(s0Temp);
				dTemp.setSeason(s1Temp);
				
				divisions.add(dTemp);
			}
			
		}catch( Exception ex ){
			
		}
		
		return divisions;
	}
}
