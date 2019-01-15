package peng.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;

public class Servlet3 extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) {
		try {
			PrintWriter pw = res.getWriter();
			pw.write("<html>");
			pw.write("<head><title>servlet3</title></head>");
			pw.write("<body>");
			pw.write("<p>This is a servlet extends GenericServlet</p>");
			pw.write("</body>");
			pw.write("</html>");
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
