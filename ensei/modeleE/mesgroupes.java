package modeleE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modele.AdminConsulter;
import modele.Module;



public class mesgroupes {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	ArrayList<Groupe>G;
	Groupe grp;
	ArrayList<Etudiant>E;
	Etudiant etu;
	 ArrayList<Seance> S;
	public mesgroupes() {
		// TODO Auto-generated constructor stub
	}
	 public ArrayList<Groupe> selectionGroupe(int i){
		 G =new ArrayList<Groupe>();
		
			try {
				
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				 ResultSet R2 = state.executeQuery("select idEnseignant from  enseignant where idUser="+i);
				 R2.next();
				  String t=" select * from groupe where idgroupe in (select idgroupe from prendreencharge where idenseignant="+R2.getInt("idenseignant")+" )";
				  
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
			
			
					int id=R.getInt("idgroupe");
					String n=R.getString("nom");
				
					String ni=R.getString("niveau");
					
					int idS=R.getInt("idsection");
					 
			    
			        grp=new Groupe(id,n,ni,idS);
			  G.add(grp);	
			      
				 }
				 
				 System.out.println("liste groupe recuperer"); 
			
				
				    state.close();
				     
				    cn.close();
				    R.close();
				    return G;
				    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
			return null;
		 
	 }
	 public ArrayList<Etudiant> ConsulterGroupe(int i){
		
		 AdminConsulter ad= new AdminConsulter();
			E =new ArrayList<Etudiant>();
		
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				 ResultSet R1=state.executeQuery("select idgroupe from séance where idséance="+i);
				 R1.next();
				  String t="select idetudiant, nom ,prénom,email,datedenaissance,idformation , idgroupe from etudiant where idgroupe="+R1.getInt("idgroupe");
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
					int id=R.getInt("idetudiant");
					int idg=R.getInt("idgroupe");
					String n=R.getString("nom");
					String p=R.getString("prénom");
					String e=R.getString("email");
					String d=R.getString("datedenaissance");
					String s =ad.specENS(R.getInt("idformation"));
			        etu=new  Etudiant(id,n,p,d,s,e,idg);
			        E.add(etu);	
			       
				 }
			   
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
	 public ArrayList<Seance> selectionSeance1(int i){
		 S=new ArrayList<Seance>();
		
			try {
				
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				 ResultSet R2 = state.executeQuery("select idEnseignant from  enseignant where idUser="+i);
				 R2.next();
				  String t=" select * from séance s,module m where idenseignant="+R2.getInt("idenseignant")+"and   s.idmodule=m.idmodule";
				  
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
			
			
					int id=R.getInt("idgroupe");
					String n=R.getString("nom");
				
					String ni=R.getString("niveau");
					
					int idS=R.getInt("idsection");
					 
			    
			        grp=new Groupe(id,n,ni,idS);
			  G.add(grp);	
			      
				 }
				 
				 System.out.println("liste groupe recuperer"); 
			
				
				    state.close();
				     
				    cn.close();
				    R.close();
				    return S;
				    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
			return null;
		 
	 }
	 public ArrayList<Etudiant> ConsulterLeGroupe(int i){
			
		 AdminConsulter ad= new AdminConsulter();
			E =new ArrayList<Etudiant>();
		
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();

				  String t="select idetudiant, nom ,prénom,email,datedenaissance,idformation,idgroupe from etudiant where idgroupe="+i;
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
					int id=R.getInt("idetudiant");
					int idg=R.getInt("idgroupe");
					String n=R.getString("nom");
					String p=R.getString("prénom");
					String e=R.getString("email");
					String d=R.getString("datedenaissance");
					String s =ad.specENS(R.getInt("idformation"));
					
			        etu=new  Etudiant(id,n,p,d,s,e,idg);
			        E.add(etu);	
			       
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
	 
}

