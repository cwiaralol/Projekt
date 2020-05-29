package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.dao.CartDAO;
import pl.MechanicX.dao.DAOFactory;

public class CartService {
	private static CartService instance;
    
    private CartService(){}
    
    public static CartService getInstance(){
        if(instance == null){
            instance = new CartService();
        }
        return instance;
    }

	public List<xStatus> getProductFromCartOfUser(int userId){
		return GetDao().getCartProducts(userId);
	}
	
	public List<xStatus> getDistinctProductsFromCartOfUser(int userId){
		return GetDao().getDistinctCartProducts(userId);
	}
	
	public void addItemToUserCart(int itemId, int userId) {
		GetDao().addItemToUserCart(itemId, userId);
	}
	
	public void deleteItemFromUserCart(int itemId, int userId) {
		GetDao().deleteItemFromUserCart(itemId, userId);
	}
	
	public void deleteAllItemsFromUserCart(int userId) {
		GetDao().deleteAllFromCart(userId);
	}
	
	private CartDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		CartDAO cartDao = factory.getCartDAO();
		return cartDao;
	}
}
