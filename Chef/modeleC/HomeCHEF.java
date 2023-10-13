package modeleC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HomeCHEF {
	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	 Formation f;
	
	public HomeCHEF() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Formation> selectFormation(int idu) {
		ArrayList<Formation> lf=new ArrayList<Formation>();
		 try
         {
         Class.forName(classforname);
        
         
         
         Connection cn= (Connection)DriverManager.getConnection(url,user,passwd);
         Statement state=cn.createStatement();
         ResultSet rs=state.executeQuery("select iddépartement from chefdedépartement  where idUser="+idu);
         rs.next();
         ResultSet rs1=state.executeQuery("select * from formation  where iddépartement="+rs.getString("iddépartement"));
        while(rs1.next()) {
        	int idf=rs1.getInt("idformation");
        	
        	int idd=rs1.getInt("iddépartement");
        String ab=rs1.getString("abréviation");
        String n=rs1.getString("nom");
        f=new Formation(idf,n,ab,idd);
        	lf.add(f);
        }
         
         state.close();
		     
		    cn.close();
		    rs.close();
		   return lf;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return lf;
	}
	public void AffecterIDens(int i , int i1) {
		try {
			
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
		     
				 	if (i==0) {
				 		state.executeUpdate( "update séance set idenseignant=NULL where idséance="+i);
				 		System.out.println(" id ens ajouté null");
				 	}else {
				 		state.executeUpdate( "update séance set idenseignant="+i1+" where idséance="+i);
				 		System.out.println(" id ens ajouté");	
				 	}
				 		
				 		 
		    		

				    	  state.close();
				          cn.close(); }catch (Exception ex) {
				  		      System.out.println(ex.toString()); 
				  		    }
		
		
		
		
			
		}
	public ArrayList<Integer> selectGroupe(int idf) {
		ArrayList<Integer> lf=new ArrayList<Integer>();
		 try
         {
         Class.forName(classforname);
        
         
         
         Connection cn= (Connection)DriverManager.getConnection(url,user,passwd);
         Statement state=cn.createStatement();
        
         ResultSet rs1=state.executeQuery("select * from groupe where idformation="+idf);
        while(rs1.next()) {
        	int idg=rs1.getInt("idgroupe");
        	
        
        
        	lf.add(idg);
        }
         
         state.close();
		     
		    cn.close();
		   
		   return lf;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return lf;
	}
	
	public String selectNOMGroupe(int idf) {
		String lf;
		 try
         {
         Class.forName(classforname);
        
         
         
         Connection cn= (Connection)DriverManager.getConnection(url,user,passwd);
         Statement state=cn.createStatement();
        
         ResultSet rs1=state.executeQuery("select * from groupe where idgroupe="+idf+" order by (nom)");
        rs1.next();
        	 lf=rs1.getString("nom");
        	
        
        
                
         
         state.close();
		     
		    cn.close();
		   
		   return lf;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return "";
	}
	public String selectNOMModule(int idf) {
		String lf;
		 try
         {
         Class.forName(classforname);
        
         
         
         Connection cn= (Connection)DriverManager.getConnection(url,user,passwd);
         Statement state=cn.createStatement();
        
         ResultSet rs1=state.executeQuery("select * from module where idmodule="+idf);
        rs1.next();
        	 lf=rs1.getString("abréviation");
        	
        
        
                
         
         state.close();
		     
		    cn.close();
		   
		   return lf;
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return "";

}}
