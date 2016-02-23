package beansAfrica;

import java.sql.Date;

public class AntecedMed {
	private int GID;
	private Date DateFirstCon;
	private Date  DateInsuline;
	private String ConsoAlc;
	private String ConsoTab;
	private String AccidentVS;
	public int getGID() {
		return GID;
	}
	public AntecedMed (int GID,Date DateFirstCon,Date  DateInsuline,String ConsoAlc,String ConsoTab,String AccidentVS){
		this.GID=GID;
		this.DateFirstCon=DateFirstCon;
		this.DateInsuline=DateInsuline;
		this.ConsoAlc=ConsoAlc;
		this.ConsoTab=ConsoTab;
		this.AccidentVS=AccidentVS;
	}
	public void setGID(int gID) {
		GID = gID;
	}

	public Date getDateFirstCon() {
		return DateFirstCon;
	}
	public void setDateFirstCon(Date dateFirstCon) {
		DateFirstCon = dateFirstCon;
	}
	public Date getDateInsuline() {
		return DateInsuline;
	}
	public void setDateInsuline(Date dateInsuline) {
		DateInsuline = dateInsuline;
	}
	public String getConsoAlc() {
		return ConsoAlc;
	}
	public void setConsoAlc(String consoAlc) {
		ConsoAlc = consoAlc;
	}
	public String getConsoTab() {
		return ConsoTab;
	}
	public void setConsoTab(String consoTab) {
		ConsoTab = consoTab;
	}
	public String getAccidentVS() {
		return AccidentVS;
	}
	public void setAccidentVS(String accidentVS) {
		AccidentVS = accidentVS;
	}

}
