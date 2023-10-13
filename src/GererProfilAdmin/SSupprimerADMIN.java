package GererProfilAdmin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.operationADMIN;


@WebServlet("/SSupprimerADMIN")
public class SSupprimerADMIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SSupprimerADMIN() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int op=Integer.parseInt(request.getParameter("op"));
		operationADMIN o=new operationADMIN();
	    o.supprimerCompteADMIN(op);
	    System.out.println("supprime2");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
