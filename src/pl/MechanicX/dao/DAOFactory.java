package pl.MechanicX.dao;

import pl.MechanicX.exception.NoSuchDbTypeException;

public abstract class DAOFactory {
	
	public static final int MYSQL_DAO_FACTORY = 1;

	public abstract UserDAO getUserDAO();
	public abstract UserCarDAO getBillingInfoDAO();
	public abstract xStatusDAO getProductDAO();
	public abstract CartDAO getCartDAO();
	public abstract ReviewDAO getReviewDAO();
	public abstract HistoryDAO getHistoryDAO();
	public abstract xActivDAO getOrdersDAO();
	public abstract xOperationDAO getShipmentDAO();
	public abstract xControlDAO getPaymentDAO();
	
	public static DAOFactory getDAOFactory() {
		DAOFactory factory = null;
		try {
			factory = getDAOFactory(MYSQL_DAO_FACTORY);
		} catch (NoSuchDbTypeException e) {
			e.printStackTrace();
		}
		return factory;
	}
	
	private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
		switch (type) {
		case MYSQL_DAO_FACTORY:
			return new MysqlDAOFactory();
		default:
			throw new NoSuchDbTypeException();
		}
	}
}