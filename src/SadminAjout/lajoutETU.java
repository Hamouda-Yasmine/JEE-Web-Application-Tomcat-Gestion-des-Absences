package SadminAjout;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminAjout;
import modele.AdminConsulter;
import modele.Etudiant;

/**
 * Servlet implementation class lajoutETU
 */
@WebServlet("/lajoutETU")
public class lajoutETU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lajoutETU() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session =request.getSession(true);
		AdminAjout o= new AdminAjout();
		String n=request.getParameter("nom");
		String p=request.getParameter("prenom");
		String a =request.getParameter("ad");
		String dn=request.getParameter("dateN");
		String numB =request.getParameter("numbac");
		String sexe =request.getParameter("sexe");
		String tele =request.getParameter("tele");
		String anne=request.getParameter("annee");
		String des=request.getParameter("des");
		
		String e =request.getParameter("email");
		String niv =request.getParameter("niveau");
		String f =request.getParameter("form");

		
			if(o.ajouterETU(e,n,p,dn,a,dn, numB, sexe, tele, anne,des,f,niv)) {
				 AdminConsulter v=new AdminConsulter();
				  ArrayList<Etudiant> l = v.ConsulterETU();
				  session.setAttribute("liste",l);
				  response.sendRedirect("admin/pages/ConsulterEtudiant.jsp");
			 
			}else {
				response.sendRedirect("erreur");}
			
		
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
