package modele;



import com.mysql.cj.jdbc.Blob;

public class ListeJustification {
	  private int idabs;
	  private int idetu;
	  private String nom;
	  private String prénom;
	  private String dateabs ;
	  private String abr;
	  private String type;
	  private Blob justification;
      private String djus;
      private int idjus;
	public ListeJustification( int idetu, String nom, String prénom,int idabs, String dateabs, String abr, String type,
			Blob justification,String djus,int idjus) {
		super();
		this.idabs = idabs;
		this.idetu = idetu;
		this.nom = nom;
		this.prénom = prénom;
		this.dateabs = dateabs;
		this.abr = abr;
		this.type = type;
		this.justification = justification;
		this.djus=djus;
		this.idjus=idjus;
	}
	public int getIdabs() {
		return idabs;
	}
	public void setIdabs(int idabs) {
		this.idabs = idabs;
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
	public void setPrénom(String prénom) {
		this.prénom = prénom;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Blob getJustification() {
		return justification;
	}
	public void setJustification(Blob justification) {
		this.justification = justification;
	}
	public String getDjus() {
		return djus;
	}
	public void setDjus(String djus) {
		this.djus = djus;
	}
	public int getIdjus() {
		return idjus;
	}
	public void setIdjus(int idjus) {
		this.idjus = idjus;
	}
	
}
