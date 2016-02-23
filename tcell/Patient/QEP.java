package dao.Patient;

/**
 * author TORKHANI Rami
 * The execution plans of queries should be declaring this class
 */

public class QEP {
	public static String EP_insertMyParameter =
			"/*EP \u0003 6 1 1 -1 1 ?1 # 5 0 0 1 3 3 1 11 r0 12 ?2 13 ?3 # \u0000*/";

		public static String EP_insertPRATICIEN =
			"/*EP \u0006 6 1 1 -1 3 ?1 # 5 0 0 1 6 5 1 22 r0 23 ?2 24 ?3 25 ?4 26 ?5 27 ?6 # \u0000*/";

		public static String EP_insertPatient =
			"/*EP \u0008 6 1 1 -1 2 ?1 # 5 0 0 1 8 4 1 14 r0 15 ?2 16 ?3 17 ?4 18 ?5 19 ?6 20 ?7 21 ?8 # \u0000*/";

		public static String EP_insertVisite =
			"/*EP \u0009 2 3 3 -1 3 ?2 # 6 2 2 3 5 ?1 # 5 1 1 2 1 0 0 0 r1 # 5 0 0 1 9 7 1 34 r2 35 ?2 36 ?3 37 ?4 38 ?5 39 ?6 40 ?7 41 ?8 42 ?9 # \u0000*/";

		public static String EP_insertANTECEDENTMED =
			"/*EP \u0006 6 1 1 -1 4 ?1 # 5 0 0 1 6 6 1 28 r0 29 ?2 30 ?3 31 ?4 32 ?5 33 ?6 # \u0000*/";

		public static String EP_getMyParameter =
			"/*EP \u0000 0 1 1 3 # 1 0 0 1 r0 3 3 1 11 12 13 # \u0000 3 1 1 IdGlobal 0 2 MytCellIp 1 3 MytCellPort # \u0000*/";

		public static String EP_getAllPRATICIEN =
			"/*EP \u0000 0 1 1 5 # 1 0 0 1 r0 6 5 1 22 23 24 25 26 27 # \u0000 6 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste # \u0000*/";

		public static String EP_getLoginNom =
			"/*EP \u0001 0 2 2 5 # 1 1 1 2 r0 6 5 1 22 23 24 25 26 27 # 4 0 0 1 23 0 ?1 r2 # \u0000 6 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste # \u0000*/";

		public static String EP_getLoginPass =
			"/*EP \u0001 0 2 2 5 # 1 1 1 2 r0 6 5 1 22 23 24 25 26 27 # 4 0 0 1 25 0 ?1 r4 # \u0000 6 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Password 0 5 Grade 0 6 Poste # \u0000*/";

		public static String EP_getInfoPatient =
			"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 8 4 1 14 15 16 17 18 19 20 21 # \u0000 8 1 1 IdGlobal 0 2 Nom 0 3 Prenom 2 4 DateNaissance 0 5 Sexe 0 6 NiveauIntel 0 7 Profession 0 8 IdPatient # \u0000*/";

		public static String EP_getAllViste =
			"/*EP \u0000 0 1 1 7 # 1 0 0 1 r0 9 7 1 34 35 36 37 38 39 40 41 42 # \u0000 9 1 1 IdGlobal 1 2 IdPRATICIEN 2 3 DateVI 0 4 Poid 0 5 Taille 0 6 IMC 0 7 Glyc 0 8 TA 0 9 Insuline # \u0000*/";

		public static String EP_getANTECEDENTMED =
			"/*EP \u0000 0 1 1 6 # 1 0 0 1 r0 6 6 1 28 29 30 31 32 33 # \u0000 6 1 1 IdGlobal 2 2 DateFirstCon 2 3 DateInsuline 0 4 ConsoAlc 0 5 ConsoTab 0 6 AccidentVS # \u0000*/";

		public static String EP_PRINTMyParameter =
			"/*EP \u0000 0 1 1 3 # 1 0 0 1 r0 3 3 1 11 12 13 # \u0000 3 1 1 IdGlobal 0 2 MytCellIp 1 3 MytCellPort # \u0000*/";

		public static String EP_PRINTAllPRATICIEN =
			"/*EP \u0000 0 1 1 5 # 1 0 0 1 r0 5 5 1 22 23 24 26 27 # \u0000 5 1 1 IdGlobal 0 2 Nom 0 3 Prenom 0 4 Grade 0 5 Poste # \u0000*/";

		public static String EP_PRINTInfoPatient =
			"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 7 4 1 14 15 16 17 18 19 20 # \u0000 7 1 1 IdGlobal 0 2 Nom 0 3 Prenom 2 4 DateNaissance 0 5 Sexe 0 6 NiveauIntel 0 7 Profession # \u0000*/";

		public static String EP_PRINTAllViste =
			"/*EP \u0000 0 1 1 7 # 1 0 0 1 r0 9 7 1 34 35 36 37 38 39 40 41 42 # \u0000 9 1 1 IdGlobal 1 2 IdPRATICIEN 2 3 DateVI 0 4 Poid 0 5 Taille 0 6 IMC 0 7 Glyc 0 8 TA 0 9 Insuline # \u0000*/";

		public static String EP_PRINTANTECEDENTMED =
			"/*EP \u0000 0 1 1 6 # 1 0 0 1 r0 6 6 1 28 29 30 31 32 33 # \u0000 6 1 1 IdGlobal 2 2 DateFirstCon 2 3 DateInsuline 0 4 ConsoAlc 0 5 ConsoTab 0 6 AccidentVS # \u0000*/";

		public static String EP_GetIdPatient =
			"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 1 4 1 21 # \u0000 1 0 1 IdPatient # \u0000*/";
		public static String EP_GetIdParameter =
				"/*EP \u0001 2 1 1 -1 1 ?1 # 1 0 0 1 r1 2 3 1 12 13 # \u0000 3 1 0 IdGlobal 0 2 MytCellIp 1 3 MytCellPort # \u0000*/";
}
