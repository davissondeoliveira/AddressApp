package project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressModel;
import service.AddressService;

@WebServlet("/addressList")
public class AddressList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AddressService addressService = new AddressService();
		ArrayList<AddressModel> addressList = addressService.getList();
        
        for(AddressModel obj: addressList) {
        	System.out.println(obj.getId() +", "+obj.getStreetOne() +", "+ obj.getStreetTwo()+", "+ obj.getCity()+", "+obj.getState()
        	+", "+ obj.getZip()+", "+ obj.getCountry());
        }
        ArrayList<AddressModel> zipList = addressService.getZipList();
        
        for(AddressModel obj: zipList) {
        	System.out.println(obj.getId() +", "+obj.getZip());
        }
        request.setAttribute("zipCollection", zipList);
        request.setAttribute("addressCollection", addressList);
        request.setAttribute("uncover", "show");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
	}
}
