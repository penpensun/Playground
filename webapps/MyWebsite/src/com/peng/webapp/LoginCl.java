package com.peng.webapp;
import java.io.IOException;

import javax.servlet.http.*;

public class LoginCl extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		// this verifies the username and the password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("admin") & password.equals("admin"))
			try {
				req.getSession().setAttribute("isLogin", true);
				req.getSession().setMaxInactiveInterval(10);
				req.getSession().setAttribute("username", username);
				res.sendRedirect("wel");
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req, res);
	}
	
	@Override
	public void destroy() {
		System.out.println("LoginCl destoryed!");
	}
	
	
}
