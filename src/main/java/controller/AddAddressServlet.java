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
		String houseNumber = request.getParameter("houseNumber");
		String zip = request.getParameter("zip");
		
		if (streetName.isEmpty() || houseNumber.isEmpty() || zip.isEmpty() ||
				streetName == null || houseNumber == null || zip == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}
		else {
			Address ad = new Address(streetName, zip, houseNumber);
			AddressHelper ah = new AddressHelper();
			ah.insertAddress(ad);
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}

	}

}
