package controle;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.xdevapi.Statement;

@WebServlet("/SJusRe")
public class SJusRe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
   
    public SJusRe() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 int id=Integer.parseInt(request.getParameter("id"));
		 System.out.println("cccmoi "+id);
	 try {
		 System.out.println("bb0");
		 Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = (Statement) cn.createStatement();
					    PreparedStatement stmt = cn.prepareStatement("select justification from justification where idjustification="+id);
					 	ResultSet R = stmt.executeQuery();
						System.out.println("bb1");
										 
										 if (R.next()) {
									     Blob jus=(Blob) R.getBlob("justification");
									     System.out.println("bb2");
										 byte byteArray[]=jus.getBytes(1,(int) jus.length());
										 System.out.println("bb3");
										 response.setContentType("image/gif");
										 System.out.println("bb4");
										 OutputStream os=response.getOutputStream();
										 System.out.println("5");
										 os.write(byteArray);
										 os.flush();
										 os.close();
										 }
										 else {
											 System.out.println("pas de photo");
										 }
									 	 ((OutputStream) state).close();
								         cn.close(); 
								}    catch (Exception ex) {
								 		      System.out.println(ex.toString()); 

								
								
								}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
