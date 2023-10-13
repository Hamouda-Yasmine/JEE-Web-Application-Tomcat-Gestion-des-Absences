package GererProfil;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modeleE.Enseignant;
import modeleE.operationENS;

/**
 * Servlet implementation class SGererENS
 */
@WebServlet("/SGererENS")
public class SGererENS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SGererENS() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int op=Integer.parseInt(request.getParameter("iduser"));
		System.out.println("liste final"+op);
		String name =request.getParameter("name");
		HttpSession session =request.getSession(true);
		operationENS o=new operationENS();
		ArrayList<Enseignant> l = o.selectionENS(op);
		System.out.println("liste final");
		session.setAttribute("name", name);
		session.setAttribute("iduser", op)
		;System.out.println("liste final");
		session.setAttribute("liste",l);
		System.out.println("liste final");
		response.sendRedirect("enseignant/pages/ModifierCompteENS.jsp");
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
