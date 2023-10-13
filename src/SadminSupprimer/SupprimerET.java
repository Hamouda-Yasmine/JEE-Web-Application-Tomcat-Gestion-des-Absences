package SadminSupprimer;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminConsulter;
import modele.AdminSupprimer;
import modele.Etudiant;


/**
 * Servlet implementation class SupprimerET
 */
@WebServlet("/SupprimerET")
public class SupprimerET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		  int op=Integer.parseInt(request.getParameter("op"));	
		  AdminSupprimer o=new AdminSupprimer();
		  o.supprimerETU(op);
		  AdminConsulter a=new AdminConsulter();
		  ArrayList<Etudiant> l = a.ConsulterETU();
		  session.setAttribute("liste",l);
		  response.sendRedirect("admin/pages/ConsulterEtudiant.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
