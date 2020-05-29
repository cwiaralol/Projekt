package pl.MechanicX.controller;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.runtime.options.Options;
import pl.MechanicX.beans.xOperation;
import pl.MechanicX.beans.User;
import pl.MechanicX.service.xActivService;
import pl.MechanicX.service.xControlService;
import pl.MechanicX.service.xOperationService;

/**
 * Servlet implementation class CheckoutControllerFinale
 */
@WebServlet("/endOperation")
public class endOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int orderId;
	private String mechanic_name;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public endOperationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		User user = (User)session.getAttribute("users");
		orderId = (int)session.getAttribute("orderId");
		mechanic_name = (String) session.getAttribute("mechanic_name");
		String email = request.getParameter("email");

		String command = request.getParameter("command");
		if(command!=null) {
		session.setAttribute("command", command);
		
		if(command.equals("simulate")) {
		
		xOperation operation = xOperationService.getInstance().getShipmentByTrackingNumber(mechanic_name);
		xOperationService.getInstance().updateShipmentWithId(operation.getOperation_id(), "", "", "", "Send");
		int control_id = xControlService.getInstance().getPaymentForOrder(orderId).getControl_id();
		xControlService.getInstance().updatePayment(control_id, "Completed");
	
		sendMailToUser(email);
		response.sendRedirect(request.getContextPath() + "/home");
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void sendMailToUser(String email) { 
		// change accordingly 
		String to = email; 
		
		// change accordingly 
		String from = "mechanik_uz@wp.pl"; 
		
		// or IP address 
		String host = "smtp.wp.pl"; 
		
		// mail id 
		final String username = "mechanik_uz@wp.pl";
		
		// correct password for gmail id 
		final String password = "rootroot"; 

		System.out.println("TLSEmail Start"); 
		// Get the session object 
		
		// Get system properties 
		Properties properties = System.getProperties(); 
		
		// Setup mail server 
		properties.setProperty("mail.smtp.host", host); 
		
		// SSL Port 
		properties.put("mail.smtp.port", "465"); 
		
		// enable authentication 
		properties.put("mail.smtp.auth", "true"); 
		
		// SSL Factory 
		properties.put("mail.smtp.socketFactory.class", 
				"javax.net.ssl.SSLSocketFactory"); 

		// creating Session instance referenced to 
		// Authenticator object to pass in 
		// Session.getInstance argument 
		Session session = Session.getDefaultInstance(properties, 
			new javax.mail.Authenticator() { 
				
				// override the getPasswordAuthentication 
				// method 
				protected PasswordAuthentication 
						getPasswordAuthentication() { 
					return new PasswordAuthentication("mechanik_uz@wp.pl", "rootroot"); 
				} 
			}); 
//compose the message 
try { 
	// javax.mail.internet.MimeMessage class is mostly 
	// used for abstraction. 
	MimeMessage message = new MimeMessage(session); 
	
	// header field of the header. 
	message.setFrom(new InternetAddress(from)); 
	
	message.addRecipient(Message.RecipientType.TO, 
						new InternetAddress(to)); 
	message.setSubject("MechanicsX-STATUS"); 
	message.setText("Zmieni³ siê status twojej naprawy, sprawdz pod numerem naprawy " + orderId +" "+"na stronie internetowej"); 

	// Send message 
	Transport.send(message); 
	System.out.println("Mail send.."); 
} 
catch (MessagingException mex) { 
	mex.printStackTrace(); 
} 
} 
}
