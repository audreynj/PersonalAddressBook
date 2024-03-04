package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;

/**
 * Servlet implementation class EditAddressServlet
 */
@WebServlet("/editAddressServlet")
public class EditAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressHelper ah = new AddressHelper();
		
		String streetName = request.getParameter("streetName");
		String zip = request.getParameter("zip");
		String houseNumber = request.getParameter("houseNumber");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Address addressToUpdate = ah.searchForAddressById(tempId);
		addressToUpdate.setStreetName(streetName);
		addressToUpdate.setZip(zip);
		addressToUpdate.setHouseNumber(houseNumber);
				
		ah.updateAddress(addressToUpdate);

		getServletContext().getRequestDispatcher("/viewAllAddressesServlet").forward(request, response);

	}

}
