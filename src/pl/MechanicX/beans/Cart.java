package pl.MechanicX.beans;

public class Cart {
private int user_id;
private int operation_id;

public Cart() {}

public Cart(int user_id, int operation_id) {
	super();
	this.user_id = user_id;
	this.operation_id = operation_id;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public int getItem_id() {
	return operation_id;
}

public void setItem_id(int operation_id) {
	this.operation_id = operation_id;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + operation_id;
	result = prime * result + user_id;
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
	Cart other = (Cart) obj;
	if (operation_id != other.operation_id)
		return false;
	if (user_id != other.user_id)
		return false;
	return true;
}

@Override
public String toString() {
	return "Cart [user_id=" + user_id + ", operation_id=" + operation_id + "]";
}


}
