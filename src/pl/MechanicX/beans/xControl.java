package pl.MechanicX.beans;

public class xControl {
	private int control_id;
	private String control_type;
	private int userId;
	private double amount;
	private int sellerId;
	private int user_car_id;
	private int orderId;
	private String status;
	
	public xControl() {}

	public xControl(int control_id, String control_type, int userId, double amount, int sellerId, int user_car_id,
			int orderId, String status) {
		super();
		this.control_id = control_id;
		this.control_type = control_type;
		this.userId = userId;
		this.amount = amount;
		this.sellerId = sellerId;
		this.user_car_id = user_car_id;
		this.orderId = orderId;
		this.status = status;
	}

	public int getControl_id() {
		return control_id;
	}

	public void setControl_id(int control_id) {
		this.control_id = control_id;
	}

	public String getControl_type() {
		return control_type;
	}

	public void setControl_type(String control_type) {
		this.control_type = control_type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getUser_car_id() {
		return user_car_id;
	}

	public void setUser_car_id(int user_car_id) {
		this.user_car_id = user_car_id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + user_car_id;
		result = prime * result + orderId;
		result = prime * result + control_id;
		result = prime * result + ((control_type == null) ? 0 : control_type.hashCode());
		result = prime * result + sellerId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		xControl other = (xControl) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (user_car_id != other.user_car_id)
			return false;
		if (orderId != other.orderId)
			return false;
		if (control_id != other.control_id)
			return false;
		if (control_type == null) {
			if (other.control_type != null)
				return false;
		} else if (!control_type.equals(other.control_type))
			return false;
		if (sellerId != other.sellerId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "xControl [control_id=" + control_id + ", control_type=" + control_type + ", userId=" + userId + ", amount="
				+ amount + ", sellerId=" + sellerId + ", user_car_id=" + user_car_id + ", orderId=" + orderId
				+ ", status=" + status + "]";
	}

	
	
}
