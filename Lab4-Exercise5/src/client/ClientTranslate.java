package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTranslate {
	public static void sendText(String msg, String choice) 
			throws UnknownHostException, IOException {
	      FileInputStream fileIn = null;

		Socket socket = new Socket(InetAddress.getLocalHost(), 4220);
		
		OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(msg);
        
        Socket socket1 = new Socket(InetAddress.getLocalHost(), 4221);
       
		OutputStream outputStream1 = socket1.getOutputStream();
        DataOutputStream dataOutputStream1 = new DataOutputStream
        		(outputStream1);
        dataOutputStream1.writeUTF(choice);
        
        

        
        BufferedReader bufferedReader = new BufferedReader
        		(new InputStreamReader(socket.getInputStream()));
        String result = bufferedReader.readLine();
        ClientFrame.updateResult(result);
	}
}