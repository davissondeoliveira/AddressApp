package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AddressService;


@WebServlet("/addressapp")
public class AddressApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		AddressService addressService = new AddressService();
	
		//check if the zip is acceptable
		if(addressService.checkZip(request.getParameter("zip"))) {
			//pop-up message
			printWriter.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			printWriter.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			printWriter.println("<script>");
			printWriter.println("$(document).ready(function(){");
			printWriter.println("swal ('WELCOME', 'Successfull!!', 'success');");
			printWriter.println("});");
			printWriter.println("</script>");
			
		}else {
			//pop-up message
			printWriter.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			printWriter.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			printWriter.println("<script>");
			printWriter.println("$(document).ready(function(){");
			printWriter.println("swal ('WELCOME', 'Not Today!!', 'error');");
			printWriter.println("});");
			printWriter.println("</script>");
			//add a new address entered by the user
			addressService.newAddress(addressService.creatingAnObj(request.getParameter("streetOne"),
					request.getParameter("streetTwo"), request.getParameter("city"),
					request.getParameter("state"), request.getParameter("zip"), request.getParameter("country")));
		}
		//reset the page
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.include(request, response);
	}
	
	//remove zip by the admin
//	addressService.remove(request.getParameter("zip"));
}