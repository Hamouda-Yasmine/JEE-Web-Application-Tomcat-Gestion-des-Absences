package GererProfilAdmin;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.*;

@WebServlet("/SmodifierProfilADMIN")
public class SmodifierProfilADMIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SmodifierProfilADMIN() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int op=Integer.parseInt(request.getParameter("id"));
		String n=request.getParameter("nom");
		
		String p=request.getParameter("prenom");
		
		String a =request.getParameter("ad");
		
		String tele =request.getParameter("tele");
		
		String e =request.getParameter("email");
		
		String pass =request.getParameter("mdp");
		
		String user =request.getParameter("user");
		
		String dn =request.getParameter("dateN");
		
		String se =request.getParameter("sexe");
		
		String des =request.getParameter("des");
		
		operationADMIN o= new operationADMIN();
		o.modifierProfileADMIN(op,n,user,p,a,e,pass,tele,dn,se,des);
		ArrayList<Administrateur> l = o.selectionADMIN(op);
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/userProfile.jsp");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
