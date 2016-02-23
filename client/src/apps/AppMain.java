package apps;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;

import api.ClientAPI;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;
import tools.Constants;
import configuration.Configuration;


public class AppMain 
{
	/**
	 * APP Main
	 * 
	 * @author TORKHANI RAMI
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		int userGID = Integer.parseInt(Configuration.getConfiguration().getProperty("myGID"));
		String tCellIP = Configuration.getConfiguration().getProperty("myIP");
		int port = Integer.parseInt(Configuration.getConfiguration().getProperty("myPort"));

		MyParameter user= null;

		// load user PubKey
		try {
		
			user = new MyParameter(userGID, tCellIP, port);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TEST GETFILEDESC
//				PatDesc file_list = ClientAPI.getPatDesc(user);
//				if(file_list != null) {
//					System.out.println("Patient list : "+ file_list.getIdPatient());
//					
//					}
			//TESTSHARE				
			ClientAPI.shareFile(11, user);
				
		System.out.println("Dooooone");
	}
}