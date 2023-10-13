package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminConsulter {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	ArrayList<Enseignant>E ;
	Enseignant ens;
	ArrayList<Etudiant> ED;
	Etudiant etu;
	ArrayList<Module> M;
	Module  mo;
	ArrayList<Seance> S;
	Seance se;
	public  AdminConsulter(){
		
		
}
	public String specETU(int i){
		 String s="";
		 try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		 
				 String m="select abréviation  from formation where idformation="+i;
			      ResultSet R1 = state.executeQuery(m);
		
			      while(R1.next()){	
					
			      s=R1.getString("abréviation");
		 
			      }
	    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
	return s;
	 }
	 public String mod(int i){
		 String s="";
		 try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		 
				 String m="select abréviation  from module where idmodule="+i;
			      ResultSet R1 = state.executeQuery(m);
		
			      while(R1.next()){	
					
			      s=R1.getString("abréviation");
		 
			      }
	    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
	return s;
	 }
	 public String groupe(int i){
		 String s="";
		 try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		 
				 String m="select nom  from groupe where idgroupe="+i;
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
	 public String specENS(int i){
		 String s="";
		 try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		 
				 String m="select abréviation from formation where idformation="+i;
			      ResultSet R1 = state.executeQuery(m);
		
			      while(R1.next()){	
					
			      s=R1.getString("abréviation");
		 
			      }
	    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
	return s;
	 }
	 
	 public String Salle(int i){
		 String s="";
		 try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		 
				 String m="select nom from section where idsection="+i;
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
	
	
	 public ArrayList<Enseignant> ConsulterENS(){
        AdminConsulter ad= new AdminConsulter();

			E =new ArrayList<Enseignant>();
		
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				  String t="select idenseignant ,nom ,prénom ,email,datedenaissance,grade,idformation from enseignant";
				  ResultSet R = state.executeQuery(t);
				
				 
			     
				 while(R.next()) {
					String s  =ad.specENS(R.getInt("idformation"));
						int id=R.getInt(1);
					String n=R.getString("nom");
					String p=R.getString("prénom");
					String e=R.getString("email");
					String d=R.getString("datedenaissance");
					String g=R.getString("grade");
					ens=new Enseignant(id,n,p,g,d,e,s);
				      E.add(ens);	
				      
			 }
				 System.out.println("enseignant consulté"); 
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
	
	 
	 public ArrayList<Module> ConsulterMOD(){
		 M =new ArrayList<Module>();
			AdminConsulter ad=new AdminConsulter();
			
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				  String t="select * from module";
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
					int id=R.getInt("idmodule");
					String n=R.getString("nom");
					String p=R.getString("abréviation");
					int idfor =R.getInt("idformation");
					String s=ad.specETU(idfor);
			    
			        mo=new Module(id,n,p,s);
			       M.add(mo);	
			       
				 }
				 System.out.println("module consulté"); 
				    state.close();
				    R.close();
				    cn.close();
				    return M;
				    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
			return null;
		 
	 }
	 public ArrayList<Seance> ConsulterSEA(){
		 S=new ArrayList<Seance>();
			AdminConsulter ad=new AdminConsulter();
			
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				  String t1="select * from séance";
				  ResultSet R = state.executeQuery(t1);
			
				 while(R.next()){
					int id=R.getInt("idséance");
					
					String hd=R.getString("heureD");
					String hf=R.getString("heureF");
					String j=R.getString("jour");
					String t=R.getString("type");
					String s=R.getString("numSalle");
					String m=ad.mod(R.getInt("idmodule"));
					String g=ad.groupe(R.getInt("idgroupe"));
					String sc=ad.Salle(R.getInt("idsection"));
			       se=new Seance(id,hd,hf,t,j,g,m,s,sc);
			       S.add(se);	
			       
				 }
				 System.out.println("séance consulté"); 
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
	 public ArrayList<Etudiant> ConsulterETU(){
		 AdminConsulter ad= new AdminConsulter();
			ED =new ArrayList<Etudiant>();
		
			try {
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				  String t="select idetudiant, nom ,prénom,email,datedenaissance,idformationfrom etudiant";
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
					int id=R.getInt("idetudiant");
					String n=R.getString("nom");
					String p=R.getString("prénom");
					String e=R.getString("email");
					String d=R.getString("datedenaissance");
					String s =ad.specENS(R.getInt("idformation"));
					
					
			        etu=new  Etudiant(id,n,p,d,s,e);
			        ED.add(etu);	
			       
				 }
			      System.out.println("etudiant consulté"); 
				    state.close();
				    R.close();
				    cn.close();
				    return ED;
				    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
			return null;
		 
	 }
	
}