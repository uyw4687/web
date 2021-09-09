package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Controller {
	
	public void ctrl(HttpServletRequest req, HttpServletResponse resp);
	
}
