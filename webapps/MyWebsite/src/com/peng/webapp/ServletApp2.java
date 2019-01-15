package com.peng.webapp;
import java.io.IOException;

import javax.servlet.*;
import java.io.*;

public class ServletApp2 implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw =res.getWriter();
			pw.print("<html>");
			pw.print("<body>");
			pw.print("<form method=\"post\">");
			pw.print("<input type=\"input\" name=\"username\" placeholder=\"Input the username\"/><br>");
			pw.print("<input type=\"password\" name=\"password\" placeholder=\"Input the password\"/>");
			pw.print("<input type=\"submit\" name=\"loginSubmit\"/>");
			pw.print("</form>");
			pw.print("</body>");
			pw.print("</html>");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
