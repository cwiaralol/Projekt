package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.util.DBConnector;

public class UserCarDAOImpl implements UserCarDAO {

	@Override
	public void create(User_Car newUserCar) {
		Connection con;
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO user_car(user_id,car_brand"
						+",car_model,  car_registration)"
						+" VALUES("
						+ newUserCar.getUserId()+", "
						+ newUserCar.getCar_brand()+", "
						+"\'"+ newUserCar.getCar_model() + "\', "
						+"\'"+ newUserCar.getCar_registration() + "\')";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}	
	}

	@Override
	public User_Car read(Integer user_car_id) {
		User_Car user_Car = new User_Car();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from user_car WHERE user_car_id = " + user_car_id + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				user_Car.setUser_car_id(user_car_id);
				user_Car.setUserId(rs.getInt("user_id"));
				user_Car.setCar_brand(rs.getString("car_brand"));
				user_Car.setCar_model(rs.getString("car_model"));
				user_Car.setCar_registration(rs.getString("car_registration"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("samochód " + user_car_id + " nieznaleziony");
			e.printStackTrace();
		}
		return user_Car;
	}

	@Override
	public void update(User_Car updatedUserCar) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "UPDATE user_car SET car_brand = \'" + updatedUserCar.getCar_brand() +"\'"
							+ ", car_model = \'"+ updatedUserCar.getCar_model() +"\'"
							+ ", car_registration = \'" + updatedUserCar.getCar_registration()+"\'"
							+ " WHERE user_car_id = "+ updatedUserCar.getUser_car_id() +";";
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("Update samochodu nie dzia³a");
			e.printStackTrace();
		
		}
		
	}

	@Override
	public void delete(Integer UserCarId) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "DELETE FROM user_car WHERE user_car_id = " + UserCarId + ";";
			st = con.createStatement();
			st.executeUpdate(query);
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("nie mogê usun¹æ samochodu o id: " +UserCarId);
			e.printStackTrace();
		}	
	}

	@Override
	public List<User_Car> getAll() {
		ArrayList<User_Car> UserCars = new ArrayList<User_Car>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from user_car;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				User_Car user_Car = new User_Car();
				user_Car.setUser_car_id(rs.getInt("user_car_id"));
				user_Car.setUserId(rs.getInt("user_id"));
				user_Car.setCar_brand(rs.getString("car_brand"));
				user_Car.setCar_model(rs.getString("car_model"));
				user_Car.setCar_registration(rs.getString("car_registration"));
				
				UserCars.add(user_Car);
			}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy samochodów");
			e.printStackTrace();
		}
		return UserCars;
	}

	@Override
	public User_Car getByUserId(int userId) {
		User_Car user_Car = new User_Car();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from user_car WHERE user_id = " + userId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				user_Car.setUser_car_id(rs.getInt("user_car_id"));
				user_Car.setUserId(userId);
				user_Car.setCar_brand(rs.getString("car_brand"));
				user_Car.setCar_model(rs.getString("car_model"));
				user_Car.setCar_registration(rs.getString("car_registration"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("samochodów u¿ytkownikao id: " + userId + " nie znaleziony");
			e.printStackTrace();
		}
		return user_Car;
	}

}
