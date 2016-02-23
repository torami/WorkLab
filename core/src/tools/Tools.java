package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.nio.BufferUnderflowException;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.bouncycastle.util.encoders.Base64;


/**
 * Tools provides static utility methods. 
 */

public class Tools 
{



		
	/**
	 * Print a message based on the received status
	 * @param status the received status
	 */
	public static void interpretStatus( int status )
	{
		switch ( status )
		{
			case Constants.OK: case Constants.SQL_OK:
				System.out.println("File correctly received by the TCell");
				break;
			case Constants.SQL_NOT_UNIQUE:
				System.err.println("WARNING : the file is already in the database");
				break;
			case Constants.SQL_KO: case Constants.KO:    
				System.err.println("ERROR : the database server has failed");
				break;
			default:
				System.err.println("Error");
				break;
		}
	}


	/**
	 * Detects and returns the IP of my PC.
	 * 
	 * @return IP
	 */
	public String getMyIPAddress () 
	{
		String IP = "";
		try {
			InetAddress thisIp = InetAddress.getLocalHost();
			IP = thisIp.getHostAddress();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return IP;
	}

}
