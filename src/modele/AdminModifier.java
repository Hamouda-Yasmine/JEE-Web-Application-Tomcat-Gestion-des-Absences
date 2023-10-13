 package modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class AdminModifier {
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
public ArrayList<Module> selectionMOD(int i) {
	AdminModifier ad=new AdminModifier();
	
	 M =new ArrayList<Module>();

		
		try {
			Class.forName(classforname);
			 cn = DriverManager.getConnection(url, user, passwd);
			 state=cn.createStatement();
			  String t="select * from module where idmodule="+i;
			  ResultSet R = state.executeQuery(t);

			 if(R.next()){
				int id=R.getInt("idmodule");		
				String n=R.getString("nom");
				String p=R.getString("abréviation");
				int idfor =R.getInt("idformation");
				String s=ad.specETU(idfor);
		    
		      
		        mo=new Module(id,n,p,s);
			       M.add(mo);
		        return M;
			 }
			
			    state.close();
			    R.close();
			    cn.close();
			    System.out.println("selection mod faite");
			    	}
		   catch (Exception e) {
			      System.out.println(e.toString()); 
			    }
		return null;
	
	
	}
public void modifierMOD (int i,String n,String a,String p) {
	System.out.println(i);
	System.out.println(n);
	System.out.println(a);
	System.out.println(p);
	int w=0;
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 ResultSet fi =state.executeQuery("select idformation from formation where abréviation ='"+p+"'");
			
	 	 if (fi.next()) { 
	 		 w=fi.getInt(1);
	 		 }
	    state.executeUpdate("update  module set nom='"+n+"',abréviation='"+a+"',idformation ='"+w+"' where idmodule="+i  ); 
	  
	   
	    System.out.println("il a modifié mod");
	state.close();
	 cn.close();}
	   catch(Exception ex) {}
	
	
}
public ArrayList<Seance> selectionSEANCE(int i){
	 S=new ArrayList<Seance>();
	 AdminConsulter ad=new AdminConsulter();

try {
	Class.forName(classforname);
	 cn = DriverManager.getConnection(url, user, passwd);
	 state=cn.createStatement();
	  String t="select * from séance where idséance="+i;
	  ResultSet R = state.executeQuery(t);

	 while(R.next()){
		 int id=R.getInt("idséance");
		 String hd=R.getString("heureD");
			String hf=R.getString("heureF");
			String j=R.getString("jour");
			String t1=R.getString("type");
			String s=R.getString("numSalle");
			String m=ad.mod(R.getInt("idmodule"));
			String g=ad.groupe(R.getInt("idgroupe"));
			String sc=ad.Salle(R.getInt("idsection"));
		
		
    
			se=new Seance(id,hd,hf,t1,j,g,m,s,sc);
		       S.add(se);		
        System.out.println("selection sea faite");
	 }
	
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

public void modifierSEA(int i,String inf,String hd,String hf,String j,String t,String s,String m,String g,String sc) {
		try {
			int idg=0;
			 int idm=0;
			 int idf=0;
			 int ids=0;
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		 if(sc=="0") {
	 		 ids=(Integer) null;
	 	 }else {
		 ResultSet sq7 =state.executeQuery("select idsection from section where nom ='"+sc+"'");
	 		
	 	 if (sq7.next()) { 
	 		 ids=sq7.getInt(1);
	 		 }}
	    ResultSet sq0 =state.executeQuery("select idformation from formation where abréviation ='"+inf+"'");
 		
	 	 if (sq0.next()) { 
	 		 idf=sq0.getInt(1);
	 		 }
	 	 if(g=="0") {
	 		 idg=(Integer) null;
	 	 }else {
	    ResultSet sq1 =state.executeQuery("select idgroupe from groupe where idformation ='"+idf+"'and nom='"+g+"'");
 		
	 	 if (sq1.next()) { 
	 		 idg=sq1.getInt(1);
	 		 }}
	 	  ResultSet sq2 =state.executeQuery("select idmodule from module where idformation ='"+idf+"'and abréviation='"+m+"'");
	 		
		 	 if (sq2.next()) { 
		 		 idm=sq2.getInt(1);
		 		 }
	    state.executeUpdate("update séance set heureD='"+hd+"',heureF ='"+hf+"',numSalle='"+s+"', jour='"+j+"',type='"+t+"',idsection='"+ids+"',idgroupe='"+idg+"',idmodule='"+idm+"' where idséance="+i  ); 
	  
	   
	    System.out.println("il a modifié seance");
	state.close();
	 cn.close();}
	   catch(Exception ex) {}
	
	
}
public ArrayList<Enseignant> selectionENS(int i){
	 E=new ArrayList<Enseignant>();


try {
	Class.forName(classforname);
	 cn = DriverManager.getConnection(url, user, passwd);
	 state=cn.createStatement();
	  String t="select * from user ,enseignant,formation where  user.idUser=enseignant.iduser and formation.idformation=enseignant.idformation and idenseignant="+i;
	  ResultSet R = state.executeQuery(t);
 
	 while(R.next()){
		int id=R.getInt("idenseignant");
		String d=R.getString("enseignant.nom");
		String n=R.getString("prénom");
		String p=R.getString("adresse");
		String p1=R.getString("datedenaissance");
		String p2=R.getString("téléphone");
		String p3=R.getString("sexe");
		String p5=R.getString("email");
		String p4=R.getString("pass");
		String p6=R.getString("grade");
		String f=R.getString("abréviation");
		String de=R.getString("description");
		String cat=R.getString("categorie");
		String user=R.getString("user.nom");
      ens=new Enseignant(id,d,n,p,p1,p2,p3,p5,p4,p6,f,de,cat,user);
      E.add(ens);	
      System.out.println("selection ens faite");
	 }
	
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
public void modifierENS (int i,String n,String p, String dn,String a,String  se ,String t,String mo,String e,String g,String f,String de,String cat,String us) {
	int w=0;
    int k=0;
String cate="";
	try {
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		
		 ResultSet fi =state.executeQuery("select idformation from formation where abréviation ='"+f+"'");
			
	 	 if (fi.next()) { 
	 		 w=fi.getInt(1);
	 		 }
	 	ResultSet fi1 =state.executeQuery("select iduser from enseignant where idenseignant ='"+i+"'");
		 
	 	 if (fi1.next()) { 
	 		k=fi1.getInt(1);
	 		 }
	 	ResultSet r5 =state.executeQuery("select categorie from user where idUser ='"+k+"'");
		 
	 	 if (r5.next()) { 
	 		cate=r5.getString(1);
	 		 }
	 	
	 	state.executeUpdate("update user set nom='"+us+"',pass='"+mo+"',categorie='"+cat+"' where user.idUser="+k  ); 
	
	    state.executeUpdate("update enseignant set nom='"+n+"',adresse='"+a+"',datedenaissance='"+dn+"',prénom='"+p+"', sexe='"+se+"',téléphone='"+t+"', email='"+e+"',grade='"+g+"',idformation='"+w+"',description='"+de+"' where idenseignant="+i  ); 
	     
	     
	     if(cat.equals("chef")&& cate.equals("ens")) {
		 		
	 		 state.executeUpdate("insert into chefdedépartement (idenseignant,iduser) values ('"+i+"','"+k+"')"); 
	 		System.out.println(i);
	 		System.out.println(k);
	 	 }
	 	 if(cat.equals("res") && cate.equals("ens")) {
		 	
		 		 state.executeUpdate("insert into responsableformation (idformation,idenseignant,iduser) values ('"+w+"','"+i+"','"+k+"')"); 
		 		System.out.println(i);
		 		System.out.println(k);
		 	 }
	 	 
	 	 
	 	if(cat.equals("ens")&& cate.equals("res")) {
	 		
	 		 state.executeUpdate("DELETE FROM responsableformation WHERE idenseignant = "+i); 
	 		 
	 		System.out.println(i);
	 		System.out.println(k);
	 	 }
	 	if(cat.equals("chef")&& cate.equals("res")) {
	 		
	 		 state.executeUpdate("DELETE FROM responsableformation WHERE idenseignant = "+i); 
	 		state.executeUpdate("insert into chefdedépartement (idenseignant,iduser) values ('"+i+"','"+k+"')"); 
	 		System.out.println(i);
	 		System.out.println(k);
	 	 }
	 	
	 	
	 	
	 	 if(cat.equals("res") && cate.equals("chef")) {
	 		state.executeUpdate("DELETE FROM chefdedépartement WHERE idenseignant = "+i); 
	 		state.executeUpdate("insert into responsableformation (idformation,idenseignant,iduser) values ('"+w+"','"+i+"','"+k+"')"); 
	 		System.out.println(i);
	 		System.out.println(k);
	 	 }
		 	 
	 	if(cat.equals("ens") && cate.equals("chef")) {
	 		 state.executeUpdate("DELETE FROM chefdedépartement WHERE idenseignant = "+i); 
	 		 
	 		System.out.println(i);
	 		System.out.println(k);
	 	 }
	    System.out.println("il a modifié ens");
	state.close();
	 cn.close();}
	   catch(Exception ex) {}
	
	
}
   public ArrayList<Etudiant> selectionEt(int i){
   ED=new ArrayList<Etudiant>();

   try {
  Class.forName(classforname);
  cn = DriverManager.getConnection(url, user, passwd);
  state=cn.createStatement();
  String t="select * from user,etudiant,formation where  user.idUser=etudiant.iduser and formation.idformation=etudiant.idformation and idetudiant="+i;
  ResultSet R = state.executeQuery(t);
  while(R.next()){
	int id=R.getInt("idetudiant");
	String d=R.getString("etudiant.nom");
	String n=R.getString("prénom");
	String p=R.getString("adresse");
	String p1=R.getString("datedenaissance");
	String p2=R.getString("téléphone");
	String p3=R.getString("sexe");
	String p4=R.getString("pass");
	String p5=R.getString("email");
	String p6=R.getString("description");
	String p7=R.getString("numbac");
	String p8=R.getString("annéedebac");
	String f=R.getString("abréviation");
	
	String user=R.getString("user.nom");
	
   etu=new Etudiant(id,d,n,p,p1,p2,p3,p7,p8,p6,p4,p5,f,user);
  
    ED.add(etu);	
   System.out.println("selection etu faite");
  }

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

public void modifierETU (int i,String n,String p,String f,String a,String dn, String e ,String se,String t,String nb,String nba ,String mo,String des,String us) {

	

	try {
		int w=0;
	    int k=0;	
		Class.forName(classforname);
		 cn = DriverManager.getConnection(url, user, passwd);
		 state=cn.createStatement();
		
		 ResultSet fi =state.executeQuery("select idformation from formation where abréviation ='"+f+"'");
		
	 	 if (fi.next()) { 
	 		w=fi.getInt(1);
	 		 }
	 	ResultSet fi1 =state.executeQuery("select iduser from etudiant where idetudiant ='"+i+"'");
	
	 	 if (fi1.next()) { 
	 		k=fi1.getInt(1);
	 		 }
	 	
	 	state.executeUpdate("update user set nom='"+us+"',pass='"+mo+"' where user.idUser="+k  ); 
		System.out.println("dkhal");
		state.executeUpdate("update  etudiant set nom='"+n+"',prénom='"+p+"',idformation='"+w+"',prénom='"+p+"',adresse='"+a+"',datedenaissance='"+dn+"',email='"+e+"',sexe='"+se+"',téléphone='"+t+"',numbac='"+nb+"',annéedebac='"+nba+"',description='"+des+"'where idetudiant="+i  ); 
	    System.out.println("il a modifié etu");
	state.close();
	 cn.close();}
	   catch(Exception ex) {}

}


}