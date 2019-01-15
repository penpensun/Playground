package com.peng.webapp;
import java.io.*;
import javax.servlet.http.*;


public class ServletApp4 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
			pw.print("<p>This is http servlet</p>");
			pw.print("</body>");
			pw.print("</html>");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
