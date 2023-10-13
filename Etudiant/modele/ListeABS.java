package modele;

public class ListeABS {
 private String heureD;
 private String heureF;
 private String date;
 private String module;
 private int idabsence;
 private String jour;
 private String type;
 private String answer;

public ListeABS( int id,String date,String heureD, String heureF, String module,String jour,String type,String an) {
	super();
	this.heureD = heureD;
	this.heureF = heureF;
	this.date = date;
	this.module = module;
	this.idabsence=id;
	this.jour=jour;
	this.type=type;
	answer=an;
	
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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getModule() {
	return module;
}
public void setModule(String module) {
	this.module = module;
}
public int getIdabsence() {
	return idabsence;
}
public void setIdabsence(int idabsence) {
	this.idabsence = idabsence;
}
public String getJour() {
	return jour;
}
public void setJour(String jour) {
	this.jour = jour;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}

 
}
