package pl.MechanicX.dao;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	@Override
	public UserCarDAO getBillingInfoDAO() {
		return new UserCarDAOImpl();
	}

	@Override
	public xStatusDAO getProductDAO() {
		return new xStatusDAOImpl();
	}

	@Override
	public CartDAO getCartDAO() {
		return new CartDAOImpl();
	}

	@Override
	public ReviewDAO getReviewDAO() {
		return new ReviewDAOImpl();
	}

	@Override
	public HistoryDAO getHistoryDAO() {
		return new HistoryDAOImpl();
	}

	@Override
	public xActivDAO getOrdersDAO() {
		return new xActivDAOImpl();
	}

	@Override
	public xOperationDAO getShipmentDAO() {
		return new xOperationDAOImpl();
	}

	@Override
	public xControlDAO getPaymentDAO() {
		return new xControlDAOImpl();
	}
}