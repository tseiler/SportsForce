/**
 * Registration controller that sends requests to JSP pages or back to index.jsp
 * @author khsu - Katie
 * @author Adrian
 */
package jsportsreg.controller;

import jsportsreg.entity.*;

import java.io.IOException;

import jsportsreg.entity.*;
import jsportsreg.helper.RegistrationDBHelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		String ### = request.getParameter("###");
    		    
		String %%% = request.getParameter("###");
		if (%%% != null && (%%% = %%%.trim()).length() != 0) {
    		    	
		}
    		    
		// Create RegistrationDBHelper object to interact with database
		RegistrationDBHelper rDBHelper = new RegistrationDBHelper();
		// Create Player_Registration object to store registration info
		Player_Registration pr = new Player_Registration();
		// Add player registration info to database
		rDBHelper.addPlayer_Registration(pr);
    		    
    		    
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
		double donation = Double.parseDouble(request.getParameter("donation"));
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
		String socksSize = request.getParameter("sockSize");
		double totalFees = 185.00;
		double uniformCampFee = 0.00;

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
		Person player =new Person(personID, birthDate, pemailAddress,
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
		 *  Create a guardian 1 Person object
		 *  @author Adrian Robinson
		 */
		Person guardian1 = new Person(personID, birthDate, g1emailAddress,
				g1firstName, gender, g1homePhone, g1lastName,
				middleName, g1mobilePhone, nickName,
				g1role, suffixName, g1workPhone, addresses, emergencyContacts,
				playerRegistrations);

		/*
		 *  Create a guardian 2 Person object
		 *  @author Adrian Robinson
		 */
		Person guardian2 = new Person(personID, birthDate, g2emailAddress,
				g2firstName, gender, g2homePhone, g2lastName,
				middleName, g2mobilePhone, nickName,
				g2role, suffixName, g2workPhone, addresses, emergencyContacts,
				playerRegistrations);

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
				division, personreg);

		// TODO Add address and contact code

		/*
		 *  Send data to confirmation.jsp for display
		 *  @author Adrian Robinson
		 */

		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/confirmation.jsp");

		request.setAttribute("pfirstName", pfirstName);
		request.setAttribute("middleName", middleName);
		request.setAttribute("plastName", plastName);
		request.setAttribute("pitcherExp", pitchingExperience);
		request.setAttribute("catcherExp", catchingExperience);
		request.setAttribute("priPos", primaryPosition);
		request.setAttribute("secPos", secondaryPosition);
		request.setAttribute("seasons", seasonsPlayed);


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
