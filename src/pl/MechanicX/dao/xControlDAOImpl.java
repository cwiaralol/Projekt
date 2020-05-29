package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.xControl;
import pl.MechanicX.util.DBConnector;

public class xControlDAOImpl implements xControlDAO{

	@Override
	public void create(xControl newPayment) {
		Connection con;		
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO control(control_type,customer_id"
						+",amount, user_car_id, seller_id,"
						+"order_id,status)"
						+" VALUES("
						+"\'"+ newPayment.getControl_type()+"\', "
						+ newPayment.getUserId() + ", "
						+ newPayment.getAmount() + ", "
						+ newPayment.getUser_car_id() + ", "
						+ newPayment.getSellerId() + ", "
						+ newPayment.getOrderId() + ", "
						+"\'"+ newPayment.getStatus()+"\');";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("nie mogê dodaæ kontroli");
			e.printStackTrace();
		
		}
	}

	@Override
	public xControl read(Integer control_id) {
		xControl control = new xControl();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE control_id = " + control_id + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				control.setControl_id(control_id);
				control.setUserId(rs.getInt("customer_id"));
				control.setControl_type(rs.getString("control_type"));
				control.setAmount(rs.getDouble("amount"));
				control.setSellerId(rs.getInt("seller_id"));
				control.setOrderId(rs.getInt("order_id"));
				control.setUser_car_id(rs.getInt("user_car_id"));
				control.setStatus(rs.getString("status"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("xControl z id: " + control_id + " nie znaleziona");
			e.printStackTrace();
		}
		return control;
	}

	@Override
	public void update(xControl updatedPayment) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "UPDATE control SET status = \'" + updatedPayment.getStatus() +"\'"
							+ " WHERE control_id = "+ updatedPayment.getControl_id() +";";
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("Upadte niepomyœlny");
			e.printStackTrace();
		
		}
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<xControl> getAll() {
		ArrayList<xControl> kontrols = new ArrayList<xControl>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xControl control = new xControl();
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
					kontrols.add(control);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy kontroli");
			e.printStackTrace();
		}
		return kontrols;
	}

	@Override
	public xControl getPaymentForOrder(int orderId) {
		xControl control = new xControl();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE order_id = " + orderId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			if(rs.next()) {
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
			}
				
				DBConnector.close(con, rs, st);
			}catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy=" + orderId);
			e.printStackTrace();
		}
		return control;
	}

	@Override
	public List<xControl> getAllPaymentsOfUser(int userId) {
		ArrayList<xControl> kontrols = new ArrayList<xControl>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE customer_id = "+ userId +";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xControl control = new xControl();
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
					kontrols.add(control);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy kontroli  = " + userId );
			e.printStackTrace();
		}
		return kontrols;
	}

	@Override
	public List<xControl> getAllPaymentsWithLessThan(double amount) {
		ArrayList<xControl> kontrols = new ArrayList<xControl>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE amount < "+ amount +";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xControl control = new xControl();
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
					kontrols.add(control);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy" + amount );
			e.printStackTrace();
		}
		return kontrols;
	}

	@Override
	public List<xControl> getAllPaymentsWithMoreThan(double amount) {
		ArrayList<xControl> kontrols = new ArrayList<xControl>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE amount > "+ amount +";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xControl control = new xControl();
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
					kontrols.add(control);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy" + amount );
			e.printStackTrace();
		}
		return kontrols;
	}

	@Override
	public List<xControl> getAllPayemntsEqualTo(double amount) {
		ArrayList<xControl> kontrols = new ArrayList<xControl>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE amount = "+ amount +";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xControl control = new xControl();
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
					kontrols.add(control);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy " + amount );
			e.printStackTrace();
		}
		return kontrols;
	}

	@Override
	public List<xControl> getAllPaymentsWithStatus(String status) {
		ArrayList<xControl> kontrols = new ArrayList<xControl>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from control WHERE status = \'"+ status.toUpperCase() +"\';";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
					xControl control = new xControl();
					control.setControl_id(rs.getInt("control_id"));
					control.setUserId(rs.getInt("customer_id"));
					control.setControl_type(rs.getString("control_type"));
					control.setAmount(rs.getDouble("amount"));
					control.setSellerId(rs.getInt("seller_id"));
					control.setOrderId(rs.getInt("order_id"));
					control.setUser_car_id(rs.getInt("user_car_id"));
					control.setStatus(rs.getString("status"));
					kontrols.add(control);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy " + status );
			e.printStackTrace();
		}
		return kontrols;
	}

}
