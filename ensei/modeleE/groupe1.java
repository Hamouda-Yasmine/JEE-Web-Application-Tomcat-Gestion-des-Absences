package modeleE;

public class groupe1 {
	private int Idgroupe;
	private String nom ;
	private String niveau;
	private int idsection;
	public groupe1() {
		// TODO Auto-generated constructor stub
	}
	public groupe1(int idgroupe, String nom, String niveau, int idsection) {
		super();
		Idgroupe = idgroupe;
		this.nom = nom;
		this.niveau = niveau;
		this.idsection = idsection;
	}
	public int getIdgroupe() {
		return Idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		Idgroupe = idgroupe;
	}
	public String getNom() {
		return nom;
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
