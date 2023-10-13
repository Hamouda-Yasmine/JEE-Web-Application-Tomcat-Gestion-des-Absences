
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsExclus {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	ArrayList<ListeABS> a;
	ListeABS la;
	ConsABS cs;
	ListeExclus LE;
	ArrayList<ListeExclus> le;
	 public String nomodule(int k){
		 String s="";
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
 
		 String m="select nom  from module where idmodule="+k;
	      ResultSet R1 = state.executeQuery(m);

	      while(R1.next()){	
			
	      s=R1.getString("nom");
 
	      }
	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
return s;
}
	 
	 public int idgroupe(int idetu){
		
		 int i=0;
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
 
		 String m="select idgroupe from etudiant where idetudiant="+idetu;
	      ResultSet R1 = state.executeQuery(m);

	      while(R1.next()){	
			
	       i=R1.getInt("idgroupe");
	      

	      }
	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
	return i;
	 }
	 
     public ArrayList<ListeExclus> ConsulterExclu(int idetu){
	    ConsExclus ex=new ConsExclus();
	 System.out.println("groupe numero"+ex.idgroupe(idetu));
	 int exc=0;int ide=0;
	   try{
		le=new ArrayList<ListeExclus>();
		Class.forName(classforname);
	    cn =(Connection) DriverManager.getConnection(url,user,passwd);
	    state = cn.createStatement();
	   	 	String t=("SELECT et.idetudiant,nom,prénom,type,idmodule,idExclus,answer FROM  exclus e ,etudiant et,réclamation r where e.idréclamation=r.idréclamation and e.idétudiant=et.idetudiant and et.idgroupe="+ex.idgroupe(idetu));
	    ResultSet R = state.executeQuery(t);
			
		 while(R.next()) {
			 ide=R.getInt("idetudiant");
			exc=R.getInt("idExclus");
			 System.out.println(exc);
			String n=R.getString("nom");
			 System.out.println(n);
			String p=R.getString("prénom");
			 System.out.println(p);
			String s=ex.nomodule(R.getInt("idmodule"));
			 System.out.println(s);
			String ty=R.getString("type");
			 System.out.println(ty);
				String r=R.getString("r.answer");
			     
		    LE=new ListeExclus(ide,n,p,s,ty,exc,r);
		   
		      le.add(LE);
		     
		      
	 }
		 System.out.println("affiché"); 
		    state.close();
		    R.close();
		    cn.close();
		    return le;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
	return null;
}
}