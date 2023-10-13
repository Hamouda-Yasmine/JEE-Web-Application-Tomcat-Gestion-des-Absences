package Exclus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SListegroupeEXCLUS
 */
@WebServlet("/SListegroupeEXCLUS")
public class SListegroupeEXCLUS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SListegroupeEXCLUS() {
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
		int idg=Integer.parseInt(request.getParameter("idgroupe"));
		session.setAttribute("idgroupe", idg);
		int idf=Integer.parseInt(request.getParameter("idformation"));
		session.setAttribute("idformation", idf);
		response.sendRedirect("ChefDep/pages/ListegroupeExclus.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
