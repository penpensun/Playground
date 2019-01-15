package com.peng.webapp;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Wel extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Object isLoginObj = req.getSession().getAttribute("isLogin");
			String username = (String)req.getSession().getAttribute("username");
			
			if(isLoginObj == null || !(boolean)isLoginObj)
				res.sendRedirect("login");
			PrintWriter pw = res.getWriter();
			pw.write("<html>");
			pw.write("<body>");
			pw.write("<p>Welcome, "+username+"!!! </p>");
			pw.write("<a href=\"/MyWebsite/logout\">Safe logout</a>");
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
