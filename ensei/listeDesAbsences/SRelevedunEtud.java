package listeDesAbsences;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SRelevedunEtud
 */
@WebServlet("/SRelevedunEtud")
public class SRelevedunEtud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SRelevedunEtud() {
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
		
		session.setAttribute("iduser",iduser);
		String name=request.getParameter("name");
		
		session.setAttribute("name",name);
		int op=Integer.parseInt(request.getParameter("op"));
		System.out.println(op);
		session.setAttribute("idetudiant",op);
		response.sendRedirect("enseignant/pages/ReleveD'unEtud.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
