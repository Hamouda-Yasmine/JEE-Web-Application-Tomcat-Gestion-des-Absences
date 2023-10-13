package modele;

public class Seance {
private int idseance;
private String heureD;
private String heureF;
private String type;
private String jour;
private String groupe;
private String module;
private String salle;
private String section;
	public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getJour() {
	return jour;
}

public void setJour(String jour) {
	this.jour = jour;
}

public String getGroupe() {
	return groupe;
}

public void setGroupe(String groupe) {
	this.groupe = groupe;
}

public String getModule() {
	return module;
}

public void setModule(String module) {
	this.module = module;
}


	public Seance(int idseance, String heureD, String heureF, String type, String jour, String groupe, String module,
		String salle,String section) {
	super();
	this.idseance = idseance;
	this.heureD = heureD;
	this.heureF = heureF;
	this.type = type;
	this.jour = jour;
	this.groupe = groupe;
	this.module = module;
	this.salle = salle;
	this.section=section;
}

	public Seance() {
		
	}
	public int getIdseance() {
	return idseance;
}
public void setIdseance(int idseance) {
	this.idseance = idseance;
}
public String getHeureD() {
	return heureD;
}
public void setHeureD(String heureD) {
	this.heureD = heureD;
}
public String getHeureF() {
	return heureF;
}
public void setHeureF(String heureF) {
	this.heureF = heureF;
}

public String getSalle() {
	return salle;
}

public void setSalle(String salle) {
	this.salle = salle;
}

public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}


}
