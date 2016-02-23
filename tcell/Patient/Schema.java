package dao.Patient;

/**
 * author TORKHANI RAMI
 * This class contains the schema database
 */
public class Schema {
	public static final String META =
			"TAB_DESC,8\n"+
			"0	QEP	512\n"+
			"1	LogDeleted	12\n"+
			"2	UpdateLog	512\n"+
			"3	MyParameter	25\n"+
			"4	PATIENT	110\n"+
			"5	PRATICIEN	89\n"+
			"6	ANTECEDENTMED	63\n"+
			"7	VISITE	114\n"+
			"COL_DESC,43\n"+
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
			"12	3	MytCellIp	17	0	4\n"+
			"13	3	MytCellPort	4	1	21\n"+
			"14	4	IdGlobal	4	1	0\n"+
			"15	4	Nom	17	0	4\n"+
			"16	4	Prenom	17	0	21\n"+
			"17	4	DateNaissance	4	2	38\n"+
			"18	4	Sexe	17	0	42\n"+
			"19	4	NiveauIntel	17	0	59\n"+
			"20	4	Profession	17	0	76\n"+
			"21	4	IdPatient	17	0	93\n"+
			"22	5	IdGlobal	4	1	0\n"+
			"23	5	Nom	17	0	4\n"+
			"24	5	Prenom	17	0	21\n"+
			"25	5	Password	17	0	38\n"+
			"26	5	Grade	17	0	55\n"+
			"27	5	Poste	17	0	72\n"+
			"28	6	IdGlobal	4	1	0\n"+
			"29	6	DateFirstCon	4	2	4\n"+
			"30	6	DateInsuline	4	2	8\n"+
			"31	6	ConsoAlc	17	0	12\n"+
			"32	6	ConsoTab	17	0	29\n"+
			"33	6	AccidentVS	17	0	46\n"+
			"34	7	IdGlobal	4	1	0\n"+
			"35	7	IdPRATICIEN	4	1	4\n"+
			"36	7	DateVI	4	2	8\n"+
			"37	7	Poid	17	0	12\n"+
			"38	7	Taille	17	0	29\n"+
			"39	7	IMC	17	0	46\n"+
			"40	7	Glyc	17	0	63\n"+
			"41	7	TA	17	0	80\n"+
			"42	7	Insuline	17	0	97\n"+
			"FK_DESC,1\n"+
			"7	35	5	22\n"+
			"SKT_DESC,1\n"+
			"0	7	VISITE	8\n"+
			"SKT_COL_DESC,2\n"+
			"0	0	5	22	1\n"+
			"0	4	4	14	0\n"+
			"CI_DESC,6\n"+
			"0	0	0	0	1\n"+
			"1	3	3	11	1\n"+
			"2	4	4	14	1\n"+
			"3	5	5	22	1\n"+
			"4	6	6	28	1\n"+
			"5	7	7	34	1\n"+
			"";
}
