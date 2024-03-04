package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressDetails;
import model.Address;
import model.Contact;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddressHelper ah = new AddressHelper();
		String listName = request.getParameter("addressBook");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String ownerName = request.getParameter("ownerName");

		String phoneNum = request.getParameter("phoneNum");

		
		LocalDate pd;
		try {
			pd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			pd = LocalDate.now();
		}
		
		String[] selectedAddresses = request.getParameterValues("allAddressesToAdd");
		List<Address> selectedAddressesInList = new ArrayList<Address>();
		
		if(selectedAddresses != null && selectedAddresses.length > 0){
			for(int i = 0; i<selectedAddresses.length; i++) {
				System.out.println(selectedAddresses[i]);
				Address c = ah.searchForAddressById(Integer.parseInt(selectedAddresses[i]));
				selectedAddressesInList.add(c);
			}
		}
		
		Contact contact = new Contact(ownerName, phoneNum);
		AddressDetails ad = new AddressDetails(listName, pd, contact);
		ad.setListOfAddresses(selectedAddressesInList);
		AddressDetailsHelper adh = new AddressDetailsHelper();
		adh.insertAddressDetails(ad);
		
		System.out.println("Success!");
		System.out.println(ad.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
