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
import modele.Module;


@WebServlet("/ModifierMod")
public class ModifierMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifierMod() {
        super();
  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession(true);
		int i= Integer.parseInt(request.getParameter("id"));
		String n= request.getParameter("nom");
	    String a=request.getParameter("abr");
	    String s= request.getParameter("spc");
	    AdminModifier ao= new AdminModifier();
	    ao.modifierMOD(i, n, a, s);
	    AdminConsulter al = new AdminConsulter();
	    ArrayList<Module> l = al.ConsulterMOD();
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/ConsulterMOD.jsp");
		 
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
