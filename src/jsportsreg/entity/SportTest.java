package jsportsreg.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SportTest {

	@Test
	public void test() {
		
		Sport instance0 = new Sport();
		
		assertEquals("Sport Test 1:  Sport ID", -1, instance0.getSportID() );
		assertEquals("Sport Test 1:  Sport Name", "", instance0.getSportName() );
		assertEquals("Sport Test 1:  Sport Description", "", instance0.getSportDescription() );
		assertEquals("Sport Test 1:  Divisions", true, instance0.getDivisions().isEmpty() );
		
		ArrayList<Division> dList = new ArrayList<Division>();
		Division division0 = new Division();
		Division division1 = new Division();
		
		dList.add(division0);
		dList.add(division1);
		
		Sport instance1 = new Sport( 1111111, "Mixed Martial Arts", "MMA", dList );
		
		assertEquals("Sport Test 2:  Sport ID", 1111111, instance1.getSportID() );
		assertEquals("Sport Test 2:  Sport Name", "MMA", instance1.getSportName() );
		assertEquals("Sport Test 2:  Sport Description", "Mixed Martial Arts", instance1.getSportDescription() );
		assertEquals("Sport Test 2:  Divisions", 2, instance1.getDivisions().size() );
		
		Division division2 = new Division();
		Division division3 = new Division();
		
		instance1.addDivision(division2);
		instance1.addDivision(division3);
		
		assertEquals("Sport Test 3:  Divisions", 4, instance1.getDivisions().size() );
		
		instance1.removeDivision(division2);
		
		assertEquals("Sport Test 4:  Divisions", 3, instance1.getDivisions().size() );
		
		instance0.setSportID(21212121);
		instance0.setSportName("Futball");
		instance0.setSportDescription("Soccer");
		instance0.addDivision(division3);
		
		assertEquals("Sport Test 5:  Sport ID", 21212121, instance0.getSportID() );
		assertEquals("Sport Test 5:  Sport Name", "Futball", instance0.getSportName() );
		assertEquals("Sport Test 5:  Sport Description", "Soccer", instance0.getSportDescription() );
		assertEquals("Sport Test 5:  Divisions", 1, instance0.getDivisions().size() );
		
		Sport instance2 = new Sport( 1111111, "Mixed Martial Arts", "MMA", dList );
		
		assertEquals("Sport Test 6:  Sport Equals", true, instance1.equals(instance2) );
	}

}
