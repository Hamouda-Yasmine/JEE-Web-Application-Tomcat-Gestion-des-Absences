package modeleE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Administrateur;

public class operationENS {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	  ArrayList<Enseignant>E ;
	  Enseignant ens;

	public operationENS() {
		// TODO Auto-generated constructor stub
	}

	
	public void modifierProfileENS(int i, String a ,String mp,String user1,String tele,String email) {
		try {
			Class.forName(classforname);
			 cn = DriverManager.getConnection(url, user, passwd );
			 state=cn.createStatement();
			 String q="SELECT iduser FROM enseignant where idenseignant="+i;
			   ResultSet R = state.executeQuery(q);
			   R.next();
			  
		    state.executeUpdate("update  enseignant e , user u set e.adresse='"+a+"',e.téléphone='"+tele+"',e.email='"+email+"',u.pass='"+mp+"',u.nom='"+user1+"'  where e.idenseignant="+i+" and u.idUser="+   R.getInt("iduser") ); 
		    //state.executeUpdate("update  user  set pass='"+mp+"',nom='"+user1+"'  where idUser="+   R.getInt("iduser"));
		   
		    
		state.close();
		 cn.close();}
		   catch(Exception ex) {}}

	public void supprimerCompteENS(int i) {
		try {
			Class.forName(classforname);
			 cn = DriverManager.getConnection(url, user, passwd);
			 state=cn.createStatement();
			
			 
			 state.executeUpdate("DELETE FROM enseignant  WHERE idUser="+i); 
		     state.executeUpdate("ALTER TABLE Enseignant AUTO_INCREMENT=0"); 
		    
		     
		 state.close();
		  cn.close();}
		    catch(Exception ex) {}
		
 }
	public ArrayList<Enseignant> selectionENS(int i){
		 E=new ArrayList<Enseignant>();


			
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				 Statement state1=cn.createStatement();
				  String t="select * from enseignant where idUser="+i;
				
				  ResultSet R = state.executeQuery(t);
				  R.next();
			      ResultSet R1= state1.executeQuery("select * from user where idUser="+i);
				R1.next();
					int id=R.getInt("idenseignant");
					
					String n=R.getString("nom");
					String p=R.getString("prénom");
					String s=R.getString("adresse");
					String tele=R.getString("téléphone") ;
			        String email=R.getString("email");
			        String user =R1.getString("nom");
			        String pass= R1.getString("pass");
			      
			        ens=new Enseignant(n,p,s,tele,id,email,pass,user);
				       E.add(ens);
			       
	   
				
				    state.close();
				    R.close();
				    R1.close();
				    cn.close();
				    return E;
				    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
			return null;
	}
}

//
