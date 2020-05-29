package pl.MechanicX.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.MechanicX.service.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
     
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("inputUsername");
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		String passwordConf = request.getParameter("inputPasswordConfirmation");
		String firstName = request.getParameter("inputFirstName");
		String middleName = request.getParameter("inputMiddleName");
		String lastName = request.getParameter("inputLastName");
		UserService userService = UserService.getInstance();
		
		if(!password.equals(passwordConf)) {
			request.setAttribute("errorMessage", "nie takie same has�a!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else {
			userService.addUser(username, email, password, firstName, middleName, lastName);
			response.sendRedirect("index.jsp?success=1");
		}
	}

}