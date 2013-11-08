package be.mms.ex08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client  {
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		PrintWriter socketWriter = null;
		
		try {
			socket = new Socket("localhost", 9000);
			socketWriter = new PrintWriter(socket.getOutputStream());
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));
			
			String userInput;
			while ((userInput = stdIn.readLine()) != null) { 
				socketWriter.println(userInput);
				socketWriter.flush();
			}
		} catch (Exception e) {
			System.err.println("Client failed : " + e.getMessage());
		} finally {
			if (socketWriter != null) socketWriter.close();
			if (socket != null) socket.close();
		}
	}
}
