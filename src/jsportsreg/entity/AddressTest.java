package jsportsreg.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testAddress() {
		
		Address instance0 = new Address();
		
		assertEquals("Basic Constructor Test 1: All blank initialized values - Street", "", instance0.getAddressStreet() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - City", "", instance0.getAddressCity() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - State", "", instance0.getAddressState() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - County", "", instance0.getAddressCounty() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - AddressID", -1, instance0.getAddressID() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - Person", null, instance0.getPerson() );
	
		Address instance1 = new Address( 1, "111 Church Street", "Atlanta", "GA", "30303", "Fulton", null );
		
		assertEquals("Basic Constructor Test 2: All blank initialized values - Street", "111 Church Street", instance1.getAddressStreet() );
		assertEquals("Basic Constructor Test 2: All blank initialized values - City", "Atlanta", instance1.getAddressCity() );
		assertEquals("Basic Constructor Test 2: All blank initialized values - State", "GA", instance1.getAddressState() );
		assertEquals("Basic Constructor Test 2: All blank initialized values - County", "Fulton", instance1.getAddressCounty() );
		assertEquals("Basic Constructor Test 2: All blank initialized values - AddressID", 1, instance1.getAddressID() );
		assertEquals("Basic Constructor Test 2: All blank initialized values - Person", null, instance1.getPerson() );
		
		Address instance2 = new Address( "222 Church Street", "Augusta", "GA", "33333", "Test", null );
		
		assertEquals("Basic Constructor Test 3: All blank initialized values - Street", "222 Church Street", instance2.getAddressStreet() );
		assertEquals("Basic Constructor Test 3: All blank initialized values - City", "Augusta", instance2.getAddressCity() );
		assertEquals("Basic Constructor Test 3: All blank initialized values - State", "GA", instance2.getAddressState() );
		assertEquals("Basic Constructor Test 3: All blank initialized values - County", "Test", instance2.getAddressCounty() );
		assertEquals("Basic Constructor Test 3: All blank initialized values - AddressID", -1, instance2.getAddressID() );
		assertEquals("Basic Constructor Test 3: All blank initialized values - Person", null, instance2.getPerson() );
		
		instance0.setAddressID(22);
		instance0.setAddressStreet("1829 Spaight Street");
		instance0.setAddressCity("Madison");
		instance0.setAddressState("WI");
		instance0.setAddressPostalCode("53709");
		instance0.setAdressCounty("Dane");
		
		assertEquals("Basic Constructor Test 1: All blank initialized values - Street", "1829 Spaight Street", instance0.getAddressStreet() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - City", "Madison", instance0.getAddressCity() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - State", "WI", instance0.getAddressState() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - County", "Dane", instance0.getAddressCounty() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - AddressID", 22, instance0.getAddressID() );
		assertEquals("Basic Constructor Test 1: All blank initialized values - Person", null, instance0.getPerson() );
		
	}
	
	

}
