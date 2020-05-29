package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.util.DBConnector;

public class CartDAOImpl implements CartDAO{

	@Override
	public List<xStatus> getCartProducts(int userId) {
		ArrayList<xStatus> statusx = new ArrayList<xStatus>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * FROM cart WHERE user_id = " + userId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int status_id = rs.getInt("status_id");
				statusx.add(GetDao().read(status_id));
			}
			
			DBConnector.close(con, rs, st);
		}catch (Exception e) {
			System.out.println("brak statusów " + userId);
			e.printStackTrace();
		}
		return statusx;
	}

	@Override
	public void addItemToUserCart(int itemId, int userId) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO cart(user_id,status_id) VALUES(" + userId + ", " + itemId +");"; 
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con, null, st);
		} catch (Exception e) {
			System.out.println("nie mogê dodaæ statusu " + userId);
			e.printStackTrace();
		}
	}

	@Override
	public void deleteItemFromUserCart(int itemId, int userId) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DBConnector.getConnection();
			String query = "DELETE FROM cart WHERE user_id = " + userId + " and status_id = " + itemId +";"; 
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con, null, st);
		} catch (Exception e) {
			System.out.println("nie mogê usun¹æ statusu " + userId);
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteAllFromCart(int userId) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DBConnector.getConnection();
			String query = "DELETE FROM cart WHERE user_id = " + userId + ";"; 
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con, null, st);
		} catch (Exception e) {
			System.out.println("nie mogê usun¹æ statusów" + userId);
			e.printStackTrace();
		}
	}
	
	private xStatusDAO GetDao() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		return factory.getProductDAO();
	}

	@Override
	public List<xStatus> getDistinctCartProducts(int userId) {
		ArrayList<xStatus> statusx = new ArrayList<xStatus>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT DISTINCT * FROM cart WHERE user_id = " + userId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int status_id = rs.getInt("status_id");
				statusx.add(GetDao().read(status_id));
			}
			
			DBConnector.close(con, rs, st);
		}catch (Exception e) {
			System.out.println("brak statusów " + userId);
			e.printStackTrace();
		}
		return statusx;
	}
}
