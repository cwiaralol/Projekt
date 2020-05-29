package pl.MechanicX.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.User;
import pl.MechanicX.service.UserCarService;
import pl.MechanicX.service.UserService;
import pl.MechanicX.util.Authenticator;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		UserService userService = UserService.getInstance();
		UserCarService UserCarServie = UserCarService.getInstance();
		boolean result = Authenticator.authenticate(username, password);
		boolean isActive = userService.getUserByUsername(username).isActive();
		HttpSession session = request.getSession();		
		
		if (result && isActive) {
			User user = userService.getUserByUsername(username);
			User_Car user_User_Car = UserCarServie.getUserCarByUserId(user.getId());		
			System.out.println("Zalogowa³ siê u¿ytkownik: " + user);
			session.setAttribute("users", user);
			request.setAttribute("users", user);

			
			if(UserCarService.getInstance().getUserCarByUserId(user.getId()).getUser_car_id() > 0) {
			session.setAttribute("user_UserINFO", user_User_Car);
	   		request.setAttribute("user_UserINFO", user_User_Car);
			}
	   		response.sendRedirect(request.getContextPath());
		} else if(isActive){
			session.invalidate();
			request.setAttribute("errorMessage", "b³êdne dane logowania!");
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
		} else if(userService.getUserByUsername(username) != null && isActive == false){
			session.invalidate();
			request.setAttribute("errorMessage", "u¿ytkownik nie istnieje!");
			request.getRequestDispatcher("/login.jsp").forward(request, response); 
		}	
	}	
}