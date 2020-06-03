package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import services.Friends_services;

/**
 * Servlet implementation class Friends
 */
@WebServlet("/Friends")
public class Friends_servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Friends_servlets() {
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
		// Service addFriend
		if (service.equals("addFriend")) {
			try {
				// On recupere les parametres
				String id1 = request.getParameter("id1");
				String id2 = request.getParameter("id2");

				// On recupere le JSON
				JSONObject a_return = Friends_services.addFriend(id1, id2);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Service deleteFriend
		if (service.equals("deleteFriend")) {
			try {
				// on recupere les parametres
				String id1 = request.getParameter("id1");
				String id2 = request.getParameter("id2");

				// On recupere le JSON
				JSONObject a_return = Friends_services.deleteFriend(id1, id2);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Service getFriendList
		if (service.equals("getFriendList")) {
			try {
				// on recupere les parametres
				String id = request.getParameter("id");

				// On recupere le JSON
				JSONObject a_return = Friends_services.getFriendList(id);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

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
