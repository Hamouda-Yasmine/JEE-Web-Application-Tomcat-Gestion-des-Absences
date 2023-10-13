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
import modele.Enseignant;


@WebServlet("/SajoutEns")
public class SajoutEns extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SajoutEns() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(true);
		
		String n=request.getParameter("nom");
		String p=request.getParameter("prenom");
		String dn=request.getParameter("dateN");
		String sexe =request.getParameter("sexe");
		String a =request.getParameter("ad");
		String tele =request.getParameter("tele");
		String cr =request.getParameter("cr");
		String e =request.getParameter("email");
		String g =request.getParameter("g");
	    String f =request.getParameter("form");
	    String de =request.getParameter("des");
	   AdminAjout opA= new AdminAjout();
	   
		if(opA.ajouterENS(n,p,dn,a,dn,e,sexe,tele,g,f,de,cr)){
			AdminConsulter v=new AdminConsulter();
			  ArrayList<Enseignant> l = v.ConsulterENS();
			  session.setAttribute("liste",l);
			 response.sendRedirect("admin/pages/ConsulterEnseignant.jsp");
		
		   }
		   else {
			   System.out.println("existe déjà");
		   }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
