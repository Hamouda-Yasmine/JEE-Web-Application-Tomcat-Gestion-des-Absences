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
import modeleE.mesgroupes;


@WebServlet("/SrecupererReleve")
public class SrecupererReleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SrecupererReleve() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		String name =request.getParameter("name");
		int iduser=Integer.parseInt(request.getParameter("iduser"));
		session.setAttribute("name", name);
		session.setAttribute("iduser",iduser);
		String v[]=request.getParameterValues("absence");
		System.out.println("idetu"+v[0]);
		int op=Integer.parseInt(request.getParameter("idgroupe"));
		System.out.println("idetu"+op);
		int op1=Integer.parseInt(request.getParameter("idseance"));
		System.out.println("idetu"+op1);
		
		FaireLappel f=new FaireLappel();
		  mesgroupes g=new mesgroupes();
			ArrayList<Etudiant> l =g.ConsulterGroupe(op);
			
			ArrayList<Etudiant >l1=new ArrayList<Etudiant>();
		for(int i=0;i<v.length;i++) {
			for (Etudiant e:l) {
				String n=Integer.toString(e.getIdetudiant());
				
				if (n.equals(v[i])) {
					l1.add(e);
					System.out.println("e added"+v[i]);
				}}}
		
		System.out.println("liste final");
		l.removeAll(l1);
		System.out.println("liste final22");
		for(Etudiant et:l) {
			f.InsererAbsence(et.getIdetudiant(),op1);
			System.out.println("liste final3");
		}
		
		response.sendRedirect("enseignant/pages/listeFaireReleve.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
