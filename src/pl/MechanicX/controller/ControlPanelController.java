package pl.MechanicX.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.xActiv;
import pl.MechanicX.beans.xControl;
import pl.MechanicX.beans.xStatus;
import pl.MechanicX.beans.xOperation;
import pl.MechanicX.beans.User;
import pl.MechanicX.filters.ProductFilter;
import pl.MechanicX.filters.UserFilter;
import pl.MechanicX.service.xActivService;
import pl.MechanicX.service.xControlService;
import pl.MechanicX.service.xStatusService;
import pl.MechanicX.service.xOperationService;
import pl.MechanicX.service.UserService;

/**
 * Servlet implementation class ControlPanelController
 */
@WebServlet("/controlPanel")
public class ControlPanelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = UserService.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlPanelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		request.setCharacterEncoding("UTF-8");
		if(command == null) command = "controlUsers";
		switch(command) {
		case "controlUsers": controlUsers(request, response);
			break;
		case "controlOperation": controlOperation(request, response);
			break;
		case "controlActivsX": controlActivsX(request, response);
			break;
		case "controlTOperation": controlTOperation(request, response);
			break;
		case "controlXControl": controlXControl(request, response);
			break;
		case "filterUsers": filterUsers(request, response);
			break;
		case "filterProducts": filterProducts(request, response);
			break;
		default: controlUsers(request, response);
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("users");
		
		session.setAttribute("command", command);
		
		if(user.getType().equals("admin")) {
			request.getRequestDispatcher("controlPanel.jsp").forward(request, response);
		}
		
		else if(user.getType().equals("mechanik")) {
			request.getRequestDispatcher("mControlPanel.jsp").forward(request, response);
		} 
		
		
		
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	
	}
	
	

	private void controlUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userService.getUserList();
		HttpSession session = request.getSession();
		session.setAttribute("userList", users);
   		request.setAttribute("userList", users);
   		System.out.println("Za³adowano liste u¿ytkowników przez u¿ytkownika " + ((User)session.getAttribute("users")).getUsername());
   		
	}

	private void controlOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		xStatusService status = xStatusService.getInstance();
		List<xStatus> statusx = status.getAllProducts();
		
		HttpSession session = request.getSession();
		session.setAttribute("statusxList", statusx);
   		request.setAttribute("statusxList", statusx);
   		
   		System.out.println("Za³adowano liste statusów przez u¿ytkownika " + ((User)session.getAttribute("users")).getUsername());
	}

	private void controlActivsX(HttpServletRequest request, HttpServletResponse response) {
		xActivService ActivsXService = xActivService.getInstance();
		List<xActiv> aktiv = ActivsXService.getAllOrders();
		HttpSession session = request.getSession();
		session.setAttribute("aktivList", aktiv);
   		request.setAttribute("aktivList", aktiv);
   		System.out.println("Za³adowano liste aktywnoœci przez u¿ytkownika " + ((User)session.getAttribute("users")).getUsername());
	}

	private void controlTOperation(HttpServletRequest request, HttpServletResponse response) {
		xOperationService controlT = xOperationService.getInstance();
		List<xOperation> controlst = controlT.getAllShipments();
		HttpSession session = request.getSession();
		session.setAttribute("controlstList", controlst);
   		request.setAttribute("controlstList", controlst);
   		System.out.println("Za³adowano liste dostaw przez u¿ytkownika " + ((User)session.getAttribute("users")).getUsername());
	}

	private void controlXControl(HttpServletRequest request, HttpServletResponse response) {
		xControlService control = xControlService.getInstance();
		List<xControl> kontrols = control.getAllPayments();
		HttpSession session = request.getSession();
		session.setAttribute("kontrolsList", kontrols);
   		request.setAttribute("kontrolsList", kontrols);
   		System.out.println("Za³adowano liste kontroli przez u¿ytkownika " + ((User)session.getAttribute("users")).getUsername());
	}

	private void filterUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchPhrase = request.getParameter("search");
		String parameter = request.getParameter("parameter");
		UserFilter userFilter = new UserFilter();
		if(searchPhrase.isEmpty()) {
			controlUsers(request, response);
		} else {
		
		if(parameter == null) parameter = "username";
		switch(parameter) {
		case "id": userFilter.filterUsersById(request, response, searchPhrase);
			break;
		case "username": userFilter.filterUsersByUsername(request, response, searchPhrase);
			break;
		case "email": userFilter.filterUsersByEmail(request, response, searchPhrase);
			break;
		case "fristName": userFilter.filterUsersByFirstName(request, response, searchPhrase);
			break;
		case "lastName": userFilter.filterUsersByLastName(request, response, searchPhrase);
			break;
		case "active": userFilter.filterUsersByStatus(request, response, searchPhrase);
			break;
		default: userFilter.filterUsersByUsername(request, response, searchPhrase);
		}
		}
	}
	
	private void filterProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchPhrase = request.getParameter("search");
		String parameter = request.getParameter("parameter");
		ProductFilter productFilter = new ProductFilter();
		if(searchPhrase.isEmpty()) {
			controlOperation(request, response);
		} else {
		
		if(parameter == null) parameter = "name";
		switch(parameter) {
		case "id": productFilter.filterProductsById(request, response, searchPhrase);
			break;
		case "name": productFilter.filterProductsByName(request, response, searchPhrase);
			break;
		case "type": productFilter.filterProductsByType(request, response, searchPhrase);
			break;
		default: productFilter.filterProductsByName(request, response, searchPhrase);
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");
		int userId = Integer.valueOf(request.getParameter("userId"));
		if(command == null) command = "blockUser";
		switch(command) {
		case "blockUser": blockUser(request, response, userId);
			break;
		case "activateUser" : activateUser(request, response, userId);
			break;
		default: blockUser(request, response, userId);
		}
	}

	private void activateUser(HttpServletRequest request, HttpServletResponse response, int userId) throws IOException {
		userService.unblockUser(userId);
		response.sendRedirect(request.getContextPath() + "/controlPanel");
	}

	private void blockUser(HttpServletRequest request, HttpServletResponse response, int userId) throws IOException {
		userService.blockUser(userId);
		response.sendRedirect(request.getContextPath() + "/controlPanel");
	}

}
