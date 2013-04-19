/**
 * Registration controller that sends requests to JSP pages or back to index.jsp
 * @author khsu - Katie
 */
package controller;

import entity.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegistrationController")

public class RegistrationController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * 
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    
    // Create a session object to store session information
  	HttpSession session = request.getSession();
		ServletContext ctx = this.getServletContext();
    
    // Get the parameters from request
    String ### = request.getParameter("###");
    
    // Create Player_Registration object to store registration info
    Player_Registration pr = new Player_Registration();
    
    
  }
  
}
