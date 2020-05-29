package pl.MechanicX.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.beans.User;
import pl.MechanicX.service.CartService;
import pl.MechanicX.service.xStatusService;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	CartService cartService = CartService.getInstance();
   	xStatusService productService = xStatusService.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
    	HttpSession session = request.getSession();
    	List<xStatus> xstatus = new ArrayList<xStatus>();
    	int userId = ((User)session.getAttribute("users")).getId();
    	xstatus = cartService.getProductFromCartOfUser(userId);
    	Map<Integer, Long> countForId = xstatus.stream()
    	        .collect(Collectors.groupingBy(xStatus::getStatus_id, Collectors.counting()));
    	List<xStatus> distinctProducts = new ArrayList<xStatus>();
    	distinctProducts = cartService.getDistinctProductsFromCartOfUser(userId);
    	for(xStatus status : distinctProducts) {
    		status.setQuantity(Integer.valueOf(Long.toString(countForId.get(status.getStatus_id()))));
    	}
		session.setAttribute("cart", distinctProducts);
   		request.setAttribute("cart", distinctProducts);
   		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");
		int status_id = Integer.valueOf(request.getParameter("status_id"));
		if(command == null) command = "addToCart";
		switch(command) {
		case "addToCart": addToCart(request, response, status_id);
			break;
		case "removeFromCart" : removeFromCart(request, response, status_id);
			break;
		case "proceedToCheckout" : proceedToCheckout(request, response);
		default: addToCart(request, response, status_id);
		}
	}
		
		private void proceedToCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("buyFromCart.jsp").forward(request, response);		
	}

		private void addToCart(HttpServletRequest request, HttpServletResponse response, int status_id) throws ServletException, IOException {
			HttpSession session = request.getSession();
			int userId = ((User)session.getAttribute("users")).getId();
			if(productService.getProduct(status_id).getQuantity() > 0) {
			cartService.addItemToUserCart(status_id, userId);
			productService.updateOperation(status_id,"", productService.getProduct(status_id).getQuantity()-1, "", 0.0, "", "");
			}
			response.sendRedirect(request.getContextPath() + "/operation");
		}
		
		private void removeFromCart(HttpServletRequest request, HttpServletResponse response, int status_id) throws ServletException, IOException {
			HttpSession session = request.getSession();
			int userId = ((User)session.getAttribute("users")).getId();
			
			int quantity = 0;
			@SuppressWarnings("unchecked")
			List<xStatus> statusx = ((List<xStatus>)session.getAttribute("cart"));
			for(xStatus status: statusx) {
				if(status.getStatus_id() == status_id) {
					quantity = status.getQuantity();
				}
			}
			
			
			cartService.deleteItemFromUserCart(status_id, userId);
			productService.updateOperation(status_id,"", productService.getProduct(status_id).getQuantity() + quantity, "", 0.0, "", "");
			response.sendRedirect(request.getContextPath() + "/cart");
		}

}
