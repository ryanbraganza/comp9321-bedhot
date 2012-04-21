package bedhot.beans;
import java.util.List;

public class CartBean {
	private List<DealBean> deals;
	public CartBean (List<DealBean> deals) {
		this.deals = deals;
	}
	public List<DealBean> deals(){
		return deals;
	}
	
}
