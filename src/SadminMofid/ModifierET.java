package SadminMofid;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminConsulter;
import modele.AdminModifier;

import modele.Etudiant;

@WebServlet("/ModifierET")
public class ModifierET extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ModifierET() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		int i= Integer.parseInt(request.getParameter("id"));
		String n=request.getParameter("nom");
		String p=request.getParameter("prenom");
		String mp =request.getParameter("mdp");
		String a =request.getParameter("ad");
		String dn=request.getParameter("dateN");
		String sexe =request.getParameter("sexe");
		String tele =request.getParameter("tele");
		String e =request.getParameter("annee");
	    String e2 =request.getParameter("numbac");
		String em=request.getParameter("email");
		String f =request.getParameter("form");
		
		String des =request.getParameter("des");
		String user =request.getParameter("user");
		System.out.println(des);
	    AdminModifier ao= new AdminModifier();
	    ao.modifierETU(i,n,p,f,a,dn,em,sexe,tele,e2,e,mp,des,user);
	    AdminConsulter al = new AdminConsulter();
	    ArrayList<Etudiant> l = al.ConsulterETU();
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/ConsulterEtudiant.jsp");
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
