package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.xOperation;
import pl.MechanicX.util.DBConnector;

public class xOperationDAOImpl implements xOperationDAO{

	@Override
	public void create(xOperation operacja) {
		Connection con;		
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO operation(order_id,customer_id"
						+",mechanic_name,garage)"
						+" VALUES("
						+"\'"+ operacja.getOrderId()+"\',"
						+"\'"+ operacja.getUserId() + "\',"
						+"\'"+ operacja.getMechanicName() + "\',"
						+"\'"+ operacja.getGarage() + "\');";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("niepomyœlne dodanie operacji");
			e.printStackTrace();
		
		}
	}

	@Override
	public xOperation read(Integer operation_id) {
		xOperation operation = new xOperation();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from operation WHERE operation_id = " + operation_id + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				operation.setOperation_id(operation_id);
				operation.setUserId(rs.getInt("customer_id"));
				operation.setMechanicName(rs.getString("mechanic_name"));
				operation.setOrderId(rs.getInt("order_id"));
				operation.setGarage(rs.getString("garage"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("xOperation z ID: " + operation_id + " nieznaleziona ");
			e.printStackTrace();
		}
		return operation;
	}

	@Override
	public void update(xOperation updatedShipment) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "UPDATE operation SET mechanic_name = \'" + updatedShipment.getMechanicName() +"\'"
							+ ", garage = \'" + updatedShipment.getGarage() +"\'" 
							+ "WHERE operation_id = "+ updatedShipment.getOperation_id() + ";";
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con,null,st);
		}catch (Exception e) {
			System.out.println("Update operacji =" + updatedShipment.getOperation_id() + "niepomyœlny");
			e.printStackTrace();
		
		}
	}

	@Override
	public void delete(Integer key) {
	}

	@Override
	public List<xOperation> getAll() {
		List<xOperation> shipments = new ArrayList<xOperation>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from operation;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			while (rs.next()) {
				xOperation operation = new xOperation();
				
				operation.setOperation_id(rs.getInt("operation_id"));
				operation.setUserId(rs.getInt("customer_id"));
				operation.setMechanicName(rs.getString("mechanic_name"));
				operation.setOrderId(rs.getInt("order_id"));
				operation.setGarage(rs.getString("garage"));
				
				shipments.add(operation);
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy operacji");
			e.printStackTrace();
		}
		return shipments;
	}

	@Override
	public xOperation getShipmentByTackingNumber(String mechanic_name) {
		xOperation operation = new xOperation();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from operation WHERE mechanic_name = \'" + mechanic_name + "\';";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				operation.setOperation_id(rs.getInt("operation_id"));
				operation.setUserId(rs.getInt("customer_id"));
				operation.setMechanicName(rs.getString("mechanic_name"));
				operation.setOrderId(rs.getInt("order_id"));
				operation.setGarage(rs.getString("garage"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê namierzyæ operacji = " + mechanic_name);
			e.printStackTrace();
		}
		return operation;
	}

	@Override
	public List<xOperation> getAllShipmentWithStatus(String status) {
		List<xOperation> shipments = new ArrayList<xOperation>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query =  "SELECT * from operation WHERE status = " + status + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			while (rs.next()) {
				xOperation operation = new xOperation();
				
				operation.setOperation_id(rs.getInt("operation_id"));
				operation.setUserId(rs.getInt("customer_id"));
				operation.setMechanicName(rs.getString("mechanic_name"));
				operation.setOrderId(rs.getInt("order_id"));
				operation.setGarage(rs.getString("garage"));
				
				shipments.add(operation);
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy operacji ze statusem = " + status);
			e.printStackTrace();
		}
		return shipments;
	}

	@Override
	public List<xOperation> getAllShipmentsWithUserId(int userId) {
		List<xOperation> shipments = new ArrayList<xOperation>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query =  "SELECT * from operation WHERE customer_id = " + userId + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			while (rs.next()) {
				xOperation operation = new xOperation();
				
				operation.setOperation_id(rs.getInt("operation_id"));
				operation.setUserId(rs.getInt("customer_id"));
				operation.setMechanicName(rs.getString("mechanic_name"));
				operation.setOrderId(rs.getInt("order_id"));
				operation.setGarage(rs.getString("garage"));
				
				shipments.add(operation);
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy operacji wed³ug userid = " + userId);
			e.printStackTrace();
		}
		return shipments;
	}

	@Override
	public List<xOperation> getAllShipmentWithCarrier(String garage) {
		List<xOperation> shipments = new ArrayList<xOperation>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query =  "SELECT * from operation WHERE garage = " + garage + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			while (rs.next()) {
				xOperation operation = new xOperation();
				
				operation.setOperation_id(rs.getInt("operation_id"));
				operation.setUserId(rs.getInt("customer_id"));
				operation.setMechanicName(rs.getString("mechanic_name"));
				operation.setOrderId(rs.getInt("order_id"));
				operation.setGarage(rs.getString("garage"));
				
				shipments.add(operation);
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy operacji wed³ug gara¿ów = " + garage);
			e.printStackTrace();
		}
		return shipments;
	}

}
