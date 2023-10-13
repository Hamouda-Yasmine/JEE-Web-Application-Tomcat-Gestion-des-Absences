package modeleE;

public class Module {
	private int idmodule;
	private String nom;
	private String abréviation;
	private String  spécialité;
	public Module() {
		// TODO Auto-generated constructor stub
	}
	public int getIdmodule() {
		return idmodule;
	}
	public void setIdmodule(int idmodule) {
		this.idmodule = idmodule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAbréviation() {
		return abréviation;
	}
	public void setAbréviation(String abréviation) {
		this.abréviation = abréviation;
	}
	public String getSpécialité() {
		return spécialité;
	}
	public void setSpécialité(String spécialité) {
		this.spécialité = spécialité;
	}
	public Module(int idmodule, String nom, String abréviation, String spécialité) {
		super();
		this.idmodule = idmodule;
		this.nom = nom;
		this.abréviation = abréviation;
		this.spécialité = spécialité;
	}

}
