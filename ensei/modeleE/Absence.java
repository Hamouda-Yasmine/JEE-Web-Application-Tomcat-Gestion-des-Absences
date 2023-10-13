package modeleE;

public class Absence {
     private int idabsence;
     private int idetudiant;
     private int idseance ;
     private int idjustification;
     private String date;
     public int getIdabsence() {
		return idabsence;
	}
	public void setIdabsence(int idabsence) {
		this.idabsence = idabsence;
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
	public int getIdjustification() {
		return idjustification;
	}
	public void setIdjustification(int idjustification) {
		this.idjustification = idjustification;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Absence(int idabsence, int idetudiant, int idseance, int idjustification, String date) {
		super();
		this.idabsence = idabsence;
		this.idetudiant = idetudiant;
		this.idseance = idseance;
		this.idjustification = idjustification;
		this.date = date;
	}
	public Absence() {
		// TODO Auto-generated constructor stub
	}

}
