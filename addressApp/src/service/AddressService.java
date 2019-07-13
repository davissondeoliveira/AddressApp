package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import model.AddressModel;

public class AddressService{
	private Connection con = null;
	private String user = "admin";
	private String pass = "Aloha1234!";
	
	public List <AddressModel> getList() {
		
		List <AddressModel> lObj = new ArrayList<AddressModel>();
		
		JSONObject obj = new JSONObject();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://test.cj3z3d92rgya.us-east-1.rds.amazonaws.com:3306/admin",user, pass);
			Statement stmt= con.createStatement();
	        ResultSet rs=stmt.executeQuery("SELECT * FROM admin.address;");
	        
	        while (rs.next()) {
	        	AddressModel am = new AddressModel();
	        	am.setId(rs.getInt("ID"));
	        	am.setStreetOne(rs.getString("STREETONE"));
	        	am.setStreetTwo(rs.getString("STREETTWO"));
	        	am.setCity(rs.getString("CITY"));
	        	am.setState(rs.getString("STATE"));
	        	am.setZip(rs.getString("ZIP"));
	        	am.setCountry(rs.getString("COUNTRY"));
	        	System.out.println(rs.getInt("ID"));
	        	System.out.println(rs.getString("STREETONE"));
	        	System.out.println(rs.getString("STREETTWO"));
	        	System.out.println(rs.getString("CITY"));
	        	System.out.println(rs.getString("STATE"));
	        	System.out.println(rs.getString("ZIP"));
	        	System.out.println(rs.getString("COUNTRY"));
	        	obj.append(rs.getString("ZIP"), am);
	        	lObj.add(am);
	        }

	        //close the connection
	        stmt.close();
	        con.close();
	        
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
		return lObj;
	}
	public Boolean checkZip(String zip) {
		System.out.println("checking: "+zip);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://test.cj3z3d92rgya.us-east-1.rds.amazonaws.com:3306/admin",user, pass);
			Statement stmt= con.createStatement();
	        ResultSet rs=stmt.executeQuery("SELECT * FROM admin.available_zips;");
	        System.out.println("Connection is done");
	        while (rs.next()) {
	        	if(rs.getString("ZIP").contentEquals(zip)) {
		        	System.out.println(rs.getString("ZIP"));
	        		return true;
	        	}
	        }
	        //close the connection
	        System.out.println("Connection is being closed");
	        stmt.close();
	        con.close();
	        
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
		return false;
	}

}
