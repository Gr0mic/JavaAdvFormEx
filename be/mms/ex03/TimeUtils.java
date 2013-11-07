package be.mms.ex03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	private static final DateFormat DATE_FORMATTER = new SimpleDateFormat(
			"yyyy/MM/dd");
	private static final DateFormat TIME_FORMATTER = new SimpleDateFormat(
			"HH:mm");	
	
	public static String formatDate(Date date) {
		return DATE_FORMATTER.format(date);
	}
	
	public static String formatTime(Date time) {
		return TIME_FORMATTER.format(time);
	}
	
	public static Date parseDate(String date) throws ParseException {
		return DATE_FORMATTER.parse(date);
	}
	
	public static Date parseTime(String time) throws ParseException {
		return TIME_FORMATTER.parse(time);
	}
}
