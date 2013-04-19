/**
 * Registration controller that sends requests to JSP pages or back to index.jsp
 * @author khsu - Katie
 */
package controller;

import jsportsreg.entity.*;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationController
 */
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
	
	}

}
