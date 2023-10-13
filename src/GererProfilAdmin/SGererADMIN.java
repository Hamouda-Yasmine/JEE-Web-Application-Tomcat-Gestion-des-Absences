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


@WebServlet("/SGererADMIN")
public class SGererADMIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SGererADMIN() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int op=Integer.parseInt(request.getParameter("opp"));
		System.out.println(op);
		HttpSession session =request.getSession(true);
		operationADMIN o=new operationADMIN();
		ArrayList<Administrateur> l = o.selectionADMIN(op);
		
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/userProfile.jsp");
		 
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
