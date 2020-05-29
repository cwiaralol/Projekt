package pl.MechanicX.controller;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.beans.User;
import pl.MechanicX.service.CartService;
import pl.MechanicX.service.xStatusService;
 
@WebListener
public class SessionController implements HttpSessionListener  {
	
	 @Override
	  public void sessionCreated(HttpSessionEvent se) {
	      HttpSession session = se.getSession();
	      session.setMaxInactiveInterval(900);
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent se) {
		  HttpSession session = se.getSession();
		  User user = (User)session.getAttribute("users");
		  if(user != null) {
	      System.out.println("sesja  " + user.getUsername() + " skoñczona");
	      CartService cartService = CartService.getInstance();
	      xStatusService productService = xStatusService.getInstance();
	      
			@SuppressWarnings("unchecked")
			List<xStatus> statusx = ((List<xStatus>)session.getAttribute("cart"));
			
			if(statusx != null) {
			for(xStatus status: statusx) {		
				cartService.deleteItemFromUserCart(status.getStatus_id(), user.getId());
				productService.updateOperation(status.getStatus_id(),"", productService.getProduct(status.getStatus_id()).getQuantity() + status.getQuantity(), "", 0.0, "", "");
			}
			System.out.println("Removed producuts from cart of user " + user.getUsername());
			}
			
		  }
	  }
}