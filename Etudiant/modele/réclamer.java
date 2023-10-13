package modele;

import java.sql.*;
public class réclamer {
public Connection cn;
public Statement state;
public ResultSet result;
public String user="root";
public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
public String passwd="00000";
public String classforname="com.mysql.cj.jdbc.Driver";



public void reclamer(String r,int ab){
	int u=0;
	 try{
		
		Class.forName(classforname);
	    cn =(Connection) DriverManager.getConnection(url,user,passwd);
	    state = cn.createStatement();
	 	state.executeUpdate("insert into réclamation (sujet,date_heure,étatréclamation,answer) values ('"+r+"',NOW(),0,'réclamation en attente')");
	 	
	 	 System.out.println(" réclamé");
	 	ResultSet R = state.executeQuery("SELECT LAST_INSERT_ID()");
	 	 if (R.next()) { 
	 		 u=R.getInt(1);
	 		 }
	 	
	 	String s ="update absence SET idréclamation ='"+u+"' where idabsence="+ab;

	 	 state.executeUpdate(s);
	 	 
	 	
	 	  state.close();
        cn.close(); 
}    catch (Exception ex) {
		      System.out.println(ex.toString()); 
		    }
	 	    
}
public void reclamerExclu(String r,int ab){
	int u=0;
	 try{
		
		Class.forName(classforname);
	    cn =(Connection) DriverManager.getConnection(url,user,passwd);
	    state = cn.createStatement();
	 	state.executeUpdate("insert into réclamation (sujet,date_heure,étatréclamation,answer) values ('"+r+"',NOW(),0,'réclamation en attente')");
	 	
	 	 System.out.println(" réclamé");
	 	ResultSet R = state.executeQuery("SELECT LAST_INSERT_ID()");
	 	 if (R.next()) { 
	 		 u=R.getInt(1);
	 		 }
	 	
	 	String s ="update exclus SET idréclamation ='"+u+"' where idExclus="+ab;

	 	 state.executeUpdate(s);
	 	 
	 	
	 	  state.close();
        cn.close(); 
}    catch (Exception ex) {
		      System.out.println(ex.toString()); 
		    }
	 	    
}
}
