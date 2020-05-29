package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.Review;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.ReviewDAO;

public class ReviewService {
	private static ReviewService instance;
    
    private ReviewService(){}
    
    public static ReviewService getInstance(){
        if(instance == null){
            instance = new ReviewService();
        }
        return instance;
    }
    
	public void addReview(int userId,int status_id, String description, int rating) {
		Review review = new Review();
		review.setUserId(userId);
		review.setStatus_id(status_id);
		review.setDescription(description);
		
		if(rating < 1) {
			rating = 1;
		} else if( rating > 5) {
			rating = 5;
		} else 
		review.setRating(rating);
		
		GetDao().create(review);
	}
	
	public void updateReview(int reviewId, String description, int rating) {
		Review review = ReviewService.getInstance().getReview(reviewId);
		
		if(!description.isEmpty() && !description.equals(review.getDescription())) {
			review.setDescription(description);
		}
		
		if(rating != 0 && rating != review.getRating()) {
			review.setRating(rating);
		}
		
		GetDao().update(review);
	}
	
	public Review getReview(int reviewId) {
		return GetDao().read(reviewId);
	}
	
	public void deleteReview(int reviewId){
		GetDao().delete(reviewId);
	}
	
	public List<Review> getAllReviews(){
		return GetDao().getAll();
	}
	
	public List<Review> getAllReviewsForProduct(int status_id){
		return GetDao().getAllForItem(status_id);
	}
	
	public List<Review> getAllReviewsFromUser(int userId){
		return GetDao().getAllFromUser(userId);
	}

	private ReviewDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		ReviewDAO reviewDao = factory.getReviewDAO();
		return reviewDao;
	}
}
