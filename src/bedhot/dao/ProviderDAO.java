package bedhot.dao;

import java.sql.*;
import java.util.List;

import bedhot.beans.ProviderBean;
import bedhot.beans.DealBean;

public class ProviderDAO {
	private final DBConnectionFactory connFactory;

	public ProviderDAO(DBConnectionFactory connFactory) {
		this.connFactory = connFactory;
	}

	public ProviderBean login(String username, String password) {
		ProviderBean provider = null;
		Connection c = this.connFactory.createConnection();
		try {
			PreparedStatement ps = c
					.prepareStatement("select * from tbl_users join tbl_providers on "
							+ "tbl_users.id = tbl_providers.userId "
							+ "where tbl_providers.adminemail = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				provider = new ProviderBean();
				provider.setAdminFullName(rs.getString("adminfullname"));
				provider.setEmail(rs.getString("adminemail"));
				provider.setId(rs.getInt("id"));
				provider.setPassword(rs.getString("password"));
				provider.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return provider;
	}

	public ProviderBean getProvider(int providerID) {
		return null;// TODO
	}

	public List<DealBean> getDeals(int providerID) {
		return null;// TODO
	}

	public boolean updateProvider(ProviderBean provider) {
		return false;// TODO
	}

	public ProviderBean addProvider(ProviderBean provider) {
		Connection c = connFactory.createConnection();
		try {
			// c.setAutoCommit(false);
			PreparedStatement ps = c
					.prepareStatement("select * from tbl_providers where adminemail = ?");
			ps.setString(1, provider.getEmail());

			ResultSet rs = ps.executeQuery();
			// if exists, send a blank providerbean back
			if (rs.next()) {
				return new ProviderBean();
			}
			String password = provider.getPassword();
			ps = c
					.prepareStatement("insert into tbl_users (isadmin, password) values (true, ?)");
			ps.setString(1, password);
			ps.executeUpdate();

			ps = c
					.prepareStatement("select id from tbl_users order by id desc limit 1");
			rs = ps.executeQuery();
			rs.next();
			int uid = rs.getInt("id");
			provider.setUserid(uid);
			ps = c.prepareStatement("insert  into tbl_providers (userid, "
					+ " adminemail) values (?,?)");
			ps.setInt(1, uid);
			ps.setString(2, provider.getEmail());
			ps.executeUpdate();
			// c.commit();
			c.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		return provider;
	}

	public boolean addDeal(int providerID, DealBean deal) {
		return false;// TODO
	}

	public boolean updateDeal(DealBean deal) {
		return false;// TODO
	}

	// can possibly be omitted for simplicity's sake
	public boolean deleteProvider(int providerID) {
		return false;// TODO
	}
}
