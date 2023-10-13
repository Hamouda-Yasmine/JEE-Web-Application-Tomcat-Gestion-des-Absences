package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SConsEtu")
public class SConsEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SConsEtu() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session =request.getSession(true);
		
	     int kk=Integer.parseInt(request.getParameter("idgrou"));
	     System.out.println("   dd"+kk);
	     session.setAttribute("kk", kk);
	    
		
		response.sendRedirect("ChefDep/pages/ListeEdu.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
