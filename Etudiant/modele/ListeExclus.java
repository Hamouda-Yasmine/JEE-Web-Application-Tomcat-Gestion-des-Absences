package modele;

public class ListeExclus {
private String nom;
private String prénom;
private String module;
private String type;
private int idexclu;
private int idetu;
private String answer;
public ListeExclus(int ide,String nom,String prénom,String module,String type,int idex,String a) {
	this.nom=nom;
	this.prénom=prénom;
	this.module=module;
	this.type=type;
	this.idexclu=idex;
	answer=a;
	idetu=ide;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrénom() {
	return prénom;
}
public void setPrénom(String prénom) {
	this.prénom = prénom;
}
public String getModule() {
	return module;
}
public void setModule(String module) {
	this.module = module;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getIdexclu() {
	return idexclu;
}
public void setIdexclu(int idexclu) {
	this.idexclu = idexclu;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public int getIdetu() {
	return idetu;
}
public void setIdetu(int idetu) {
	this.idetu = idetu;
}
}
