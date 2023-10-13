package modele;

public class ListeReclamation {
 
private int idabs;
private int idexc;
  private int idetu;
  private String nom;
  private String prénom;
  private String sujet;
  private String dateabs ;
  private String abr;
  private int idréc;
  private String type;

  public ListeReclamation(int id, String n, String p, String d, String s, int abs, String abr,int idréc) {
		this.idetu=id;
		this.nom=n;
		this.prénom=p;
		this.dateabs=d;
		this.sujet=s;
		this.abr=abr;
		this.idabs=abs;
		this.idréc=idréc;
	}
  public ListeReclamation(int id, String n, String p, int idex, String abr,String t,String s,int idréc) {
		this.idetu=id;
		this.nom=n;
		this.prénom=p;
		this.idexc=idex;
		this.type=t;
		this.abr=abr;
	    this.idréc=idréc;
	    this.sujet=s;
	}

  
  public int getIdabs() {
	return idabs;
}



public void setIdabs(int idabs) {
	this.idabs = idabs;
}



public int getIdexc() {
	return idexc;
}



public void setIdexc(int idexc) {
	this.idexc = idexc;
}



public int getIdetu() {
	return idetu;
}



public void setIdetu(int idetu) {
	this.idetu = idetu;
}



public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getPrénom() {
	return prénom;
}



public void setPrénom(String pénom) {
	this.prénom = pénom;
}



public String getSujet() {
	return sujet;
}



public void setSujet(String sujet) {
	this.sujet = sujet;
}



public String getDateabs() {
	return dateabs;
}



public void setDateabs(String dateabs) {
	this.dateabs = dateabs;
}



  

public String getAbr() {
	return abr;
}



public void setAbr(String abr) {
	this.abr = abr;
}



public int getIdréc() {
	return idréc;
}



public void setIdréc(int idréc) {
	this.idréc = idréc;
}



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}
}
