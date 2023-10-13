package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.ConsABS;
import modele.ListeABS;
import modele.réclamer;

@WebServlet("/Sreclamer")
public class Sreclamer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Sreclamer() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ab=Integer.parseInt(request.getParameter("ab"));
		String n=request.getParameter("r");
		réclamer re=new réclamer();
		re.reclamer(n,ab);
		System.out.println("c bon");
		HttpSession session =request.getSession(true);
		int op=Integer.parseInt(request.getParameter("opp"));
		ConsABS m=new ConsABS ();
		ArrayList<ListeABS> mo =m.ConsulterABS(op);
	    session.setAttribute("liste",mo);
		response.sendRedirect("Etudiant/pages/conslisteabs.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
