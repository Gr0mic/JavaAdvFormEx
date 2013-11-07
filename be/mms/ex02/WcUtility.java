package be.mms.ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WcUtility {

	/**
	 * @param arg
	 */
	public static void main(String[] arg) {
		// TODO Auto-generated method stub
		if (arg.length != 1) {
			System.out.println("USAGE:: WcUtility <fileName>");
			return;
		}
		String src = arg[0];
		BufferedReader in = null;

		try {	
			in = new BufferedReader(new FileReader(src));
	        int s, oldS = -1;
	        int nbrWord = 0, nbrChar = 0, nbrLine=0;
	        while ((s = in.read()) != -1) {
	            nbrChar++;
	            
	            if (s == '\n') nbrLine++;
	            
	            if (!Character.isWhitespace(s) & (Character.isWhitespace(oldS) | oldS == -1) ) nbrWord++;
	            oldS = s;
	        }
	        System.out.format("FILE: %s> nbrChar:%d nbrWord:%d nbrLine:%d", src,nbrChar,nbrWord,nbrLine );
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
