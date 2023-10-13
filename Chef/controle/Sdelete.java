package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.jibGroupe;

@WebServlet("/Sdelete")
public class Sdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Sdelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("op"));
		  System.out.println("cc"+id); 
	     jibGroupe lo= new jibGroupe();
	     lo.Delete(id);
	     System.out.println("done"); 
	    
		
		response.sendRedirect("ChefDep/pages/EspaceJustif.jsp");	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
