package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.xOperation;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.xOperationDAO;


public class xOperationService {
	private static xOperationService instance;
    
    private xOperationService(){}
    
    public static xOperationService getInstance(){
        if(instance == null){
            instance = new xOperationService();
        }
        return instance;
    }
    
	public void addOper(int orderId, int userId, String mechanic_name, String returnAddress, String garage, float charge, String status) {
		xOperation operation = new xOperation();
		status = status.toUpperCase();
		
		operation.setOrderId(orderId);
		operation.setUserId(userId);
		operation.setMechanicName(mechanic_name);
		operation.setReturnAddress(returnAddress);
		operation.setGarage(garage);
		operation.setCharge(charge);
		operation.setStatus(status);
		
		getDao().create(operation);
	}
	
	public xOperation getShipmentWithId(int operation_id) {
		return getDao().read(operation_id);
	}
	
	public void updateShipmentWithId(int operation_id, String mechanic_name, String returnAddress, String garage, String status) {
		xOperation operation = getDao().read(operation_id);
		status = status.toUpperCase();
		
		if(!mechanic_name.isEmpty() && !mechanic_name.equals(operation.getMechanicName())) {
		 operation.setMechanicName(mechanic_name);
		}
		
		if(!returnAddress.isEmpty() && !returnAddress.equals(operation.getReturnAddress())) {
		operation.setReturnAddress(returnAddress);
		}

		if(!garage.isEmpty() && !garage.equals(operation.getGarage())) {
		operation.setGarage(garage);
		}

		if(!status.isEmpty() && !status.equals(operation.getStatus())) {
		operation.setStatus(status);
		}
		
		getDao().update(operation);
	}
	
	public List<xOperation> getAllShipments(){
		return getDao().getAll();
	}
	
	public xOperation getShipmentByTrackingNumber(String mechanic_name) {
		return getDao().getShipmentByTackingNumber(mechanic_name);
	}
	
	public List<xOperation> getAllShipmentsWithUserId(int userId){
		return getDao().getAllShipmentsWithUserId(userId);
	}
	
	public List<xOperation> getAllShipmentsWithStatus(String status){
		return getDao().getAllShipmentWithStatus(status);
	}
	
	public List<xOperation> getAllShipmentsWithCarrier(String garage){
		return getDao().getAllShipmentWithCarrier(garage);
	}

	private xOperationDAO getDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		xOperationDAO orderDao = factory.getShipmentDAO();
		return orderDao;
	}
}
