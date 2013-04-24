package jsportsreg.helper;


import jsportsreg.entity.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.sun.media.sound.EmergencySoundbank;

import java.util.ArrayList;

public class RegistrationDBHelperTest {

	@Test
	public void testGetDivisions() throws Exception{
		
		ArrayList<Division> dListVerify = new ArrayList<Division>();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		
		Date tDate1 = df.parse("6-1-2013");
		Date tDate2 = df.parse("8-30-2013");
		Date tDate3 = df.parse("9-15-2013");
		Date tDate4 = df.parse("11-30-2013");
			
		Season seasonVerify1 = new Season(789670000, tDate2, "Summer 2013", tDate1, new ArrayList<Division>() );
		Season seasonVerify2 = new Season(789670001, tDate4, "Fall 2013", tDate3, new ArrayList<Division>() );
		
		Sport sportVerify1 = new Sport(123233000, "Baseball", "Baseball", new ArrayList<Division>() );
		
		dListVerify.add( new Division(1, "Major 11 & 12 year olds", "Major 11 & 12 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Major 11 & 12 year olds", "Major 11 & 12 year olds", 
				seasonVerify2, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Minor 9 & 10 year olds", "Minor 9 & 10 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Minor 9 & 10 year olds", "Minor 9 & 10 year olds", 
				seasonVerify2, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Tball 5 & 6 year olds", "Tball 5 & 6 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Tball 5 & 6 year olds", "Tball 5 & 6 year olds", 
				seasonVerify2, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Seniors 15 thru 18 year olds", "Seniors 15 thru 18 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Seniors 15 thru 18 year olds", "Seniors 15 thru 18 year olds", 
				seasonVerify2, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "PeeWee 7 & 8 year olds", "PeeWee 7 & 8 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "PeeWee 7 & 8 year olds", "PeeWee 7 & 8 year olds", 
				seasonVerify2, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Pony 13 & 14 year olds", "Pony 13 & 14 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() ) );
		dListVerify.add( new Division(1, "Pony 13 & 14 year olds", "Pony 13 & 14 year olds", 
				seasonVerify2, sportVerify1, new ArrayList<Player_Registration>() ) );
		
		RegistrationDBHelper instance0 = new RegistrationDBHelper();
		
		ArrayList<Division> dList = instance0.getDivisions();
		
		assertEquals("Get Divisions Test 1:  Number of Divisions", 12, dList.size() );
		for( Division d0 : dList ){
			assertEquals("Get Divisions Test 2:  Contains", true, dList.contains(d0) );
		}
	}

	@Test
	public void testPlayer_Registration() throws Exception{
		
		String JDBC_URL = "jdbc:mysql://xlf.cqqc3wlbhkub.us-east-1.rds.amazonaws.com/sports_force";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,
					"mist7570", "GoDAWGS2013");
			System.out.println("Connected to sports_force database to delete JUnit Test Records");
			
			/*
			 * Prepared Statements for specific JUnit cleanup.
			 */
			
			PreparedStatement pKeyStmt = conn.prepareStatement("SELECT personID FROM People " + 
					"WHERE first_name = ? AND middle_name = ? AND last_name = ? AND birth_date = ? AND gender = ? AND " +
					"role = ? AND work_phone = ? AND home_phone = ? AND mobile_phone = ?");
			
			PreparedStatement cleanAddressesStmt = conn.prepareStatement("DELETE FROM Addresses " + 
					"WHERE personID = ?");
			
			PreparedStatement countEmergencyContactStmt = conn.prepareStatement("SELECT COUNT(*) FROM Emergency_Contacts " +
					"WHERE personID = ?");
			
			PreparedStatement listEmergencyContactsStmt = conn.prepareStatement("SELECT contactID FROM Emergency_Contacts " +
					"WHERE personID = ?");
			
			PreparedStatement cleanEmergencyContactsStmt = conn.prepareStatement("DELETE FROM Emergency_Contacts " + 
					"WHERE personID = ?");
			
			PreparedStatement cleanPersonStmt = conn.prepareStatement("DELETE FROM People " + 
					"WHERE personID = ?");
			
			PreparedStatement cleanPlayerRegistrationStmt = conn.prepareStatement("DELETE FROM Player_Registration " + 
					"WHERE personID = ?");
			
			/*
			 * Get the primary key of the person associated with player registration.
			 */
			
			pKeyStmt.setString(1, "Phillip");
			pKeyStmt.setString(2, "Nande");
			pKeyStmt.setString(3, "Sukoluski");
			pKeyStmt.setString(4, "1975-12-21");
			pKeyStmt.setString(5, "Male");
			pKeyStmt.setString(6, "Player");
			pKeyStmt.setString(7,"404-555-1234");
			pKeyStmt.setString(8, "404-555-9876");
			pKeyStmt.setString(9, "404-555-4321");
			
			pKeyStmt.execute();
			
			ResultSet rsCleanUp = pKeyStmt.getResultSet();
			
			int pKey;

			rsCleanUp.next();
			pKey = rsCleanUp.getInt(1);
			
			/*
			 * Delete the associated addresses with this primary key.
			 */
			
			cleanAddressesStmt.setInt(1, pKey);
			cleanAddressesStmt.executeUpdate();
			
			/*
			 * Delete the associated Emergency contacts and record the IDs of the people in a list.
			 */
			
			listEmergencyContactsStmt.setInt(1, pKey);
			countEmergencyContactStmt.setInt(1, pKey);
			listEmergencyContactsStmt.execute();
			countEmergencyContactStmt.execute();
			
			ResultSet rsEC = listEmergencyContactsStmt.getResultSet();
			ResultSet rsECCount = countEmergencyContactStmt.getResultSet();
			
			rsECCount.next();
			
			int [] contacts = new int[rsECCount.getInt(1)];
			
			int i = 0;
			while( rsEC.next() ){
				contacts[i++] = rsEC.getInt(1);
			}
			
			cleanEmergencyContactsStmt.setInt(1, pKey);
			cleanEmergencyContactsStmt.executeUpdate();
			
			/*
			 * Delete the people that were associated with the emergency contacts, driven from the 
			 * list created in the previous step.
			 */
			
			for( int key : contacts){
				
				cleanPersonStmt.setInt(1, key);
				cleanPersonStmt.executeUpdate();
			}
			
			/*
			 * Delete the Player Registration records associated with the specific primary key.
			 */
			
			cleanPlayerRegistrationStmt.setInt(1, pKey);
			cleanPlayerRegistrationStmt.executeUpdate();
			
			/*
			 * Delete the person associated with this primary key.
			 */
			
			cleanPersonStmt.setInt(1, pKey);
			cleanPersonStmt.executeUpdate();
			
			
		}catch(Exception ex){
			System.out.println("Unable to cleanup test data.  May not exist...");
			ex.printStackTrace();
		}
		
		
		RegistrationDBHelper instance0 = new RegistrationDBHelper();
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		
		Player_Registration pr0 = new Player_Registration();
		Date dateTest1 = df.parse("12-21-1975"); 
		Person p0 = new Person();
		
		p0.setFirstName("Phillip");
		p0.setMiddleName("Nande");
		p0.setLastName("Sukoluski");
		p0.setSuffixName("");
		p0.setNickName("Suki");
		p0.setBirthDate(dateTest1);
		p0.setGender("Male");
		p0.setRole("Player");
		p0.setWorkPhone("404-555-1234");
		p0.setHomePhone("404-555-9876");
		p0.setMobilePhone("404-555-4321");
		
		Address addr0 = new Address();
		
		addr0.setAddressStreet("1829 Spaight Street");
		addr0.setAddressCity("Madison");
		addr0.setAddressState("WI");
		addr0.setAddressPostalCode("53709");
		addr0.setAddressCounty("Dane");
		
		p0.addAddress(addr0);
		
		Date dateTest2 = df.parse("12-3-1957"); 
		Person p1 = new Person();
		
		p1.setFirstName("Bob");
		p1.setMiddleName("Bill");
		p1.setLastName("Sukoluski");
		p1.setSuffixName("");
		p1.setNickName("");
		p1.setBirthDate(dateTest2);
		p1.setGender("Male");
		p1.setRole("Parent/Guardian");
		p1.setWorkPhone("404-555-9999");
		p1.setHomePhone("404-555-8888");
		p1.setMobilePhone("404-555-5555");
		
		p0.addEmergencyContact(p1);
		
		pr0.setPerson(p0);
		
		Date tDate1 = df.parse("6-1-2013");
		Date tDate2 = df.parse("8-30-2013");
			
		Season seasonVerify1 = new Season(789670000, tDate2, "Summer 2013", tDate1, new ArrayList<Division>() );
		Sport sportVerify1 = new Sport(123233000, "Baseball", "Baseball", new ArrayList<Division>() );
		Division d0 = new Division(1, "Major 11 & 12 year olds", "Major 11 & 12 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() );
		
		pr0.setDivision(d0);
		pr0.setAdditionalPosition("LF");
		pr0.setBalance(500.00);
		pr0.setBaseFee(200.00);
		pr0.setByLawsAgreement(false);
		pr0.setCatchingExperience(true);
		pr0.setCatchingGear(true);
		pr0.setCodeOfConduct(true);
		pr0.setDiscount(15.00);
		pr0.setDonation(55.00);
		pr0.setFundraisingFee(35.00);
		pr0.setHatSize("Adult");
		pr0.setJersey1(15);
		pr0.setJersey2(12);
		pr0.setJerseySize("Youth Large");
		pr0.setLateFee(2.00);
		pr0.setLiabilityWaiver(true);
		pr0.setOutOfCountyFee(20.00);
		pr0.setPantSize("Youth Large");
		pr0.setPhotoWaiver(true);
		pr0.setPitchingExperience(true);
		pr0.setPrimaryPosition("P");
		pr0.setRefundAmount(0.00);
		pr0.setRefundPolicy(true);
		pr0.setSeasonsPlayed(3);
		pr0.setSecondaryPosition("CF");
		pr0.setSocksSize("Adult");
		pr0.setTotalFees(325.00);
		pr0.setUniformCampFee(25.50);
		pr0.setAdditionalPosition("CF");
		
		instance0.setPassPhrase("test123456");
		instance0.setPlayer_Registration(pr0);
		
		assertEquals("Registration Data Test 1: registrationID", true, (0 < instance0.getRegistrationID()) );
		assertEquals("Registration Data Test 2: authentication", true, instance0.authenticateRegistration() );
		
		RegistrationDBHelper instance1 = new RegistrationDBHelper();
		
		instance1.setPassPhrase("Test123");
		instance1.setRegistrationID(instance0.getRegistrationID());
		
		assertEquals("Registration Date Test 3: authentication", false, instance1.authenticateRegistration() );
		instance1.setPassPhrase("test123456");
		instance1.setRegistrationID(instance0.getRegistrationID());
		
		assertEquals("Registration Data Test 4: additionalPosition", "CF", instance1.getPlayer_Registration().getAdditionalPosition() );
		assertEquals("Registration Data Test 4: balance", 500.00, instance1.getPlayer_Registration().getBalance(), 2);
		assertEquals("Registration Data Test 4: baseFee", 200.00, instance1.getPlayer_Registration().getBaseFee(), 0.001 );
		assertEquals("Registration Data Test 4: byLawsAgreement", false, instance1.getPlayer_Registration().getByLawsAgreement() );
		assertEquals("Registration Data Test 4: catchingExperience", true, instance1.getPlayer_Registration().getCatchingExperience() );
		assertEquals("Registration Data Test 4: catchingGear", true, instance1.getPlayer_Registration().getCatchingGear());
		assertEquals("Registration Data Test 4: codeOfConduct", true, instance1.getPlayer_Registration().getCodeOfConduct() );
		assertEquals("Registration Data Test 4: discount", 15.00, instance1.getPlayer_Registration().getDiscount(), 0.001 );
		assertEquals("Registration Data Test 4: donation", 55.00, instance1.getPlayer_Registration().getDonation(), 0.001 );
		assertEquals("Registration Data Test 4: division", d0, instance1.getPlayer_Registration().getDivision() );
		assertEquals("Registration Data Test 4: fundraisingFee", 35.00, instance1.getPlayer_Registration().getFundraisingFee(), 0.001 );
		assertEquals("Registration Data Test 4: hatSize", "Adult", instance1.getPlayer_Registration().getHatSize() );
		assertEquals("Registration Data Test 4: jersey1", 15, instance1.getPlayer_Registration().getJersey1() );
		assertEquals("Registration Data Test 4: jersey2", 12, instance1.getPlayer_Registration().getJersey2() );
		assertEquals("Registration Data Test 4: jerseySize", "Youth Large", instance1.getPlayer_Registration().getJerseySize() );
		assertEquals("Registration Data Test 4: lateFee", 2.00, instance1.getPlayer_Registration().getLateFee(), 0.001 );
		assertEquals("Registration Data Test 4: liabilityWaiver", true, instance1.getPlayer_Registration().getLiabilityWaiver() );
		assertEquals("Registration Data Test 4: outOfCountyFee", 20.00, instance1.getPlayer_Registration().getOutOfCountyFee(), 0.001 );
		assertEquals("Registration Data Test 4: pantSize", "Youth Large", instance1.getPlayer_Registration().getPantSize() );
		assertEquals("Registration Data Test 4: person", p0.getPersonID(), instance1.getPlayer_Registration().getPerson().getPersonID() );
		assertEquals("Registration Data Test 4: photoWaiver", true, instance1.getPlayer_Registration().getPhotoWaiver() );
		assertEquals("Registration Data Test 4: pitchingExperience", true, instance1.getPlayer_Registration().getPitchingExperience() );
		assertEquals("Registration Data Test 4: primaryPosition", "P", instance1.getPlayer_Registration().getPrimaryPosition() );
		assertEquals("Registration Data Test 4: refundAmount", 0.00, instance1.getPlayer_Registration().getRefundAmount(), 0.001 );
		assertEquals("Registration Data Test 4: refundPolicy", true, instance1.getPlayer_Registration().getRefundPolicy() );
		assertEquals("Registration Data Test 4: registrationID", instance0.getRegistrationID(), instance1.getPlayer_Registration().getRegistrationID() );
		assertEquals("Registration Data Test 4: seasonsPlayed", 3, instance1.getPlayer_Registration().getSeasonsPlayed() );
		assertEquals("Registration Data Test 4: secondaryPosition", "CF", instance1.getPlayer_Registration().getSecondaryPosition() );
		assertEquals("Registration Data Test 4: socksSize", "Adult", instance1.getPlayer_Registration().getSocksSize() );
		assertEquals("Registration Data Test 4: totalFees", 325.00, instance1.getPlayer_Registration().getTotalFees(), 0.001 );
		assertEquals("Registration Data Test 4: uniformCampFee", 25.50, instance1.getPlayer_Registration().getUniformCampFee(), 0.001 );
	
		/*
		 * Test Update Functionality
		 */
		
		addr0.setAddressCity("Lodi");
		addr0.setAddressCounty("Columbia");
		
		p1.setEmailAddress("test@test.com");
		p1.setFirstName("Phyllis");
		p1.setGender("Female");
		p1.setMiddleName("Luanne");
		p1.setMobilePhone("678-555-4444");
		p1.setRole("Emergency Contact");
		
		p0.setNickName("Hero");
		
		pr0.setDonation(100);
		pr0.setSecondaryPosition("3B");
		pr0.setPrimaryPosition("P");
		pr0.setAdditionalPosition("SS");
		pr0.setPitchingExperience(true);
		
		instance0.setPlayer_Registration(pr0);
		
		/*
		 * Create a new instance to pull data for final test.
		 */
		
		RegistrationDBHelper instance2 = new RegistrationDBHelper();
		
		instance2.setPassPhrase("test123456");
		instance2.setRegistrationID( instance1.getRegistrationID() );
		
		assertEquals("Registration Data Test 5: additionalPosition", "SS", instance2.getPlayer_Registration().getAdditionalPosition() );
		assertEquals("Registration Data Test 5: balance", 500.00, instance2.getPlayer_Registration().getBalance(), 2);
		assertEquals("Registration Data Test 5: baseFee", 200.00, instance2.getPlayer_Registration().getBaseFee(), 0.001 );
		assertEquals("Registration Data Test 5: byLawsAgreement", false, instance2.getPlayer_Registration().getByLawsAgreement() );
		assertEquals("Registration Data Test 5: catchingExperience", true, instance2.getPlayer_Registration().getCatchingExperience() );
		assertEquals("Registration Data Test 5: catchingGear", true, instance2.getPlayer_Registration().getCatchingGear());
		assertEquals("Registration Data Test 5: codeOfConduct", true, instance2.getPlayer_Registration().getCodeOfConduct() );
		assertEquals("Registration Data Test 5: discount", 15.00, instance2.getPlayer_Registration().getDiscount(), 0.001 );
		assertEquals("Registration Data Test 5: donation", 100.00, instance2.getPlayer_Registration().getDonation(), 0.001 );
		assertEquals("Registration Data Test 5: division", d0, instance2.getPlayer_Registration().getDivision() );
		assertEquals("Registration Data Test 5: fundraisingFee", 35.00, instance2.getPlayer_Registration().getFundraisingFee(), 0.001 );
		assertEquals("Registration Data Test 5: hatSize", "Adult", instance2.getPlayer_Registration().getHatSize() );
		assertEquals("Registration Data Test 5: jersey1", 15, instance2.getPlayer_Registration().getJersey1() );
		assertEquals("Registration Data Test 5: jersey2", 12, instance2.getPlayer_Registration().getJersey2() );
		assertEquals("Registration Data Test 5: jerseySize", "Youth Large", instance2.getPlayer_Registration().getJerseySize() );
		assertEquals("Registration Data Test 5: lateFee", 2.00, instance2.getPlayer_Registration().getLateFee(), 0.001 );
		assertEquals("Registration Data Test 5: liabilityWaiver", true, instance2.getPlayer_Registration().getLiabilityWaiver() );
		assertEquals("Registration Data Test 5: outOfCountyFee", 20.00, instance2.getPlayer_Registration().getOutOfCountyFee(), 0.001 );
		assertEquals("Registration Data Test 5: pantSize", "Youth Large", instance2.getPlayer_Registration().getPantSize() );
		assertEquals("Registration Data Test 5: person", p0.getPersonID(), instance2.getPlayer_Registration().getPerson().getPersonID() );
		assertEquals("Registration Data Test 5: photoWaiver", true, instance2.getPlayer_Registration().getPhotoWaiver() );
		assertEquals("Registration Data Test 5: pitchingExperience", true, instance2.getPlayer_Registration().getPitchingExperience() );
		assertEquals("Registration Data Test 5: primaryPosition", "P", instance2.getPlayer_Registration().getPrimaryPosition() );
		assertEquals("Registration Data Test 5: refundAmount", 0.00, instance2.getPlayer_Registration().getRefundAmount(), 0.001 );
		assertEquals("Registration Data Test 5: refundPolicy", true, instance2.getPlayer_Registration().getRefundPolicy() );
		assertEquals("Registration Data Test 5: registrationID", instance0.getRegistrationID(), instance2.getPlayer_Registration().getRegistrationID() );
		assertEquals("Registration Data Test 5: seasonsPlayed", 3, instance2.getPlayer_Registration().getSeasonsPlayed() );
		assertEquals("Registration Data Test 5: secondaryPosition", "3B", instance2.getPlayer_Registration().getSecondaryPosition() );
		assertEquals("Registration Data Test 5: socksSize", "Adult", instance2.getPlayer_Registration().getSocksSize() );
		assertEquals("Registration Data Test 5: totalFees", 325.00, instance2.getPlayer_Registration().getTotalFees(), 0.001 );
		assertEquals("Registration Data Test 5: uniformCampFee", 25.50, instance2.getPlayer_Registration().getUniformCampFee(), 0.001 );
		
		assertEquals("Registration Data Test 6: Person Nickname:", "Hero", instance2.getPlayer_Registration().getPerson().getNickName() );
		
	}
}
