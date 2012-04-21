package bedhot.servlet;
import bedhot.beans.*;
import java.util.ArrayList;
import java.util.List;
import bedhot.dao.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends CommandServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		CriteriaBean criteria = new CriteriaBean();
		
		criteria.setDesc(request.getParameter("desc"));
		List<DealBean> deals = DAOFactory.getInstance().getDealDAO().findDeals(criteria);
		if (deals == null) {
			request.setAttribute("name", "search");
			request.setAttribute("value", "findDeals returned null");
			return "/error.jsp";
		}
		ArrayList<DealBean> list = new ArrayList<DealBean>();
		for (DealBean deal : deals) {
			list.add(deal);
		}
		request.setAttribute("list", list);
		return "/results.jsp";
	}

}
