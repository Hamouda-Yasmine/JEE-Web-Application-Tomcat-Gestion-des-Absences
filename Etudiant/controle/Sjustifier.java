package controle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import modele.ConsABS;
import modele.ListeABS;
import modele.justifier;

@WebServlet("/Sjustifier")
@MultipartConfig(maxFileSize = 16177216)
public class Sjustifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Sjustifier() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
		int op=Integer.parseInt(request.getParameter("opp"));
		ConsABS m=new ConsABS ();
		ArrayList<ListeABS> mo =m.ConsulterABS(op);
	    session.setAttribute("liste",mo);
		Part photo = request.getPart("p");
		InputStream pf = photo.getInputStream();
		int ab=Integer.parseInt(request.getParameter("ab"));
	   
		justifier re=new justifier();
		re.justif(pf,ab);
		

		response.sendRedirect("Etudiant/pages/conslisteabs.jsp");
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
