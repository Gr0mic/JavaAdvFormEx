package be.mms.ex08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection extends Thread {

	public ServerConnection(Socket connection) {
		this.connection = connection;
	}

	private Socket connection;
		
	public void run() {
		BufferedReader stdIn = null;
		try {
			stdIn = new BufferedReader(
					new InputStreamReader( connection.getInputStream() )
					);
			PrintWriter socketWriter = new PrintWriter(connection.getOutputStream(), true);
			
			while(!socketWriter.checkError()){
				Thread.sleep(100);
				String s = null;
				while (null != (s = stdIn.readLine())) {
					System.out.println(s);
				}
			}
			
		} catch (IOException e) {
			System.out.println("Client Error : " + e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (stdIn != null)
				try {
					stdIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		System.out.println("Client OFF");
	}

}
