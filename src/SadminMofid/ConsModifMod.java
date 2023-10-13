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
import modele.Module;

/**
 * Servlet implementation class ConsModifMod
 */
@WebServlet("/ConsModifMod")
public class ConsModifMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsModifMod() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
        int op=Integer.parseInt(request.getParameter("op"));
        AdminModifier m=new AdminModifier ();
		ArrayList<Module> mo =m.selectionMOD(op);
	    session.setAttribute("liste",mo);
	    response.sendRedirect("admin/pages/modifierMOD.jsp");
	   
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
