package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import services.Authentification_services;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification_servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentification_servlets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// pour savoir quel service utiliser
		String service = request.getParameter("service");

		// Selon le service necessaire, on va dans le bon if
		// Service login
		if (service.equals("login")) {
			try {
				// On recupere les parametres
				String login = request.getParameter("login");
				String password = request.getParameter("password");

				// On recupere le JSON
				JSONObject a_return = Authentification_services.login(login, password);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return);

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Service logout
		if (service.equals("logout")) {
			try {
				// On recupere les parametres
				String id = request.getParameter("id");

				// On recupere le JSON
				JSONObject a_return = Authentification_services.logout(id);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return);

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
