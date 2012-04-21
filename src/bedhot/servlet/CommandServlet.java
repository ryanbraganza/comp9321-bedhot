package bedhot.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public abstract class CommandServlet extends HttpServlet implements Command{
	private static final long serialVersionUID = 1L;
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
	
	protected final void doGet (HttpServletRequest request, HttpServletResponse response) {
		execute(request, response);
	}
	protected final void doPost (HttpServletRequest request, HttpServletResponse response) {
		execute(request, response);
	}
}
