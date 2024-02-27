package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String streetName = request.getParameter("streetName");
		String houseNum = request.getParameter("houseNum");
		String zip = request.getParameter("zip");
		String ownerName = request.getParameter("ownerName");
		
		if (streetName.isEmpty() || houseNum.isEmpty() || zip.isEmpty() || ownerName.isEmpty() 
				|| streetName == null || houseNum == null || zip == null || ownerName == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}
		else {
			Address ad = new Address(streetName, ownerName, zip, houseNum);
			AddressHelper ah = new AddressHelper();
			ah.insertAddress(ad);
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}

	}

}
