package modeleE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FaireLappel {

	public Connection cn;
	public Statement state;
	public ResultSet result;
	public String user="root";
	public String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public String passwd="00000";
	public String classforname="com.mysql.cj.jdbc.Driver";
	  ArrayList <Groupe>G;
	  Groupe g;
	public FaireLappel() {
		// TODO Auto-generated constructor stub
	}
	  public void InsererAbsence(int i , int i1) {
			try {
				
					Class.forName(classforname);
					 cn = DriverManager.getConnection(url, user, passwd);
					 state=cn.createStatement();
			     
					 	
					 		
					 		 
 state.executeUpdate( "INSERT INTO absence (idetudiant,date,idséance) values ('"+i+"', NOW(),'"+i1+"')");
System.out.println(" etu ajouté");			    		

					    	  state.close();
					          cn.close(); }catch (Exception ex) {
					  		      System.out.println(ex.toString()); 
					  		    }
			
			
			
			
				
			}
	  public ArrayList<Groupe> selectionnergroupedunesection(int i){		  			    	
					 	   
		  G=new ArrayList<Groupe>();
			
			try {
				
				Class.forName(classforname);
				 cn = DriverManager.getConnection(url, user, passwd);
				 state=cn.createStatement();
				
				  String t=" select * from groupe where idsection="+i;
				 
				  ResultSet R = state.executeQuery(t);
			
				 while(R.next()){
			
			
					int id=R.getInt("idgroupe");
					String n=R.getString("nom");
					System.out.println(n);
				
					
					
					int idS=R.getInt("idsection");
					 
			    
			        g=new Groupe(id,n,idS);
			  G.add(g);	
			      
				 }
				 
				 for(Groupe gr: G) {
				 System.out.println("liste groupe recuperer"+gr.getNom()); 
				 }
				
				    state.close();
				     
				    cn.close();
				    R.close();
				    for(Groupe gr: G) {
						 System.out.println("liste groupe recuperer 2"+gr.getNom()); 
						 }
				    return G;
				    	}
			   catch (Exception e) {
				      System.out.println(e.toString()); 
				    }
			return null;
		  
		  
		  
			}
}