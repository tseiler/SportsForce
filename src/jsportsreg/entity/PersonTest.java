package jsportsreg.entity;

import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import org.junit.Test;

public class PersonTest {

	/** Tests all constructors and getters and setters.
	 * 
	 */
	@Test
	public void testPerson() throws Exception{
		
		Person instance0 = new Person();
		
		assertEquals("Person Test 1: First Name", "", instance0.getFirstName());
		assertEquals("Person Test 1: Last Name", "", instance0.getLastName());
		assertEquals("Person Test 1: Middle Name", "", instance0.getMiddleName() );
		assertEquals("Person Test 1: Nick Name", "", instance0.getNickName() );
		assertEquals("Person Test 1: Suffix Name", "", instance0.getSuffixName() );
		assertEquals("Person Test 1: Home Phone Number", "", instance0.getHomePhone() );
		assertEquals("Person Test 1: Mobile Phone Number", "", instance0.getMobilePhone() );
		assertEquals("Person Test 1: Work Phone Number", "", instance0.getWorkPhone() );
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date dateTest0 = df.parse("01-01-1900");
		assertEquals("Person Test 1: Birth Date", dateTest0, instance0.getBirthDate() );
		assertEquals("Person Test 1: Gender", "", instance0.getGender() );
		assertEquals("Person Test 1: Role", "", instance0.getRole() );
		assertEquals("Person Test 1: Person ID", -1, instance0.getPersonID() );
		assertEquals("Person Test 1: Player Registrations", true, instance0.getPlayerRegistrations().isEmpty() );
		assertEquals("Person Test 1: Addresses", true, instance0.getAddresses().isEmpty() );
		assertEquals("Person Test 1: Emergency Contacts", true, instance0.getEmergencyContacts().isEmpty() );
		
		
		Date dateTest1 = df.parse("12-21-1975"); 
				
		Person instance1 = new Person( 21, dateTest1, "tseiler@xcellutions.com", "Travis", "Male", "404-759-0121", "Seiler",
				"David", "404-890-0006", "T-Rex", "Parent/Guardian", "", "770-555-9999", new ArrayList<Address>(), 
				new ArrayList<Person>(), new ArrayList<Player_Registration>() );
		
		assertEquals("Person Test 2: First Name", "Travis", instance1.getFirstName());
		assertEquals("Person Test 2: Last Name", "Seiler", instance1.getLastName());
		assertEquals("Person Test 2: Middle Name", "David", instance1.getMiddleName() );
		assertEquals("Person Test 2: Nick Name", "T-Rex", instance1.getNickName() );
		assertEquals("Person Test 2: Suffix Name", "", instance1.getSuffixName() );
		assertEquals("Person Test 2: Home Phone Number", "404-759-0121", instance1.getHomePhone() );
		assertEquals("Person Test 2: Mobile Phone Number", "404-890-0006", instance1.getMobilePhone() );
		assertEquals("Person Test 2: Work Phone Number", "770-555-9999", instance1.getWorkPhone() );
		assertEquals("Person Test 2: Birth Date", dateTest1, instance1.getBirthDate() );
		assertEquals("Person Test 2: Gender", "Male", instance1.getGender() );
		assertEquals("Person Test 2: Role", "Parent/Guardian", instance1.getRole() );
		assertEquals("Person Test 2: Person ID", 21, instance1.getPersonID() );
		assertEquals("Person Test 2: Player Registrations", true, instance1.getPlayerRegistrations().isEmpty() );
		assertEquals("Person Test 2: Addresses", true, instance1.getAddresses().isEmpty() );
		assertEquals("Person Test 2: Emergency Contacts", true, instance1.getEmergencyContacts().isEmpty() );
		
		instance0.setFirstName("Alexzander");
		instance0.setMiddleName("Edward");
		instance0.setLastName("Seiler");
		instance0.setSuffixName("");
		instance0.setNickName("Zander");
		Date dateTest2 = df.parse("10-3-2010");
		instance0.setBirthDate(dateTest2);
		instance0.setGender("Male");
		instance0.setRole("Player");
		instance0.setWorkPhone("404-555-1234");
		instance0.setHomePhone("404-555-9876");
		instance0.setMobilePhone("404-555-4321");
		instance0.setPersonID(2010);
		
		ArrayList<Address> aList = new ArrayList<Address>();
		Address addr1 = new Address();
		Address addr2 = new Address();
		aList.add(addr1);
		aList.add(addr2);
		
		instance0.setAddresses(aList);

		ArrayList<Player_Registration> pList = new ArrayList<Player_Registration>();
		Player_Registration pr0 = new Player_Registration();
		pList.add(pr0);
		
		instance0.setPlayerRegistrations(pList);
		
		ArrayList<Person> ecList = new ArrayList<Person>();
		ecList.add(instance1);
		
		instance0.setEmergencyContacts(ecList);
		
		
		assertEquals("Person Test 3: First Name", "Alexzander", instance0.getFirstName());
		assertEquals("Person Test 3: Last Name", "Seiler", instance0.getLastName());
		assertEquals("Person Test 3: Middle Name", "Edward", instance0.getMiddleName() );
		assertEquals("Person Test 3: Nick Name", "Zander", instance0.getNickName() );
		assertEquals("Person Test 3: Suffix Name", "", instance0.getSuffixName() );
		assertEquals("Person Test 3: Home Phone Number", "404-555-9876", instance0.getHomePhone() );
		assertEquals("Person Test 3: Mobile Phone Number", "404-555-4321", instance0.getMobilePhone() );
		assertEquals("Person Test 3: Work Phone Number", "404-555-1234", instance0.getWorkPhone() );
		assertEquals("Person Test 3: Birth Date", dateTest2, instance0.getBirthDate() );
		assertEquals("Person Test 3: Gender", "Male", instance0.getGender() );
		assertEquals("Person Test 3: Role", "Player", instance0.getRole() );
		assertEquals("Person Test 3: Person ID", 2010, instance0.getPersonID() );
		assertEquals("Person Test 3: Player Registrations", 1, instance0.getPlayerRegistrations().size() );
		assertEquals("Person Test 3: Addresses", 2, instance0.getAddresses().size() );
		assertEquals("Person Test 3: Emergency Contacts", 1, instance0.getEmergencyContacts().size() );
	}

}
