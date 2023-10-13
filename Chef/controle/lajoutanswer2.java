package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.jibGroupe;


@WebServlet("/lajoutanswer2")
public class lajoutanswer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public lajoutanswer2() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     int id=Integer.parseInt(request.getParameter("id"));
	     String n=request.getParameter("answer");
	     
	     jibGroupe lo= new jibGroupe();
	     lo.insertanswer(n, id);
	     
	    
		
		response.sendRedirect("ChefDep/pages/AfficherRExc.jsp");	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
