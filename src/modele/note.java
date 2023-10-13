package modele;

public class note {
 private String note;
 private int idnote;

 public note(String note,int idnote) {
	 this.note=note;
	 this.idnote=idnote;
 }
public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}
public int getIdnote() {
	return idnote;
}
public void setIdnote(int idnote) {
	this.idnote = idnote;
}
}
