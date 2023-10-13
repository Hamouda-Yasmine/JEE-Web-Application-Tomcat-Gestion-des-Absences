package etablirelaListeDesEcxlus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeleE.Etudiant;
import modeleE.FaireLappel;
import modeleE.ListedesExclus;
import modeleE.mesgroupes;

/**
 * Servlet implementation class SrecupererlisteExclus
 */
@WebServlet("/SrecupererlisteExclus")
public class SrecupererlisteExclus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrecupererlisteExclus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session =request.getSession(true);
		int iduser=Integer.parseInt(request.getParameter("iduser"));
		String name=request.getParameter("name");
		session.setAttribute("iduser", iduser);
		session.setAttribute("name", name);
		String v[]=request.getParameterValues("exclus");
	
		String t=request.getParameter("type");
		int op1=Integer.parseInt(request.getParameter("idmodule"));
		System.out.println("le module"+op1);
		
		ListedesExclus l= new ListedesExclus();
			
		for(int i=0;i<v.length;i++) {
			
			l.InsererExclus(op1,Integer.parseInt(v[i]),t);
		}
		
		response.sendRedirect("enseignant/pages/Lesmodulesdel'ENS.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
