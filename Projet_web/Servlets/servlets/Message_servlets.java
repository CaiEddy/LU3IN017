package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import services.Message_services;

/**
 * Servlet implementation class Message
 */
@WebServlet("/Message")
public class Message_servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Message_servlets() {
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
		// Service addMessage
		if (service.equals("addMessage")) {
			try {
				// On recupere les parametres
				String id = request.getParameter("id");
				String text = request.getParameter("text");

				// On recupere le JSON
				JSONObject a_return = Message_services.addMessage(id, text);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Service deleteMessage
		if (service.equals("deleteMessage")) {
			try {
				// on recupere les parametres
				String id_user = request.getParameter("id_user");
				String id_msg = request.getParameter("id_msg");

				// On recupere le JSON
				JSONObject a_return = Message_services.deleteMessage(id_user, id_msg);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Service listMessage
		if (service.equals("listMessage")) {
			try {
				// on recupere les parametres
				String id = request.getParameter("id");

				// On recupere le JSON
				JSONObject a_return = Message_services.listMessage(id);

				// Affichage
				PrintWriter out = response.getWriter();
				out.print(a_return.toString());

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Service setMessage
		if (service.equals("setMessage")) {
			try {
				// on recupere les parametres
				String id_user = request.getParameter("id_user");
				String id_msg = request.getParameter("id_msg");
				String text = request.getParameter("text");

				// On recupere le JSON
				JSONObject a_return = Message_services.setMessage(id_user, id_msg, text);

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
