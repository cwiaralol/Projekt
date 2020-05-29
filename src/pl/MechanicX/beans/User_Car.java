package pl.MechanicX.beans;

import java.sql.Date;

	public class User_Car {
	private int user_car_id;
	private int userId;
	private String car_brand;
	private String car_model;
	private String car_registration;
	
	public User_Car() { }
	
	

	public User_Car(int user_car_id, int userId, String car_brand, String car_model,String car_registration) {
		super();
		this.user_car_id = user_car_id;
		this.userId = userId;
		this.car_brand = car_brand;
		this.car_model = car_model;
		this.car_registration = car_registration;
	}



	public int getUser_car_id() {
		return user_car_id;
	}

	public void setUser_car_id(int user_car_id) {
		this.user_car_id = user_car_id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}



	public String getCar_registration() {
		return car_registration;
	}

	public void setCar_registration(String car_registration) {
		this.car_registration = car_registration;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car_registration == null) ? 0 : car_registration.hashCode());
		result = prime * result + user_car_id;
		result = prime * result + ((car_brand == null) ? 0 : car_brand.hashCode());
		result = prime * result + ((car_model == null) ? 0 : car_model.hashCode());
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
		User_Car other = (User_Car) obj;
		if (car_registration == null) {
			if (other.car_registration != null)
				return false;
		} else if (!car_registration.equals(other.car_registration))
			return false;
		if (user_car_id != other.user_car_id)
			return false;
		if (car_brand == null) {
			if (other.car_brand != null)
				return false;
		} else if (!car_brand.equals(other.car_brand))
			return false;
		if (car_model == null) {
			if (other.car_model != null)
				return false;
		} else if (!car_model.equals(other.car_model))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "UserCar [billingInfoId=" + user_car_id + ", userId=" + userId + ", car_brand=" + car_brand
				+ ", car_model=" + car_model  + ", car_registration="
				+ car_registration + "]";
	}

	

	}
