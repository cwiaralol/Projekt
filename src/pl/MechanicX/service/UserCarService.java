package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.dao.UserCarDAO;
import pl.MechanicX.dao.DAOFactory;

public class UserCarService {
	private static UserCarService instance;
    
    private UserCarService(){}
    
    public static UserCarService getInstance(){
        if(instance == null){
            instance = new UserCarService();
        }
        return instance;
    }
	
	public void addUserCar(int userId, String car_brand, String car_model, String car_registration) {
		User_Car user_Car = new User_Car();
		user_Car.setUserId(userId);
		user_Car.setCar_brand(car_brand);
		user_Car.setCar_model(car_model);
		user_Car.setCar_registration(car_registration);
		
		
		GetDao().create(user_Car);
	}
	
	public User_Car getUserCarById(int UserCarId) {
		return GetDao().read(UserCarId);
	}
	
	public void updateUserCar(int UserCarId, String car_brand, String car_model,  String car_registration) {
		User_Car user_Car = GetDao().read(UserCarId);
		
		if(!car_brand.isEmpty() && !car_brand.equals(user_Car.getCar_brand())) {
			user_Car.setCar_brand(car_brand);
		}
		
		if((car_model != null) && !car_model.equals(user_Car.getCar_model())){
			user_Car.setCar_model(car_model);
		}
		
		
		if(!car_registration.isEmpty() && !car_registration.equals(user_Car.getCar_registration())) {
			user_Car.setCar_registration(car_registration);
		}
		
		GetDao().update(user_Car);
		
	}
	
	public void deleteUserCar(int UserCarId) {
		GetDao().delete(UserCarId);
	}
	
	public List<User_Car> getAllUserCars(){
		return GetDao().getAll();
	}
	
	public User_Car getUserCarByUserId(int userId) {
		return GetDao().getByUserId(userId);
	}
	
	private UserCarDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		return factory.getBillingInfoDAO();
	}

}
