package modele;

public class Enseignant {
	  private String nom;
	  private String prenom;
	  private String adresse;
	  private String date_de_naissance;
	  private String téléphone;
	  private String sexe;
	  private String grade;
	  private int idenseignant;
	  private String email;
	  private String motdepasse;
	  private String form;
	  private String Description;
	  private String user;
	  private String Catégorie;
	  public String getNom() {
		return nom;
	}
	  public Enseignant (int i,String nom, String prenom ,String g,String d,String e,String f) {
      	this.nom=nom;
      	this.prenom=prenom;
      	this.idenseignant=i;
      	this.date_de_naissance=d;
      	this.email=e;
      	this.grade=g;
      	this.form=f;
      }
	  public Enseignant(int i,String nom, String prenom, String adresse, String date_de_naissance, String téléphone, String sexe ,String email,String mo,String g,String f,String des) {
			this.nom=nom;
			this.prenom=prenom;
			this.adresse=adresse;
			this.date_de_naissance=date_de_naissance;
			this.téléphone=téléphone;
			idenseignant=i;
	     	motdepasse=mo;
			grade=g;
			this.email=email;
			this.sexe=sexe;
			this.form=f;
			this.Description=des;}
	  public Enseignant(int i,String nom, String prenom, String adresse, String date_de_naissance, String téléphone, String sexe ,String email,String mo,String g,String f,String des,String cat,String user) {
			this.nom=nom;
			this.prenom=prenom;
			this.adresse=adresse;
			this.date_de_naissance=date_de_naissance;
			this.téléphone=téléphone;
			idenseignant=i;
	     	motdepasse=mo;
			grade=g;
			this.email=email;
			this.sexe=sexe;
			this.form=f;
			this.Description=des;
			this.Catégorie=cat;
			this.user=user;
			
		}

	  
	

	public Enseignant(String no, int id) {
		this.idenseignant=id;
		this.prenom=no;
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
		return idenseignant;
	}
	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
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
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCatégorie() {
		return Catégorie;
	}
	public void setCatégorie(String catégorie) {
		Catégorie = catégorie;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
