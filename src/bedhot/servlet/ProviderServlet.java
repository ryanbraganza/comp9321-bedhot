package bedhot.servlet;

import javax.servlet.http.HttpServletRequest;
import bedhot.beans.ProviderBean;
import javax.servlet.http.HttpServletResponse;

import bedhot.dao.DAOFactory;

public class ProviderServlet extends CommandServlet {


	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		ProviderBean provider = DAOFactory.getInstance().getProviderDAO().login(username, password);
		request.getSession().setAttribute("provider", provider);
		return "/welcome.jsp";
	}

}
