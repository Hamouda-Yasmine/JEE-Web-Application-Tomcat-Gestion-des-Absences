package SadminMofid;

import java.io.IOException;

import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminConsulter;
import modele.AdminModifier;
import modele.Seance;


@WebServlet("/ModifierSEANCE")
public class ModifierSEANCE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifierSEANCE() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session =request.getSession(true);
		int i= Integer.parseInt(request.getParameter("id"));
		System.out.println(i);
    	String idf=request.getParameter("idfor").toString();
    	System.out.println(idf);
	    String hd=request.getParameter("heureD");
	    System.out.println(hd);
	    String hf= request.getParameter("heureF");
	    System.out.println(hf);
	    String t= request.getParameter("t");
	    System.out.println(t);
	    String j= request.getParameter("j");
	    System.out.println(j);
	    String m= request.getParameter("m");
	    System.out.println(m);
	    String g= request.getParameter("g");
	    System.out.println(g);
	    String s= request.getParameter("s");
	    System.out.println(s);
	    String sc= request.getParameter("sc");
	    System.out.println(sc);
	    AdminModifier ao= new AdminModifier();
	    ao.modifierSEA(i,idf,hd,hf,j,t,s,m,g,sc);
	    AdminConsulter al = new AdminConsulter();
	    ArrayList <Seance>l = al.ConsulterSEA();
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/ConsulterSeance.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
