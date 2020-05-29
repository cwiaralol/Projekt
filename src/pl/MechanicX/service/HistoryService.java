package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.History;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.HistoryDAO;

public class HistoryService {
	private static HistoryService instance;
    
    private HistoryService(){}
    
    public static HistoryService getInstance(){
        if(instance == null){
            instance = new HistoryService();
        }
        return instance;
    }
	
	public void addToHistory(int userId, int orderId) {
		History history = new History();
		
		history.setUserId(userId);
		history.setOrderId(orderId);
		
		GetDao().create(history);
	}
	
	public History getHistoryById(int historyId) {
		return GetDao().read(historyId);
	}

	public List<History> getEntireHistory(){
		return GetDao().getAll();	
	}
	
	public List<History> getHistoryOfUser(int userId){
		return GetDao().getHistoryOfUser(userId);
	}
	
	private HistoryDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		HistoryDAO historyDao = factory.getHistoryDAO();
		return historyDao;
	}
}
