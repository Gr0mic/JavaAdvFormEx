package be.ttic.ex03;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
public class CalendarApp {

	private static final String FILE_NAME = "appointments.dat";

	public static void main(String[] args) throws Exception {
		List<Appointment> appointments = new LinkedList<Appointment>();
		appointments.add(new Appointment("Java OO", 
				TimeUtils.parseDate("2013/10/30"),
				TimeUtils.parseTime("08:45")));
		appointments.add(new Appointment("EJB", 
				TimeUtils.parseDate("2013/11/10"),
				TimeUtils.parseTime("08:45")));		
		
		saveAppointments(appointments);
		loadAppointments();
	}
		
	private static void saveAppointments(List<Appointment> appointments) {
		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		
		try {
			fos = new FileOutputStream(FILE_NAME);
			os = new ObjectOutputStream(fos);
			
			for (Appointment appointment : appointments) 
				os.writeObject(appointment);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			closeQuietly(os);
			closeQuietly(fos);
		}
	}	
		
	private static void loadAppointments() {
		FileInputStream fis = null;
		ObjectInputStream is = null;

		try {
			fis = new FileInputStream(FILE_NAME);
			is = new ObjectInputStream(fis);
			
			while (true) {
				System.out.println(is.readObject());
			}
		} catch (EOFException eof) {
			//
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			closeQuietly(fis);
			closeQuietly(is);
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