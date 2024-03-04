package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllAddressesServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AddressDetails listToDelete = adh.searchForAddressDetailsById(tempId);
				adh.deleteList(listToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AddressDetails listToEdit = adh.searchForAddressDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("month", listToEdit.getPrintDate().getMonthValue());
				request.setAttribute("day", listToEdit.getPrintDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getPrintDate().getYear());
				
				
				AddressHelper ahForAddresses = new AddressHelper();
				
				request.setAttribute("allAddresses", ahForAddresses.showAllAddresses());
							
				if(ahForAddresses.showAllAddresses().isEmpty()){
					request.setAttribute("allAddresses", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);	
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			
			request.setAttribute("allAddressess", ah.showAllAddresses());
			if(ah.showAllAddresses().isEmpty()) {
				request.setAttribute("allAddressess", " ");
			}
			
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
		
	}

}
