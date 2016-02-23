package api;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import message.GetPatDesc;
import message.SharePatDesc;
import beansAfrica.MyParameter;
import beansAfrica.PatDesc;





/**
 * USER API
 * 
 */
public class ClientAPI
{




	public static PatDesc getPatDesc(MyParameter user) {
		return GetPatDesc.getPatDesc(user);
	}
	public static void shareFile( int userGID, MyParameter myInfo) throws UnknownHostException, IOException {
		SharePatDesc.sharePat( userGID, myInfo);
	}

}
