package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Sens")
public class Sens extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Sens() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		 int idens=Integer.parseInt(request.getParameter("id"));
		 System.out.println(idens);
	     String n=request.getParameter("name");
	     System.out.println(n);
	     session.setAttribute("id",idens);
	     session.setAttribute("name",n);
	     response.sendRedirect("enseignant/pages/homeENS.jsp");	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
