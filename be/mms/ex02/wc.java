package be.mms.ex02;

import java.io.*;

public class wc {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("USAGE: wc file");
			System.exit(1);
		}
		
		Reader reader = null;
		try {
			reader = new FileReader(args[0]);
			
			int nl = 0, nw = 0, nc = 0;
			int data;
			boolean inWord = false;
			
			while ((data = reader.read()) != -1) {
				char c = (char) data;
				
				nc++;
				if (c == '\n') nl++;
				
				if (Character.isWhitespace(c)) {
					inWord = false;
				} else if (!inWord) {
					nw++;
					inWord = true;
				}
			}
			
			System.out.format("%d %d %d %s\n", nl, nw, nc, args[0]);
		} catch (FileNotFoundException nfe) {
			System.err.println("ERROR: unable to open \"" + args[0] + "\" file");
		} catch (Exception e) {
			System.err.println(e.getMessage());			
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					System.err.println(ioe.getMessage());
				}
			}
		}
	}	
}
