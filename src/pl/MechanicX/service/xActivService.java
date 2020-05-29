package pl.MechanicX.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import pl.MechanicX.beans.xActiv;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.xActivDAO;

public class xActivService {
	private static xActivService instance;
    
    private xActivService(){}
    
    public static xActivService getInstance(){
        if(instance == null){
            instance = new xActivService();
        }
        return instance;
    }
    
	public void addNewOrder(int userId, String status, double total) {        
		xActiv activs = new xActiv();

		activs.setUserId(userId);
		activs.setOrderDate(Date.valueOf(LocalDate.now()));
		activs.setStatus(status);
		activs.setTotal(total);
		
		getDao().create(activs);
	}
	
	public xActiv getOrderById(int orderId) {
		return getDao().read(orderId);
	}
	
	public void updateOrderStatus(int orderId, String status) {
		xActiv activs = getDao().read(orderId);
		
		if(!status.isEmpty() && !status.equals(activs.getStatus())) {
		activs.setStatus(status);
		}
		
		getDao().update(activs);
	}
	
	public List<xActiv> getAllOrders(){
		return getDao().getAll();
	}
	
	public List<xActiv> getAllOrdersOfUser(int userId){
		return getDao().getAllOrdersOfUser(userId);
	}
	
	public List<xActiv> getAllOrdersWithStatus(String status){
		return getDao().getAllOrdersWithStatus(status);
	}

	public List<xActiv> getAllOrdersWithDate(Date date){
		return getDao().getAllOrdersWithDate(date);
	}
	
	private xActivDAO getDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		xActivDAO orderDao = factory.getOrdersDAO();
		return orderDao;
	}

}
