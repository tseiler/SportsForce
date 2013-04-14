package jsportsreg.entity;

import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class PersonTest {

	/** Tests all constructors and getters and setters.
	 * 
	 */
	@Test
	public void testPerson() {
		
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
		
		try{
			Date dateTest = df.parse("01-01-1900");
			assertEquals("Person Test 1: Birth Date", dateTest, instance0.getBirthDate() );
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		assertEquals("Person Test 1: Gender", "", instance0.getGender() );
		assertEquals("Person Test 1: Role", "", instance0.getRole() );
		assertEquals("Person Test 1: Person ID", -1, instance0.getPersonID() );
		assertEquals("Person Test 1: Player Registrations", "", instance0.getPlayerRegistrations().isEmpty() );
		assertEquals("Person Test 1: Addresses", "", instance0.getAddresses().isEmpty() );
		assertEquals("Person Test 1: Emergency Contacts", "", instance0.getEmergencyContacts().isEmpty() );
		
	}

}
