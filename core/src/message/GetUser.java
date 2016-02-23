package message;
import java.net.Socket;
import command.Command;
import command.GetUserCommand;
import tools.Constants;
import tools.IOStreams;
import beansAfrica.MyParameter;

public class GetUser {

	public static MyParameter getUser(int userGID, MyParameter myInfo) {
		/**
		 * getUser
		 * @param userGID
		 * @param myInfo
		 */

		MyParameter user = null;
		try {
			/* socket connection to my TCELL */
			Socket socket = new Socket(myInfo.getMyTcellIp(), myInfo.getMyTcellPort());
			IOStreams stream = new IOStreams(socket);

			/* get the user from the TCELL */
			Command getUserCommand = new GetUserCommand(Constants.CMD_GET_USER,userGID);
			stream.getOutputStream().writeObject(getUserCommand);
			user = (MyParameter) stream.getInputStream().readObject();

			stream.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}