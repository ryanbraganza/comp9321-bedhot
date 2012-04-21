package bedhot.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionFactory {
	private InitialContext ctx;

	private Context envContext;

	private DataSource ds;

	/**
	 * can and will return null
	 * @return
	 */
	public Connection createConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public DBConnectionFactory() {
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			throw new RuntimeException(
					"Unable to create AbstractJndiLocator line 1: "
							+ e.getMessage(), e);
		}

		try {
			envContext = (Context) ctx.lookup("java:/comp/env");
		} catch (NamingException e) {
			throw new RuntimeException(
					"Unable to create AbstractJndiLocator line 2: "
							+ e.getMessage(), e);
		}
	}

	/**
	 * If this returns null, caller should deal with it
	 */
	private Object lookup(String name) throws NamingException {
		Object o = envContext.lookup(name);
		return o;
	}

	/**
	 * Finds a data source by looking up the initial context
	 * 
	 * @return
	 */
	private DataSource getDataSource() {
		if (ds == null) {
			try {
				ds = (DataSource) lookup("jdbc/HSQLDB");
			} catch (NamingException e) {
				throw new RuntimeException("Unable to locate data source; "
						+ e.getMessage(), e);
			}
		}
		return ds;
	}
}
