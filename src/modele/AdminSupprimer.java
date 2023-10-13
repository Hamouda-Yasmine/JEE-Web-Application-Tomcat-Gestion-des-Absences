package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminSupprimer {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	
	
	public void supprimerMOD (int i) {
		try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 
	    state.executeUpdate("DELETE FROM module WHERE idmodule = "+i); 
	    state.executeUpdate("ALTER TABLE module AUTO_INCREMENT=0"); 
	   
	    System.out.println("il a supprimé mod ");
	state.close();
	 cn.close();}
	   catch(Exception ex) {}
	}
		

	public void supprimerSEA (int i) {

		try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 
	    state.executeUpdate("DELETE FROM séance WHERE idséance = "+i); 
	    state.executeUpdate("ALTER TABLE séance AUTO_INCREMENT=0"); 
	   
	    
	state.close();
	 cn.close();}
	   catch(Exception ex) {}
	
	}
	
	
	public void supprimerENS(int i) {
		int id=0;
		try {
			Class.forName(classforname);
			 cn = DriverManager.getConnection(url, user, passwd);
			 state=cn.createStatement();
			 ResultSet fi =state.executeQuery("select iduser from enseignant where idenseignant ='"+i+"'");
				
		 	 if (fi.next()) { 
		 		 
		 		 id=fi.getInt(1);
		 		 }
			 state.executeUpdate("DELETE FROM enseignant  WHERE idenseignant = "+i); 
			 state.executeUpdate("DELETE FROM user WHERE idUser = "+id); 
		     state.executeUpdate("ALTER TABLE enseignant AUTO_INCREMENT=0"); 
		     state.executeUpdate("ALTER TABLE user AUTO_INCREMENT=0");
			 state.executeUpdate("DELETE FROM chefdedépartement WHERE idenseignant = "+i); 
			 state.executeUpdate("ALTER TABLE chefdedépartement AUTO_INCREMENT=0");
			 state.executeUpdate("DELETE FROM responsableformation WHERE idenseignant = "+i); 
			 state.executeUpdate("ALTER TABLE responsableformation AUTO_INCREMENT=0");
		 state.close();
		  cn.close();}
		    catch(Exception ex) {}
		
 }
public void supprimerETU(int i) {
	int id=0;
try {
	Class.forName(classforname);
	 cn = DriverManager.getConnection(url, user, passwd);
	 state=cn.createStatement();
	 
	 ResultSet fi =state.executeQuery("select iduser from etudiant where idetudiant ='"+i+"'");
		
 	 if (fi.next()) { 
 		 
 		 id=fi.getInt(1);
 		 }
 	 
     state.executeUpdate("DELETE FROM etudiant WHERE idetudiant = "+i); 
     state.executeUpdate("DELETE FROM user WHERE idUser = "+id); 
     state.executeUpdate("ALTER TABLE etudiant AUTO_INCREMENT=0"); 
     state.executeUpdate("ALTER TABLE user AUTO_INCREMENT=0"); 
     
 state.close();
  cn.close();}
    catch(Exception ex) {}
}

}

