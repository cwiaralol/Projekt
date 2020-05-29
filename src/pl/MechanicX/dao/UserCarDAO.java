package pl.MechanicX.dao;

import pl.MechanicX.beans.User_Car;

public interface UserCarDAO extends GenericDAO<User_Car, Integer>{
	User_Car getByUserId(int userId);
}
