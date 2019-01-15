package com.peng.webapp;
import java.io.IOException;
import java.io.*;

import javax.servlet.*;

public class ServletApp1 implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destoryed!");
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
		System.out.println("Servlet inited");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter pw = res.getWriter();
			pw.println("Service called");
			pw.println("Service implemented");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
