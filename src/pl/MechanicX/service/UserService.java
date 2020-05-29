package pl.MechanicX.service;

import java.util.List;

import pl.MechanicX.beans.User;
import pl.MechanicX.dao.DAOFactory;
import pl.MechanicX.dao.UserDAO;

public class UserService {
	private static UserService instance;
    
    private UserService(){}
    
    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }
    
	public void addUser(String username, String email, String password, String firstName, String middleName, String lastName) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setMiddleName(middleName);
		user.setLastName(lastName);
		
		GetDao().create(user);
	}
	
	public User getUserById(int userId) {
		return GetDao().read(userId);
	}
	
	public void updateUser(int userId, String password, String firstName, String middleName, String lastName, boolean isActive) {
		User user = GetDao().read(userId);
		
		if(!password.isEmpty() && !password.equals(user.getPassword())) {
			user.setPassword(password);
		}
		
		if(!firstName.isEmpty() && !firstName.equals(user.getFirstName())) {
			user.setFirstName(firstName);
		}
		
		if(!middleName.equals(user.getMiddleName())) {
			user.setMiddleName(middleName);
		}
		
		if(!lastName.isEmpty() && !lastName.equals(user.getLastName())) {
			user.setLastName(lastName);
		}
		
		user.setActive(isActive);
		
		GetDao().update(user);
	}
	
	public void deleteUser(int userId) {
		GetDao().delete(userId);
	}
		
	public User getUserByUsername(String username) {
		return GetDao().getUserByUsername(username);
	}
	
	public User getUserByEmail(String mail) {
		return GetDao().getUserByMail(mail);
	}
	
	public List<User> getUserList() {
		return GetDao().getAll();
	}
	
	public void blockUser(int userId) {
		GetDao().blockUser(userId);
	}
	
	public void unblockUser(int userId) {
		GetDao().unblockUser(userId);
	}
	
	public String getUsernameFromId(int userId) {
		return GetDao().read(userId).getUsername();
	}
	
	public List<User> getUsersByFirstName(String firstName){
		return GetDao().getUsersByFirstName(firstName);
	}
	
	public List<User> getUsersByLastName(String lastName){
		return GetDao().getUsersByLastName(lastName);
	}

	public List<User> getUsersByEmail(String email){
		return GetDao().getUsersByEmail(email);
	}

	public List<User> getUsersByUsername(String username){
		return GetDao().getUsersByUsername(username);
	}

	public List<User> getUsersByActiveStatus(boolean isActive){
		return GetDao().getUsersByActiveStatus(isActive);
	}
	
	private UserDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		return userDao;
	}
}
