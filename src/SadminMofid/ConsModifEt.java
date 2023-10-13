package SadminMofid;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminModifier;
import modele.Etudiant;


@WebServlet("/ConsModifEt")
public class ConsModifEt extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ConsModifEt() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session =request.getSession(true);
		    int op=Integer.parseInt(request.getParameter("op"));
		    System.out.println(op);
		    AdminModifier m=new AdminModifier ();
			ArrayList<Etudiant> mo =m.selectionEt(op);
		    session.setAttribute("liste",mo);
		    response.sendRedirect("admin/pages/ModifierETU.jsp");
		   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
