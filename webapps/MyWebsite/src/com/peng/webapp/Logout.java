package com.peng.webapp;
import javax.servlet.http.*;
import java.io.*;

public class Logout extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter pw = res.getWriter();
			req.getSession().removeAttribute("username");
			req.getSession().setAttribute("isLogin", false);
			pw.write("your have successfully loggined out.");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
