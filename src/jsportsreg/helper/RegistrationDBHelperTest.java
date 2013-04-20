package jsportsreg.helper;


import jsportsreg.entity.*;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;
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

}
