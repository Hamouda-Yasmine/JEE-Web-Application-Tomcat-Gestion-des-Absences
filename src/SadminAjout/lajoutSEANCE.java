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
import modele.Seance;

@WebServlet("/lajoutSEANCE")
public class lajoutSEANCE extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public lajoutSEANCE() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session =request.getSession(true);
    	String idf=request.getParameter("idf").toString();
	    String hd=request.getParameter("heureD");
	    String hf= request.getParameter("heureF");
	    String t= request.getParameter("t");
	    String j= request.getParameter("j");
	    String m= request.getParameter("m");
	    String g= request.getParameter("g");
	    String s= request.getParameter("s");
	    String sc= request.getParameter("sc");
	    String idfor= request.getParameter("idfor");
	    AdminAjout opA= new AdminAjout();
	 
	    if(opA.ajouterSéance(idf,hd,hf,j,t,s,m,g,sc)) {
	    	AdminConsulter a=new AdminConsulter();
			  ArrayList<Seance> l = a.ConsulterSEA();
			  session.setAttribute("liste",l);
			  session.setAttribute("idfor",idfor);
			  response.sendRedirect("admin/pages/ConsulterSeance.jsp");
		  	 
	      }
	      else {
	    	  System.out.println(" erreur");
	      }
	    }
	    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
