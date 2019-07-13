package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.JSONObject;

public class AddressService implements AddressServiceImp{
	
	public JSONObject getConnection() {
		JSONObject obj = new JSONObject();
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://72.130.253.5/32:3306/test", "root", "Aloha1234!");
			System.out.println("we did it");
			
			
			return obj;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("we did not");
			return null;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("we did not");
			return null;
		}
	}
	
	

}
