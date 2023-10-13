package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.SupprimerRespo;


@WebServlet("/SupR")
public class SupR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SupR() {
        super();
    }


	
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	
		 int op=Integer.parseInt(request.getParameter("opp"));	
         SupprimerRespo s= new SupprimerRespo();
		 s.supprimerR(op);
         response.sendRedirect("Login/login.jsp");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
