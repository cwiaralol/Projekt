package pl.MechanicX.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.filters.ProductFilter;
import pl.MechanicX.service.xStatusService;

/**
 * Servlet implementation class OperationController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		xStatusService productService = xStatusService.getInstance();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
   		String command = request.getParameter("command");
   		session.setAttribute("command", command);
   		if(command == null) command = "";
		if(command.equals("filterProducts")) {
			filterProducts(request, response);
		} else {
			List<xStatus> statusx = productService.getAllProducts();
			session.setAttribute("statusxList", statusx);
	   		request.setAttribute("statusxList", statusx);
		}

   		request.getRequestDispatcher("operation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void filterProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchPhrase = request.getParameter("search");
		String parameter = request.getParameter("parameter");
		ProductFilter productFilter = new ProductFilter();
		request.setCharacterEncoding("UTF-8");
		if(parameter == null) parameter = "name";
		switch(parameter) {
		case "name": productFilter.filterProductsByName(request, response, searchPhrase);
			break;
		case "type": productFilter.filterProductsByType(request, response, searchPhrase);
			break;
		default: productFilter.filterProductsByName(request, response, searchPhrase);
		}
	}

}
