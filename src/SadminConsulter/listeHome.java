package SadminConsulter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modele.Etudiant;
import modele.méthodeHOME;


@WebServlet("/listeHome")
public class listeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public listeHome() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		méthodeHOME a= new méthodeHOME();
		ArrayList<Etudiant> l =a.ListeHOME();
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/new.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
