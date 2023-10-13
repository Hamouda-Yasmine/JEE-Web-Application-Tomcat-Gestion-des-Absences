package modele;

import java.sql.*;

public class AdminAjout {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	public  AdminAjout(){
		
	}
	
	 public boolean ajouterENS(String n, String p, String dn ,String a,String mp ,String e,String sexe,String tele,String g,String inf,String des,String x){
		 
		 try{
			 int iu=0; 
			 int w=0;
			 int idens=0;
			 int iddep=0;
			Class.forName(classforname);
		    cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		    String q="SELECT * FROM enseignant where nom='"+n+"' and prénom='"+p+"'and adresse='"+a+"'";
		    ResultSet R =  state.executeQuery(q);
		 	  if(R.next()){
		       return false;
		 	   }
		 	 ResultSet fi =state.executeQuery("select idformation from formation where abréviation ='"+inf+"'");
	
			 	 if (fi.next()) { 
			 		 w=fi.getInt(1);
			 		 }
			 	 ResultSet dep =state.executeQuery("select iddépartement from formation where idformation ='"+w+"'");
			 	
			 	 if (dep.next()) { 
			 		 iddep=dep.getInt(1);
			 		 }
		 	 state.executeUpdate("insert into user (nom,pass,categorie) values ('"+n+"','"+mp+"','"+x+"')");
		 	ResultSet R1 = state.executeQuery("SELECT LAST_INSERT_ID()");
		 	 if (R1.next()) { 
		 		 iu=R1.getInt(1);
		 		 }
		 	
		 	  state.executeUpdate("INSERT INTO enseignant (nom,prénom,grade,datedenaissance,adresse,email,sexe,téléphone,iduser,idformation,description)VALUES ( '"+n+"','"+p+"','"+g+"','"+dn+"','"+a+"','"+e+"','"+sexe+"','"+tele+"','"+iu+"','"+w+"','"+des+"')");
		 	 ResultSet R2 = state.executeQuery("SELECT LAST_INSERT_ID()");
		 	 if (R2.next()) { 
		 		 idens=R2.getInt(1);
		 		 }
		 	 if(x.equals("chef")) {
		 		
		 		 state.executeUpdate("insert into chefdedépartement (idenseignant,iduser,iddépartement) values ('"+idens+"','"+iu+"','"+iddep+"')"); 
		 		System.out.println(idens);
		 		System.out.println(iu);
		 		System.out.println(iddep);
		 	 }
		 	 if(x.equals("res")) {
			 	
			 		 state.executeUpdate("insert into responsableformation (idformation,idenseignant,iduser) values ('"+w+"','"+idens+"','"+iu+"')"); 
			 		System.out.println(idens);
			 		System.out.println(iu);
			 	 }
		 	 System.out.println(" ens ajouté");
		 	  state.close();
	          cn.close(); 
	 }    catch (Exception ex) {
	  		      System.out.println(ex.toString()); 
	  		    }
		 	    return true;
}

     public boolean ajouterETU(String e ,String n, String p, String dn ,String a,String mp,String numB,String sexe,String tele,String anne,String des,String inf,String niv  ) {
			try {
				int iu=0;
				int w=0;
					Class.forName(classforname);
					 cn = DriverManager.getConnection(url, user, passwd);
					 state=cn.createStatement();
			         
					 ResultSet R =state.executeQuery("SELECT * FROM etudiant where nom ='"+n+"'and prénom ='"+p+"' and adresse='"+a+"'");
					    
					 	   if (R.next()){
					 		    return false;}
					 	  ResultSet fi =state.executeQuery("select idformation from formation where abréviation ='"+inf+"'");
					 		
						 	 if (fi.next()) { 
						 		 w=fi.getInt(1);
						 		 }
					 	  state.executeUpdate("insert into user (nom,pass,categorie) values ('"+n+"','"+mp+"','etu')");
					 	  ResultSet R1 = state.executeQuery("SELECT LAST_INSERT_ID()");
					 	 if (R1.next()) { 
					 		 iu=R1.getInt(1);
					 		 }
   state.executeUpdate( "INSERT INTO etudiant (email, nom, prénom ,datedenaissance,adresse,numbac,sexe,téléphone,annéedebac,description,iduser,idformation,niveau) values ('"+e+"','"+n+"','"+p+"','"+dn+"','"+a+"','"+numB+"','"+sexe+"','"+tele+"','"+anne+"','"+des+"','"+iu+"','"+w+"','"+niv+"')");
   System.out.println(" etu ajouté");		


					    	  state.close();
					          cn.close(); }catch (Exception ex) {
					  		      System.out.println(ex.toString()); 
					  		    }
					  			    	
					 	    return true;
			}
	 public boolean ajouterMOD(String n,String a,String p)  {
		 int w=0;
				try {
			Class.forName(classforname);
		    cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		    ResultSet fi =state.executeQuery("select idformation from formation where abréviation ='"+p+"'");
			
		 	 if (fi.next()) { 
		 		 w=fi.getInt(1);
		 		 }
		 	 
		 	 System.out.println(w);
            String s="insert into module(nom,abréviation,idformation) values ('"+n+"','"+a+"','"+w+"')";
	        int t = state.executeUpdate(s); 
	        if (t==1){
	        	 System.out.println("module ajouté");
	    	  return true;
	         }
	   	
		 	    state.close();
	            cn.close();
	    	}
   catch (Exception e) {
	      System.out.println(e.toString()); 
	    }
	    return false;

	 }
	
     public boolean ajouterSéance(String inf,String hd,String hf,String j,String t,String s,String m,String g,String sc) {
	 int idg=0;
	 int idm=0;
	 int idf=0;
	 int ids=0;
		try {
			Class.forName(classforname);
		    cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		    if(sc==null) {
		 		 ids=(Integer) null;
		 	 }else {
		    ResultSet sq7 =state.executeQuery("select idsection from section where nom ='"+sc+"'");
	 		
		 	 if (sq7.next()) { 
		 		 ids=sq7.getInt(1);
		 		 }}
		 	System.out.println("ss"+ids);
		    ResultSet sq0 =state.executeQuery("select idformation from formation where abréviation ='"+inf+"'");
	 		
		 	 if (sq0.next()) { 
		 		 idf=sq0.getInt(1);
		 		 }
		 	 if(g==null) {
		 		 idg=0;
		 	 }
		 	 else{
		
		    ResultSet sq1 =state.executeQuery("select idgroupe from groupe where idformation ='"+idf+"'and nom='"+g+"'");
	 		
		 	 if (sq1.next()) { 
		 		 idg=sq1.getInt(1);
		 		 }
		 	 }
		 	System.out.println(idg);
		 	  ResultSet sq2 =state.executeQuery("select idmodule from module where idformation ='"+idf+"'and abréviation='"+m+"'");
		 		
			 	 if (sq2.next()) { 
			 		 idm=sq2.getInt(1);
			 		 }
			 	System.out.println("mmm"+idm);
			String sq="insert into séance(heureD,heureF,jour,type,numSalle,idmodule,idgroupe,idsection) values ('"+hd+"','"+hf+"','"+j+"','"+t+"','"+s+"','"+idm+"','"+idg+"','"+ids+"')";
            int t1 = state.executeUpdate(sq); 
  	      if (t1==1){
  	    	 System.out.println("séance ajouté");
  	    	  return true;
  	      }
  	      
  	   
  		 	    state.close();
  	            cn.close();
  	    	}
     catch (Exception e) {
  	      System.out.println(e.toString()); 
  	    }
  	         return false;

 }

}
	


