package Exclus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SafficherlisteExclusModule
 */
@WebServlet("/SafficherlisteExclusModule")
public class SafficherlisteExclusModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SafficherlisteExclusModule() {
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
		int idf=Integer.parseInt(request.getParameter("idgroupe"));
		session.setAttribute("idgroupe", idf);
		int idm=Integer.parseInt(request.getParameter("idmodule"));
		session.setAttribute("idmodule", idm);
		response.sendRedirect("ChefDep/pages/ListeTypeModule.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
