package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Administrateur;
import modele.Chef;
import modele.Enseignant;
import modele.Etudiant;
import modele.Respo;
import modele.User;
import modele.login;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session =request.getSession(true);
		String nom =request.getParameter("nom");
		String mdp =request.getParameter("mdp");
		User u=login.verifierlogin(nom, mdp);
		String x=u.getCategorie();
		Etudiant e=login.idetu(nom, mdp);
		Administrateur a=login.idadm(nom,mdp);
		Enseignant ens=login.idens(nom, mdp);
		Chef c=login.idc(nom,mdp);
		Respo r=login.idr(nom,mdp);
		
		switch(x) {
		  case "ens":
			  session.setAttribute("id", u.getIdUser());
			  session.setAttribute("name", u.getNom());
			  session.setAttribute("i", ens.getIdenseignant());
			  session.setAttribute("n", ens.getPrenom());

			  response.sendRedirect("enseignant/pages/homeENS.jsp");
	     	  break;
	     	  
		  case "etu":
			  session.setAttribute("id", u.getIdUser());
			  session.setAttribute("name", u.getNom());
			  session.setAttribute("i", e.getIdetudiant());
			  session.setAttribute("n", e.getPrenom());
		    
			  response.sendRedirect("Etudiant/pages/homeETU.jsp");
	     	  break;
		  case "admin":
			  session.setAttribute("id", u.getIdUser());
			  session.setAttribute("name", u.getNom());
			  session.setAttribute("i", a.getIdadministrateur());
			  session.setAttribute("n", a.getPrenom());
		      
		      response.sendRedirect("admin/pages/homeADMIN.jsp");break;
		  case "chef":
			  session.setAttribute("id", u.getIdUser());
			  session.setAttribute("name", u.getNom());
			  session.setAttribute("i", ens.getIdenseignant());
			  session.setAttribute("n", ens.getPrenom());
			  session.setAttribute("idc", c.getIdchef());
			  response.sendRedirect("ChefDep/pages/homeCHEF.jsp");break;
		
		  case "res":
			  session.setAttribute("id", u.getIdUser());
			  session.setAttribute("name", u.getNom());
			  session.setAttribute("i", ens.getIdenseignant());
			  session.setAttribute("n", ens.getPrenom());
			  session.setAttribute("idr", r.getIdrespo());
			  System.out.println(r.getIdrespo());
			  response.sendRedirect("RespoForm/pages/homeRF.jsp");break;
		 
		
		  default:
			  response.sendRedirect("Login/login.jsp");break; }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
