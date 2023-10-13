package modeleC;

public class Formation {
	
	private int idFormation;
	private String nom;
	private String abreviation;
	private int idDepartement;
	

	public Formation(int idFormation, String nom, String abreviation, int idDepartement) {
		super();
		this.idFormation = idFormation;
		this.nom = nom;
		this.abreviation = abreviation;
		this.idDepartement = idDepartement;
	}


	public int getIdFormation() {
		return idFormation;
	}


	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAbreviation() {
		return abreviation;
	}


	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}


	public int getIdDepartement() {
		return idDepartement;
	}


	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}


	public Formation() {
		// TODO Auto-generated constructor stub
	}

}
