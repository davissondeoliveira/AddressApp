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

@WebServlet("/remove")
public class Remove extends HttpServlet {
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
			printWriter.println("swal ('REMOVED', 'Successfull!!', 'success');");
			printWriter.println("});");
			printWriter.println("</script>");
			//remove zip by the admin
			addressService.remove(request.getParameter("zip"));

		}else {
			//pop-up message
			printWriter.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			printWriter.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			printWriter.println("<script>");
			printWriter.println("$(document).ready(function(){");
			printWriter.println("swal ('SORRY', 'Try Again!!', 'error');");
			printWriter.println("});");
			printWriter.println("</script>");
		}
		//reset the page
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.include(request, response);

	}

}
