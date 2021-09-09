package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	HashMap<String, Controller> serv_map;
	
	@Override
	public void init() throws ServletException {

		serv_map = new HashMap<String, Controller>();
		serv_map.put("/member/add.do", new AddController());
		serv_map.put("/member/remove.do", new RemoveController());
		serv_map.put("/member/search.do", new SearchController());
		serv_map.put("/member/change.do", new ChangeController());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Controller controller = serv_map.get(req.getRequestURI());
		controller.ctrl(req, resp);
	
	}
	
}
