package bedhot.beans;

public class ProviderBean {
	private int id;
	private int userid;
	private String adminFullName;
	private String email;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminFullName() {
		return adminFullName;
	}
	public void setAdminFullName(String adminFullName) {
		this.adminFullName = adminFullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
