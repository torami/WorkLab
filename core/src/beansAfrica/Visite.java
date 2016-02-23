package beansAfrica;

import java.sql.Date;

public class Visite {
	
	private int GID;
	private int IdPraticien;
	private Date datevi;
	private String Poid;
	private String Taille;
	private String IMC;
	private String Glyc;
	private String TA;
	private String Insuline;
	public Visite(int gID, int idPraticien, Date datevi, String poid,String taille, String iMC, String glyc, String tA, String insuline) {
		super();
		GID = gID;
		IdPraticien = idPraticien;
		this.datevi = datevi;
		Poid = poid;
		Taille = taille;
		IMC = iMC;
		Glyc = glyc;
		TA = tA;
		Insuline = insuline;
	}
	public int getGID() {
		return GID;
	}
	public void setGID(int gID) {
		GID = gID;
	}
	public int getIdPraticien() {
		return IdPraticien;
	}
	public void setIdPraticien(int idPraticien) {
		IdPraticien = idPraticien;
	}
	public Date getDatevi() {
		return datevi;
	}
	public void setDatevi(Date datevi) {
		this.datevi = datevi;
	}
	public String getPoid() {
		return Poid;
	}
	public void setPoid(String poid) {
		Poid = poid;
	}
	public String getTaille() {
		return Taille;
	}
	public void setTaille(String taille) {
		Taille = taille;
	}
	public String getIMC() {
		return IMC;
	}
	public void setIMC(String iMC) {
		IMC = iMC;
	}
	public String getGlyc() {
		return Glyc;
	}
	public void setGlyc(String glyc) {
		Glyc = glyc;
	}
	public String getTA() {
		return TA;
	}
	public void setTA(String tA) {
		TA = tA;
	}
	public String getInsuline() {
		return Insuline;
	}
	public void setInsuline(String insuline) {
		Insuline = insuline;
	}
	



}
