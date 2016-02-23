package beansAfrica;

import java.io.Serializable;



public class MedeDesc implements Serializable {
	public int GID;
	public String nom;
	public String prenom;
	public String password;
	public String grade;
	public String poste;
	public MedeDesc(int GID, String nom,String prenom,String password, String grade, String poste)
	{
		this.GID=GID;
		this.nom=nom;
		this.prenom=prenom;
		this.password=password;
		this.grade = grade;
		this.poste = poste;          
	}
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	

	


	
	
}


