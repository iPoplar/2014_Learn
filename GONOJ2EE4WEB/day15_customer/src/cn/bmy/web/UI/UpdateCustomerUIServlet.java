package cn.bmy.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Customer;
import cn.bmy.exception.DaoException;
import cn.bmy.service.BusinessService;
import cn.bmy.utils.Globals;


public class UpdateCustomerUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		BusinessService service = new BusinessService();
		Customer c;
		try {
			c = service.findCustomer(id);
			request.setAttribute("customer", c);
			
			request.setAttribute("preferences", Globals.preferences);
			request.setAttribute("types", Globals.types);
			
			request.getRequestDispatcher("/WEB-INF/jsp/updatecustomer.jsp").forward(request, response);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
