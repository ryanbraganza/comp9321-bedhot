package bedhot.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoSuchPageServlet extends CommandServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/404.jsp";
	}

}
