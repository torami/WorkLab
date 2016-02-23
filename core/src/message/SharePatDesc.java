package message;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.Socket;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;

import tools.Constants;
import tools.IOStreams;
import tools.Tools;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;
import command.Command;
import command.Share_Pat_Desc_Command;

/**
 * ShareFile is the class used to send a share command with others TCs. It provides the
 * methods to retrieve a file description inside the database, create the share
 * message, and send it with the file to the TCs.
 * 
 * @author TORKHANI Rami
 */
public class SharePatDesc{

	public static void sharePat(int userGID, MyParameter myInfo){

		/**
		 * Establishes the connection with the TCs and send the file with the share
		 * message.
		 * 
		 * @param pat
		 *            the file's path to share.
		 * @param userGID
		 *           userGID to whom we share the file. Those users need
		 *            to be in the User table.
		 * @param myInfo 
		 * 			My information used to create the connection          
		 */

		try {
			//MyParameter user = GetUser.getUser(userGID, myInfo);

			/* get the file from the TCELL */
			PatDesc PatientDescriptionToShare = GetPatDesc.getPatDesc(myInfo);
			
			/*SHARE FILE */
			/* socket connection to the recipient TCELL */
			Socket socket = new Socket("127.0.0.1",8811);
			/* Creation of the stream */
			IOStreams stream = new IOStreams(socket);

			/* send the share command to the recipient TCELL */
			Command sharePatDescCommand = new Share_Pat_Desc_Command(Constants.CMD_GET_FILE_TO_SHARE, PatientDescriptionToShare);
			stream.getOutputStream().writeObject(sharePatDescCommand);
			int status = stream.getInputStream().readInt();
			Tools.interpretStatus( status );

			stream.close();
			socket.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("recipient TCell is not connected! The file can not be sent!");
		}

	}
}