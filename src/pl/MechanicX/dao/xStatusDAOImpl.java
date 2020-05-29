package pl.MechanicX.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.util.DBConnector;

public class xStatusDAOImpl implements xStatusDAO{

	@Override
	public void create(xStatus newProduct) {
		Connection con;
		try {
			con = DBConnector.getConnection();
			String query = "INSERT INTO status(status_name,quantity"
						+",type, description,"
						+"image_url, seller_id)"
						+" VALUES("
						+"\'"+ newProduct.getStatus_name()+"\', "
						+ newProduct.getQuantity() + ", "
						+"\'"+ newProduct.getType() + "\', "
						+"\'"+ newProduct.getDescription() + "\', "
						+"\'"+ newProduct.getImageUrl() + "\', "
						+ newProduct.getSellerId() + ")";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con, null, st);
		}catch (Exception e) {
			System.out.println("po³¹czenie niepomyœlne");
			e.printStackTrace();
		}
	}

	@Override
	public xStatus read(Integer status_id) {
		xStatus status = new xStatus();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from status WHERE status_id = " + status_id + ";";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			if (rs.next()) {
				status.setStatus_id(status_id);
				status.setStatus_name(rs.getString("status_name"));
				status.setQuantity(rs.getInt("quantity"));
				status.setType(rs.getString("type"));
				status.setDescription(rs.getString("description"));
				status.setImageUrl(rs.getString("image_url"));
				status.setSellerId(rs.getInt("seller_id"));
			}
			
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("xStatus z ID: " + status_id + " nieznaleziony");
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void update(xStatus updatedProduct) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "UPDATE status SET status_name = \'" + updatedProduct.getStatus_name() +"\'"
							+ ", quantity = "+ updatedProduct.getQuantity()
							+ ", type = \'" + updatedProduct.getType() + "\'"
							+ ", description = \'" + updatedProduct.getDescription() + "\'"
							+ ", image_url = \'" + updatedProduct.getImageUrl() + "\'"
							+ " WHERE status_id = "+ updatedProduct.getStatus_id() +";";
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			DBConnector.close(con, null, st);
		}catch (Exception e) {
			System.out.println("Update statusu niepomyœlny");
			e.printStackTrace();
		
		}
		
	}

	@Override
	public void delete(Integer status_id) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getConnection();
			String query = "DELETE FROM status WHERE status_id = " + status_id + ";";
			st = con.createStatement();
			st.executeUpdate(query);
			DBConnector.close(con, null, st);
		}catch (Exception e) {
			System.out.println("nie mo¿na usun¹æ statusu o id " + status_id);
			e.printStackTrace();
		}
	}

	@Override
	public List<xStatus> getAll() {
		ArrayList<xStatus> statusx = new ArrayList<xStatus>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from status;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {

				xStatus status = new xStatus();
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_name(rs.getString("status_name"));
				status.setQuantity(rs.getInt("quantity"));
				status.setType(rs.getString("type"));
				status.setDescription(rs.getString("description"));
				status.setImageUrl(rs.getString("image_url"));
				status.setSellerId(rs.getInt("seller_id"));
				
				statusx.add(status);
			}
				DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy statusów");
			e.printStackTrace();
		}
		return statusx;
	}

	@Override
	public List<xStatus> getProductsBySellerId(int sellerId) {
		ArrayList<xStatus> statusx = new ArrayList<xStatus>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from status WHERE seller_id = \'" + sellerId + "\';";
			st = con.createStatement();
			rs = st.executeQuery(query);		
			while (rs.next()) {
				xStatus status = new xStatus();
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_name(rs.getString("status_name"));
				status.setType(rs.getString("type"));
				status.setQuantity(rs.getInt("quantity"));
				status.setDescription(rs.getString("description"));
				status.setImageUrl(rs.getString("image_url"));
				status.setSellerId(sellerId);
				
				statusx.add(status);
			}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("status z zarz¹dc¹: " + sellerId + " nie znaleziony");
			e.printStackTrace();
		}
		return statusx;
	}
	
	@Override
	public xStatus getProductByItemName(String itemName) {
		xStatus status = new xStatus();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from status WHERE status_name = \'" + itemName + "\';";
			st = con.createStatement();
			rs = st.executeQuery(query);		
			if (rs.next()) {
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_name(itemName);
				status.setType(rs.getString("type"));
				status.setQuantity(rs.getInt("quantity"));
				status.setDescription(rs.getString("description"));
				status.setImageUrl(rs.getString("image_url"));
				status.setSellerId(rs.getInt("seller_id"));
			}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nazwa statusu" + itemName + " nie znaleziony");
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public List<xStatus> getProductsByType(String type) {
		ArrayList<xStatus> statusx = new ArrayList<xStatus>();
		Connection con;
		ResultSet rs;
		Statement st = null;
		try {
			con = DBConnector.getConnection();
			String query = "SELECT * from status WHERE type LIKE \'%" +type + "%\';";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				xStatus status = new xStatus();
				status.setStatus_id(rs.getInt("status_id"));
				status.setStatus_name(rs.getString("status_name"));
				status.setQuantity(rs.getInt("quantity"));
				status.setType(rs.getString("type"));
				status.setDescription(rs.getString("description"));
				status.setImageUrl(rs.getString("image_url"));
				status.setSellerId(rs.getInt("seller_id"));
				
				statusx.add(status);
				}
			DBConnector.close(con, rs, st);
		} catch (Exception e) {
			System.out.println("nie mogê zrobiæ listy  " + type);
			e.printStackTrace();
		}
		return statusx;
	}

	

}
