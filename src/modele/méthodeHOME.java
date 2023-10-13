package modele;

import java.sql.*;

import java.util.ArrayList;
public class méthodeHOME {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	ArrayList<Etudiant> ED;
	Etudiant etu;
   public ArrayList<Etudiant> ListeHOME() {
	AdminConsulter ac=new AdminConsulter();
	ED =new ArrayList<Etudiant>();
	try{
		Class.forName(classforname);
		cn =(Connection) DriverManager.getConnection(url,user,passwd);
	    state = cn.createStatement();
	    String q="SELECT idetudiant,nom,prénom,idformation FROM ( SELECT * FROM etudiant ORDER BY idetudiant DESC LIMIT 4)Var1 ORDER BY idetudiant ASC";
	    ResultSet R =  state.executeQuery(q);
	    while(R.next()) {
			String s  =ac.specETU(R.getInt("idformation"));
			int id=R.getInt("idetudiant");
			
			String n=R.getString("nom");
			String p=R.getString("prénom");
			
	        etu=new  Etudiant(id,n,p,s);
	        ED.add(etu);
	     }
	 	    state.close();
            cn.close(); 
         return ED;
}
	    catch (Exception ex) {
 		      System.out.println(ex.toString()); 
 		    }
	 	    return null;
}
   public void insertnote(String n,int id) {
	
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		  
		    String q="insert into note (note,idadmin) values ('"+n+"','"+id+"');";
		    
		    state.executeUpdate(q);
		   
		    System.out.println("note ajouté");
	  
   }catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	 
   }
   
  public ArrayList<note> note(int i) {
	  ArrayList<note> note=new ArrayList<note>();
	  note n;
	   try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		    String q="SELECT note,idNote FROM note where idadmin="+i;
		    ResultSet R =  state.executeQuery(q);
		    while(R.next()) {
				String s  =R.getString("note");
				int id=R.getInt("idNote");
			 n=new note(s,id);
		     note.add(n);	
		    }
	  
   }catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	   return note;
   }
  public void suppnote(int idnote) {
	    try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		   
		    String a="delete from note where idNote="+idnote;
		    
		     state.executeUpdate(a);
		     state.executeUpdate("ALTER TABLE note AUTO_INCREMENT=0"); 
		     System.out.println("1");
		    
	  
   }catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	   
   }
  public int nombretu() {
	  int i=0;
	    try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		   
		    String a="SELECT COUNT(*) FROM etudiant";
		    ResultSet R = state.executeQuery(a);
			while( R.next()){
				 i=R.getInt("COUNT(*)");
			 }
	  
 }catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	    return i;
 }
  public int nombrens() {
	  int i=0;
	    try{
			Class.forName(classforname);
			cn =(Connection) DriverManager.getConnection(url,user,passwd);
		    state = cn.createStatement();
		   
		    String a="SELECT COUNT(*) FROM enseignant";
		    ResultSet R = state.executeQuery(a);
			while( R.next()){
				 i=R.getInt("COUNT(*)");
			 }
	  
 }catch (Exception ex) {
	      System.out.println(ex.toString()); 
	    }
	    return i;
 }
}



