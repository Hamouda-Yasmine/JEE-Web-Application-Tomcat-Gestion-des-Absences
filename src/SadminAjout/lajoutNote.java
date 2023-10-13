package SadminAjout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modele.méthodeHOME;


@WebServlet("/lajoutNote")
public class lajoutNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public lajoutNote() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String n=request.getParameter("note");
		
		 int id=Integer.parseInt(request.getParameter("id"));
		
		 méthodeHOME a=new méthodeHOME();
		 a.insertnote(n,id);
		 response.sendRedirect("admin/pages/homeADMIN.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
