package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modele.ConsExclus;

import modele.ListeExclus;

@WebServlet("/ConsulterListeExclus")
public class ConsulterListeExclus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ConsulterListeExclus() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		int op=Integer.parseInt(request.getParameter("opp"));
		ConsExclus m=new ConsExclus ();
		ArrayList<ListeExclus> mo =m.ConsulterExclu(op);
	    session.setAttribute("liste",mo);
	    response.sendRedirect("Etudiant/pages/ListeExclu.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
