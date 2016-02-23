package org.inria.dmsp;
public class QEP {
public static final String META =
	"TAB_DESC,6\n"+
	"0	QEP	512\n"+
	"1	LogDeleted	12\n"+
	"2	UpdateLog	512\n"+
	"3	MEDECIN	55\n"+
	"4	PATIENT	36\n"+
	"5	VISITE	73\n"+
	"COL_DESC,27\n"+
	"0	0	IdGlobal	4	1	0\n"+
	"1	0	QEPStr	460	0	4\n"+
	"2	0	SQLStr	24	9	464\n"+
	"3	0	ExplainStr	24	9	488\n"+
	"4	1	TabId	4	1	0\n"+
	"5	1	TuplePos	4	1	4\n"+
	"6	1	Flag	4	1	8\n"+
	"7	2	TabId	4	1	0\n"+
	"8	2	TuplePos	4	1	4\n"+
	"9	2	TupleSize	4	1	8\n"+
	"10	2	CompleteTup	500	0	12\n"+
	"11	3	IdGlobal	4	1	0\n"+
	"12	3	NomPROF	17	0	4\n"+
	"13	3	GRADE	17	0	21\n"+
	"14	3	SERVICE	17	0	38\n"+
	"15	4	IdGlobal	4	1	0\n"+
	"16	4	FULLNAME	17	0	4\n"+
	"17	4	AGE	4	1	21\n"+
	"18	4	SEX	3	0	25\n"+
	"19	4	TAILLE	8	0	28\n"+
	"20	5	IdGlobal	4	1	0\n"+
	"21	5	IdPatient	4	1	4\n"+
	"22	5	IdMedecin	4	1	8\n"+
	"23	5	IMC	17	0	12\n"+
	"24	5	TDT	17	0	29\n"+
	"25	5	POID	17	0	46\n"+
	"26	5	DateVI	10	0	63\n"+
	"FK_DESC,2\n"+
	"5	21	4	15\n"+
	"5	22	3	11\n"+
	"SKT_DESC,1\n"+
	"0	5	VISITE	8\n"+
	"SKT_COL_DESC,2\n"+
	"0	0	3	11	1\n"+
	"0	4	4	15	1\n"+
	"CI_DESC,4\n"+
	"0	0	0	0	1\n"+
	"1	3	3	11	1\n"+
	"2	4	4	15	1\n"+
	"3	5	5	20	1\n"+
	"";

public static String EP_insertMedecin =
	"/*EP \u0004 6 1 1 -1 1 ?1 # 5 0 0 1 4 3 1 11 r0 12 ?2 13 ?3 14 ?4 # \u0000*/";

public static String EP_insertPatient =
	"/*EP \u0005 6 1 1 -1 2 ?1 # 5 0 0 1 5 4 1 15 r0 16 ?2 17 ?3 18 ?4 19 ?5 # \u0000*/";

public static String EP_insertVisite =
	"/*EP \u0007 2 4 4 -1 1 ?3 # 2 5 5 -1 2 ?2 # 7 3 3 4 5 # 6 2 2 3 3 ?1 # 5 1 1 2 2 0 0 0 r1 1 r3 # 5 0 0 1 7 5 1 20 r4 21 ?2 22 ?3 23 ?4 24 ?5 25 ?6 26 ?7 # \u0000*/";

public static String EP_getAllMedecin =
	"/*EP \u0000 0 1 1 3 # 1 0 0 1 r0 4 3 1 11 12 13 14 # \u0000 4 1 1 IdGlobal 0 2 NomPROF 0 3 GRADE 0 4 SERVICE # \u0000*/";

public static String EP_getAllPatient =
	"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 5 4 1 15 16 17 18 19 # \u0000 5 1 1 IdGlobal 0 2 FULLNAME 1 3 AGE 0 4 SEX 0 5 TAILLE # \u0000*/";

public static String EP_getAllViste =
	"/*EP \u0000 0 1 1 5 # 1 0 0 1 r0 7 5 1 20 21 22 23 24 25 26 # \u0000 7 1 1 IdGlobal 1 2 IdPatient 1 3 IdMedecin 0 4 IMC 0 5 TDT 0 6 POID 0 7 DateVI # \u0000*/";

public static String EP_PrintAllPatient =
	"/*EP \u0000 0 1 1 4 # 1 0 0 1 r0 5 4 1 15 16 17 18 19 # \u0000 5 1 1 IdGlobal 0 2 FULLNAME 1 3 AGE 0 4 SEX 0 5 TAILLE # \u0000*/";

public static String EP_PrintAllMedecin =
	"/*EP \u0000 0 1 1 3 # 1 0 0 1 r0 4 3 1 11 12 13 14 # \u0000 4 1 1 IdGlobal 0 2 NomPROF 0 3 GRADE 0 4 SERVICE # \u0000*/";

public static String EP_PrintAllViste =
	"/*EP \u0000 0 1 1 5 # 1 0 0 1 r0 7 5 1 20 21 22 23 24 25 26 # \u0000 7 1 1 IdGlobal 1 2 IdPatient 1 3 IdMedecin 0 4 IMC 0 5 TDT 0 6 POID 0 7 DateVI # \u0000*/";

public static String EP_isMedecinExists =
	"/*EP \u0001 0 2 2 3 # 1 1 1 2 r0 4 3 1 11 12 13 14 # 4 0 0 1 12 0 ?1 r2 # \u0000 4 1 1 IdGlobal 0 2 NomPROF 0 3 GRADE 0 4 SERVICE # \u0000*/";

public static String EP_isPatientExists =
	"/*EP \u0001 0 2 2 4 # 1 1 1 2 r0 5 4 1 15 16 17 18 19 # 4 0 0 1 16 0 ?1 r2 # \u0000 5 1 1 IdGlobal 0 2 FULLNAME 1 3 AGE 0 4 SEX 0 5 TAILLE # \u0000*/";

public static String EP_findVisitByDate =
	"/*EP \u0001 0 2 2 5 # 1 1 1 2 r0 7 5 1 20 21 22 23 24 25 26 # 4 0 0 1 26 0 ?1 r7 # \u0000 7 1 1 IdGlobal 1 2 IdPatient 1 3 IdMedecin 0 4 IMC 0 5 TDT 0 6 POID 0 7 DateVI # \u0000*/";

}


