package com.peng.webapp;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Login extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			PrintWriter pw =res.getWriter();
			pw.print("<html>");
			pw.print("<body>");
			pw.print("<form method=\"post\">");
			pw.print("<input type=\"input\" name=\"username\" placeholder=\"Input the username\"/><br>");
			pw.print("<input type=\"password\" name=\"password\" placeholder=\"Input the password\"/>");
			pw.print("<input type=\"submit\" name=\"loginSubmit\"/>");
			pw.print("</form>");
			pw.print("<p>This is generic servlet</p>");
			pw.print("</body>");
			pw.print("</html>");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try{
			res.sendRedirect("logincl?username="+username+"&password="+password);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
