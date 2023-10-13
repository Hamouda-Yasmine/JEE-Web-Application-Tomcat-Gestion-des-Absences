package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Blob;

public class jibGroupe {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	ArrayList<groupe> gro;
	groupe group;
	ArrayList<Etudiant> ETU;
	Etudiant e;
	ListeReclamation lr;
	ArrayList<ListeReclamation> LR;
	ArrayList<ListeJustification> jus;
	ListeJustification j;
public ArrayList<groupe> getGroup(int idf) {
	gro=new ArrayList<groupe>();
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		 
		    String q="SELECT nom,idgroupe FROM groupe  where idformation="+idf   ;
		  
		    ResultSet R =  state.executeQuery(q);
		    
		 	  while(R.next()){
		 		String g =R.getString("nom"); 
		 	
		 		int idgr=R.getInt("idgroupe");
		 
		 		
		 		 group=new  groupe(idgr,g);
			        gro.add(group);
		 	  }
		 
		    
		    cn.close();
			 state.close();
			 return gro;
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	 return null;
}

public ArrayList<Etudiant> getEtudiant(int idg) {
	AdminConsulter ad= new AdminConsulter();
	ETU=new ArrayList<Etudiant>();
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		 
		    String q="SELECT *,groupe.nom FROM etudiant,groupe  where etudiant.idgroupe=groupe.idgroupe and etudiant.idgroupe="+idg   ;
		  
		    ResultSet R =  state.executeQuery(q);
		    
		 	  while(R.next()){
		 		 int id=R.getInt("idetudiant");
		 		 System.out.println(id);
					String n=R.getString("etudiant.nom");
					System.out.println(n);
					String p=R.getString("prénom");
					System.out.println(p);
					String em=R.getString("email");
					System.out.println(em);
					String d=R.getString("datedenaissance");
					System.out.println(d);
					String s =ad.specENS(R.getInt("idformation"));
					System.out.println(s);
					String ng=R.getString("groupe.nom");
					String t=R.getString("téléphone");
					String ab=R.getString("annéedebac");
					String adr=R.getString("adresse");
		 		
		 		 e=new  Etudiant(id,n,p,d,s,em,ng,t,ab,adr);
			        ETU.add(e);
		 	  }
		 	
		   
		   
		    
		    cn.close();
			 state.close();
			 return ETU;
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	 return null;
}
public ArrayList<ListeReclamation> getReclt(int idg) {
	
	LR=new ArrayList<ListeReclamation>();
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		 
		    String q="SELECT etudiant.idetudiant,etudiant.nom,prénom,idabsence,date,sujet,abréviation,réclamation.idréclamation  FROM etudiant,absence,réclamation,séance,module where  absence.idetudiant=etudiant.idetudiant and réclamation.idréclamation=absence.idréclamation and étatréclamation=0  and absence.idséance=séance.idséance and séance.idmodule=module.idmodule and etudiant.idgroupe="+idg ;
		  
		    ResultSet R =  state.executeQuery(q);
		    
		 	  while(R.next()){
		 		 int id=R.getInt("idetudiant");
		 		
					String n=R.getString("nom");
					
					String p=R.getString("prénom");
			
					int abs=R.getInt("idabsence");
					
					String d=R.getString("date");
					
					String s=R.getString("sujet");
					
					String abr=R.getString("abréviation");
				
					int rec=R.getInt("idréclamation");
					 lr=new  ListeReclamation(id,n,p,d,s,abs,abr,rec);
			        LR.add(lr);
		 	  }
		 	
		   
		   
		    
		    cn.close();
			 state.close();
			 return LR;
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	 return null;
}

public void insertanswer(String n,int id) {
	
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		  
		    String q="update réclamation set answer='"+n+"',étatréclamation='1' where idréclamation="+id;
		  
		    state.executeUpdate(q);
		   
		    System.out.println("answer ajouté");
	  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	 
}
public ArrayList<ListeReclamation> getRecltE(int idg) {
	
	LR=new ArrayList<ListeReclamation>();
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		 
		    String q="SELECT idetudiant,etudiant.nom,prénom,sujet,abréviation,réclamation.idréclamation,exclus.type,idExclus  FROM etudiant,exclus,module,réclamation where exclus.idétudiant=etudiant.idetudiant and réclamation.idréclamation=exclus.idréclamation and étatréclamation=0   and exclus.idmodule=module.idmodule and etudiant.idgroupe="+idg ;
		  
		    ResultSet R =  state.executeQuery(q);
		    
		 	  while(R.next()){
		 		 int id=R.getInt("idetudiant");
		 		
					String n=R.getString("nom");
					
					String p=R.getString("prénom");
			
					int idex=R.getInt("idExclus");
					
					String t=R.getString("type");
					
					String s=R.getString("sujet");
					
					String abr=R.getString("abréviation");
				
					int rec=R.getInt("idréclamation");
					 lr=new  ListeReclamation(id,n,p,idex,abr,t,s,rec);
			        LR.add(lr);
		 	  }
		 	
		   
		 	
		    cn.close();
			 state.close();
			 return LR;
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	 return null;
}
public ArrayList<ListeJustification> getJustif(int idg) {
	
	jus=new ArrayList<ListeJustification>();
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		 
		    String q="SELECT etudiant.idetudiant,etudiant.nom,prénom,idabsence,absence.date,abréviation,type,justification.date,justification.idjustification,justification FROM etudiant,absence,séance,module,justification where  absence.idetudiant=etudiant.idetudiant  and étatjustification=2  and absence.idséance=séance.idséance and séance.idmodule=module.idmodule and absence.idjustification=justification.idjustification and etudiant.idgroupe="+idg ;
		  
		    ResultSet R =  state.executeQuery(q);
		    
		 	  while(R.next()){
		 		   int id=R.getInt("idetudiant");
		 		    String n=R.getString("nom");
					String p=R.getString("prénom");
					
			        int abs=R.getInt("idabsence");
					String dabs=R.getString("absence.date");
					String t=R.getString("type");
					String abr=R.getString("abréviation");
					  int idjus=R.getInt("idjustification");
					Blob photo=(Blob) R.getBlob("justification");
					
					String djus=R.getString("justification.date");
					j=new  ListeJustification(id,n,p,abs,dabs,abr,t,photo,djus,idjus);
			        jus.add(j);
		 	  }
		 	
		   
		   
		    
		    cn.close();
			 state.close();
			 return jus;
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	 return null;
}

public void Delete(int id) {
	

	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		    System.out.println("1");
		    state.executeUpdate("update absence SET idjustification =null where idjustification="+id);
		    System.out.println("2"); 
		    state.executeUpdate("delete from justification where idjustification="+id );
		   
		  
		    state.executeUpdate("ALTER TABLE justification AUTO_INCREMENT=0"); 
		    System.out.println("3"); 
		   
		    System.out.println("4"); 
		  
		    
		     cn.close();
			 state.close();
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	
}
public void Accpet(int id) {
	

	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		
		    String q="update justification set étatjustification='1' where idjustification="+id;
		    state.executeUpdate(q);
		    
		     cn.close();
			 state.close();
			  
}catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	
	
}

}