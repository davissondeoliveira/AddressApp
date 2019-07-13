package project;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.AddressService;


@WebServlet("/addressapp")
public class AddressApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AddressService addressService;
	
	public void setAddressServfice(AddressService addressService) {
		this.addressService = addressService;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap myArr = new HashMap();
		
		JSONObject myObj = addressService.getConnection();
		
		String s1 = request.getParameter("streetOne");
		String s2 = request.getParameter("streetTwo");
		String ci = request.getParameter("city");
		String st = request.getParameter("state");
		String zp = request.getParameter("zip");
		String ct = request.getParameter("country");
		
		if(zp.equalsIgnoreCase("96734")) {
			request.getSession().setAttribute("message", "Perfect! It does match!");
			response.sendRedirect("result.jsp");
		}else {
			request.getSession().setAttribute("message", "Sorry! Try again!");
			response.sendRedirect("result.jsp");
		}
	}

}
