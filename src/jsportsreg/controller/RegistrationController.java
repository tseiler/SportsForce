/**
 * Registration controller that sends requests to JSP pages or back to index.jsp
 * @author khsu - Katie
 * @author Adrian Robinson
 */
package jsportsreg.controller;

import jsportsreg.entity.*;
import jsportsreg.helper.RegistrationDBHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public RegistrationController() {
	        super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    		    
		// Create a session object to store session information
		HttpSession session = request.getSession();
		ServletContext ctx = this.getServletContext();
    		    
		// Get the parameters from request
		/*
		String ### = request.getParameter("###");
    		    
		String %%% = request.getParameter("###");
		if (%%% != null && (%%% = %%%.trim()).length() != 0) {
    		    	
		}
    	*/    
			
		/*
		 * Retrieve player registration data for the update.jsp page
		 * @author Adrian Robinson
		 */
		
		// Retrieve player registration
		RegistrationDBHelper instance1 = new RegistrationDBHelper();
		instance1.setPassPhrase("test123456");
		instance1.setRegistrationID(Integer.parseInt(request.getParameter("registrationID")));
		
		// Set request parameters to send to response
		
		ServletContext ctx1 = this.getServletContext();
		RequestDispatcher dispatcher = ctx1.getRequestDispatcher("/update.jsp");

		request.setAttribute("registrationID", request.getParameter("registrationID"));
		request.setAttribute("pfirstName", instance1.getPlayer_Registration().getPerson().getFirstName());
		request.setAttribute("middleName", instance1.getPlayer_Registration().getPerson().getMiddleName());
		request.setAttribute("plastName", instance1.getPlayer_Registration().getPerson().getLastName());
		request.setAttribute("suffix", instance1.getPlayer_Registration().getPerson().getSuffixName());
		request.setAttribute("nickName", instance1.getPlayer_Registration().getPerson().getNickName());
		request.setAttribute("gender", instance1.getPlayer_Registration().getPerson().getGender());
		request.setAttribute("birth", instance1.getPlayer_Registration().getPerson().getBirthDate());
		request.setAttribute("phomePhone", instance1.getPlayer_Registration().getPerson().getHomePhone());
		request.setAttribute("street", instance1.getPlayer_Registration().getPerson().getAddresses().get(0).getAddressStreet());
		request.setAttribute("city", instance1.getPlayer_Registration().getPerson().getAddresses().get(0).getAddressCity());
		request.setAttribute("state", instance1.getPlayer_Registration().getPerson().getAddresses().get(0).getAddressState());
		request.setAttribute("county", instance1.getPlayer_Registration().getPerson().getAddresses().get(0).getAddressCounty());
		request.setAttribute("zipCode", instance1.getPlayer_Registration().getPerson().getAddresses().get(0).getAddressPostalCode());
		
		request.setAttribute("seasons", instance1.getPlayer_Registration().getSeasonsPlayed());
		request.setAttribute("priPos", instance1.getPlayer_Registration().getPrimaryPosition());
		request.setAttribute("secPos", instance1.getPlayer_Registration().getSecondaryPosition());
		request.setAttribute("addPos", instance1.getPlayer_Registration().getAdditionalPosition());
		request.setAttribute("pitcherExp", instance1.getPlayer_Registration().getPitchingExperience());
		request.setAttribute("catcherExp", instance1.getPlayer_Registration().getCatchingExperience());
		request.setAttribute("catcherGear", instance1.getPlayer_Registration().getCatchingGear());
		request.setAttribute("jerseySize", instance1.getPlayer_Registration().getJerseySize());
		request.setAttribute("pantSize", instance1.getPlayer_Registration().getPantSize());
		request.setAttribute("socksSize", instance1.getPlayer_Registration().getSocksSize());
		request.setAttribute("hatSize", instance1.getPlayer_Registration().getHatSize());
		request.setAttribute("jersey1", instance1.getPlayer_Registration().getJersey1());
		request.setAttribute("jersey2", instance1.getPlayer_Registration().getJersey2());
		
		// Get registration's player record, then retrieve emergency contacts, if any
		if (!instance1.getPlayer_Registration().getPerson().getEmergencyContacts().isEmpty()) {
			request.setAttribute("g1firstName", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getFirstName());
			request.setAttribute("g1lastName", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getLastName());
			request.setAttribute("g1homePhone", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getHomePhone());
			request.setAttribute("g1workPhone", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getWorkPhone());
			request.setAttribute("g1mobilePhone", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getMobilePhone());
			request.setAttribute("g1emailAddress", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getEmailAddress());
			request.setAttribute("g1role", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(0).getRole());
			request.setAttribute("g2firstName", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getFirstName());
			request.setAttribute("g2lastName", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getLastName());
			request.setAttribute("g2homePhone", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getHomePhone());
			request.setAttribute("g2workPhone", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getWorkPhone());
			request.setAttribute("g2mobilePhone", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getMobilePhone());
			request.setAttribute("g2emailAddress", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getEmailAddress());
			request.setAttribute("g2role", instance1.getPlayer_Registration().getPerson().getEmergencyContacts().get(1).getRole());
			//request.setAttribute("donation", d.format(donation));			
		} // end of if

		dispatcher.forward(request,response);    		    
    } // end of doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 *  Person form data for player, guardian1, and guardian2 objects
		 *  @author Adrian Robinson
		 */
		int personID = 0;
		Date birthDate = new Date();
		String birth = request.getParameter("month")+"/"+request.getParameter("day")+"/"+request.getParameter("year");
		String g1emailAddress = request.getParameter("g1emailAddress");
		String g2emailAddress = request.getParameter("g2emailAddress");
		String pemailAddress = request.getParameter("pemailAddress");
		String pfirstName = request.getParameter("pfirstName");
		String middleName = request.getParameter("middleName");
		String plastName = request.getParameter("plastName");
		String g1firstName = request.getParameter("g1firstName");
		String g2firstName = request.getParameter("g2firstName");
		String g1lastName = request.getParameter("g1lastName");
		String g2lastName = request.getParameter("g2lastName");
		String gender = request.getParameter("gender");
		String phomePhone  = request.getParameter("parea")+"-"+request.getParameter("pphone1")+"-"+request.getParameter("pphone2");
		String g1homePhone  = request.getParameter("g1area")+"-"+request.getParameter("g1phone1")+"-"+request.getParameter("g1phone2");
		String g2homePhone  = request.getParameter("g2area")+"-"+request.getParameter("g2phone1")+"-"+request.getParameter("g2phone2");		
		String g1mobilePhone = request.getParameter("g1marea")+"-"+request.getParameter("g1mphone1")+"-"+request.getParameter("g1mphone2");
		String g2mobilePhone = request.getParameter("g2marea")+"-"+request.getParameter("g2mphone1")+"-"+request.getParameter("g2mphone2");
		String nickName = request.getParameter("nickName");
		String g1role = request.getParameter("g1role");
		String g2role = request.getParameter("g2role");
		String suffixName = request.getParameter("suffix");
		String g1workPhone = request.getParameter("g1warea")+"-"+request.getParameter("g1wphone1")+"-"+request.getParameter("g1wphone2");
		String g2workPhone = request.getParameter("g2marea")+"-"+request.getParameter("g2mphone1")+"-"+request.getParameter("g2mphone2");
		List<Address> addresses = null; 
		List<Person> emergencyContacts = null;
		List<Player_Registration> playerRegistrations = null;
		
		/*
		 * Address form data
		 * @author Adrian Robinson
		 */
		
		String addressStreet = request.getParameter("street");
		String addressCity = request.getParameter("city");
		String addressState = request.getParameter("state");
		String addressPostalCode = request.getParameter("zipCode");
		String addressCounty = request.getParameter("county");
		
		
		/*
		 *  Player_Registration form data
		 *  @author Adrian Robinson
		 */
		int registrationID = 1;
		String additionalPosition = request.getParameter("addPos");
		double balance = 185.00;
		double baseFee = 185.00;
		boolean byLawsAgreement = Boolean.parseBoolean(request.getParameter("byLaws"));
		boolean catchingExperience = Boolean.parseBoolean(request.getParameter("catcherExp"));
		boolean catchingGear = Boolean.parseBoolean(request.getParameter("catcherGear"));
		boolean codeOfConduct = Boolean.parseBoolean(request.getParameter("codeConduct"));
		double discount = 0.00;
		double donation = 0.00;
		double fundraisingFee = 0.00;
		String hatSize = request.getParameter("hatSize");
		int jersey1 = Integer.parseInt(request.getParameter("jersey1"));
		int jersey2 = Integer.parseInt(request.getParameter("jersey2"));
		String jerseySize = request.getParameter("jerseySize");
		double lateFee = 0.00;
		boolean liabilityWaiver = Boolean.parseBoolean(request.getParameter("liability"));
		double outOfCountyFee = 50.00;
		String pantSize = request.getParameter("pantSize");
		boolean photoWaiver = Boolean.parseBoolean(request.getParameter("photo"));
		boolean pitchingExperience = Boolean.parseBoolean(request.getParameter("pitcherExp"));
		String primaryPosition = request.getParameter("priPos");
		double refundAmount = 0.00;
		boolean refundPolicy = Boolean.parseBoolean(request.getParameter("refundPolicy"));
		int seasonsPlayed = Integer.parseInt(request.getParameter("seasons"));
		String secondaryPosition = request.getParameter("secPos");
		String socksSize = request.getParameter("socksSize");
		double totalFees = 185.00;
		double uniformCampFee = 0.00;
		
		// Used to display donation values in dollar currency
		DecimalFormat d = new DecimalFormat("'$'0.00");
		
		// Handle Other donation values
		if (request.getParameter("donation").matches("other"))
			donation = Double.parseDouble(request.getParameter("dother"));
		else
			donation = Double.parseDouble(request.getParameter("donation"));

		
		/*
		 *  Convert birthDate String to Java Date
		 *  @author Adrian Robinson
		 */
		
		try {
			birthDate = new SimpleDateFormat("MM/dd/yy").parse(birth);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		
		// Add Registration DBHelper code
		RegistrationDBHelper instance0 = new RegistrationDBHelper();
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		
		Date tDate1 = null;
		try {
			tDate1 = df.parse("6-1-2013");
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Date tDate2 = null;
		try {
			tDate2 = df.parse("8-30-2013");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
				
		Season seasonVerify1 = new Season(789670000, tDate2, "Summer 2013", tDate1, new ArrayList<Division>() );
				
		Sport sportVerify1 = new Sport(123233000, "Baseball", "Baseball", new ArrayList<Division>() );
		
		/*
		 *  Determine Age Group from birthDate
		 *  @author Adrian Robinson
		 */
		String ageGroup = "";
		int divId = 0;
		
		try {
			
			if (birthDate.after(new SimpleDateFormat("MM/dd/yy").parse("04/30/2006")) && birthDate.before(new SimpleDateFormat("MM/dd/yy").parse("05/01/2008"))) {
				ageGroup = "Tball 5 & 6 year olds";
				divId = 5;
			}
				
			else if (birthDate.after(new SimpleDateFormat("MM/dd/yy").parse("04/30/2004")) && birthDate.before(new SimpleDateFormat("MM/dd/yy").parse("05/01/2006"))) {
				ageGroup = "PeeWee 7 & 8 year olds";
				divId = 9;				
			}
				
			else if (birthDate.after(new SimpleDateFormat("MM/dd/yy").parse("04/30/2002")) && birthDate.before(new SimpleDateFormat("MM/dd/yy").parse("05/01/2004"))) {
				ageGroup = "Minor 9 & 10 year olds";
				divId = 4;
			}
				
			else if (birthDate.after(new SimpleDateFormat("MM/dd/yy").parse("04/30/2000")) && birthDate.before(new SimpleDateFormat("MM/dd/yy").parse("05/01/2002"))) {
				ageGroup = "Major 11 & 12 year olds";
				divId = 1;
			}
				
			else if (birthDate.after(new SimpleDateFormat("MM/dd/yy").parse("04/30/1998")) && birthDate.before(new SimpleDateFormat("MM/dd/yy").parse("05/01/2000"))) {
				ageGroup = "Pony 13 & 14 year olds";
				divId = 12;
			}
				
			else {
				ageGroup = "Seniors 15 thru 18 year olds";
				divId = 8;
			}
				
		} // end of try
		
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Create Division object for Player_Registration
		Division d0 = new Division(divId, ageGroup, ageGroup, seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() );
			
		
		// Create Player Registration object
		Player_Registration pr0 = new Player_Registration();
		
		/*
		 *  Person object to be used with Player_Registration object
		 *  @author Adrian Robinson
		 */
		
		// Create Player Object
		Person p0 = new Person();
		
		// Add form data to Player object
		p0.setFirstName(pfirstName);
		p0.setMiddleName(middleName);
		p0.setLastName(plastName);
		p0.setSuffixName(suffixName);
		p0.setNickName(nickName);
		p0.setBirthDate(birthDate);
		p0.setGender(gender);
		p0.setRole("Player");
		p0.setWorkPhone("404-555-1234");
		p0.setHomePhone(phomePhone);
		p0.setMobilePhone("404-555-4321");
		p0.setEmailAddress(pemailAddress);
		
		/*
		 * Address object to be used with @param player Person object
		 * @author Adrian Robinson
		 */
		
		// Create Address object
		Address addr0 = new Address();
		
		// Add form data to address object
		addr0.setAddressStreet(addressStreet);
		addr0.setAddressCity(addressCity);
		addr0.setAddressState(addressState);
		addr0.setAddressPostalCode(addressPostalCode);
		addr0.setAddressCounty(addressCounty);
		
		// Associate address to player
		p0.addAddress(addr0);
				
				
		/*
		 *  Create guardian 1
		 *  Add form data to guardian 1 object
		 *  @author Adrian Robinson
		 */
		
		Person p1 = new Person();
				
		p1.setFirstName(g1firstName);
		p1.setLastName(g1lastName);
		p1.setRole(g1role);
		p1.setWorkPhone(g1workPhone);
		p1.setHomePhone(g1homePhone);
		p1.setMobilePhone(g1mobilePhone);
		p1.setEmailAddress(g1emailAddress);
		
		// Set correct contact gender if Parent, use "Other" for Guardian
		
		if (g1role.matches("Father"))
			p1.setGender("Male");
		else if (g1role.matches("Mother"))
			p1.setGender("Female");
		else
			p1.setGender("Other");
		
		/*
		 *  Create guardian 2
		 *  Add form data to guardian 2 object
		 *  @author Adrian Robinson
		 */
		Person p2 = new Person();
		
		// Add form data to guardian 2 object
		p2.setFirstName(g2firstName);
		p2.setLastName(g2lastName);		
		p2.setRole(g2role);
		p2.setWorkPhone(g2workPhone);
		p2.setHomePhone(g2homePhone);
		p2.setMobilePhone(g2mobilePhone);
		p2.setEmailAddress(g2emailAddress);
		
		/*
		 *  Set correct contact gender if Parent, use "Other" for Guardian
		 *  @author Adrian Robinson
		 */
		
		if (g2role.matches("Father"))
			p2.setGender("Male");
		else if (g2role.matches("Mother"))
			p2.setGender("Female");
		else
			p2.setGender("Other");
		
		// Add guardian 1 and 2 to the player object
		p0.addEmergencyContact(p1);
		p0.addEmergencyContact(p2);
		
		// Add the player object to the registration object
		pr0.setPerson(p0);
		
		/*
		 *  Set the registration object attributes
		 *  @author Adrian Robinson
		 */
	
		pr0.setDivision(d0);
		pr0.setAdditionalPosition(additionalPosition);
		pr0.setBalance(500.00);
		pr0.setBaseFee(200.00);
		pr0.setByLawsAgreement(byLawsAgreement);
		pr0.setCatchingExperience(catchingExperience);
		pr0.setCatchingGear(catchingGear);
		pr0.setCodeOfConduct(codeOfConduct);
		pr0.setDiscount(15.00);
		pr0.setDonation(55.00);
		pr0.setFundraisingFee(35.00);
		pr0.setHatSize(hatSize);
		pr0.setJersey1(jersey1);
		pr0.setJersey2(jersey2);
		pr0.setJerseySize(jerseySize);
		pr0.setLateFee(2.00);
		pr0.setLiabilityWaiver(liabilityWaiver);
		pr0.setOutOfCountyFee(20.00);
		pr0.setPantSize(pantSize);
		pr0.setPhotoWaiver(photoWaiver);
		pr0.setPitchingExperience(pitchingExperience);
		pr0.setPrimaryPosition(primaryPosition);
		pr0.setRefundAmount(0.00);
		pr0.setRefundPolicy(refundPolicy);
		pr0.setSeasonsPlayed(seasonsPlayed);
		pr0.setSecondaryPosition(secondaryPosition);
		pr0.setSocksSize(socksSize);
		pr0.setTotalFees(325.00);
		pr0.setUniformCampFee(25.50);
		
		// Add the registration to the DB
		instance0.setPassPhrase("test123456");
		instance0.setPlayer_Registration(pr0);
		registrationID = instance0.getRegistrationID();
		
		if (nickName != "")
			nickName = "(" + nickName + ")";
		
		/*
		 *  Send data to confirmation.jsp for display
		 *  @author Adrian Robinson
		 */

		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/confirmation.jsp");

		request.setAttribute("registrationID", registrationID);
		request.setAttribute("pfirstName", pfirstName);
		request.setAttribute("middleName", middleName);
		request.setAttribute("plastName", plastName);
		request.setAttribute("suffix", suffixName);
		request.setAttribute("nickName", nickName);
		request.setAttribute("gender", gender);
		request.setAttribute("birth", birth);
		request.setAttribute("phomePhone", phomePhone);
		request.setAttribute("street", addressStreet);
		request.setAttribute("city", addressCity);
		request.setAttribute("state", addressState);
		request.setAttribute("county", addressCounty);
		request.setAttribute("zipCode", addressPostalCode);
		
		request.setAttribute("seasons", seasonsPlayed);
		request.setAttribute("priPos", primaryPosition);
		request.setAttribute("secPos", secondaryPosition);
		request.setAttribute("addPos", additionalPosition);
		request.setAttribute("pitcherExp", pitchingExperience);
		request.setAttribute("catcherExp", catchingExperience);
		request.setAttribute("catcherGear", catchingGear);
		request.setAttribute("jerseySize", jerseySize);
		request.setAttribute("pantSize", pantSize);
		request.setAttribute("socksSize", socksSize);
		request.setAttribute("hatSize", hatSize);
		request.setAttribute("jersey1", jersey1);
		request.setAttribute("jersey2", jersey2);
		
		request.setAttribute("g1firstName", g1firstName);
		request.setAttribute("g1lastName", g1lastName);
		request.setAttribute("g1homePhone", g1homePhone);
		request.setAttribute("g1workPhone", g1workPhone);
		request.setAttribute("g1mobilePhone", g1mobilePhone);
		request.setAttribute("g1emailAddress", g1emailAddress);
		request.setAttribute("g1role", g1role);
		request.setAttribute("g2firstName", g2firstName);
		request.setAttribute("g2lastName", g2lastName);
		request.setAttribute("g2homePhone", g2homePhone);
		request.setAttribute("g2workPhone", g2workPhone);
		request.setAttribute("g2mobilePhone", g2mobilePhone);
		request.setAttribute("g2emailAddress", g2emailAddress);
		request.setAttribute("g2role", g2role);
		request.setAttribute("donation", d.format(donation));


		dispatcher.forward(request,response);

		/*
		 *   Debug console output
		 */
		
		System.out.println("Confirmation Number: " + registrationID);
		System.out.println("Player Info:");
		System.out.println(p0.getFirstName());
		System.out.println(p0.getMiddleName());
		System.out.println(p0.getLastName());
		System.out.println(p0.getSuffixName());
		System.out.println(p0.getNickName());
		System.out.println(p0.getGender());
		System.out.println(p0.getBirthDate());
		System.out.println(p0.getHomePhone());
		System.out.println("");

		System.out.println("Registration Info:");
		System.out.println(pr0.getSeasonsPlayed());
		System.out.println(pr0.getPrimaryPosition());
		System.out.println(pr0.getSecondaryPosition());
		System.out.println(pr0.getAdditionalPosition());
		System.out.println(pr0.getPitchingExperience());
		System.out.println(pr0.getCatchingExperience());
		System.out.println(pr0.getCatchingGear());
		System.out.println(pr0.getJerseySize());
		System.out.println(pr0.getPantSize());
		System.out.println(pr0.getSocksSize());
		System.out.println(pr0.getHatSize());
		System.out.println(pr0.getJersey1());
		System.out.println(pr0.getJersey2());
		System.out.println("");

		System.out.println("Guardian 1 Info:");
		System.out.println(p1.getFirstName());
		System.out.println(p1.getLastName());
		System.out.println(p1.getHomePhone());
		System.out.println(p1.getWorkPhone());
		System.out.println(p1.getRole());
		System.out.println("");

		System.out.println("Guardian 2 Info:");
		System.out.println(p2.getFirstName());
		System.out.println(p2.getLastName());
		System.out.println(p2.getHomePhone());
		System.out.println(p2.getWorkPhone());
		System.out.println(p2.getRole());
		
		System.out.println(ageGroup);
		System.out.println(divId);
		
	}
	
}
