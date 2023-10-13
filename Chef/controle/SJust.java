package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SJust")
public class SJust extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SJust() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(true);
		
	     int k=Integer.parseInt(request.getParameter("idgrou"));
	 
	     session.setAttribute("k", k);
	    
		
		response.sendRedirect("ChefDep/pages/EspaceJustif.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
