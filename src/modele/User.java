package modele;

public class User {
 private int idUser;
 private String nom;
 private String pass;
 private String categorie;
	public User(int idUser, String nom, String pass, String categorie) {
	super();
	this.idUser = idUser;
	this.nom = nom;
	this.pass = pass;
	this.categorie = categorie;
}
	public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
	public User() {
		
	}

}
