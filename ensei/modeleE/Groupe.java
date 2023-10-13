package modeleE;

public class Groupe {
private int Idgroupe;
private String nom ;
private String niveau;
private int idsection;
	public Groupe(int idgroupe, String nom, String niveau, int idsection) {
	super();
	this.Idgroupe = idgroupe;
	this.nom = nom;
	this.niveau = niveau;
	this.idsection = idsection;
}
	public Groupe(int idgroupe) {
		
		this.Idgroupe = idgroupe;
	}
	public Groupe(int idgroupe, String nom, int idsection) {
		super();
		Idgroupe = idgroupe;
		this.nom = nom;
		this.idsection = idsection;
	}
	public Groupe() {
		// TODO Auto-generated constructor stub
	}
	public int getIdgroupe() {
		return Idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		Idgroupe = idgroupe;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getIdsection() {
		return idsection;
	}
	public void setIdsection(int idsection) {
		this.idsection = idsection;
	}
	

}
