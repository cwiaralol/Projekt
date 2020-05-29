package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.xStatus;

public class StatusTest {
	@Test
	public void shouldConstructorReturnExpectedValues() {
		//given
		xStatus status = new xStatus(1,"ready",1,"koniec",1,"dziala","image", 1);
		
		//when
		int status_id = 1;
		String status_name = "ready";
		int quantity = 1;
		String type = "koniec";
		String description = "dziala";
		String imageUrl = "image";
		int sellerId = 1;
		
		//then
		assertTrue(status.getStatus_id() == status_id);
		assertTrue(status.getStatus_name().equals(status_name));
		assertTrue(status.getQuantity() == quantity);
		assertTrue(status.getType().equals(type));
		assertTrue(status.getDescription().equals(description));
		assertTrue(status.getImageUrl().equals(imageUrl));
		assertTrue(status.getSellerId() == sellerId);		
	}
	
	@Test
	public void shouldGettersReturnTheRightValueFromSetters() {
		//given
		xStatus status = new xStatus();
		int status_id = 1;
		String status_name = "ready";
		int quantity = 1;
		String type = "koniec";
		String description = "dziala";
		String imageUrl = "image";
		int sellerId = 1;
		
		//when
		status.setStatus_id(status_id);
		status.setStatus_name(status_name);
		status.setQuantity(quantity);
		status.setType(type);
		status.setDescription(description);
		status.setImageUrl(imageUrl);
		status.setSellerId(sellerId);
		
		//then
		assertTrue(status.getStatus_id() == status_id);
		assertTrue(status.getStatus_name().equals(status_name));
		assertTrue(status.getQuantity() == quantity);
		assertTrue(status.getType().equals(type));
		assertTrue(status.getDescription().equals(description));
		assertTrue(status.getImageUrl().equals(imageUrl));
		assertTrue(status.getSellerId() == sellerId);	
	}
	
	@Test
	public void testHashCodeAndEquals() {
		//given
		xStatus status = new xStatus(1,"ready",1,"3d",1,"koniec","image", 1);
		xStatus otherProduct = new xStatus(2,"ready", 1, "koniec", 1, "tez dziala", "img", 2);
		
		//when
		
		
		//then
		assertSame(status,status);
		assertEquals(status,status);
		assertNotEquals(status, otherProduct);
		
		assertTrue(status.hashCode() == status.hashCode());
		assertFalse(status.hashCode() == otherProduct.hashCode());
		
		assertTrue(status.equals(status));
		assertFalse(status.equals(otherProduct));
		assertFalse(status.equals(null));
		assertFalse(status.equals(new User_Car()));
	}
	
	@Test
	public void testToString() {
		//given
		xStatus status = new xStatus();
		
		//when
		String text = "xStatus [status_id=0, itemName=null, quantity=0, type=null, description=null, imageUrl=null, sellerId=0]";
		
		//then
		assertEquals(status.toString(), text);
	}
}
