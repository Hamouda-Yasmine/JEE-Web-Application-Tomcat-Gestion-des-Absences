package modeleE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListedesExclus {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
  ArrayList<Etudiant> E;
  Etudiant e;

  ArrayList<Integer> S;
	public ListedesExclus() {
		// TODO Auto-generated constructor stub
	}

	
public ArrayList<Etudiant>  ListeEtud(int i){
	
	
	E =new ArrayList<Etudiant>();
	
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 
		  String t="select idetudiant, nom ,prénom from etudiant where idgroupe="+i;
		  ResultSet R = state.executeQuery(t);
	
		 while(R.next()){
			int id=R.getInt("idetudiant");
			String n=R.getString("nom");
			String p=R.getString("prénom");
		
			
	        e=new  Etudiant(id,n,p);
	        E.add(e);	
	       
		 }
	   
		    state.close();
		    R.close();
		    cn.close();
		    return E;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
	return null;
	
}
public ArrayList<Integer>  ListeSeance(int i1,int i,String s){
	S=new ArrayList<Integer>();
	
	
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 
		  String t="select idséance from séance where  idenseignant="+i1+" and idmodule="+i+" and type='"+s+"'   ";
		  ResultSet R = state.executeQuery(t);
	
		 while(R.next()){
			int id=R.getInt("idséance");
		
		
			
	       
	        S.add(id);	
	       
		 }
	   
		    state.close();
		    R.close();
		    cn.close();
		    return S;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
	return null;
}
public int NombreAbsence(int i1,int i){
	
	
	
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 
		  String t="select count(*) from absence where idséance="+i1+" and idetudiant="+i ;
		  ResultSet R = state.executeQuery(t);
	
		 R.next();
			int id=R.getInt(1);
		
		
			
	       
	       	
	       
		 
	   
		    state.close();
		    R.close();
		    cn.close();
		    return id;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
	return 0;
	
}
		
		
	public int NombreJustification(int i1,int i ) {
		try {
			Class.forName(classforname);
			 cn = DriverManager.getConnection(url, user, passwd);
			 state=cn.createStatement();
			 
			  String t="select count(idjustification) from absence where idséance="+i1+" and idetudiant="+i ;
			  ResultSet R = state.executeQuery(t);
		
			 R.next();
				int id=R.getInt(1);
			
			
				
		       
		       	
		       
			 
		   
			    state.close();
			    R.close();
			    cn.close();
			    return id;
			    	}
		   catch (Exception e) {
			      System.out.println(e.toString()); 
			    }
		return 0;
		
	}
	
	
	
	  public void InsererExclus(int i , int i1, String T) {
			try {
				
					Class.forName(classforname);
					 cn = DriverManager.getConnection(url, user, passwd);
					 state=cn.createStatement();
			     
					 	
					 		
					 		 
state.executeUpdate( "INSERT INTO exclus (idétudiant,idmodule,type) values ('"+i1+"','"+i+"','"+T+"')");
System.out.println(" etu ajouté");			    		

					    	  state.close();
					          cn.close(); }catch (Exception ex) {
					  		      System.out.println(ex.toString()); 
					  		    }
					  			    	
					 	   
			}
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
}
