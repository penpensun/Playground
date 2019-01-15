package com.peng.webapp;
import javax.servlet.http.*;
import java.io.*;

public class SessAttrTest extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession sess = req.getSession();
		sess.setAttribute("SessionAttr1", "This is session attribute 1.");
		sess.setAttribute("SessionAttr2", new StringBuilder("This is string builder as attr. 2"));
		
		try {
			PrintWriter pw = res.getWriter();
			pw.write("Session attribute1: "+ (String)sess.getAttribute("SessionAttr1")+"\n");
			pw.write("Session attribute2: "+ sess.getAttribute("SessionAttr2").toString()+"\n");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
