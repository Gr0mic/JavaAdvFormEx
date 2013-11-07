package be.ttic.ex02;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CountReaderTest {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("USAGE: wc file");
			System.exit(1);
		}
		
		Reader fileReader = null;
		CountReader countReader = null;
		try {
			fileReader = new FileReader(args[0]);
			countReader = new CountReader(fileReader);
			
			char[] buffer = new char[1024];
			while (countReader.read(buffer) > 0);		
			
			System.out.format("%d %d %d %s\n", 
								countReader.getLines(), countReader.getWords(), countReader.getChars(), 
								args[0]);
		} catch (FileNotFoundException nfe) {
			System.err.println("ERROR: unable to open \"" + args[0] + "\" file");
		} catch (Exception e) {
			System.err.println(e.getMessage());			
		} finally {
			closeQuietly(fileReader, countReader);
		}		
	}
	
	private static void closeQuietly(Closeable... closeables) {
		if (closeables.length > 0) {
			for (Closeable c : closeables) {
				try {
					c.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
	
}
