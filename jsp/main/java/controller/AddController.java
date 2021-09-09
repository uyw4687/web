package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Member;
import proc.Processor;

class AddController implements Controller {
	
	@Override
	public void ctrl(HttpServletRequest req, HttpServletResponse resp) {
		
		Member newMember = new Member();
		newMember.setId(req.getParameter("id"));
		newMember.setPw(req.getParameter("pw"));
		newMember.setNick(req.getParameter("nick"));
		newMember.setEmail(req.getParameter("email"));
		
		if (new Processor().add(newMember)) {
			Util.forward(req, resp, "result/fin.jsp?type=add&id="+req.getParameter("id"));
		}
		else {
			Util.forward(req, resp, "result/fail.jsp?type=add");
		}
		
	}
	
}
