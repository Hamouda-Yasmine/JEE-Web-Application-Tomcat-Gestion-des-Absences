package modele;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class justifier {

		public Connection cn;
		public Statement state;
		public ResultSet result;
		public String user="root";
		public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		public String passwd="00000";
		public String classforname="com.mysql.cj.jdbc.Driver";
		ArrayList<justification>ju;
		public justifier() {
			
		}
		
		    public void justif(InputStream photo,int ab){
			   int u=0;
			   
			   try{
				 
		     Class.forName(classforname);
			 cn =(Connection) DriverManager.getConnection(url,user,passwd);
			 state = cn.createStatement();
			 PreparedStatement stmt = cn.prepareStatement("insert into justification (justification,date,étatjustification) values (?,NOW(),2)");
			 stmt.setBinaryStream(1,photo);
			 int i=stmt.executeUpdate();
			 System.out.println(i+" c'est stocké");
			 	
			 	
			 	 ResultSet R = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			 	 if (R.next()) { 
			 		 u=R.getInt(1);
			 		 }
			 	System.out.println(u);
			 	String s ="update absence SET idjustification ='"+u+"' where idabsence="+ab;
	
			 	 state.executeUpdate(s);
			 	 
			 	
			 	  state.close();
		         cn.close(); 
		}    catch (Exception ex) {
		 		      System.out.println(ex.toString()); 
		 		    }
			 	    
		}}
		
		

