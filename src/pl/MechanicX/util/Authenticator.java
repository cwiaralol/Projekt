package pl.MechanicX.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Authenticator {
	public static boolean authenticate(String username, String password){
		boolean auth = false;
		try{
			Connection con = DBConnector.getConnection();
			String query = "select * from users where username = \'" + username + "\' and user_password = \'" + password + "\';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				auth = true;
			}
			DBConnector.close(con, rs, st);
			
		}catch(Exception e){
			System.out.println("b��d autoryzacji u�ytkownika " + username);
			e.printStackTrace();
			return false;
		}
		return auth;
	}
}
