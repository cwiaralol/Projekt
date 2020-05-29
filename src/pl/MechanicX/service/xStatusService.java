package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.xStatusDAO;

public class xStatusService {
	private static xStatusService instance;
    
    private xStatusService(){}
    
    public static xStatusService getInstance(){
        if(instance == null){
            instance = new xStatusService();
        }
        return instance;
    }
    
	public void addOperationX(String itemName, int quantity, String type, String description, String imageUrl, int sellerId) {
		xStatus status = new xStatus();
		status.setStatus_name(itemName);
		status.setQuantity(quantity);
		status.setType(type);
		status.setDescription(description);
		status.setImageUrl(imageUrl);
		status.setSellerId(1);
		
		GetDao().create(status);
	}
	
	public xStatus getProduct(int status_id) {
		return GetDao().read(status_id);
	}
	
	public void updateOperation(int status_id, String status_name, int quantity, String type, String description, String imageUrl) {
		xStatus status = getProduct(status_id);
		
		if(!status_name.isEmpty() && !status_name.equals(status.getStatus_name())) {
			status.setStatus_name(status_name);
		}
		
		if(quantity != status.getQuantity() && quantity >=0) {
			status.setQuantity(quantity);
		}
		
		if(!type.isEmpty() && !type.equals(status.getType())) {
			status.setType(type);
		}
		
		
		if(!description.isEmpty() && !description.equals(status.getDescription())) {
			status.setDescription(description);
		}
		
		if(!imageUrl.isEmpty() && !imageUrl.equals(status.getImageUrl())) {
			status.setDescription(imageUrl);
		}
		
		GetDao().update(status);
	}
	
	public void deleteProduct(int status_id) {
		GetDao().delete(status_id);
	}
	
	public List<xStatus> getAllProducts(){
		return GetDao().getAll();
	}
	
	public List<xStatus> getAllProductsFromSeller(int sellerId){
		return GetDao().getProductsBySellerId(sellerId);
	}
	
	public xStatus getProductByName(String itemName) {
		return GetDao().getProductByItemName(itemName);
	}
	
	public List<xStatus> getAllProductsByType(String type){
		return GetDao().getProductsByType(type);
	}
	

	
	public List<xStatus> getAllProductsBySearch(String searchPhrase){
		return GetDao().getProductsByProductName(searchPhrase);
	}
	
	private xStatusDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		xStatusDAO productDao = factory.getProductDAO();
		return productDao;
	}
}
