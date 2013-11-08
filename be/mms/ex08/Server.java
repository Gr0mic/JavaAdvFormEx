package be.mms.ex08;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket listener = null;
		
		try {
			listener = new ServerSocket(9000);
			
			while (true) {
				Socket clientConnection = listener.accept();
				
				ServerConnection sc = new ServerConnection(clientConnection);
				sc.start();
			}
		} catch (Exception e) {
			System.err.println("Server failed : " + e.getMessage());
		} finally {
			if (listener != null) listener.close();
		}
	}

}
