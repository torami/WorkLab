package dao.external.server;

public class TCell_QEP_IDs {
	/**
	 * author TORKHANI Rami
	 * EP_QEP class must exist in every application. It allows to interact
	 * hard coded QEPs inside SGBD. Application QEP start id should be greater
	 * than the value of last element of this class.
	 */
	public static class EP_QEP // 1
	{
		public static final int EP_QEP_INSERT = 0;
	}

	/* Application QEP ids */
	public static class QEP // 2
	{
		public static final int EP_insertMyParameter  = EP_QEP.EP_QEP_INSERT + 1;
		public static final int EP_insertPRATICIEN  = EP_insertMyParameter  + 1;
		public static final int EP_insertPatient = EP_insertPRATICIEN  + 1;
		public static final int EP_insertVisite = EP_insertPatient + 1;
		public static final int EP_insertANTECEDENTMED  = EP_insertVisite + 1;
		
		public static final int EP_getMyParameter = EP_insertANTECEDENTMED + 1;
		public static final int EP_getAllPRATICIEN= EP_getMyParameter + 1;
		public static final int EP_getLoginInfo = EP_getAllPRATICIEN + 1;
		public static final int EP_getLoginNom= EP_getLoginInfo + 1;
		public static final int EP_getLoginPass= EP_getLoginNom + 1;
		public static final int EP_getInfoPatient= EP_getLoginPass + 1;
		public static final int EP_getAllViste  = EP_getInfoPatient  + 1;
		public static final int EP_getANTECEDENTMED   = EP_getAllViste + 1;
		
		public static final int EP_PRINTMyParameter  = EP_getANTECEDENTMED   + 1;
		public static final int EP_PRINTAllPRATICIEN = EP_PRINTMyParameter  + 1;
		public static final int EP_PRINTInfoPatient = EP_PRINTAllPRATICIEN + 1;
		public static final int EP_PRINTAllViste  = EP_PRINTInfoPatient + 1;
		public static final int EP_PRINTANTECEDENTMED  = EP_PRINTAllViste + 1;
		public static final int EP_GetIdPatient = EP_PRINTANTECEDENTMED + 1;
		public static final int EP_GetIdParameter = EP_GetIdPatient + 1;
		
		
	}
}
