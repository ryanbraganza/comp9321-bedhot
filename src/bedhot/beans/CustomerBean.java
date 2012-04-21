package bedhot.beans;

public class CustomerBean {
	private int id;
	private String email;
	private int userID;
	private String cctype;
	private int ccnumber;
	private String ccmonthexpiry;
	private String ccyearexpiry;
	
	public String getCcmonthexpiry() {
		return ccmonthexpiry;
	}
	public void setCcmonthexpiry(String string) {
		this.ccmonthexpiry = string;
	}
	public String getCcyearexpiry() {
		return ccyearexpiry;
	}
	public void setCcyearexpiry(String ccyearexpiry) {
		this.ccyearexpiry = ccyearexpiry;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getCctype() {
		return cctype;
	}
	public void setCctype(String cctype) {
		this.cctype = cctype;
	}
	public int getCcnumber() {
		return ccnumber;
	}
	public void setCcnumber(int ccnumber) {
		this.ccnumber = ccnumber;
	}
	public int getCcsecuritynumber() {
		return ccsecuritynumber;
	}
	public void setCcsecuritynumber(int ccsecuritynumber) {
		this.ccsecuritynumber = ccsecuritynumber;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	private int ccsecuritynumber;
	private String ccname;

}
