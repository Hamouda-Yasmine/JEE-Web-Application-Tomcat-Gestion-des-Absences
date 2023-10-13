package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsABS {
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
public ArrayList<ListeABS> ConsulterABS(int i){
	
	 cs=new ConsABS();
	 a=new ArrayList<ListeABS>();
	 try{
		
		Class.forName(classforname);
	    cn =(Connection) DriverManager.getConnection(url,user,passwd);
	    state = cn.createStatement();
	   	 	String t=("SELECT *,answer FROM absence a ,séance s ,réclamation r where a.idséance=s.idséance and a.idréclamation=r.idréclamation and  idetudiant="+i);
	    ResultSet R = state.executeQuery(t);
			
		 while(R.next()) {
			 
			int id=R.getInt("idabsence");
			
			String n=R.getString("date");
			
			String p=R.getString("heureD");
		
			String e=R.getString("heureF");
			
			String j=R.getString("jour");
			
			String ty=R.getString("type");
		
			String s=cs.nomodule(R.getInt("idmodule"));
			
			String r=R.getString("r.answer");
			
		
			la=new ListeABS(id,n,p,e,s,j,ty,r);
			
		      a.add(la);	

		      
	 }
		 System.out.println("affiché"); 
		    state.close();
		    R.close();
		    cn.close();
		    return a;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
	return null;
}
}