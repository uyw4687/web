package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Member;
import proc.Processor;

public class ChangeController implements Controller {

	@Override
	public void ctrl(HttpServletRequest req, HttpServletResponse resp) {

		Member member = new Member();
		member.setId(req.getParameter("id"));
		member.setPw(req.getParameter("pw"));
		member.setNick(req.getParameter("nick"));
		member.setEmail(req.getParameter("email"));

		if (new Processor().change(member)) {
			Util.forward(req, resp, "result/fin.jsp?type=change");
		}
		else {
			Util.forward(req, resp, "result/fail.jsp?type=change");
		}
		
	}

}
