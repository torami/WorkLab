/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon;


import java.net.Socket;

import tools.Constants;
import tools.IOStreams;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;
import command.Command;
import command.Share_Pat_Desc_Command;
import command.GetAllPatDescCommand;
import command.GetUserCommand;
import configuration.Configuration;
import dao.Patient.TcellDAOToken;



/**
 * ThreadServer in TCell. It receives commands from clients and executes the
 * associated actions.
 *
 * @author  TORKHANI Rami
 *
 */
public class ClientConnectionManager extends Thread {
	Socket socket;
	int userGID;

	public ClientConnectionManager(Socket s, int userGID) {
		/**
		 * Creates a ThreadServer instance
		 * @param socket the client socket
		 * @param userGID the userGID of the TC
		 */
		this.socket = s;
		this.userGID = userGID;
	}

	@Override
	public void run() {
		try {
			IOStreams ioStreams = new IOStreams(socket);
			Command cmd = readCommand(ioStreams);
			
			switch (cmd.getNumCommand()) {
		

			case Constants.CMD_GET_Pat_DESC: 
				sendPatDesc(ioStreams);
//				insertReceivedMetaData((((Share_Pat_Desc_Command) cmd)).getPat());
				break;
		
			 case Constants.CMD_GET_USER:
				 sendUser(((GetUserCommand) cmd).getUserGID(),ioStreams);
				 
			 break;
			
			 case Constants.CMD_GET_FILE_TO_SHARE:
					
					// Insert received metaData
					insertReceivedMetaData((((Share_Pat_Desc_Command) cmd)).getPat());
	 
					//Send status
					ioStreams.getOutputStream().writeInt(Constants.OK);
					TcellDAOToken.getInstance(false).printAllPatient();
				 break;
			default:
				System.out.println("unknown command");
				break;
			}
			
			ioStreams.close();
			socket.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	private void insertReceivedMetaData(PatDesc patDesc) {
		/**
		 * insertReceivedMetaData inserting the file described in the database
		 * @param fileDesc
		 */
		TcellDAOToken.getInstance(false).insertPatient(patDesc.getGID(),patDesc.getNom(),patDesc.getPrenom(),patDesc.getNaissance(),patDesc.getSexe(),patDesc.getNiveauIntel(),patDesc.getProfession(),patDesc.getIdPatient());

		try {
			TcellDAOToken.getInstance(false).Save_DBMS_on_disk();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void sendUser(int userGID, IOStreams ioStreams) {
		/**
		 * sendUser is able to send the requested User  
		 * @param userGID
		 * 			 	Requested user
		 * @param ioStreams
		 */
		try {
			MyParameter user = TcellDAOToken.getInstance(false).getUserById(userGID);
			ioStreams.getOutputStream().writeObject(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void sendPatDesc(IOStreams ioStreams) {
		/**
	     * Sends files' description to a client through a stream.
	     * @param stream an IOStreams object
	     */

		try {
			PatDesc listDesc =  TcellDAOToken.getInstance(false).getPatient();

			if (listDesc == null) {
				System.err.println("None Patient description in the database");
				ioStreams.getOutputStream().writeInt(Constants.KO);
			} else {
				ioStreams.getOutputStream().writeInt(Constants.OK);
				/* Send the list */
				ioStreams.getOutputStream().writeObject(listDesc);
				System.out.println("Patient descriptions sent");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Command readCommand(IOStreams stream) {
		 /**
		   * readCommand Receives Command.
		   * @param ioStreams
		   * 				 an IOStreams object
		   */
		Command cmd = null;
		try {
			cmd = (Command) stream.getInputStream().readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
	}


	


	

}
