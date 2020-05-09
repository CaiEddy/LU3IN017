package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		
		writer.println("HELLO WORLD !!!");
		writer.println("LUCIE ON A REUSSI AHAHAHHAHAHAHA");
		writer.println("ON VA PAS T'EXPLIQUER !!!!!!!");
		
	}

}
	