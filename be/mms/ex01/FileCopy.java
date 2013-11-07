package be.mms.ex01;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopy {
	
	public static void main(String[] args) throws FileNotFoundException {

		if (args.length < 2) {
			System.out.println("Il manque des informations");
			return;
		}
		
		String src = args[0];
		String dst = args[1];
		
		// TODO create function copy :: for other usage
		FileInputStream in = null;
		FileOutputStream out = null;
		int len;
		byte[] buf = new byte[1024];
		
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			while (-1 != (len = in.read(buf))) {
			  out.write(buf, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO Create function close :: code repeated
			if (in instanceof FileInputStream) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			if (out instanceof FileOutputStream) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
