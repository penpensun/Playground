package com.peng.webapp;
import javax.servlet.http.*;
import java.io.*;

public class SessionTest1 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession sess = req.getSession();
		try {
			PrintWriter pw = res.getWriter();
			String sessId = sess.getId();
			pw.write("The session id for servlet session test1 is: "+sessId);
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
