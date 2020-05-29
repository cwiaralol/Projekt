package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.Review;
import pl.MechanicX.util.DBConnector;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	public void create(Review newRating) {
		Connection con;		
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO review(customer_id,status_id"
						+",description, rating)"
						+" VALUES("
						+ newRating.getUserId() + ", "
						+ newRating.getStatus_id() + ", "
						+"\'"+ newRating.getDescription() + "\', "
						+ newRating.getRating() +");";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("nie mogê dodaæ recenzji");
			e.printStackTrace();
		
		}
	}

	@Override
	public Review read(Integer reviewId) {
		Review review = new Review();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from review WHERE review_id = " + reviewId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				review.setReviewId(reviewId);
				review.setUserId(rs.getInt("customer_id"));
				review.setStatus_id(rs.getInt("status_id"));
				review.setDescription(rs.getString("description"));
				review.setRating(rs.getInt("rating"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("id: " + reviewId + " nie znalezione");
			e.printStackTrace();
		}
		return review;
	}

	@Override
	public void update(Review updatedReview) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "UPDATE review SET description = \'" + updatedReview.getDescription() +"\'"
							+ ", rating = "+ updatedReview.getRating()
							+ " WHERE review_ID = "+ updatedReview.getReviewId() +";";
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con, null, st);
		}catch (Exception e) {
			System.out.println("update niepomyœlny");
			e.printStackTrace();
		
		}
	}

	@Override
	public void delete(Integer reviewId) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "DELETE FROM review WHERE review_id = " + reviewId + ";";
			st = con.createStatement();
			st.executeUpdate(query);
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("niemogê usun¹æ tego id : " + reviewId);
			e.printStackTrace();
		}
	}

	@Override
	public List<Review> getAll() {
		ArrayList<Review> reviews = new ArrayList<Review>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from review;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setUserId(rs.getInt("customer_id"));
				review.setStatus_id(rs.getInt("status_id"));
				review.setDescription(rs.getString("description"));
				review.setRating(rs.getInt("rating"));;		
				reviews.add(review);
			}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy recenzji");
			e.printStackTrace();
		}
		return reviews;
	}

	@Override
	public List<Review> getAllForItem(int itemId) {
		ArrayList<Review> reviews = new ArrayList<Review>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from review WHERE status_id = " + itemId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setUserId(rs.getInt("customer_id"));
				review.setStatus_id(rs.getInt("status_id"));
				review.setDescription(rs.getString("description"));
				review.setRating(rs.getInt("rating"));;		
				reviews.add(review);	
			}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("Couldn't make a list with all reviews");
			e.printStackTrace();
		}
		return reviews;
	}

	@Override
	public List<Review> getAllFromUser(int userId) {
		ArrayList<Review> reviews = new ArrayList<Review>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from review WHERE customer_id = " + userId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setUserId(rs.getInt("customer_id"));
				review.setStatus_id(rs.getInt("status_id"));
				review.setDescription(rs.getString("description"));
				review.setRating(rs.getInt("rating"));;		
				reviews.add(review);	
			}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy recenzji");
			e.printStackTrace();
		}
		return reviews;
	}

}
