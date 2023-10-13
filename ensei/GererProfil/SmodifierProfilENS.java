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

import modele.*;
import modeleE.Enseignant;
import modeleE.operationENS;

/**
 * Servlet implementation class SmodifierProfilENS
 */
@WebServlet("/SmodifierProfilENS")
public class SmodifierProfilENS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmodifierProfilENS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		int op=Integer.parseInt(request.getParameter("iduser"));
		
		String name =request.getParameter("name");
		
		
		session.setAttribute("iduser", op);
		session.setAttribute("name", name);
		operationENS o= new operationENS();
		int op1=Integer.parseInt(request.getParameter("id"));
		String mp =request.getParameter("mdp");
		System.out.println(mp);
		String a =request.getParameter("ad");
	    String user=request.getParameter("user");
		String tele =request.getParameter("tele");
		String email=request.getParameter("email");
		session.setAttribute("name", user);
		o.modifierProfileENS(op1,  a, mp, user, tele,email);
		
		ArrayList<Enseignant> l = o.selectionENS(op);
		session.setAttribute("liste",l);
		response.sendRedirect("enseignant/pages/ModifierCompteENS.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
