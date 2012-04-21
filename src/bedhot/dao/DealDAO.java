package bedhot.dao;

import bedhot.beans.CriteriaBean;
import bedhot.beans.DealBean;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DealDAO {
	private final DBConnectionFactory connFactory;

	public DealDAO(DBConnectionFactory connFactory) {
		this.connFactory = connFactory;
	}

	public List<DealBean> findDeals(CriteriaBean criteria) {
		ArrayList<DealBean> results = new ArrayList<DealBean>();
		Connection c = connFactory.createConnection();
		try {
			PreparedStatement ps = 
			c.prepareStatement("select * from tbl_deals join " +
					"tbl_hotels on tbl_deals.hotelid = tbl_hotels.id " +
					"where tbl_deals.info = ?");
			ps.setString (1, criteria.getDesc());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DealBean deal = new DealBean();
				Date end = rs.getDate("enddate");
				deal.setEnd(end);
				String hotelName = rs.getString("hotelName");
				deal.setHotelName(hotelName);
				int id = rs.getInt("id");
				deal.setID(id);
				String info = rs.getString("info");
				deal.setInfo(info);
				Date start = rs.getDate("startdate");
				deal.setStart(start);
				results.add(deal);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return results;
	}

	/** hackhackhack */
	public List<String> listAll() {
		ArrayList<String> everything = new ArrayList<String>();
		try {

			Connection connection = connFactory.createConnection();
			ResultSet rs;
			PreparedStatement ps = connection
					.prepareStatement("select * from tbl_users");
			rs = ps.executeQuery();
			everything.add("tbl_users<br/>id, isadmin, password");
			while (rs.next()) {
				String result = "";
				result += rs.getInt("id");
				result += "\t";
				result += rs.getBoolean("isadmin");
				result += "\t";
				result += rs.getString("password");
				everything.add(new String(result));
			}
			rs = connection.prepareStatement("select * from tbl_customers")
					.executeQuery();
			everything.add("customers: id, userID, email,"
					+ "cctype, ccnumber," + "ccname");
			while (rs.next()) {
				String result = "";
				result += rs.getInt("id");
				result += "\t";
				result += rs.getInt("userID");
				result += "\t";
				result += rs.getString("email");
				result += "\t";
				result += rs.getString("cctype");
				result += "\t";
				result += rs.getString("ccnumber");
				result += "\t";
				result += rs.getString("ccname");
				everything.add(result);
			}
			rs = connection.prepareStatement("select * from tbl_providers").executeQuery();
			everything.add("id, userid, adminfullname, adminemail");
			while (rs.next()) {
				String result = "";
				result += rs.getInt("id");
				result += "\t";
				result += rs.getInt("userId");
				result += "\t";
				result += rs.getString("adminFullName");
				result += "\t";
				result += rs.getString("adminemail");
				everything.add(result);
			}

			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return everything;
	}
}
