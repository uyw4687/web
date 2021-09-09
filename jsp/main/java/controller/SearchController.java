package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Member;
import proc.Processor;

public class SearchController implements Controller {

	@Override
	public void ctrl(HttpServletRequest req, HttpServletResponse resp) {
		
		Member member = new Processor().search(req.getParameter("id"));
		req.setAttribute("member", member);
		req.setAttribute("checked", true);
		
		if (req.getParameter("source").equals("change")) {
			Util.forward(req, resp, "change.jsp");
		}
		else {
			Util.forward(req, resp, "search.jsp");
		}
		
	}

}
