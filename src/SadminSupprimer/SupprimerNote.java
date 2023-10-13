package SadminSupprimer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modele.méthodeHOME;


@WebServlet("/SupprimerNote")
public class SupprimerNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SupprimerNote() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			 int id=Integer.parseInt(request.getParameter("idn"));
			 System.out.println("rah yjab le int");
			 System.out.println(id);
			 méthodeHOME a=new méthodeHOME();
			 a.suppnote(id);
			 response.sendRedirect("admin/pages/homeADMIN.jsp");
			
			
		
		 
		 
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
