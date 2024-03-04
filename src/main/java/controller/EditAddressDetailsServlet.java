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
 * Servlet implementation class EditAddressDetailsServlet
 */
@WebServlet("/editAddressDetailsServlet")
public class EditAddressDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddressDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				AddressDetailsHelper adh = new AddressDetailsHelper();
				AddressHelper ah = new AddressHelper();
				ContactHelper ch = new ContactHelper();
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AddressDetails listToUpdate = adh.searchForAddressDetailsById(tempId);

				String newListName = request.getParameter("addressBook");

				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				
				String ownerName = request.getParameter("ownerName");
				String phoneNum = request.getParameter("phoneNum");

				Contact newContact = ch.findContact(ownerName);
				
				newContact.setPhoneNum(phoneNum);

				LocalDate pd;
				try {
					pd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				} catch (NumberFormatException ex) {
					pd = LocalDate.now();
				}

				try {
					//items are selected in list to add
					String[] selectedAddresses = request.getParameterValues("allAddressesToAdd");
					List<Address> selectedAddressesInList = new ArrayList<Address>();

					for (int i = 0; i < selectedAddresses.length; i++) {
						System.out.println(selectedAddresses[i]);
						Address c = ah.searchForAddressById(Integer.parseInt(selectedAddresses[i]));
						selectedAddressesInList.add(c);
					}
					listToUpdate.setListOfAddresses(selectedAddressesInList);
				} catch (NullPointerException ex) {
					// no items selected in list - set to an empty list
					List<Address> selectedAddressesInList = new ArrayList<Address>();
					listToUpdate.setListOfAddresses(selectedAddressesInList);
				}

				listToUpdate.setAddressBook(newListName);
				listToUpdate.setPrintDate(pd);
				listToUpdate.setContact(newContact);


				adh.updateList(listToUpdate);

				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
	
}


