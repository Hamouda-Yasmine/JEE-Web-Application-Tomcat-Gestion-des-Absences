package modeleE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HomeENS {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	  String abrev;
	  String Gr;
	  int id;
	   public int selectIDens(int i) {
		   try
           {
           Class.forName(classforname);
          
           String query="select idenseignant from Enseignant where idUser="+i ;
           
           Connection cn= (Connection)DriverManager.getConnection(url,user,passwd);
           Statement state=cn.createStatement();
           ResultSet rs=state.executeQuery(query);
           rs.next();
           id =rs.getInt(1);
           state.close();
		     
		    cn.close();
		    rs.close();
		   
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
           return id;
        
	   }
	  
	  
	  
		
		 public String selectionGroupe(int i){
				
				
				try {
					
					Class.forName(classforname);
					 cn = DriverManager.getConnection(url, user, passwd);
					 state=cn.createStatement();
					 
					  String t=" select nom  from groupe where idgroupe="+i;
					  
					  ResultSet R = state.executeQuery(t);
				          R.next();
					
				          Gr= R.getString("nom");
				          
					    state.close();
					     
					    cn.close();
					    R.close();
					   
					    	}
				   catch (Exception e) {
					      System.out.println(e.toString()); 
					    }
				
				
			 return Gr;
		 }
		 public String selectionNomsection(int i){
				
				
				try {
					
					Class.forName(classforname);
					 cn = DriverManager.getConnection(url, user, passwd);
					 state=cn.createStatement();
					 
					  String t=" select nom from section  where idsection="+i;
					  
					  ResultSet R = state.executeQuery(t);
				          R.next();
					
				          abrev= R.getString("nom");
					    state.close();
					     
					    cn.close();
					    R.close();
					   
					    	}
				   catch (Exception e) {
					      System.out.println(e.toString()); 
					    }
				
				
			 return abrev;
		 }


}
