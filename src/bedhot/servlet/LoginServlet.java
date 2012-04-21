package bedhot.servlet;

import bedhot.beans.CustomerBean;
import bedhot.dao.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends CommandServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		CustomerDAO cdao = DAOFactory.getInstance().getCustomerDAO();
		String action = request.getParameter("action");

		if (action.equals("login")) {
			CustomerBean customer = cdao.login(email, password);
			if (customer == null) {
				request.setAttribute("name", "login");
				request.setAttribute("value", "no such user");
				return "/error.jsp";
			}
			request.getSession().setAttribute("customer",
					cdao.login(email, password));
			return "/search.jsp";
		} else if (action.equals("register")) {
			return "creg";
		} else if (action.equals("preg")) {
			return "preg";
		} else if (action.equals("plog")) {
			return "plog";			
		} else {
			System.err.println(action);
			request.setAttribute("name", "no such action");
			request.setAttribute("value", "what you are doing, huh?");
			return "/error.jsp";
		}
	}

}
