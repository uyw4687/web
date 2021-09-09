package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String url) {
		try {
			req.getRequestDispatcher(url).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
