package modeleE;

public class Seance {
private int idSeance;
private String heureD;
private String heureF;
private int idCHefdep;
private int idgroupe;
private int idenseignant;
private int idmodule;
private String type;
	public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
	public Seance(int idSeance, String heureD, String heureF, int idCHefdep, int idgroupe, int idenseignant, int idmodule) {
	super();
	this.idSeance = idSeance;
	this.heureD = heureD;
	this.heureF = heureF;
	this.idCHefdep = idCHefdep;
	this.idgroupe = idgroupe;
	this.idenseignant = idenseignant;
	this.idmodule = idmodule;
}
	public Seance(int idSeance, String heureD, String heureF, int idmodule,String type) {
		super();
		this.idSeance = idSeance;
		this.heureD = heureD;
		this.heureF = heureF;
		this.idmodule = idmodule;
		this.type=type;
	}
	public int getIdmodule() {
	return idmodule;
}
public void setIdmodule(int idmodule) {
	this.idmodule = idmodule;
}
	public Seance() {
		// TODO Auto-generated constructor stub
	}
	public int getIdSeance() {
		return idSeance;
	}
	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
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
	public int getIdCHefdep() {
		return idCHefdep;
	}
	public void setIdCHefdep(int idCHefdep) {
		this.idCHefdep = idCHefdep;
	}
	public int getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}
	public int getIdenseignant() {
		return idenseignant;
	}
	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
	}
	
	

}
