package modeleE;

public class Exclus {
 private int idexclus;
 private int idetudiant;
 private int idseance ;
	public Exclus(int idetudiant, int idseance) {
	super();
	this.idetudiant = idetudiant;
	this.idseance = idseance;
}
	public int getIdexclus() {
	return idexclus;
}
public void setIdexclus(int idexclus) {
	this.idexclus = idexclus;
}
public int getIdetudiant() {
	return idetudiant;
}
public void setIdetudiant(int idetudiant) {
	this.idetudiant = idetudiant;
}
public int getIdseance() {
	return idseance;
}
public void setIdseance(int idseance) {
	this.idseance = idseance;
}
	public Exclus() {
		// TODO Auto-generated constructor stub
	}

}
