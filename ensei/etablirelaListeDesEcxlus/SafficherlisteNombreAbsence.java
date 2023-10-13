package etablirelaListeDesEcxlus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SafficherlisteNombreAbsence
 */
@WebServlet("/SafficherlisteNombreAbsence")
public class SafficherlisteNombreAbsence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SafficherlisteNombreAbsence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession(true);
		int iduser=Integer.parseInt(request.getParameter("iduser"));
		String name=request.getParameter("name");
		session.setAttribute("iduser", iduser);
		session.setAttribute("name", name);
		int op1=Integer.parseInt(request.getParameter("op1"));
		//int op3=Integer.parseInt(request.getParameter("id"));
		String op=request.getParameter("op").toString();
		System.out.println(op1 );
		session.setAttribute("idmodule",op1);
		//session.setAttribute("id",op3);
		session.setAttribute("type", op);
		
		response.sendRedirect("enseignant/pages/NombreDesabsencedesEtudiants.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
