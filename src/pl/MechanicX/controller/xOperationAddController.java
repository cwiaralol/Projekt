package pl.MechanicX.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.MechanicX.service.xStatusService;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/addOperationX")
public class xOperationAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xOperationAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addOperationX.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String status_name ="domyslne";
		int quantity =1;
		String type = "domyslne";
		String description = request.getParameter("description");
		String imageUrl = request.getParameter("imageUrl");
		
		xStatusService.getInstance().addOperationX(status_name, quantity, type, description, imageUrl, 1);
		response.sendRedirect(request.getContextPath() + "/controlPanel?command=controlOperation");
	}

}
