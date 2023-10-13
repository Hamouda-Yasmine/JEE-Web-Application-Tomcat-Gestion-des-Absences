package modeleE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListedesAbsences {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	  ArrayList<Groupe>Liste;
	  Groupe g;
	  Seance s;
	  String m;
	public ListedesAbsences() {
		// TODO Auto-generated constructor stub
	}
	 public ArrayList<Groupe> selectIDdesgroupe(int i) {
		
		 Liste= new ArrayList<Groupe>();
		 
		   try
         {
         Class.forName(classforname);
        
         String query="select idenseignant from enseignant where idUser="+i ;
         
          cn= (Connection)DriverManager.getConnection(url,user,passwd);
        state=cn.createStatement();
         ResultSet rs=state.executeQuery(query);
         rs.next();
        int id =rs.getInt("idenseignant");
         ResultSet rs1=state.executeQuery("select idgroupe from prendreencharge where idenseignant="+id);
         while(rs1.next()) {
        	 int idg=rs1.getInt("idgroupe");
        	 
        	g=new Groupe (idg);
        	 Liste.add(g);
         }
       
       
         state.close();
		     
		    cn.close();
		    rs1.close();
		    
		   
		   
		    return Liste;
		   
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return null;
      
	   }
	 public Seance selectionnerSeance1(int i) {
		 s=new Seance();
		  try
	         {
	         Class.forName(classforname);
	        
	         String query="select * from séance where idséance="+i;
	         
	          cn= (Connection)DriverManager.getConnection(url,user,passwd);
	        state=cn.createStatement();
	         ResultSet rs=state.executeQuery(query);
	         rs.next();
	        
	            
	        	 int ids=rs.getInt("idséance");
	        	 String hd=rs.getString("heureD");
	        	 String hf=rs.getString("heureF");
	        	 int idm =rs.getInt("idmodule");
	        	String type=rs.getString("type");
	        	s=new Seance (ids,hd,hf,idm,type);
	        	
	         
	       
	       
	         state.close();
			     
			    cn.close();
			    rs.close();
			    
			   
			   
			    return s;
			   
			    	}
		   catch (Exception e) {
			      System.out.println(e.toString()); 
			    }
	         return null;
	      
		 
	 }

	 public Seance selectionnerSeance(int i) {
		 s=new Seance();
		  try
	         {
	         Class.forName(classforname);
	    
	      
	         
	          cn= (Connection)DriverManager.getConnection(url,user,passwd);
	        state=cn.createStatement();
	        ResultSet rs1=state.executeQuery("select idséance from absence where idetudiant="+i);
	        rs1.next();
	        String query="select * from séance where idséance="+rs1.getInt("idséance");
	         ResultSet rs=state.executeQuery(query);
	         rs.next();
	        
	            
	        	 int ids=rs.getInt("idséance");
	        	 String hd=rs.getString("heureD");
	        	 String hf=rs.getString("heureF");
	        	 int idm =rs.getInt("idmodule");
	        	String type=rs.getString("type");
	        	s=new Seance (ids,hd,hf,idm,type);
	        	
	         
	       
	       
	         state.close();
			     
			    cn.close();
			    rs.close();
			    
			   
			   
			    return s;
			   
			    	}
		   catch (Exception e) {
			      System.out.println(e.toString()); 
			    }
	         return null;
	      
		 
	 }
	 public String SelectionnerModule(int i) {
		 try
         {
         Class.forName(classforname);
         String query="select abréviation from module where idmodule="+i;
         cn= (Connection)DriverManager.getConnection(url,user,passwd);
         state=cn.createStatement();
         ResultSet rs=state.executeQuery(query);
         rs.next();
          m=rs.getString("abréviation");
         
         state.close();
		 cn.close();
		 rs.close();
		 return m;
		   
		    	}
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    }
         return "";
      
	 }
	 public void supprimerabsence(int i) {
		  try
	         {
	         Class.forName(classforname);
	    cn= (Connection)DriverManager.getConnection(url,user,passwd);
	        state=cn.createStatement();
	       
	        String query="delete from absence where idabsence="+i;
	         state.executeUpdate(query);
	        
	          state.close();
			  cn.close();
			    }
		   catch (Exception e) {
			      System.out.println(e.toString()); 
			    } }
	public int  etatjustification(int i) {
		try
        {
        Class.forName(classforname);
   cn= (Connection)DriverManager.getConnection(url,user,passwd);
       state=cn.createStatement();
      
       String query="select * from justification where idjustification="+i;
       ResultSet rs=state.executeQuery(query);
      if(rs.next()) {return rs.getInt("étatjustification");}
       
         state.close();
		  cn.close();
		    }
	   catch (Exception e) {
		      System.out.println(e.toString()); 
		    } 
		return 0;
	}
	 
	 
	 
}
