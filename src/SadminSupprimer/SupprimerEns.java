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
import modele.Enseignant;

@WebServlet("/SupprimerEns")
public class SupprimerEns extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SupprimerEns() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		  int op=Integer.parseInt(request.getParameter("op"));	
		  AdminSupprimer o=new AdminSupprimer();
		  o.supprimerENS(op);
		  AdminConsulter a=new AdminConsulter();
		  ArrayList<Enseignant> l = a.ConsulterENS();
		  session.setAttribute("liste",l);
		  response.sendRedirect("admin/pages/ConsulterEnseignant.jsp");
		  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
