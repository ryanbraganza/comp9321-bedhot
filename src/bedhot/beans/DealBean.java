package bedhot.beans;

import java.sql.Date;

public class DealBean {
	private int ID;
	private String hotelName;
	private Date start;
	private Date end;
	private String info;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

}
