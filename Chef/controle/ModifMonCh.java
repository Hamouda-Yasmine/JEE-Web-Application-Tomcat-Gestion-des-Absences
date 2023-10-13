package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminModifier;
import modele.Enseignant;



@WebServlet("/ModifMonCh")
public class ModifMonCh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifMonCh() {
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
		String e =request.getParameter("email");
		String g =request.getParameter("g");
		String user=request.getParameter("user");
		String f =request.getParameter("form");
		String des =request.getParameter("des");
		String cat =request.getParameter("cat");
	    AdminModifier ao= new AdminModifier(); 
	    ao.modifierENS(i,n,p,dn,a,sexe,tele,mp,e,g,f,des,cat,user);
	    ArrayList<Enseignant> mo =ao.selectionENS(i);
        session.setAttribute("liste",mo);
		response.sendRedirect("ChefDep/pages/MonProfil.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
