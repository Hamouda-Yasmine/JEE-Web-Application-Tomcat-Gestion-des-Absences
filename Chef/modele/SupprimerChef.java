package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SupprimerChef {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	

public void supprimerC(int i) {
	int id=0;
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 ResultSet fi =state.executeQuery("select iduser from enseignant where idenseignant ='"+i+"'");
			
	 	 if (fi.next()) { 
	 		 
	 		 id=fi.getInt(1);
	 		 }
	 	 state.executeUpdate("update user set categorie='ens' where user.idUser="+id  ); 
		 state.executeUpdate("DELETE FROM chefdedépartement WHERE idenseignant = "+i); 
		 state.executeUpdate("ALTER TABLE chefdedépartement AUTO_INCREMENT=0");
	    
	     
	 state.close();
	  cn.close();}
	    catch(Exception ex) {}
	
}}