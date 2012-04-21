package bedhot;

import bedhot.servlet.*;

import java.util.HashMap;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class ControlServlet extends HttpServlet {

	private HashMap<String, Command> commands;

	private static final long serialVersionUID = 1L;

	/**
	 * Initializes the servlet.
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		commands = new HashMap<String, Command>();
	    commands.put("PAGE_NOT_FOUND", new NoSuchPageServlet());
	    commands.put("login", new LoginServlet());
	    commands.put("add", new AddToCartServlet());
	    commands.put("checkout",new CheckoutServlet());
	    commands.put("creg", new RegisterCustomerServlet());
	    commands.put("preg", new RegisterProviderServlet());
	    commands.put("plog", new ProviderServlet());
	    commands.put("deal", new MakeDealServlet());
	    commands.put("search", new SearchServlet());
	    commands.put("cupdate", new UpdateCustomerServlet());
	    commands.put("dupdate", new UpdateDealServlet());
	    commands.put("pupdate", new UpdateProviderServlet());
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private final void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Command cmd = resolveCommand(request);
		String next = cmd.execute(request, response);

		while (next.indexOf('.') < 0) {// chaining servlets
			cmd = commands.get(next);
			next = cmd.execute(request, response);
		}
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(next);
		dispatcher.forward(request, response);
	}

	private Command resolveCommand(HttpServletRequest request) {
		Command cmd = commands.get(request.getParameter("do"));
		if (cmd == null) {
			cmd = commands.get("PAGE_NOT_FOUND");
		}
		return cmd;
	}

	@Override
	public String getServletInfo() {
		return "ControlServlet: Controller in MVC of ProProject Bed-Hot Deals";
	}

}
