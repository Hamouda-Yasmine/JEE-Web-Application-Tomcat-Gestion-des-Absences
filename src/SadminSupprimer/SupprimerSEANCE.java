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

import modele.Seance;

/**
 * Servlet implementation class SupprimerSEANCE
 */
@WebServlet("/SupprimerSEANCE")
public class SupprimerSEANCE extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerSEANCE() {
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
		  o.supprimerSEA(op);
		  AdminConsulter a=new AdminConsulter();
		  ArrayList<Seance> l = a.ConsulterSEA();
		  session.setAttribute("liste",l);
		  response.sendRedirect("admin/pages/ConsulterSeance.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
