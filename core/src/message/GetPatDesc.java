package message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import tools.Constants;
import tools.IOStreams;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;
import command.GetAllPatDescCommand;
import command.Share_Pat_Desc_Command;

/**
 * GetFileDesc provides the method to ask for the list of all the files' descriptions stored on a TC. 
 * A file description consists of a fileGID, type and description.
 * 
 * @author ABDOU
 */
public class GetPatDesc 
{

	/**
	 * Get the files' descriptions
	 * @return the list of the files' description, as a String
	 */
	
	public static PatDesc getPatDesc(MyParameter user) {
		

		String TCellIP = user.getMyTcellIp();
		int TcellPort = user.getMyTcellPort();
		PatDesc listFilesDesc =null;
		try {
			Socket socket = new Socket(TCellIP, TcellPort);
			/* Creation of the stream */
			IOStreams stream = new IOStreams(socket);

			/* Send the command */

			GetAllPatDescCommand getPatDescCmd = new GetAllPatDescCommand(Constants.CMD_GET_Pat_DESC);
			stream.getOutputStream().writeObject(getPatDescCmd);
		
			int status = stream.getInputStream().readInt();

			if (status == Constants.OK) {
				listFilesDesc = (PatDesc) stream.getInputStream().readObject();
				System.out.println("Here is the description of the "+ listFilesDesc+ " Patient stored in TCell : ");
				System.out.println("FileGID : " + listFilesDesc.GID + " Nom : " + listFilesDesc.nom + " Prénom : " + listFilesDesc.prenom);
			
				
			
			} else {
				System.err.println("No Patient found");
			}

		} catch (Exception ex) {
			System.err.println("An error occured");
		}

		return listFilesDesc;
	}	
	
	
	
	



}