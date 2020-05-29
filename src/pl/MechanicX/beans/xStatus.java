package pl.MechanicX.beans;

public class xStatus {
private int status_id;
private String status_name;
private int quantity;
private String type;
private String description;
private String imageUrl;
private int sellerId;

public xStatus(){}

public xStatus(int status_id, String status_name, int quantity, String type, String description,
		String imageUrl, int sellerId) {
	super();
	this.status_id = status_id;
	this.status_name = status_name;
	this.quantity = quantity;
	this.type = type;
	this.description = description;
	this.imageUrl = imageUrl;
	this.sellerId = sellerId;
}

public int getStatus_id() {
	return status_id;
}

public void setStatus_id(int status_id) {
	this.status_id = status_id;
}

public String getStatus_name() {
	return status_name;
}

public void setStatus_name(String itemName) {
	this.status_name = itemName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}



public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

public int getSellerId() {
	return sellerId;
}

public void setSellerId(int sellerId) {
	this.sellerId = sellerId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
	result = prime * result + ((status_name == null) ? 0 : status_name.hashCode());

	result = prime * result + status_id;
	result = prime * result + quantity;
	result = prime * result + sellerId;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	xStatus other = (xStatus) obj;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (imageUrl == null) {
		if (other.imageUrl != null)
			return false;
	} else if (!imageUrl.equals(other.imageUrl))
		return false;
	if (status_name == null) {
		if (other.status_name != null)
			return false;
	} else if (!status_name.equals(other.status_name))
		return false;

	if (status_id != other.status_id)
		return false;
	if (quantity != other.quantity)
		return false;
	if (sellerId != other.sellerId)
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}

@Override
public String toString() {
	return "xStatus [status_id=" + status_id + ", itemName=" + status_name + ", quantity=" + quantity + ", type=" + type
		+ ", description=" + description + ", imageUrl=" + imageUrl + ", sellerId=" + sellerId
			+ "]";
}


}
