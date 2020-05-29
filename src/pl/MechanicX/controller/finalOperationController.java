package pl.MechanicX.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pl.MechanicX.beans.xActiv;
import pl.MechanicX.beans.xStatus;
import pl.MechanicX.beans.xOperation;
import pl.MechanicX.beans.User;
import pl.MechanicX.service.xActivService;
import pl.MechanicX.service.xControlService;
import pl.MechanicX.service.xStatusService;
import pl.MechanicX.service.xOperationService;

/**
 * Servlet implementation class finalOperationController
 */
@WebServlet("/finalOperation")
public class finalOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finalOperationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status_id = Integer.valueOf(request.getParameter("status_id"));
		xStatus status = xStatusService.getInstance().getProduct(status_id);
		HttpSession session = request.getSession();
		session.setAttribute("status", status);
		request.getRequestDispatcher("finalOperation.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		String control_type = request.getParameter("control_type");
		String garage = request.getParameter("garage");
		double total = (double) session.getAttribute("total");
		String mechanic_name =request.getParameter("mechanic");
		xStatus status = (xStatus)session.getAttribute("status");
		int status_id = status.getStatus_id();
		String description = status.getDescription();
		String address = request.getParameter("address");
		String email = request.getParameter("address");
		String id_uzytkownika = request.getParameter("id_uzytkownika");
		int idx=Integer.parseInt(id_uzytkownika);
		
		User user = (User)session.getAttribute("users");
		float charge = 0;
		
	
		
				
		
		xActivService.getInstance().addNewOrder(idx, description, total);
		List<xActiv> aktiv = xActivService.getInstance().getAllOrdersOfUser(user.getId());
		int orderId = 0;
		
		for(xActiv activs: aktiv) {
			if(activs.getTotal() == total) {
				orderId = activs.getOrderId();
			}
		}
		
		
		xControlService.getInstance().addXCont(control_type, idx, total, 1, 1, orderId);
				
		xOperationService.getInstance().addOper(orderId, idx,mechanic_name , address, garage, charge, description);
				
		session.setAttribute("orderId", orderId);
		session.setAttribute("mechanic_name", mechanic_name);
		
		int productQuantity = xStatusService.getInstance().getProduct(status_id).getQuantity();
		xStatusService.getInstance().updateOperation(status_id, "", productQuantity - 1, "", 0.0, "", "");
		request.getRequestDispatcher("endOperation.jsp").forward(request, response);
	}
		

	
	
}
