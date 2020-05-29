package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.xActiv;
import pl.MechanicX.util.DBConnector;

public class xActivDAOImpl implements xActivDAO{

	@Override
	public void create(xActiv newOrder) {
		Connection con;		
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO activities(customer_id,order_date"
						+",order_status, total)"
						+" VALUES("
						+ newOrder.getUserId()+", "
						+"\'"+ newOrder.getOrderDate() + "\', "
						+"\'"+ newOrder.getStatus() + "\', "
						+ newOrder.getTotal() + ");";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("nie mogê zrobiæ aktywnoœci");
			e.printStackTrace();
		
		}
	}

	@Override
	public xActiv read(Integer orderId) {
		xActiv activs = new xActiv();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from activities WHERE order_id = " + orderId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				activs.setOrderId(orderId);
				activs.setUserId(rs.getInt("customer_id"));
				activs.setOrderDate(rs.getDate("order_date"));
				activs.setStatus(rs.getString("order_status"));
				activs.setTotal(rs.getDouble("total"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("xActiv  " + orderId + " nieznaleziony");
			e.printStackTrace();
		}
		return activs;
	}

	@Override
	public void update(xActiv updatedOrder) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "UPDATE activities SET order_status = \'" + updatedOrder.getStatus() +"\'"
							+ " WHERE order_id = "+ updatedOrder.getOrderId() +";";
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("Update  = " + updatedOrder.getOrderId() + "niepomyœlny");
			e.printStackTrace();
		
		}
		
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<xActiv> getAll() {
		ArrayList<xActiv> aktiv = new ArrayList<xActiv>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from activities;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xActiv activs = new xActiv();
					
					activs.setOrderId(rs.getInt("order_id"));
					activs.setUserId(rs.getInt("customer_id"));
					activs.setOrderDate(rs.getDate("order_date"));
					activs.setStatus(rs.getString("order_status"));
					activs.setTotal(rs.getDouble("total"));
					
					aktiv.add(activs);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy aktywnoœci");
			e.printStackTrace();
		}
		return aktiv;
	}

	@Override
	public List<xActiv> getAllOrdersOfUser(int userId) {
		ArrayList<xActiv> aktiv = new ArrayList<xActiv>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from activities WHERE customer_id = " + userId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xActiv activs = new xActiv();
					
					activs.setOrderId(rs.getInt("order_id"));
					activs.setUserId(rs.getInt("customer_id"));
					activs.setOrderDate(rs.getDate("order_date"));
					activs.setStatus(rs.getString("order_status"));
					activs.setTotal(rs.getDouble("total"));
					
					aktiv.add(activs);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy u¿ytkowników wszystkich aktywnych =" + userId);
			e.printStackTrace();
		}
		return aktiv;
	}

	@Override
	public List<xActiv> getAllOrdersWithStatus(String status) {
		ArrayList<xActiv> aktiv = new ArrayList<xActiv>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from activities WHERE order_status = \'" + status.toUpperCase() + "\';";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xActiv activs = new xActiv();
					
					activs.setOrderId(rs.getInt("order_id"));
					activs.setUserId(rs.getInt("customer_id"));
					activs.setOrderDate(rs.getDate("order_date"));
					activs.setStatus(rs.getString("order_status"));
					activs.setTotal(rs.getDouble("total"));
					
					aktiv.add(activs);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy aktywnych ze statusem =" + status);
			e.printStackTrace();
		}
		return aktiv;
	}

	@Override
	public List<xActiv> getAllOrdersWithDate(Date date) {
		ArrayList<xActiv> aktiv = new ArrayList<xActiv>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from activities WHERE order_date = \'" + date + "\';";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xActiv activs = new xActiv();
					
					activs.setOrderId(rs.getInt("order_id"));
					activs.setUserId(rs.getInt("customer_id"));
					activs.setOrderDate(rs.getDate("order_date"));
					activs.setStatus(rs.getString("order_status"));
					activs.setTotal(rs.getDouble("total"));
					
					aktiv.add(activs);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy z dat¹ =" + date);
			e.printStackTrace();
		}
		return aktiv;
	}

}
