package SadminAjout;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminAjout;
import modele.AdminConsulter;
import modele.Module;


@WebServlet("/lajoutMOD")
public class lajoutMOD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public lajoutMOD() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session =request.getSession(true);
		String n= request.getParameter("nom");
	    String a=request.getParameter("abr");
	    String s= request.getParameter("form");
	    
	    AdminAjout opA= new AdminAjout();
	    if(opA.ajouterMOD(n,a,s)) {
	     AdminConsulter m=new AdminConsulter();
	   	  ArrayList<Module> l = m.ConsulterMOD();
	   	  session.setAttribute("liste",l);
	   	response.sendRedirect("admin/pages/ConsulterMOD.jsp");
		  	
	      }
	      else {
	    	  System.out.println("erreur");
	      }
	    }
	   
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}

}
