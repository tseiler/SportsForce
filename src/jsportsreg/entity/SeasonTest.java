package jsportsreg.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class SeasonTest {

	@Test
	public void testSeason() throws Exception{
	
		/**
		 * Test the basic Season constructor and getters.
		 */
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		
		Season instance0 = new Season();
		
		Date startDate0 = df.parse("1-1-1900");
		Date endDate0 = df.parse("1-1-1900");
		
		assertEquals("Season Test 1:  Season ID", -1, instance0.getSeasonID() );
		assertEquals("Season Test 1:  Season ID", "", instance0.getSeasonName() );
		assertEquals("Season Test 1:  startDate", startDate0, instance0.getSeasonStartDate() );
		assertEquals("Season Test 1:  endDate", endDate0, instance0.getSeasonEndDate() );
		assertEquals("Season Test 1:  Divisions", true, instance0.getDivisions().isEmpty() );
		
		Date startDate1 = df.parse("1-1-2013");
		Date endDate1 = df.parse("5-1-2013");
		ArrayList<Division> dList = new ArrayList<Division>();
		Division division0 = new Division();
		dList.add(division0);
		
		Season instance1 = new Season( 2013, endDate1, "Spring 2013", startDate1, dList );
		
		assertEquals("Season Test 2:  Season ID", 2013, instance1.getSeasonID() );
		assertEquals("Season Test 2:  Season ID", "Spring 2013", instance1.getSeasonName() );
		assertEquals("Season Test 2:  startDate", startDate1, instance1.getSeasonStartDate() );
		assertEquals("Season Test 2:  endDate", endDate1, instance1.getSeasonEndDate() );
		assertEquals("Season Test 2:  Divisions", 1, instance1.getDivisions().size() );
		
		/**
		 * Testing setters and validity.
		 */
		
		Date startDate2 = df.parse("6-1-2013");
		Date endDate2 = df.parse("1-1-2013");
		Division division1 = new Division();
		dList.add(division1);
		
		instance0.setSeasonID(2121);
		instance0.setSeasonName("Summer 2013");
		instance0.setSeasonStartDate(startDate2);
		instance0.setSeasonEndDate(endDate2);
		instance0.setDivisions(dList);
		
		assertEquals("Season Test 3:  Season ID", 2121, instance0.getSeasonID() );
		assertEquals("Season Test 3:  Season ID", "Summer 2013", instance0.getSeasonName() );
		assertEquals("Season Test 3:  startDate", startDate2, instance0.getSeasonStartDate() );
		assertEquals("Season Test 3:  endDate", endDate2, instance0.getSeasonEndDate() );
		assertEquals("Season Test 3:  Divisions", 2, instance0.getDivisions().size() );
		
	}

}
