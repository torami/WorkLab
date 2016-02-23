package daemon;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import beansAfrica.MyParameter;
import configuration.Configuration;
import dao.Patient.TcellDAOToken;

/**
 * Daemon in TrustedCell.
 * 
 * @author TORKHANI Rami
 */
public class TCellDaemon{


	public static void main(String[] args) throws IOException {
		
		//V�rifi� si un fichier de configuration est d�fini
		if (System.getProperty("configurationFilePath") == null) {
			System.out.println("'configurationFilePath' system property is not defined");
			return;
		}
		
		System.getProperties().setProperty("jdbc.port", Configuration.getConfiguration().getProperty("dbPort"));
		
		MyParameter myInfo  = TcellDAOToken.getInstance(false).getMyParameter();
		
		int userGID = myInfo.getMyGid();
		int listenPort = myInfo.getMyTcellPort();
		ServerSocket server = null;
		try {

			/* Creation of the server socket */
			server = new ServerSocket(listenPort);

			/* The server listens for new connections and accepts it */
			System.out.println("TCell Daemon started...");

			while (true) {
				System.out.println("\nWaiting for a connection from an APP or from other TCells");
				Socket clientSocket = server.accept();
				System.out.println("Accepted connection : " + clientSocket);

				/* For each socket, a new thread is created */
				ClientConnectionManager ccm = new ClientConnectionManager(clientSocket, userGID);
				ccm.start();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			server.close();
		}
	}
}