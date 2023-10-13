package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.ConsExclus;
import modele.ListeExclus;
import modele.réclamer;

@WebServlet("/SreclamExclu")
public class SreclamExclu extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SreclamExclu() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		System.out.println("c bon");
		int ab=Integer.parseInt(request.getParameter("ab"));
		System.out.println(ab);
		int op=Integer.parseInt(request.getParameter("opp"));
		System.out.println(op);
		String n=request.getParameter("r");System.out.println(n);
		réclamer re=new réclamer();
		re.reclamerExclu(n,ab);
		System.out.println("c bon");
		ConsExclus m=new ConsExclus ();
		ArrayList<ListeExclus> mo =m.ConsulterExclu(op);
	    session.setAttribute("liste",mo);
		response.sendRedirect("Etudiant/pages/ListeExclu.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
