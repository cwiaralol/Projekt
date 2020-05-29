package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.xControl;

public class ControlTest {
	@Test
	public void shouldConstructorReturnExpectedValues() {
		//given
		xControl control = new xControl(1,"ready",1,1,1,1, 1, "ready");
		
		//when
		int control_id = 1;
		String control_type = "ready";
		int userId = 1;
		double amount = 1;
		int sellerId = 1;
		int user_car_id = 1;
		int orderId = 1;
		String status = "ready";
		
		//then
		assertTrue(control.getControl_id() == control_id);
		assertTrue(control.getControl_type().equals(control_type));
		assertTrue(control.getUserId() == userId);
		assertTrue(control.getAmount() == amount);
		assertTrue(control.getSellerId() == sellerId);
		assertTrue(control.getUser_car_id() == user_car_id);
		assertTrue(control.getOrderId() == orderId);
		assertTrue(control.getStatus().equals(status));
		
	}
	
	@Test
	public void shouldGettersReturnTheRightValueFromSetters() {
		//given
		xControl control = new xControl();
		int control_id = 1;
		String control_type = "ready";
		int userId = 1;
		double amount = 1;
		int sellerId = 1;
		int user_car_id = 1;
		int orderId = 1;
		String status = "ready";
		
		//when
		control.setControl_id(control_id);
		control.setControl_type(control_type);
		control.setUserId(userId);
		control.setAmount(amount);
		control.setSellerId(sellerId);
		control.setUser_car_id(user_car_id);
		control.setOrderId(orderId);
		control.setStatus(status);
		
		//then
		assertTrue(control.getControl_id() == control_id);
		assertTrue(control.getControl_type().equals(control_type));
		assertTrue(control.getUserId() == userId);
		assertTrue(control.getAmount() == amount);
		assertTrue(control.getSellerId() == sellerId);
		assertTrue(control.getUser_car_id() == user_car_id);
		assertTrue(control.getOrderId() == orderId);
		assertTrue(control.getStatus().equals(status));
	}
	
	@Test
	public void testHashCodeAndEquals() {
		//given
		xControl control = new xControl(1,"ready",1,1,1,1,1, "ready");
		xControl otherPayment = new xControl(1,"ready",1,1,1,1, 1, "ready");
		
		//when
		
		
		//then
		assertSame(control,control);
		assertEquals(control,control);
		assertNotEquals(control, otherPayment);
		
		assertTrue(control.hashCode() == control.hashCode());
		assertFalse(control.hashCode() == otherPayment.hashCode());
		
		assertTrue(control.equals(control));
		assertFalse(control.equals(otherPayment));
		assertFalse(control.equals(null));
		assertFalse(control.equals(new User_Car()));
	}
	
	@Test
	public void testToString() {
		//given
		xControl control = new xControl();
		
		//when
		String text = "xControl [control_id=0, control_type=null, userId=0, amount=0.0, sellerId=0, user_car_id=0, orderId=0, status=null]";

		//then
		assertEquals(control.toString(), text);
	}
}
