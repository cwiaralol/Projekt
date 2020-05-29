package pl.MechanicX.beans;

public class xOperation {
	private int operation_id;
	private int orderId;
	private int userId;
	private String mechanic_name;
	private String returnAddress;
	private String garage;
	private float charge;
	private String status;
	
	public xOperation() {}

	public xOperation(int operation_id, int orderId, int userId, String mechanic_name, String returnAddress,
			String garage, float charge, String status) {
		super();
		this.operation_id = operation_id;
		this.orderId = orderId;
		this.userId = userId;
		this.mechanic_name = mechanic_name;
		this.returnAddress = returnAddress;
		this.garage = garage;
		this.charge = charge;
		this.status = status;
	}

	public int getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(int operation_id) {
		this.operation_id = operation_id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMechanicName() {
		return mechanic_name;
	}

	public void setMechanicName(String mechanic_name) {
		this.mechanic_name = mechanic_name;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
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
		result = prime * result + ((garage == null) ? 0 : garage.hashCode());
		result = prime * result + Float.floatToIntBits(charge);
		result = prime * result + orderId;
		result = prime * result + ((returnAddress == null) ? 0 : returnAddress.hashCode());
		result = prime * result + operation_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((mechanic_name == null) ? 0 : mechanic_name.hashCode());
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
		xOperation other = (xOperation) obj;
		if (garage == null) {
			if (other.garage != null)
				return false;
		} else if (!garage.equals(other.garage))
			return false;
		if (Float.floatToIntBits(charge) != Float.floatToIntBits(other.charge))
			return false;
		if (orderId != other.orderId)
			return false;
		if (returnAddress == null) {
			if (other.returnAddress != null)
				return false;
		} else if (!returnAddress.equals(other.returnAddress))
			return false;
		if (operation_id != other.operation_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (mechanic_name == null) {
			if (other.mechanic_name != null)
				return false;
		} else if (!mechanic_name.equals(other.mechanic_name))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "xOperation [operation_id=" + operation_id + ", orderId=" + orderId + ", userId=" + userId
				+ ", mechanic_name=" + mechanic_name + ", returnAddress=" + returnAddress + ", garage=" + garage
				+ ", charge=" + charge + ", status=" + status + "]";
	}

	
	
	
}
