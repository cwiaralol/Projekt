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
import pl.MechanicX.beans.Review;
import pl.MechanicX.beans.User;
import pl.MechanicX.service.xStatusService;
import pl.MechanicX.service.ReviewService;
import pl.MechanicX.service.UserService;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	List<Review> reviews = new ArrayList<Review>();
    	ReviewService reviewService = ReviewService.getInstance();
    	xStatusService productService = xStatusService.getInstance();
    	UserService userService = UserService.getInstance();
    	
    	int status_id = Integer.valueOf(request.getParameter("status_id"));
    	xStatus status = productService.getProduct(status_id);
    	List<xStatus> statusx = new ArrayList<xStatus>();
    	statusx.add(status);
    	List<User> users = new ArrayList<User>();
    	reviews = reviewService.getAllReviewsForProduct(status_id);
    	float reviewAvg = 0.0f;
    	
    	
    	for(Review review : reviews) {
    		review.setUsername(userService.getUsernameFromId(review.getUserId()));
    		users.add(UserService.getInstance().getUserById(review.getUserId()));
    		reviewAvg += review.getRating();
    	} 
    	
    	reviewAvg = (float)reviewAvg / (float)reviews.stream().count();
    	session.setAttribute("userList", users);
    	request.setAttribute("userList", users);
    	session.setAttribute("avg", reviewAvg);
    	request.setAttribute("avg", reviewAvg);
		session.setAttribute("review", reviews);
   		request.setAttribute("review", reviews);
   		session.setAttribute("status", statusx);
   		request.setAttribute("status", statusx);
   		
		request.getRequestDispatcher("review.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		session.setAttribute("command", command);
		request.setCharacterEncoding("UTF-8");
		int reviewId = Integer.valueOf(request.getParameter("reviewId"));
		if(command == null) command = "editReview";
		switch(command) {
		case "removeReview" : removeReview(request, response, reviewId);
			break;
		default: removeReview(request, response, reviewId);
		}
	}

	private void removeReview(HttpServletRequest request, HttpServletResponse response, int reviewId) throws IOException {
		int status_id = ReviewService.getInstance().getReview(reviewId).getStatus_id();
		ReviewService.getInstance().deleteReview(reviewId);
		response.sendRedirect(request.getContextPath() + "/review?status_id=" + status_id);
	}

}
