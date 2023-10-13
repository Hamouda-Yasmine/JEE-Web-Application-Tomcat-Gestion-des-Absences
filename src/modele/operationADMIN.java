package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;



public class operationADMIN {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	ArrayList<Administrateur> A;
	Administrateur ad;
	  
	public operationADMIN() {
		
	}
	public void modifierProfileADMIN(int i,String n,String us, String p, String a ,String e ,String mp,String tele,String dn,String se,String des) {
	int u=0;
		try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 String q="SELECT * FROM administrateur where idadministrateur ="+i;
		 ResultSet R = state.executeQuery(q);
		while( R.next()){
			 u=R.getInt("iduser");
		 }
		 state.executeUpdate("update user set pass='"+mp+"',nom='"+us+"'  where idUser="+u);
		 System.out.println("cc");
		 state.executeUpdate("update  administrateur set nom='"+n+"',prénom='"+p+"',adresse='"+a+"',email='"+e+"',téléphone='"+tele+"',sexe='"+se+"',description='"+des+"',datedenaissance='"+dn+"' where idadministrateur="+i  ); 
		 System.out.println("admin modifié");
		
	    
	state.close();
	 cn.close();}
	   catch(Exception ex) { System.out.println(e.toString());}
}
    public ArrayList<Administrateur> selectionADMIN(int i){

	 A =new ArrayList<Administrateur>();

	
		try {
			Class.forName(classforname);
			 cn = DriverManager.getConnection(url, user, passwd);
			 state=cn.createStatement();
			 Statement state1=cn.createStatement();
			 
		      ResultSet R= state1.executeQuery("select * from user,administrateur where user.idUser=administrateur.iduser and administrateur.idadministrateur="+i);
			  while(R.next()) {
				 
			    int id=R.getInt("idadministrateur");
			 
				String n=R.getString("administrateur.nom");
				String p=R.getString("prénom");
				String adr=R.getString("adresse");
				String tele=R.getString("téléphone") ;
		        String email=R.getString("email");
		        String user=R.getString("user.nom");
		       
		        String pass= R.getString("pass");
		        String dn=R.getString("datedenaissance");
		        String s=R.getString("sexe");
		        
		       
		        String des=R.getString("description");
		      
		        ad=new Administrateur(n,p,s,tele,id,pass,user,email,dn,adr,des);
			       A.add(ad);
			  }
			       
			    state.close();
			    R.close();
			    
			    cn.close();
			    return A;
			    	}
		   catch (Exception e) {
			      System.out.println(e.toString()); 
			    }
		return null;
}
public void supprimerCompteADMIN(int i) {
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		
		 
		 state.executeUpdate("DELETE FROM user  WHERE iduser="+i); 
	     state.executeUpdate("ALTER TABLE user AUTO_INCREMENT=0"); 
	    
	     
	 state.close();
	  cn.close();}
	    catch(Exception ex) {}
	
}

}



	
