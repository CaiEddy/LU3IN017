package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Test extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		String z = req.getParameter("z");
		writer.println(z);
		writer.print("<br/>");
		writer.println("ON FAIT PAS DU TOMCAT NOUS ??? !!!");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}