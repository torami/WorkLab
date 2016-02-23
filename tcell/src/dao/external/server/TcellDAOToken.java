package dao.external.server;

import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.inria.database.QEPng;

import test.jdbc.Tools;
import beansAfrica.AntecedMed;
import beansAfrica.Login;
import beansAfrica.MedeDesc;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;
import beansAfrica.Visite;
import configuration.Configuration;
import dao.Patient.QEP;
import dao.Patient.Schema;
import dao.Patient.TCell_QEP_IDs;



/**
 * author TORKHANI Rami
 * the TCell DB Manager.
 */
public class TcellDAOToken extends Tools{
	private static int fileIdGlobal=0;

	private static TcellDAOToken instance = null;
	
	
	// Renvoyer une instance de TcellDAOToken
		public static TcellDAOToken getInstance(boolean ignoreLoadQEP) {
			/**
			 * TcellDAOToken Creates a TCELL_DB instance
			 * @param ignoreLoadQEP
			 */

			if (instance == null) {
				synchronized (TcellDAOToken.class) {
					if (instance == null) {
						instance = new TcellDAOToken(ignoreLoadQEP);
					}
				}
			}
			return instance;
		}

	//Load JDBC driver, get a connexion, without installing execution plans
	
	public  TcellDAOToken(boolean ignoreLoadQEP) {
		try {
			out = new PrintWriter(java.lang.System.out);
		    init();
			openConnection(Configuration.getConfiguration().getProperty("dbPath"), null);
			
			((org.inria.jdbc.Connection) db).bypassInitialization();
			
			Class<?>[] executionPlans = new Class[] { QEP.class };
			QEPng.loadExecutionPlans(TCell_QEP_IDs.class, executionPlans);
			if(!ignoreLoadQEP){
				QEPng.installExecutionPlans(db);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public void DropTables() {
		/**
		 * Drop the tables of DB.
		 */
		try {
			Desinstall_DBMS_MetaData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CreateTables() {
		/**
		 * Creates the tables in DB.
		 * 
		 */
		try {
			String schema = Schema.META;
			Install_DBMS_MetaData(schema.getBytes(),0);

			// load and install QEPs
			Class<?>[] executionPlans = new Class[] { QEP.class };
			QEPng.loadExecutionPlans(TCell_QEP_IDs.class, executionPlans);
			QEPng.installExecutionPlans(db);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Inserts a patient's description
	 * 
	 * @param GID
	 *            the global id of the file
	 * @param fullname
	 *            the fullname of the patient
	 * @param age
	 *            the age of the patient
	 * @param sex
	 *            the civility of the patient
	 * @param taille
	 *            the size of patient
	 * @throws Exception
	 */
	public void insertPatient(int GID,String Nom,String Prenom,Date Age,String Sexe,String NiveauIntel,String Profession,String IdPatient) {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_insertPatient);
			//ps.setInt(1, fileIdGlobal++);
			ps.setInt(1, GID);
			ps.setString(2, Nom);
			ps.setString(3, Prenom);
			ps.setDate(4, Age);
			ps.setString(5, Sexe);
			ps.setString(6, NiveauIntel);
			ps.setString(7, Profession);
			ps.setString(8, IdPatient);
			ps.executeUpdate();
			
			String query= "INSERT INTO PATIENT  VALUES ("+ GID+","+Nom+","+Prenom+","+Age+","+Sexe+","+NiveauIntel+","+Profession+")";
			//System.out.println("Executing query : " + query);			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
		}

	}
	
	/**
	 * Inserts a Consultation 's description
	 * 
	 * @param IdGlobal
	 *            the global id of the consultation
	 * @param IdPatient
	 *           the global id of the Patient
	 * @param IdMedecin
	 *            the global id of a Doctor
	 * @param IMC
	 *            Sepecifique to Doc
	 * @param TDT
	 * 			  Sepecifique to Doc
	 * @param POID   
	 * 			  Sepecifique to Doc  
	 * @param DATEVI   
	 * 			  the date of consultation	  
	 * @throws Exception
	 */
	public void InsertVisite(int GID,int IdPRATICIEN,Date DateVI,String Poid ,String Taille,String IMC,String Glyc,String TA,String Insuline,String id_pat) {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_insertVisite);
			//ps.setInt(1, fileIdGlobal++);
			ps.setInt(1, GID);
			ps.setInt(2, IdPRATICIEN);
			ps.setDate(3, DateVI);
			ps.setString(4, Poid);
			ps.setString(5, Taille);
			ps.setString(6, IMC);
			ps.setString(7, Glyc);
			ps.setString(8, TA);
			ps.setString(9, Insuline);
			ps.setString(10, id_pat);
			ps.executeUpdate();
			
			String query= "INSERT INTO VISITE  VALUES ("+ GID+"||"+IdPRATICIEN+"||"+DateVI+"||"+Poid+"||"+Taille+"||"+IMC+"||"+Glyc+"||"+TA+"||"+Insuline+"||"+id_pat+")";
			//System.out.println("Executing query : " + query);			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
		}
	}
	/**
	 * Inserts a Personnel's description
	 * 
	 * @param GID
	 *            the global id of the doctor
	 * @param nomProf
	 *            the name of the professor
	 * @param grade
	 *            the level of the doctor
	 * @param service
	 *            the service of the doctor 
	 * @throws Exception
	 */
	public void InsertPraticien(int GID,String nom ,String prenom,String password,String grade,String service,String id_pat) {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_insertPRATICIEN);
			//ps.setInt(1, fileIdGlobal++);
			ps.setInt(1, GID);
			ps.setString(2, nom);
			ps.setString(3, prenom);
			ps.setString(4, password);
			ps.setString(5, grade);
			ps.setString(6, service);
			ps.setString(7, id_pat);
			ps.executeUpdate();
			
			String query= "INSERT INTO PRATICIEN  VALUES ("+ GID+"||"+nom+"||"+prenom+"||"+password+"||"+grade+"||"+service+"||"+id_pat+")";
			//System.out.println("Executing query : " + query);			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
		}
	}
	/**
	 * Inserts a medical history 's description 
	 * @throws Exception
	 */
	public void insertAntecedentsMed(int GID,Date DateFirstCon,Date  DateInsuline,String ConsoAlc ,String ConsoTab, String AccidentVS,String id_pat) {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_insertANTECEDENTMED);
			ps.setInt(1, GID);
			ps.setDate(2,DateFirstCon );
			ps.setDate(3, DateInsuline);
			ps.setString(4,ConsoAlc );
			ps.setString(5, ConsoTab);
			ps.setString(6, AccidentVS);
			ps.setString(7, id_pat);
			ps.executeUpdate();
			
			String query= "INSERT INTO Antécedent_Med  VALUES ("+ GID+"||"+DateFirstCon+"||"+DateInsuline+"||"+ConsoAlc+"||"+ConsoTab+"||"+AccidentVS+"||"+id_pat+")";
			//System.out.println("Executing query : " + query);			

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * Inserts parmameter of token
	 * 
	 * @param GID
	 *            the global id of the token
	 * @param MytCellIp
	 *            the Ip of the cell
	 * @param MytCellPort
	 *            the listing port of cell 
	 * @throws Exception
	 */
	public void insertMyTOKENParameter(int IdGlobal,String MytCellIp,int MytCellPort,String id_pat) {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_insertMyParameter);
			ps.setInt(1, IdGlobal);
			ps.setString(2, MytCellIp);
			ps.setInt(3, MytCellPort);
			ps.setString(4, id_pat);
			ps.executeUpdate();
			
			String query= "INSERT INTO MyInfo  VALUES ("+ IdGlobal+"||"+MytCellIp+"||"+MytCellPort+"||"+id_pat+")";
			//System.out.println("Executing query : " + query);			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
		}
	}
	/**
	 * SELECT GID, nom,prenom,grade,poste FROM MEDECIN;
	 * 	  @return FileDesc 
	 *    The Doctor's description <GID, nom, prenom, grade, poste>
	 */
	public ArrayList<MedeDesc> getAllPraticien() {

		ArrayList<MedeDesc> result = new ArrayList<MedeDesc>();

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getAllPRATICIEN);
			ResultSet rs = ps.executeQuery();
			String query = "SELECT GID, nom,prenom,grade,service FROM Praticien";
			System.out.println("Executing query : " + query);			
			while (rs.next() == true) {
				int GID = rs.getInt(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String password = rs.getString(4);
				String grade = rs.getString(5);
				String poste = rs.getString(6);
				String id_pat = rs.getString(7);
				result.add(new MedeDesc(GID,nom, prenom,password,grade,poste));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}

		return result;
	}
	/**
	 * SELECT GID,fistcon,dateinsuline,ConsoAlc,ConsoTab,AccidentVS FROM ANTECEDMED;
	 * 	  @return {@link AntecedMed} 
	 *    The Doctor's description <GID,fistcon,dateinsuline,ConsoAlc,ConsoTab,AccidentVS>
	 */
	public AntecedMed getANTECEDENT() {

		AntecedMed result = null;

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getANTECEDENTMED);
			ResultSet rs = ps.executeQuery();
			String query = "SELECT GID,fistcon,dateinsuline,ConsoAlc,ConsoTab,AccidentVS ANTECEDENTMED";
			System.out.println("Executing query : " + query);			
			while (rs.next() == true) {
				int GID = rs.getInt(1);
				Date fistcon = rs.getDate(2);
				Date dateinsuline = rs.getDate(3);
				String ConsoAlc = rs.getString(4);
				String ConsoTab = rs.getString(5);
				String AccidentVS = rs.getString(6);
				result = new AntecedMed(GID, fistcon, dateinsuline, ConsoAlc, ConsoTab, AccidentVS);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}

		return result;
	}
	/**
	 * SELECT GID, nom,prenom,grade,poste FROM MEDECIN;
	 * 	  @return FileDesc 
	 *    The Doctor's description <GID, nom, prenom, grade, poste>
	 */
	public ArrayList<Visite> getAllVisite() {

		ArrayList<Visite> result = new ArrayList<Visite>();

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getAllViste );
			ResultSet rs = ps.executeQuery();
			
			String query = "SELECT VISITE";
			System.out.println("Executing query : " + query);			
				while (rs.next() == true) {
				int GID = rs.getInt(1);
				int idPraticien = rs.getInt(2);
				 Date datevi  = rs.getDate(3);
				 String Poid = rs.getString(4);
				 String Taille= rs.getString(5);
				 String IMC= rs.getString(6);
				 String Glyc= rs.getString(7);
				 String TA= rs.getString(8);
				String Insuline= rs.getString(9);
				result.add(new Visite(GID,idPraticien,datevi,Poid,Taille,IMC,Glyc,TA,Insuline));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}

		return result;
	}
	/**
	 * SELECT GID, Nom,Prenom,Age, Sexe, NiveauIntel, Profession,IdPatient FROM Patient;
	 * 	  @return FileDesc 
	 *    The Patient's description < GID, Nom,Prenom,Age, Sexe, NiveauIntel, Profession,IdPatient>
	 */
	public PatDesc getPatient() {

		PatDesc result = null;

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getInfoPatient );
			ResultSet rs = ps.executeQuery();
			String query = "SELECT GID, Nom,Prenom,Age, Sexe, NiveauIntel, Profession,IdPatient FROM Patient";
			System.out.println("Executing query : " + query);			
			while (rs.next() == true) {
				int GID = rs.getInt(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				Date naissance = rs.getDate(4);
				String sexe = rs.getString(5);
				String Niveau = rs.getString(6);
				String Profession = rs.getString(7);
				String idpat = rs.getString(8);
				result = new PatDesc(GID,nom, prenom,naissance,sexe,Niveau,Profession,idpat);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}

		return result;
	}
	/**
	 * SELECT IdGlobal, MytCellIp, MytCellPort, MyPublicKey, MyPrivateKey FROM MyParameter;
	 * 	  @return FileDesc 
	 *    The Token parameter's description <IdGlobal, MytCellIp, MytCellPort, MyPublicKey, MyPrivateKey>
	 */
public MyParameter getMyParameter() {
		
		MyParameter myInfo = null;
		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getMyParameter);
			ResultSet rs = ps.executeQuery();

			String query = "SELECT IdGlobal, MYTCELLIP, MYTCELLPORT FROM MyParameter";
			System.out.println("Executing query : " + query);

			while (rs.next()) {

				int myGid = rs.getInt(1);
				String myTcellIp = rs.getString(2);
				int myTcellPort = rs.getInt(3);
				
			
				myInfo = new MyParameter(myGid, myTcellIp, myTcellPort);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
		}

		return myInfo;
	}
/**
 * IS MEDECIN EXIST;
 * 	  @return FileDesc 
 *    The user 's <username,password>
 */
public int getLoginName(String username) {
	
	int state = 0;
	try {
		java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getLoginNom);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();

		String query = "SELECT"+username+"FROM Login";
		System.out.println("Executing query : " + query);

		if(rs.next())
			state++;
		

	} catch (Exception e) {
		e.printStackTrace();
	} 

	return state;
}
/**
 * IS MEDECIN IS PASSWORD EXIST;
 * 	  @return FileDesc 
 *    The user 's <username,password>
 */
public int getLoginPass(String password) {
	
	int state = 0;
	try {
		java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_getLoginPass);
		ps.setString(1,password);
		ResultSet rs = ps.executeQuery();

		String query = "SELECT"+password+"FROM Login";
		System.out.println("Executing query : " + query);

		if(rs.next())
			state++;
		

	} catch (Exception e) {
		e.printStackTrace();
	} 

	return state;
}
/**
 * Select USERGID, TCELLIP, PORT from MyParameter WHERE USERGID = 'userGID';
 * @param userGID the user ID
 * @return List<IP>
 *    List of IPs <USERGID, TCELLIP, PUBLICKEY>
 */
public MyParameter getUserById( int userGID ){
	MyParameter user = null;

	try {
		java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_GetIdParameter);
		ps.setInt(1, userGID);
		ResultSet rs = ps.executeQuery();
		
		String query = "SELECT IdGlobal, TCELLIP,TCELLPORT FROM MyParameter WHERE IdGlobal = "+ userGID +")";
		System.out.println("Executing query : " + query);			

		
		//Retrieve TCellIP from USER table in TCellDB
		while (rs.next()) {
			int UserGID =rs.getInt(1);
			String TCellIP = rs.getString(2);
			int port = rs.getInt(3);
			user = new MyParameter(UserGID,TCellIP, port);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		// Uncomment when the close function will be implemented
		// attemptToClose(ps);
	}

	return user;                      
}

			/************LOG INFO***************/
	public void printAllMedecin() {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_PRINTAllPRATICIEN);
			ResultSet rs = ps.executeQuery();
			
			String query = "SELECT IdGlobal, Nom, Prenom, Grade, Poste FROM MEDECIN";
			System.out.println("Executing query : " + query);			

			Tools.lireResultSet(rs , out);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void printAllPatient() {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_PRINTInfoPatient);
			ResultSet rs = ps.executeQuery();
			
			String query = "SELECT IdGlobal, Nom, Prenom, Age, Sexe, NiveauIntel, Profession FROM PATIENT";
			System.out.println("Executing query : " + query);			

			Tools.lireResultSet(rs , out);
		} catch (Exception e) {
			e.printStackTrace();}
		
	}
	
	public void printAllVisite() {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_PRINTAllViste);
			ResultSet rs = ps.executeQuery();
			
			String query = "SELECT IdGlobal, IdPatient, IdPRATICIEN, DateVI, Poid ,Taille, IMC, TDT, TG, Insuline FROM VISITE";
			System.out.println("Executing query : " + query);			

			Tools.lireResultSet(rs , out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}
	}
	public void printAnteced() {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_PRINTANTECEDENTMED);
			ResultSet rs = ps.executeQuery();
			
			String query = "SELECT GID,fistcon,dateinsuline,ConsoAlc,ConsoTab,AccidentVS ANTECEDENTMED";
			System.out.println("Executing query : " + query);			

			Tools.lireResultSet(rs , out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}
	}
	public void printMyTokenParameter() {

		try {
			java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection) db).prepareStatement(TCell_QEP_IDs.QEP.EP_PRINTMyParameter);
			ResultSet rs = ps.executeQuery();
			
			String query = "SELECT IdGlobal, MytCellIp, MytCellPort, MyPublicKey, MyPrivateKey FROM MyParameter";
			System.out.println("Executing query : " + query);			

			Tools.lireResultSet(rs , out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Uncomment when the close function will be implemented
			// attemptToClose(ps);
			
		}
	}
	
	/*************************************************************************************************************/

	

	private void attemptToClose(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
