package bedhot.dao;

/**
 * hacked up version of IoC/ServiceLocator pattern
 * 
 * @author ryanb
 *
 */
public class DAOFactory {

	private static final DBConnectionFactory connFactory = new DBConnectionFactory();
	private static final DAOFactory factory = new DAOFactory();

	private static final CustomerDAO customerDAO = new CustomerDAO(connFactory);

	private static final DealDAO dealDAO = new DealDAO(connFactory);

	private static final ProviderDAO providerDAO = new ProviderDAO(connFactory);

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public DealDAO getDealDAO() {
		return dealDAO;
	}

	public ProviderDAO getProviderDAO() {
		return providerDAO;
	}

	public static DAOFactory getInstance() {
		return factory;
	}
}
