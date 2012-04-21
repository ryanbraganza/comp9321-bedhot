package bedhot.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bedhot.dao.DAOFactory;
import bedhot.beans.*;

public class RegisterProviderServlet extends CommandServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getParameter("email") + "" + request.getParameter("password"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ProviderBean provider = new ProviderBean();
		provider.setEmail(email);
		provider.setPassword(password);
		provider = DAOFactory.getInstance().getProviderDAO().addProvider(provider);
		
		request.getSession().setAttribute("provider", provider);
		return "/makeDeal.jsp";
	}

}
