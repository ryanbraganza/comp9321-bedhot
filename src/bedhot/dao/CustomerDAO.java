package bedhot.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import bedhot.beans.*;

public class CustomerDAO {
	private final DBConnectionFactory connFactory;

	public CustomerDAO(DBConnectionFactory connFactory) {
		this.connFactory = connFactory;
	}

	// checkme
	public CustomerBean getCustomer(int userID) {
		CustomerBean customer = null;
		Connection c = this.connFactory.createConnection();
		try {
			PreparedStatement ps = c
					.prepareStatement("select * from tbl_users join tbl_customers on"
							+ "tbl_users.id = tbl_customers.userId"
							+ "where tbl_users.id=?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new CustomerBean();
				customer.setId(rs.getInt("id"));
				customer.setUserID(rs.getInt("userId"));
				customer.setEmail(rs.getString("email"));
				customer.setCctype(rs.getString("cctype"));
				customer.setCcnumber(rs.getInt("ccnumber"));
				customer.setCcname(rs.getString("ccname"));
			}
		} catch (SQLException e) {

		}
		return customer;
	}

	public CartBean getCart(int userID) {
		List<DealBean> deals = new ArrayList<DealBean>();
		Connection c = connFactory.createConnection();
		try {
			PreparedStatement ps;
			ps = c
					.prepareStatement("select * from tbl_cartitems join tbl_deals"
							+ "on tbl_deals.id = tbl_cartItems.dealID"
							+ "join tbl_hotels on"
							+ "tbl_deals.hotelid = tbl_hotels.id"
							+ "where userId = ?");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DealBean deal = new DealBean();
				Date end = rs.getDate("enddate");
				deal.setEnd(end);
				deal.setHotelName(rs.getString("name"));
				deal.setID(rs.getInt("id"));
				deal.setInfo(rs.getString("info"));
				deal.setStart(rs.getDate("startdate"));
				deals.add(deal);
			}
		} catch (SQLException e) {
			return null;
		}
		CartBean bean = new CartBean(deals);
		return bean;//
	}

	public CustomerBean addCustomer(CustomerBean customer, String password) {
		Connection c = this.connFactory.createConnection();

		try {
			//c.setAutoCommit(false);
			PreparedStatement ps = c.prepareStatement("select * from tbl_customers where email = ?");
			ps.setString(1, customer.getEmail());
			
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				return new CustomerBean();
			}
			ps = c
					.prepareStatement("insert into tbl_users (isadmin, password) values (false, ?)");
			ps.setString(1, password);
			ps.executeUpdate();

			ps = c
					.prepareStatement("select id from tbl_users order by id desc limit 1");
			 rs = ps.executeQuery();
			rs.next();
			int uid = rs.getInt("id");
			System.out.println(uid);
			customer.setUserID(uid);
			ps = c
					.prepareStatement("insert  into tbl_customers (email, userid) " +
							"values (?,?)");
			ps.setInt(2, uid);
			String email = customer.getEmail();
			ps.setString(1, email);
			ps.executeUpdate();
			//c.commit();
			c.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		System.out.println("customer added");
		return login(customer.getEmail(), password);
	}

	public boolean updateCustomer(CustomerBean customer) {
		return false;// TODO
	}

	public boolean reviewHotel(ReviewBean review, int hotelID) {
		return false;// TODO
	}

	public boolean updateCart(CartBean cart) {
		return false;// TODO
	}

	public boolean makePurchase(int dealID, int customerID) {
		return false;// TODO
	}

	// can possibly be omitted for simplicity's sake
	public boolean deleteCustomer(int customerID) {
		return false;// TODO
	}

	public CustomerBean login(String username, String password) {
		CustomerBean customer = null;
		Connection c = this.connFactory.createConnection();
		try {
			PreparedStatement ps = c
					.prepareStatement("select * from tbl_users join tbl_customers on "
							+ "tbl_users.id = tbl_customers.userId "
							+ "where tbl_customers.email = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new CustomerBean();
				customer.setId(rs.getInt("id"));
				customer.setUserID(rs.getInt("userId"));
				customer.setEmail(rs.getString("email"));
				customer.setCctype(rs.getString("cctype"));
				customer.setCcnumber(rs.getInt("ccnumber"));
				customer.setCcname(rs.getString("ccname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return customer;
	}
}
