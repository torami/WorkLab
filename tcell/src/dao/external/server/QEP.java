package dao.external.server;

/**
 * author TORKHANI Rami
 * The execution plans of queries should be declaring this class
 */

public class QEP {
	public static String EP_insertMyParameter =
			"/*EP \u0004 6 1 1 -1 1 ?1 # 5 0 0 1 4 3 1 11 r0 12 ?2 13 ?3 14 ?4 # \u0000*/";

		public static String EP_insertPRATICIEN =
			"/*EP \u0007 6 1 1 -1 3 ?1 # 5 0 0 1 7 5 1 23 r0 24 ?2 25 ?3 26 ?4 27 ?5 28 ?6 29 ?7 # \u0000*/";

		public static String EP_insertPatient =
			"/*EP \u0008 6 1 1 -1 2 ?1 # 5 0 0 1 8 4 1 15 r0 16 ?2 17 ?3 18 ?4 19 ?5 20 ?6 21 ?7 22 ?8 # \u0000*/";

		public static String EP_insertVisite =
			"/*EP \n 2 3 3 -1 3 ?2 # 6 2 2 3 5 ?1 # 5 1 1 2 1 0 0 0 r1 # 5 0 0 1 10 7 1 37 r2 38 ?2 39 ?3 40 ?4 41 ?5 42 ?6 43 ?7 44 ?8 45 ?9 46 ?10 # \u0000*/";

		public static String EP_insertANTECEDENTMED =
			"/*EP \u0007 6 1 1 -1 4 ?1 # 5 0 0 1 7 6 1 30 r0 31 ?2 32 ?3 33 ?4 34 ?5 35 ?6 36 ?7 # \u0000*/";

		public static String EP_getMyParameter =
			"/*EP \u0000 0 1 1 3 # 1 0 0 1 r0 4 3 1 11 12 13 14 # \u0000 4 1 1 IdGlobal 0 2 MytCellIp 1 3 MytCellPort 0 4 IdPatient # \u0000*/";

		public static String EP_getAllPRATICIEN =
			"/*EP \u0000 0 1 1 5 # 1 0 0 1 r0 7 5 1 23 24 25 26 27 28 29 # \u0000 7 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste 0 7 IdPatient # \u0000*/";

		public static String EP_getLoginNom =
			"/*EP \u0001 0 2 2 5 # 1 1 1 2 r0 7 5 1 23 24 25 26 27 28 29 # 4 0 0 1 24 0 ?1 r2 # \u0000 7 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste 0 7 IdPatient # \u0000*/";

		public static String EP_getLoginPass =
			"/*EP \u0001 0 2 2 5 # 1 1 1 2 r0 7 5 1 23 24 25 26 27 28 29 # 4 0 0 1 26 0 ?1 r4 # \u0000 7 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste 0 7 IdPatient # \u0000*/";

		public static String EP_getInfoPatient =
			"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 8 4 1 15 16 17 18 19 20 21 22 # \u0000 8 1 1 IdGlobal 0 2 Nom 0 3 Prenom 2 4 DateNaissance 0 5 Sexe 0 6 NiveauIntel 0 7 Profession 0 8 IdPatient # \u0000*/";

		public static String EP_getAllViste =
			"/*EP \u0000 0 1 1 7 # 1 0 0 1 r0 10 7 1 37 38 39 40 41 42 43 44 45 46 # \u0000 10 1 1 IdGlobal 1 2 IdPRATICIEN 2 3 DateVI 0 4 Poid 0 5 Taille 0 6 IMC 0 7 Glyc 0 8 TA 0 9 Insuline 0 10 IdPatient # \u0000*/";

		public static String EP_getANTECEDENTMED =
			"/*EP \u0000 0 1 1 6 # 1 0 0 1 r0 7 6 1 30 31 32 33 34 35 36 # \u0000 7 1 1 IdGlobal 2 2 DateFirstCon 2 3 DateInsuline 0 4 ConsoAlc 0 5 ConsoTab 0 6 AccidentVS 0 7 IdPatient # \u0000*/";

		public static String EP_PRINTMyParameter =
			"/*EP \u0000 0 1 1 3 # 1 0 0 1 r0 4 3 1 11 12 13 14 # \u0000 4 1 1 IdGlobal 0 2 MytCellIp 1 3 MytCellPort 0 4 IdPatient # \u0000*/";

		public static String EP_PRINTAllPRATICIEN =
			"/*EP \u0000 0 1 1 5 # 1 0 0 1 r0 7 5 1 23 24 25 26 27 28 29 # \u0000 7 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste 0 7 IdPatient # \u0000*/";

		public static String EP_PRINTInfoPatient =
			"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 8 4 1 15 16 17 18 19 20 21 22 # \u0000 8 1 1 IdGlobal 0 2 Nom 0 3 Prenom 2 4 DateNaissance 0 5 Sexe 0 6 NiveauIntel 0 7 Profession 0 8 IdPatient # \u0000*/";

		public static String EP_PRINTAllViste =
			"/*EP \u0000 0 1 1 7 # 1 0 0 1 r0 10 7 1 37 38 39 40 41 42 43 44 45 46 # \u0000 10 1 1 IdGlobal 1 2 IdPRATICIEN 2 3 DateVI 0 4 Poid 0 5 Taille 0 6 IMC 0 7 Glyc 0 8 TA 0 9 Insuline 0 10 IdPatient # \u0000*/";

		public static String EP_PRINTANTECEDENTMED =
			"/*EP \u0000 0 1 1 6 # 1 0 0 1 r0 7 6 1 30 31 32 33 34 35 36 # \u0000 7 1 1 IdGlobal 2 2 DateFirstCon 2 3 DateInsuline 0 4 ConsoAlc 0 5 ConsoTab 0 6 AccidentVS 0 7 IdPatient # \u0000*/";

		public static String EP_GetIdPatient =
			"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 8 4 1 15 16 17 18 19 20 21 22 # \u0000 8 1 1 IdGlobal 0 2 Nom 0 3 Prenom 2 4 DateNaissance 0 5 Sexe 0 6 NiveauIntel 0 7 Profession 0 8 IdPatient # \u0000*/";

		public static String EP_GetIdParameter =
			"/*EP \u0001 2 1 1 -1 1 ?1 # 1 0 0 1 r1 3 3 1 12 13 14 # \u0000 4 1 0 IdGlobal 0 2 MytCellIp 1 3 MytCellPort 0 4 IdPatient # \u0000*/";
}
