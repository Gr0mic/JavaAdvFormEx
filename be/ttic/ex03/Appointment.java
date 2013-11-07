package be.ttic.ex03;

import java.io.Serializable;
import java.util.Date;

public class Appointment  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private Date date;
	private Date time;

	public Appointment() {
	}

	public Appointment(String description, Date date, Date time) {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Rendez-vous : ");
		sb.append("'").append(description).append("'");
		sb.append(", le ").append(TimeUtils.formatDate(date));
		sb.append(", à ").append(TimeUtils.formatTime(time));

		return sb.toString();
	}
	
}
