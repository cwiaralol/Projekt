package pl.MechanicX.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.service.xStatusService;

/**
 * Servlet implementation class updateOperationController
 */
@WebServlet("/updateOperation")
public class updateOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateOperationController() {
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
		xStatus status = xStatusService.getInstance().getProduct(Integer.valueOf(request.getParameter("status_id")));
		session.setAttribute("updateOperation", status);
		request.setAttribute("updateOperation", status);
		request.getRequestDispatcher("updateOperation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int status_id = (((xStatus)session.getAttribute("updateOperation")).getStatus_id());
		String status_name = request.getParameter("status_name");
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String imageUrl = request.getParameter("imageUrl");
		
		xStatusService.getInstance().updateOperation(status_id, status_name, quantity, type, description, imageUrl);
		response.sendRedirect(request.getContextPath() + "/controlPanel?command=controlOperation");
	}

}
