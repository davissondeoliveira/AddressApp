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
	
	//Get a list of all address entered by users
	public List <AddressModel> getList() {
		
		List <AddressModel> lObj = new ArrayList<AddressModel>();
		
		JSONObject obj = new JSONObject();
		
		try {
			//start connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://test.cj3z3d92rgya.us-east-1.rds.amazonaws.com:3306/admin",user, pass);
			Statement stmt= con.createStatement();
	        ResultSet rs=stmt.executeQuery("SELECT * FROM admin.address;");
	        
	        while (rs.next()) {
	        	AddressModel am = new AddressModel();
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
	//add an address entered by users.
	public Boolean newAddress(AddressModel addressModel) {
		try {
			//start connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://test.cj3z3d92rgya.us-east-1.rds.amazonaws.com:3306/admin",user, pass);
			Statement stmt= con.createStatement();
		       stmt.executeUpdate("INSERT INTO admin.address (STREETONE, STREETTWO, CITY, STATE, ZIP, COUNTRY)"
		       		+" VALUES ('"+addressModel.getStreetOne()+"', '"+addressModel.getStreetTwo()
		       		+"', '"+addressModel.getCity()+"', '"+addressModel.getState()
		       		+"', '"+addressModel.getZip()+"', '"+addressModel.getCountry()+"');");
		       System.out.println("added");
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
	
	//check if a zip keyed by user matches with available zips
	public Boolean checkZip(String zip) {
		System.out.println("checking: "+zip);
		
		try {
			//start connection
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
	
	//add a new available zip
	public Boolean add(String zip) {
		System.out.println("checking: "+zip);
		Boolean newZip = checkZip(zip);
		if(!newZip) {
			try {
				//start connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://test.cj3z3d92rgya.us-east-1.rds.amazonaws.com:3306/admin",user, pass);
				Statement stmt= con.createStatement();
		        stmt.executeUpdate("INSERT INTO admin.available_zips (ZIP) VALUES (\""+zip+"\");");
		        System.out.println("added");
		        //close the connection
		        System.out.println("Connection is being closed");
		        stmt.close();
		        con.close();
		        
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return false;
			}
		}
		return false;
	}
	//delete an available zip
	public Boolean remove(String zip) {
		System.out.println("removing: "+zip);
		
		try {
			//start connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://test.cj3z3d92rgya.us-east-1.rds.amazonaws.com:3306/admin",user, pass);
			Statement stmt= con.createStatement();
	        stmt.executeUpdate("DELETE FROM admin.available_zips WHERE ZIP = "+zip+";");
	        System.out.println("Removed");
	     
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
	//create an address obj
	public AddressModel creatingAnObj(String streetOne, String streetTwo, String city, String state, String zip,
			String country) {
		AddressModel obj = new AddressModel();
		obj.setStreetOne(streetOne);
		obj.setStreetTwo(streetTwo);
		obj.setCity(city);
		obj.setState(state);
		obj.setZip(zip);
		obj.setCountry(country);
		return obj;
	}

}
