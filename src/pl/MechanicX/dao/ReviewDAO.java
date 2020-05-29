package pl.MechanicX.dao;

import java.util.List;

import pl.MechanicX.beans.Review;

public interface ReviewDAO extends GenericDAO<Review, Integer>{
	List<Review> getAllForItem(int itemId);
	List<Review> getAllFromUser(int userId);
}
