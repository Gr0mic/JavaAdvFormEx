package be.ttic.ex01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("USAGE : FileCopy file1 file2");
			System.exit(1);
		}
		
		copyFile(args[0], args[1]);
	}
	
	private static void zipFile(String src, String dst) {
		InputStream in = null;
		BufferedInputStream bin = null;
		
		OutputStream out = null;
		BufferedOutputStream bout = null;
		GZIPOutputStream gout = null;

		try {
			in = new FileInputStream(src);
			bin = new BufferedInputStream(in);
			
			out = new FileOutputStream(dst);
			gout = new GZIPOutputStream(out);
			bout = new BufferedOutputStream(gout);
			
			int data;
			while ((data = bin.read()) != -1) {
				bout.write(data);
			}
		} catch (FileNotFoundException nfe) {
			System.err.println("Src file cannot be found");
		} catch (IOException ioe) {
			System.err.print("Unable to copy file : " +  ioe.getMessage());
		} finally {
			closeQuietly(in);
			closeQuietly(bin);
			closeQuietly(gout);
			closeQuietly(out);
			closeQuietly(bout);
		}
	}

	private static void copyFile(String src, String dst) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (FileNotFoundException nfe) {
			System.err.println("Src file cannot be found");
		} catch (IOException ioe) {
			System.err.print("Unable to copy file : " +  ioe.getMessage());
		} finally {
			closeQuietly(in);
			closeQuietly(out);
		}
	}
	
	private static void closeQuietly(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException ex) {
				System.err.println("Unable to close file : " + ex.getMessage());
			}
		}		
	}
	
}
