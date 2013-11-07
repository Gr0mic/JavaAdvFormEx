package be.mms.ex03;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class CalendarApp {

	private static final String FILE_NAME = "c:\\test\\appointments.dat";
	
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		List<Appointment> appointments = new LinkedList<Appointment>();
		appointments.add(
			new Appointment(
					"Java adv Part1", 
					TimeUtils.parseDate("2013/11/05"), 
					TimeUtils.parseTime("09:00")
					)
				);
		appointments.add(
				new Appointment(
						"Java adv Part2", 
						TimeUtils.parseDate("2013/11/06"), 
						TimeUtils.parseTime("8:45")
						)
				);
		appointments.add(
				new Appointment(
						"Java adv Part3", 
						TimeUtils.parseDate("2013/11/07"), 
						TimeUtils.parseTime("8:52")
						)
				);
		
		saveAppointments(appointments);
		loadAppointments();
		
	}

	private static void loadAppointments() {
		FileInputStream file = null;
		ObjectInputStream in = null;
		try {
			
			file = new FileInputStream(FILE_NAME);
			in = new ObjectInputStream(file);
			
			try {
				@SuppressWarnings("unchecked")
				List<Appointment> appointments = (List<Appointment>) in.readObject();
				for (Appointment a : appointments) {
					System.out.format("%s %s %s\n", a.getDescription(),TimeUtils.formatDate(a.getDate()), TimeUtils.formatTime(a.getTime())  );
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeQuietly(file,in);
		}
	}

	private static void saveAppointments(List<Appointment> appointments) {
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		try {
			file = new FileOutputStream(FILE_NAME);
			out = new ObjectOutputStream(file);
		
			out.writeObject(appointments);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeQuietly(file,out);
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
