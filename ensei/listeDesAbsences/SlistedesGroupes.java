package listeDesAbsences;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeleE.Groupe;
import modeleE.ListedesAbsences;


/**
 * Servlet implementation class SlistedesGroupes
 */
@WebServlet("/SlistedesGroupes")
public class SlistedesGroupes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlistedesGroupes() {
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
		int op=Integer.parseInt(request.getParameter("iduser"));
		session.setAttribute("iduser",op);
		String name=request.getParameter("name");
		session.setAttribute("name",name);
		
		ListedesAbsences L=new ListedesAbsences();
		ArrayList<Groupe> l =L.selectIDdesgroupe(op);
		session.setAttribute("liste",l);
		response.sendRedirect("enseignant/pages/lesReleveesD'absences.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
