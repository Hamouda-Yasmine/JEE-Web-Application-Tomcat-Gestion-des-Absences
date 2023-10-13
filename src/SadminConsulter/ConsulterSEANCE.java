package SadminConsulter;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminConsulter;
import modele.Seance;

@WebServlet("/ConsulterSEANCE")
public class ConsulterSEANCE extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ConsulterSEANCE() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session =request.getSession(true);
		AdminConsulter o=new AdminConsulter();
		ArrayList<Seance> l =o.ConsulterSEA();
		session.setAttribute("liste",l);
		response.sendRedirect("admin/pages/ConsulterSeance.jsp");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
