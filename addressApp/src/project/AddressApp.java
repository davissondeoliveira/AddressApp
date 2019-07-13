package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressModel;
import service.AddressService;


@WebServlet("/addressapp")
public class AddressApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AddressService addressService;
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		List<AddressModel> aList = addressService.getList();
		
		for(AddressModel modelAddress: aList){
			
			System.out.println("ID: " + modelAddress.getId() +" | ZIP: "+ modelAddress.getZip());
		}
		
		String s2 = request.getParameter("streetOne");
		String s1 = request.getParameter("streetTwo");
		String ci = request.getParameter("city");
		String st = request.getParameter("state");
		String zp = request.getParameter("zip");
		String ct = request.getParameter("country");

		if(zp.equalsIgnoreCase("96734")) {
			
			response.sendRedirect("result.jsp");
		}else {
			response.sendRedirect("index.html");
		}
	}
}