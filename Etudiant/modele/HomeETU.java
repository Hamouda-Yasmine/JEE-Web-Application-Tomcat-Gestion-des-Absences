package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomeETU {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	String m;

	public HomeETU() {
		
	}
	 public String SelectionnerModule(int i) {
		 try
         {
        Class.forName(classforname);
 	    cn =(Connection) DriverManager.getConnection(url,user,passwd);
 	    state = cn.createStatement();
 	    String query="select abréviation from module where idmodule="+i;
         ResultSet rs=state.executeQuery(query);
         rs.next();
          m=rs.getString("abréviation");
         
         state.close();
		 cn.close();
		 rs.close();
		 return m;
		   
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return "";
      
	 }

}

