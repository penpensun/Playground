package peng.servlet;
import java.io.*;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Servlet1 implements Servlet{
	
	@Override
	public void destroy() {
		System.out.println("destoryed");
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
		System.out.println("init");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = res.getWriter();
			pw.write("Hello world!");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
