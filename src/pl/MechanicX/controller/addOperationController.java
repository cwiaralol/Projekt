package pl.MechanicX.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.service.xStatusService;

/**
 * Servlet implementation class addOperationController
 */
@WebServlet("/addOperation")
public class addOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOperationController() {
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
		int status_id = Integer.valueOf(request.getParameter("status_id"));
		xStatus status = xStatusService.getInstance().getProduct(status_id);
		status.setQuantity(1);
		List<xStatus> statusx = new ArrayList<xStatus>();
    	statusx.add(status);
    	
    	session.setAttribute("status", statusx);
   		request.setAttribute("status", statusx);
   		
   		request.getRequestDispatcher("addOperation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
