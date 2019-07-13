package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		AddressService addressService = new AddressService();
		
		String s2 = request.getParameter("streetOne");
		String s1 = request.getParameter("streetTwo");
		String ci = request.getParameter("city");
		String st = request.getParameter("state");
		String zp = request.getParameter("zip");
		String ct = request.getParameter("country");

		if(addressService.checkZip(zp)) {
			
			PrintWriter out = response.getWriter();  
			out.write("Good Job!");
		}else {
			response.sendRedirect("index.jsp");
		}
	}
}