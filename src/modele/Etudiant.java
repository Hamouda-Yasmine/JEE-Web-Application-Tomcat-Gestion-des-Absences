package modele;

public class Etudiant {
	  private int idetudiant ;
	  private String nom;
	  private String prenom;
	  private String adresse;
	  private String date_de_naissance;
	  private String téléphone;
	  private String sexe;
	  private String numBac;
	  private String anneeBac;
	  private String motdepasse;
	  private String description;
	  private String email;
	  private String form;
	  private String nomg;
	 
	  private String user;
	  public Etudiant(int i,String nom, String prenom, String adresse, String date_de_naissance, String téléphone, String sexe,
				String numBac, String anneeBac,String desp,String mo,String email,String f,String user) {
		this.idetudiant=i;	
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.date_de_naissance = date_de_naissance;
		this.téléphone = téléphone;
		this.sexe = sexe;
		this.numBac = numBac;
		this.anneeBac = anneeBac;
	    this.email=email;
	    this.motdepasse=mo;
		this.description=desp;
         this.form=f;
        
        
         this.user=user;
	}
	public Etudiant(String nom, String prenom, String adresse, String date_de_naissance, String téléphone, String sexe,
			String numBac, String anneeBac,int idetudiant ) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.date_de_naissance = date_de_naissance;
		this.téléphone = téléphone;
		this.sexe = sexe;
		this.numBac = numBac;
		this.anneeBac = anneeBac;
		this.idetudiant=idetudiant;
	}
	public Etudiant(int idetudiant,String nom, String prenom,String form) {
		super();
		this.idetudiant = idetudiant;
		this.prenom = prenom;
		this.form=form;
		this.nom=nom;
	}
	public Etudiant(int idetudiant, String prenom) {
		super();
		this.idetudiant = idetudiant;
		this.prenom = prenom;
	}
	public Etudiant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Etudiant(int i,String n,String p,String d,String f,String e) {
		email=e;
		idetudiant=i;
		nom=n;
		prenom=p;
		date_de_naissance=d;
		form=f;}
	public Etudiant(int i,String n,String p,String d,String f,String e,String ng,String téléphone,String ab,String ad) {
		email=e;
		idetudiant=i;
		nom=n;
		prenom=p;
		date_de_naissance=d;
		form=f;
		nomg=ng;
		this.téléphone=téléphone;
		anneeBac=ab;
		adresse=ad;
	}
	public Etudiant() {
		
	}
	public int getIdetudiant() {
		return idetudiant;
	}
	public void setIdetudiant(int idetudiant) {
		this.idetudiant = idetudiant;
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
	public String getNumBac() {
		return numBac;
	}
	public void setNumBac(String numBac) {
		this.numBac = numBac;
	}
	public String getAnneeBac() {
		return anneeBac;
	}
	public void setAnneeBac(String anneeBac) {
		this.anneeBac = anneeBac;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNomg() {
		return nomg;
	}
	public void setNomg(String nomg) {
		this.nomg = nomg;
	}
}
