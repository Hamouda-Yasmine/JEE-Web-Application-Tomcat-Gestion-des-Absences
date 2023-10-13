package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SGroupe")
public class SGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SGroupe() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		
	    int op=Integer.parseInt(request.getParameter("idf"));
	    session.setAttribute("form", op);
	    
		
		response.sendRedirect("ChefDep/pages/ConsulterRec2.jsp");
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
