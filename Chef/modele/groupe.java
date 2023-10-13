package modele;

public class groupe {
	 private String nom;
	 private int idgroupe;
	 
	 public groupe(int id,String n) {
		 
		 this.idgroupe=id;
		 this.nom=n;
	 }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}
}
