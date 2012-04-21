package bedhot.servlet;

import bedhot.beans.CustomerBean;
import bedhot.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCustomerServlet extends CommandServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getParameter("email") + "" + request.getParameter("password"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		CustomerBean customer = new CustomerBean();
		customer.setEmail(email);
		
		customer = DAOFactory.getInstance().getCustomerDAO().addCustomer(customer, password);
		if (customer.getId() == 0) {
			request.setAttribute("name", "register");
			request.setAttribute("value", "trying to register an already in use email");
			return "/error.jsp";
		}
		System.out.println(customer.getId());
		request.getSession().setAttribute("customer", customer);
		return "/search.jsp";
	}

}
