package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proc.Processor;

public class RemoveController implements Controller {

	@Override
	public void ctrl(HttpServletRequest req, HttpServletResponse resp) {

		try {
			if (new Processor().remove(req.getParameter("id"))) {
				req.getRequestDispatcher("result/fin.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("result/fail.jsp?type=remove").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
