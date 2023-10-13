package modele;

public class Administrateur {
	  private String nom;
	  private String prenom;
	  private String adresse;
	  private String date_de_naissance;
	  private String sexe;
	  private int idadministrateur;
	  private String description;
	  private String email;
	  private String motdepasse;
	  private String téléphone;
	  private String user;
	  public Administrateur(String prenom, int idadministrateur) {
		super();
		this.prenom = prenom;
		this.idadministrateur = idadministrateur;
	}
	
	 public int getIdadministrateur() {
		return idadministrateur;
	}
	public void setIdadministrateur(int idadministrateur) {
		this.idadministrateur = idadministrateur;
	}
	public String getTéléphone() {
		return téléphone;
	}
	public void setTéléphone(String téléphone) {
		this.téléphone = téléphone;
	}
	public Administrateur () {
		 
	 }
	  public Administrateur(String n, String p, String s, String tele, int id, String pass, String user, String email,String dn,String adr,String des) {
		this.nom=n;
		this.prenom=p;
		this.sexe=s;
		this.téléphone=tele;
		this.idadministrateur=id;
		this.user=user;
		this.email=email;
		this.motdepasse=pass;
		this.date_de_naissance=dn;
		this.adresse=adr;
		this.description=des;
		
	}
	public String getNom() {
		return nom;
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
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
