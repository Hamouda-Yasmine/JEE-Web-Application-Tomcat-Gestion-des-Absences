package modele;
import java.sql.*;

public class login {
	static User u;
	static Etudiant e;
	static Administrateur a;
	static Enseignant ens;
	static Chef c;
	static Respo r;
	public login() {
	
	}

	public static User verifierlogin(String n,String m) {
	
	 try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			

		   String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		   String passwd="00000";
		   String user = "root";
		    Connection conn = DriverManager.getConnection(url, user, passwd);
		   Statement state = conn.createStatement(); 
		   String q="SELECT * FROM user where nom ='"+n+"'and pass ='"+m+"';";
		   ResultSet R = state.executeQuery(q);
		 	   if (R.next()) {
		 		    int id= R.getInt("idUser");
			 		String no=R.getString("nom");
			 		String p=R.getString("pass");
			 		String c=R.getString("categorie");
			 		u=new User(id,no,p,c);
			 		return u;
		 		
		 }
		           state.close();
		 	    R.close();
		 	    conn.close();
		 	    }
		 	   	
		    catch (Exception e) { System.out.println(e.toString());  }
	 return null;
}
	public static Etudiant idetu(String n,String m) {
		
		 try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
				

			   String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			   String passwd="00000";
			   String user = "root";
			   Connection conn = DriverManager.getConnection(url, user, passwd);
			   Statement state = conn.createStatement(); 
			 
			   u=login.verifierlogin(n, m);
			   
			   String q="SELECT idetudiant,prénom FROM etudiant where iduser="+u.getIdUser();
			   
			   ResultSet R = state.executeQuery(q);
			 	   if (R.next()) {
			 		    int id= R.getInt("idetudiant");
			 		  
				 		String no=R.getString("prénom");
				 		
				 	    e=new Etudiant(id,no);
				 	 
				 		return e;
			 		
			 }
			           state.close();
			 	    R.close();
			 	    conn.close();
			 	    }
			 	   	
			    catch (Exception e) { System.out.println(e.toString());  }
		 return null;
	}
	public static Administrateur idadm(String n,String m) {
		
		 try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
				

			   String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			   String passwd="00000";
			   String user = "root";
			   Connection conn = DriverManager.getConnection(url, user, passwd);
			   Statement state = conn.createStatement(); 
			 
			   u=login.verifierlogin(n, m);
			   
			   String q="SELECT idadministrateur,prénom FROM administrateur where iduser="+u.getIdUser();
			   
			   ResultSet R = state.executeQuery(q);
			 	   if (R.next()) {
			 		    int id= R.getInt("idadministrateur");
			 		   
				 		String no=R.getString("prénom");
				 		
				 	    a=new Administrateur(no,id);
				 	  
				 		return a;
			 		
			 }
			           state.close();
			 	    R.close();
			 	    conn.close();
			 	    }
			 	   	
			    catch (Exception e) { System.out.println(e.toString());  }
		 return null;
	}
	public static Enseignant idens(String n,String m) {
		
		 try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
				

			   String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			   String passwd="00000";
			   String user = "root";
			   Connection conn = DriverManager.getConnection(url, user, passwd);
			   Statement state = conn.createStatement(); 
			 
			   u=login.verifierlogin(n, m);
			   
			   String q="SELECT idenseignant,prénom FROM enseignant where iduser="+u.getIdUser();
			  
			   ResultSet R = state.executeQuery(q);
			 	   if (R.next()) {
			 		    int id= R.getInt("idenseignant");
			 		   System.out.println(id);
				 		String no=R.getString("prénom");
				 		System.out.println(no);
				 	    ens=new Enseignant(no,id);
				 	  
				 		return ens;
			 		
			 }
			           state.close();
			 	    R.close();
			 	    conn.close();
			 	    }
			 	   	
			    catch (Exception e) { System.out.println(e.toString());  }
		 return null;
	}
	
	public static Respo idr(String n,String m) {
		
		 try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
				

			   String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			   String passwd="00000";
			   String user = "root";
			   Connection conn = DriverManager.getConnection(url, user, passwd);
			   Statement state = conn.createStatement(); 
			 
			   u=login.verifierlogin(n, m);
			   
			   String q="SELECT idresponsable FROM responsableformation where iduser="+u.getIdUser();
			   
			   ResultSet R = state.executeQuery(q);
			 	   if (R.next()) {
			 		    int id= R.getInt("idresponsable");
			 		 
				 		
				 	   r=new Respo(id);
				 	 
				 		return r;
			 		
			 }
			           state.close();
			 	    R.close();
			 	    conn.close();
			 	    }
			 	   	
			    catch (Exception e) { System.out.println(e.toString());  }
		 return null;
	}
		
	public static Chef idc(String n,String m) {
		
		 try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
				

			   String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			   String passwd="00000";
			   String user = "root";
			   Connection conn = DriverManager.getConnection(url, user, passwd);
			   Statement state = conn.createStatement(); 
			 
			   u=login.verifierlogin(n, m);
			   
			   String q="SELECT idchef FROM chefdedépartement where iduser="+u.getIdUser();
			   
			   ResultSet R = state.executeQuery(q);
			 	   if (R.next()) {
			 		    int id= R.getInt("idchef");
			 		  
				 		
				 	   c=new Chef(id);
				 	 
				 		return c;
			 		
			 }
			           state.close();
			 	    R.close();
			 	    conn.close();
			 	    }
			 	   	
			    catch (Exception e) { System.out.println(e.toString());  }
		 return null;
	}
		
	}
