package modeleE;

public class PrendreEnCharge {
 private int idenseignant;
 private int idgroupe;
	public int getIdenseignant() {
	return idenseignant;
}
public void setIdenseignant(int idenseignant) {
	this.idenseignant = idenseignant;
}
public int getIdgroupe() {
	return idgroupe;
}
public void setIdgroupe(int idgroupe) {
	this.idgroupe = idgroupe;
}
	public PrendreEnCharge(int idenseignant, int idgroupe) {
	super();
	this.idenseignant = idenseignant;
	this.idgroupe = idgroupe;
}
	public PrendreEnCharge() {
		// TODO Auto-generated constructor stub
	}

}
