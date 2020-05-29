package pl.MechanicX.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.User;
import pl.MechanicX.service.UserCarService;
import pl.MechanicX.service.UserService;

/**
 * Servlet implementation class UserCarController
 */
@WebServlet("/UserCar")
public class UserCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		session.setAttribute("command", command);
		if(command.equals("updateUserCar")) {
		request.getRequestDispatcher("updateUserCar.jsp").forward(request, response);
		}else if(command.equals("addUserCar")) {
		request.getRequestDispatcher("addUserCar.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		session.setAttribute("command", command);
		int userId = ((User)session.getAttribute("users")).getId();
		String car_brand;
		String car_registration;
		String car_model;
		switch(command) {
		case "addUserCar": 
			car_brand = request.getParameter("cardNumber");
			car_model = request.getParameter("expirationDate");
			car_registration = request.getParameter("billingAddress");
			createUserCar(car_brand, car_model,car_registration, userId);
			session.setAttribute("user_UserINFO", UserCarService.getInstance().getUserCarByUserId(userId));
			response.sendRedirect(request.getContextPath() + "/profile");
			break;
		case "updateUserCar" : 
			car_brand = request.getParameter("car_brand");
			car_model =request.getParameter("car_model");
			car_registration = request.getParameter("car_registration");
			updateUserCar(car_brand, car_model,car_registration, userId);
			session.setAttribute("users", UserService.getInstance().getUserById(userId));
			session.setAttribute("user_UserINFO", UserCarService.getInstance().getUserCarByUserId(userId));
			response.sendRedirect(request.getContextPath() + "/profile");
			break;
		default:
			System.out.println("Not valid option in user car edit");
		}
	}

	private void updateUserCar(String car_brand, String car_model, String car_registration,int userId) {
		int UserCarId = UserCarService.getInstance().getUserCarByUserId(userId).getUser_car_id();
		UserCarService.getInstance().updateUserCar(UserCarId, car_brand, car_model,  car_registration);
	}

	private void createUserCar(String car_brand, String car_model, String car_registration,
			int userId) {
		UserCarService.getInstance().addUserCar(userId, car_brand, car_model, car_registration);
	}

}
