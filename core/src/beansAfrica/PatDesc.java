package beansAfrica;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * public String nom;
 */

public class PatDesc implements Serializable {
	public int GID;
	public String nom;
	public int getGID() {
		return GID;
	}

	public void setGID(int gID) {
		GID = gID;
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

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNiveauIntel() {
		return NiveauIntel;
	}

	public void setNiveauIntel(String niveauIntel) {
		NiveauIntel = niveauIntel;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public String getIdPatient() {
		return IdPatient;
	}

	public void setIdPatient(String idPatient) {
		IdPatient = idPatient;
	}

	public String prenom;
	public Date naissance;
	public String sexe;
	public String NiveauIntel;
	public String Profession;
	public String IdPatient;

	public PatDesc (int GID, String fullname,String prenom,Date age, String sexe, String NiveauIntel, String Profession,String idPat)
	{
		this.GID=GID;
		this.nom=fullname;
		this.prenom=prenom;
		this.naissance = age;
		this.sexe = sexe;
		this.NiveauIntel= NiveauIntel;
		this.Profession=Profession;
		this.IdPatient=idPat;
	}


	
	
}

