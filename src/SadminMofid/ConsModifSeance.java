package SadminMofid;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.AdminModifier;
import modele.Seance;
import java.sql.*;


@WebServlet("/ConsModifSeance")
public class ConsModifSeance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
    public ConsModifSeance() {
        super();
       
    }
    public String getIdf(int i){
		 String ab="";
		 try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		 
				 String m="SELECT formation.abréviation  FROM séance,formation,groupe where séance.idgroupe=groupe.idgroupe and formation.idformation=groupe.idformation and idséance="+i;
			      ResultSet R1 = state.executeQuery(m);
		
			      while(R1.next()){	
					
			      ab=R1.getString("abréviation");
		 
			      }
	    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
	return ab;
	 }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(true);
        int op=Integer.parseInt(request.getParameter("op"));
        String idfor =getIdf(op);
        AdminModifier m=new AdminModifier ();
		ArrayList<Seance> mo =m.selectionSEANCE(op);
	    session.setAttribute("liste", mo);
	    session.setAttribute("idfor", idfor);
	    response.sendRedirect("admin/pages/ModifierSEANCE.jsp");
	   
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}