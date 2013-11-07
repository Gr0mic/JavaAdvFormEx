package be.mms.ex03;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable{

	private static final long serialVersionUID = 1;
	public String description;
	public Date date;
	public Date time;
	
	
	public Appointment(String description, Date date, Date time) {
		super();
		this.description = description;
		this.date = date;
		this.time = time;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
