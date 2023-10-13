package faireLappel;

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
import modeleE.Groupe;
import modeleE.mesgroupes;

/**
 * Servlet implementation class SrecupererReleveSection
 */
@WebServlet("/SrecupererReleveSection")
public class SrecupererReleveSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrecupererReleveSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		String name =request.getParameter("name");
		int iduser=Integer.parseInt(request.getParameter("iduser"));
		session.setAttribute("name", name);
		session.setAttribute("iduser",iduser);
		String v[]=request.getParameterValues("absence");
	
		int op=Integer.parseInt(request.getParameter("idsection"));
		
		int op1=Integer.parseInt(request.getParameter("idseance"));
	
		
		FaireLappel f=new FaireLappel();
		  mesgroupes g= new mesgroupes();
			ArrayList<Groupe> l =f.selectionnergroupedunesection(op);
			
			ArrayList<Etudiant >l1=new ArrayList<Etudiant>();
			ArrayList<Etudiant >l2=new ArrayList<Etudiant>();
			for (Groupe gr:l) {
				
				l1.addAll(g.ConsulterLeGroupe(gr.getIdgroupe()));}
		for(int i=0;i<v.length;i++) {
		
				
			for (Etudiant e:l1) {
				
				String n=Integer.toString(e.getIdetudiant());
			
				if (n.equals(v[i])) {
					l2.add(e);
					System.out.println("e added"+v[i]);
				}}}
		
		
		l1.removeAll(l2);
		
		for(Etudiant et:l1) {
			f.InsererAbsence(et.getIdetudiant(),op1);
		}
		
		response.sendRedirect("enseignant/pages/afficherlisteFaireLappelSection.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
