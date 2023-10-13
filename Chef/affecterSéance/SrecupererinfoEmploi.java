package affecterSéance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeleC.HomeCHEF;

/**
 * Servlet implementation class SrecupererinfoEmploi
 */
@WebServlet("/SrecupererinfoEmploi")
public class SrecupererinfoEmploi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrecupererinfoEmploi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HomeCHEF h1=new HomeCHEF();
		HttpSession session =request.getSession(true);
		int iduser=Integer.parseInt(request.getParameter("iduser"));
		String name=request.getParameter("name");
		session.setAttribute("iduser", iduser);
		session.setAttribute("name", name);
		int idf=Integer.parseInt(request.getParameter("idformation"));
		session.setAttribute("idformation", idf);
		int idE=Integer.parseInt(request.getParameter("idens"));
		session.setAttribute("idens", idE);
		for(int i=1;i<=1;i++) {
			if (Integer.parseInt(request.getParameter(String.valueOf(i))) != -1) {
		int id=Integer.parseInt(request.getParameter(String.valueOf(i)));
		h1.AffecterIDens(id, idE);}}
		response.sendRedirect("ChefDep/pages/EmploiENS.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
