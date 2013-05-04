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
		// Create RegistrationDBHelper object to interact with database
		RegistrationDBHelper rDBHelper = new RegistrationDBHelper();
		// Create Player_Registration object to store registration info
		Player_Registration pr = new Player_Registration();
		// Add player registration info to database
		//rDBHelper.addPlayer_Registration(pr);
    		    
    		    
    }

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

		
		// TODO set correct division based on birthDate
		Division division = new Division();


		/*
		 *  Convert birthDate String to Java Date
		 *  @author Adrian Robinson
		 */
		try {
			birthDate = new SimpleDateFormat("MM/dd/yy").parse(birth);
		} catch (ParseException e) {

			e.printStackTrace();
		}


		/*
		 *  Create a player Person object
		 *  @author Adrian Robinson
		 */
		Person player = new Person(personID, birthDate, pemailAddress,
				pfirstName, gender, phomePhone, plastName,
				middleName, "", nickName,
				"", suffixName, "", addresses, emergencyContacts,
				playerRegistrations);

		/*
		 *  Person object to be used with Player_Registration object
		 *  @author Adrian Robinson
		 */
		Person personreg = player;
		
		/*
		 * Address object to be used with @param player Person object
		 * @author Adrian Robinson
		 */
		
		Address playerAddress = new Address(-1, addressStreet, addressCity, addressState, 
				addressPostalCode, addressCounty, player);
		
		//player.addAddress(playerAddress);

		/*
		 *  Create a guardian 1 Person object
		 *  @author Adrian Robinson
		 */
		Person guardian1 = new Person(personID, birthDate, g1emailAddress,
				g1firstName, gender, g1homePhone, g1lastName,
				middleName, g1mobilePhone, nickName,
				g1role, suffixName, g1workPhone, addresses, emergencyContacts,
				playerRegistrations);
		
		//player.addEmergencyContact(guardian1);

		/*
		 *  Create a guardian 2 Person object
		 *  @author Adrian Robinson
		 */
		Person guardian2 = new Person(personID, birthDate, g2emailAddress,
				g2firstName, gender, g2homePhone, g2lastName,
				middleName, g2mobilePhone, nickName,
				g2role, suffixName, g2workPhone, addresses, emergencyContacts,
				playerRegistrations);

		//player.addEmergencyContact(guardian2);
		
		/*
		 *  Create a registration Player_Registration object
		 *  @author Adrian Robinson
		 */
		Player_Registration registration = new Player_Registration(registrationID, additionalPosition,
				balance, baseFee, byLawsAgreement, catchingExperience, catchingGear,
				codeOfConduct, discount, donation, fundraisingFee, hatSize, jersey1,
				jersey2, jerseySize, lateFee, liabilityWaiver, outOfCountyFee, pantSize,
				photoWaiver, pitchingExperience, primaryPosition, refundAmount, refundPolicy,
				seasonsPlayed, secondaryPosition, socksSize, totalFees, uniformCampFee,
				division, player);
		
		//Test block
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
		
		Division d0 = new Division(1, "Major 11 & 12 year olds", "Major 11 & 12 year olds", 
				seasonVerify1, sportVerify1, new ArrayList<Player_Registration>() );
		
		// Create Player Registration object
		Player_Registration pr0 = new Player_Registration();
		
		// Create Player Object
		Person p0 = new Person();
		
		// Add form data to Player object - WORKING
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
		
		// Create Address object
		Address addr0 = new Address();
		
		// Add form data to address object - WORKING
		addr0.setAddressStreet(addressStreet);
		addr0.setAddressCity(addressCity);
		addr0.setAddressState(addressState);
		addr0.setAddressPostalCode(addressPostalCode);
		addr0.setAddressCounty(addressCounty);
		
		// Associate address to player - WORKING
		p0.addAddress(addr0);
				
		// Create guardian 1
		Person p1 = new Person();
		
		// Add form data to guardian 1 object
		p1.setFirstName(g1firstName);
		p1.setLastName(g1lastName);
		p1.setRole(g1role);
		p1.setWorkPhone(g1workPhone);
		p1.setHomePhone(g1homePhone);
		p1.setMobilePhone(g1mobilePhone);
		p1.setEmailAddress(g1emailAddress);
		
		
		// Create guardian 2
		Person p2 = new Person();
		
		// Add form data to guardian 2 object
		p2.setFirstName(g2firstName);
		p2.setLastName(g2lastName);		
		p2.setRole(g2role);
		p2.setWorkPhone(g2workPhone);
		p2.setHomePhone(g2homePhone);
		p2.setMobilePhone(g2mobilePhone);
		p2.setEmailAddress(g2emailAddress);
		
		// Add guardian 1 and 2 to the player object - NOT WORKING
		p0.addEmergencyContact(p1);
		p0.addEmergencyContact(p2);
		
		// Add the player object to the registration object - NOT WORKING
		pr0.setPerson(p0);
		
		// Set the registration object attributes
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
		
		// Add the registration to the DB - NOT WORKING
		instance0.setPassPhrase("test123456");
		instance0.setPlayer_Registration(pr0);
		
		
		// Add player person object to DB
		//instance0.setPlayer_Registration(registration);

		/*
		 *  Send data to confirmation.jsp for display
		 *  @author Adrian Robinson
		 */

		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/confirmation.jsp");

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
		System.out.println("Player Info:");
		System.out.println(player.getFirstName());
		System.out.println(player.getMiddleName());
		System.out.println(player.getLastName());
		System.out.println(player.getSuffixName());
		System.out.println(player.getNickName());
		System.out.println(player.getGender());
		System.out.println(player.getBirthDate());
		System.out.println(player.getHomePhone());
		System.out.println("");

		System.out.println("Registration Info:");
		System.out.println(registration.getSeasonsPlayed());
		System.out.println(registration.getPrimaryPosition());
		System.out.println(registration.getSecondaryPosition());
		System.out.println(registration.getAdditionalPosition());
		System.out.println(registration.getPitchingExperience());
		System.out.println(registration.getCatchingExperience());
		System.out.println(registration.getCatchingGear());
		System.out.println(registration.getJerseySize());
		System.out.println(registration.getPantSize());
		System.out.println(registration.getSocksSize());
		System.out.println(registration.getHatSize());
		System.out.println(registration.getJersey1());
		System.out.println(registration.getJersey2());
		System.out.println("");

		System.out.println("Guardian 1 Info:");
		System.out.println(guardian1.getFirstName());
		System.out.println(guardian1.getLastName());
		System.out.println(guardian1.getHomePhone());
		System.out.println(guardian1.getWorkPhone());
		System.out.println(guardian1.getRole());
		System.out.println("");

		System.out.println("Guardian 2 Info:");
		System.out.println(guardian2.getFirstName());
		System.out.println(guardian2.getLastName());
		System.out.println(guardian2.getHomePhone());
		System.out.println(guardian2.getWorkPhone());
		System.out.println(guardian2.getRole());



	}
	
}
