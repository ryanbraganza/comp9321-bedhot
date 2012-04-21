package bedhot.beans;

public class CriteriaBean {
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return desc;
	}
}
