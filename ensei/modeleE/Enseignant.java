package modeleE;

public class Enseignant {
	  private String nom;
	  private String prenom;
	  private String adresse;
	  private String date_de_naissance;
	  private String téléphone;
	  private String sexe;
	  private String grade;
	  private int idEnseignant;
	  private String email;
	  private String pass;
	  private String form;
	  private String user;
	  public Enseignant(String nom, String prenom, String adresse, String téléphone, int idEnseignant, String email,
			String pass, String user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.téléphone = téléphone;
		this.idEnseignant = idEnseignant;
		this.email = email;
		this.pass = pass;
		this.user = user;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNom() {
		return nom;
	}
	  public Enseignant (int i,String nom, String prenom ,String g,String d,String e,String f) {
      	this.nom=nom;
      	this.prenom=prenom;
      	this.idEnseignant=i;
      	this.date_de_naissance=d;
      	this.email=e;
      	this.grade=g;
      	this.form=f;
      }
	  public Enseignant(int i,String nom, String prenom, String adresse, String date_de_naissance, String téléphone, String sexe ,String email,String mo,String g,String f) {
			this.nom=nom;
			this.prenom=prenom;
			this.adresse=adresse;
			this.date_de_naissance=date_de_naissance;
			this.téléphone=téléphone;
			idEnseignant=i;
	     	this.pass=mo;
			grade=g;
			this.email=email;
			this.sexe=sexe;
			this.form=f;
		}

	  
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(String date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	public String getTéléphone() {
		return téléphone;
	}
	public void setTéléphone(String téléphone) {
		this.téléphone = téléphone;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getIdenseignant() {
		return idEnseignant;
	}
	public void setIdenseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMotdepasse() {
		return pass;
	}
	public void setMotdepasse(String motdepasse) {
		this.pass = motdepasse;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	
}
