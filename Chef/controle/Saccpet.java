package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modele.jibGroupe;


@WebServlet("/Saccpet")
public class Saccpet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Saccpet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("op"));
	    
	     jibGroupe lo= new jibGroupe();
	     lo.Accpet(id);
	     
	    
		
	     response.sendRedirect("ChefDep/pages/EspaceJustif.jsp");	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
