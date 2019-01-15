package com.peng.webapp;
import javax.servlet.*;
import java.io.*;

public class ServletApp3 extends GenericServlet {

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
			pw.print("<p>This is generic servlet</p>");
			pw.print("</body>");
			pw.print("</html>");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
