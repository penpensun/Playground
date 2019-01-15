package peng.servlet;
import java.io.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = res.getWriter();
			pw.write("Hello world!");
			pw.write("This is the class extending GenericServlet");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
