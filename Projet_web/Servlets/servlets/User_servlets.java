package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import services.User_services;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User_servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User_servlets() {
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

		// Service getUser
		if (service.equals("getUser")) {
			try {
				// On recupere les parametres
				String id = request.getParameter("id");

				// On recupere le JSON
				JSONObject a_return = User_services.getUser(id);

				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Service getUserlist
		if (service.equals("getUserlist")) {
			try {
				// On recupere le JSON
				JSONObject a_return = User_services.getUserlist();

				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Service createUser
		if (service.equals("createUser")) {
			try {
				// On recupere les parametres
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				String prenom = request.getParameter("prenom");
				String nom = request.getParameter("nom");
				String pseudo = request.getParameter("pseudo");
				String mail = request.getParameter("mail");
				String sexe = request.getParameter("sexe");
				String date_de_naissance = request.getParameter("date_de_naissance");

				// On recupere le JSON
				JSONObject a_return = User_services.createUser(login, password, prenom, nom, pseudo, mail, sexe,
						date_de_naissance);

				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Service deleteUser
		if (service.equals("deleteUser")) {
			try {
				// On recupere les parametres
				String id = request.getParameter("id");

				// On recupere le JSON
				JSONObject a_return = User_services.deleteUser(id);

				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

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
