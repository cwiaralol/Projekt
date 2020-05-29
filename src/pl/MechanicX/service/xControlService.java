package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.xControl;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.xControlDAO;

public class xControlService {
	private static xControlService instance;
    
    private xControlService(){}
    
    public static xControlService getInstance(){
        if(instance == null){
            instance = new xControlService();
        }
        return instance;
    }
	
	public void addXCont(String control_type, int userId, double amount, int sellerId, int user_car_id, int orderId) {
		xControl control = new xControl();
		
		control.setControl_type(control_type);
		control.setUserId(userId);
		control.setAmount(amount);
		control.setSellerId(1);
		control.setUser_car_id(user_car_id);
		control.setOrderId(orderId);
		control.setStatus("pending".toUpperCase());
		
		GetDao().create(control);
	}
	
	public xControl getPaymentWithId(int control_id) {
		return GetDao().read(control_id);
	}
	
	public void updatePayment(int control_id, String status) {
		xControl control = getPaymentWithId(control_id);
		
		if(!status.isEmpty() && !status.equals(control.getStatus()))
		control.setStatus(status.toUpperCase());
		
		GetDao().update(control);
	}
	
	public List<xControl> getAllPayments(){
		return GetDao().getAll();
	}
	
	public xControl getPaymentForOrder(int orderId) {
		return GetDao().getPaymentForOrder(orderId);
	}
	
	public List<xControl> getAllPaymentsOfUser(int userId){
		return GetDao().getAllPaymentsOfUser(userId);
	}
	
	public List<xControl> getAllPaymentsWithAmountLessThan(double amount){
		return GetDao().getAllPaymentsWithLessThan(amount);
	}
	
	public List<xControl> getAllPaymentsWithAmountMoreThan(double amount){
		return GetDao().getAllPaymentsWithMoreThan(amount);
	}
	
	public List<xControl> getAllPaymentsWithAmountEqualTo(double amount){
		return GetDao().getAllPayemntsEqualTo(amount);
	}
	
	public List<xControl> getAllPaymentsWithStatus(String status){
		return GetDao().getAllPaymentsWithStatus(status);
	}

	private xControlDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		xControlDAO paymentDao = factory.getPaymentDAO();
		return paymentDao;
	}
}
