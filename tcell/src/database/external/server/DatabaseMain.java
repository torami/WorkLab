/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database.external.server;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import configuration.Configuration;
import dao.external.server.TcellDAOToken;
/**
 * author TORKHANI Rami 
 * Initialization of the DataBase.
 */
public class DatabaseMain {
	/**
	 * Initialization of db.
	 * 
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 */


	public static void main(String[] args) throws NoSuchAlgorithmException,
	FileNotFoundException {

		if (System.getProperty("configurationFilePath") == null) {
			System.out.println("'configurationFilePath' system property is not defined");
			return;
		}

		try { 
			/*STOP HERE*/
			TcellDAOToken.getInstance(true);
			TcellDAOToken.getInstance(false).DropTables();
			TcellDAOToken.getInstance(false).CreateTables();

			/*InsertDATA*/
			System.getProperties().setProperty("jdbc.port", Configuration.getConfiguration().getProperty("dbPort"));
			String InsertFilePath = Configuration.getConfiguration().getProperty("InsertFilePath");
			String InsertDoctorPath = Configuration.getConfiguration().getProperty("InsertDoctorPath");
			FileInputStream fstream1 = new FileInputStream(InsertDoctorPath);
			FileInputStream fstream = new FileInputStream(InsertFilePath);
			// Init MyInfo
			int myGid = Integer.parseInt(Configuration.getConfiguration().getProperty("userGID"));
			String myTcellIp = Configuration.getConfiguration().getProperty("tcellIP") ;
			int myTcellPort = Integer.parseInt(Configuration.getConfiguration().getProperty("port"));

			TcellDAOToken.getInstance(false).insertMyTOKENParameter(myGid, myTcellIp, myTcellPort,"10");
			TcellDAOToken.getInstance(false).printMyTokenParameter();
			// Get the contacts info of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			//Add Some Queries To Table PATIENT From File
			while ((strLine = br.readLine()) != null) {
				if (strLine != "") {
					String[] tokens = strLine.split(":");
					String GID = tokens[0];
					String nom = tokens[1];
					String prenom = tokens[2];
					String datenaiss = tokens[3];
					java.util.Date utilDate = new SimpleDateFormat("dd MMM yyyy").parse(datenaiss);
					java.sql.Date datenaissance = new java.sql.Date(utilDate.getTime());
					String sexe = tokens[4];
					String niveauintel = tokens[5];
					String profession = tokens[6];
					String idPatient = tokens[7];
					TcellDAOToken.getInstance(false).insertPatient(Integer.parseInt(GID),nom,prenom,datenaissance,sexe,niveauintel,profession,idPatient);
					TcellDAOToken.getInstance(false).printAllPatient();
				}
			}
			br.close();
			in.close();
			//Insert Doctor
			in = new DataInputStream(fstream1);
			br = new BufferedReader(new InputStreamReader(in));
			strLine ="";

			//Add Some Queries To table PRATICIEN From File
			while ((strLine = br.readLine()) != null) {
				if (strLine != "") {
					String[] tokens = strLine.split(":");
					String GID = tokens[0];
					String nom = tokens[1];
					String prenom = tokens[2];
					String password = tokens[3];
					String grade = tokens[4];
					String poste = tokens[5];
					String id_pat = tokens[6];
					TcellDAOToken.getInstance(false).InsertPraticien(Integer.parseInt(GID), nom, prenom, password, grade,poste,id_pat);
					
				}
			}
			br.close();
			in.close();
			java.util.Date utilDate1 = new SimpleDateFormat("dd MMM yyyy").parse("16 December 2015");
			java.sql.Date datevisite = new java.sql.Date(utilDate1.getTime());
			//INSERT A CONSULTATION
			TcellDAOToken.getInstance(false).InsertVisite(1,4,datevisite,"75kg","1m85","12.5","13","12.8","3 doses","10");
			TcellDAOToken.getInstance(false).InsertVisite(2,2,datevisite,"78kg","1m85","9.5","12.9","12.8","2 doses","10");
			TcellDAOToken.getInstance(false).InsertVisite(3,6,datevisite,"81kg","1m85","10","13","12.8","0 doses","10");
			TcellDAOToken.getInstance(false).InsertVisite(4,1,datevisite,"79kg","1m85","11.5","12.9","12.8","0 doses","10");

			//INSERT ANTECEDENT MEDIC
			TcellDAOToken.getInstance(false).insertAntecedentsMed(1, datevisite, datevisite, "Oui", "Oui","Non","10");
			
			//Print LOGs
			System.out.println("Moniseur "+TcellDAOToken.getInstance(false).getLoginName("Faye")+"EXIST");
			System.out.println("This Password  "+TcellDAOToken.getInstance(false).getLoginPass("MeHap")+"EXIST");
			TcellDAOToken.getInstance(false).printAllMedecin();
			TcellDAOToken.getInstance(false).getAllVisite();
			TcellDAOToken.getInstance(false).printAnteced();
		
			
		
			TcellDAOToken.getInstance(false).Save_DBMS_on_disk();
			TcellDAOToken.getInstance(false).Shutdown_DBMS();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}

