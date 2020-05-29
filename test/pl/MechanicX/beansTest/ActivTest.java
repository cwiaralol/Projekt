package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.xActiv;

public class ActivTest {
	@Test
	public void shouldConstructorReturnExpectedValues() {
		//given
		xActiv activs = new xActiv(1,1,Date.valueOf(LocalDate.now()),"w gara¿u",10.00);
		
		//when
		int orderId = 1;
		int userId = 1;
		Date date = Date.valueOf(LocalDate.now());
		String status = "w gara¿u";
		double total = 10.00;
		
		//then
		assertTrue(activs.getUserId() == userId);
		assertTrue(activs.getOrderId() == orderId);
		assertTrue(activs.getOrderDate().equals(date));
		assertTrue(activs.getStatus().equals(status));
		assertTrue(activs.getTotal() == total);
	}
	
	@Test
	public void shouldGettersReturnTheRightValueFromSetters() {
		//given
		xActiv activs = new xActiv();
		int orderId = 1;
		int userId = 1;
		Date date = Date.valueOf(LocalDate.now());
		String status = "w gara¿u";
		double total = 10.00;
		
		//when
		activs.setOrderId(orderId);
		activs.setUserId(userId);
		activs.setOrderDate(date);
		activs.setStatus(status);
		activs.setTotal(total);
		
		//then
		assertTrue(activs.getUserId() == userId);
		assertTrue(activs.getOrderId() == orderId);
		assertTrue(activs.getOrderDate() == date);
		assertTrue(activs.getStatus().equals(status));
		assertTrue(activs.getTotal() == total);
	}
	
	@Test
	public void testHashCodeAndEquals() {
		//given
		xActiv activs = new xActiv(1,1,Date.valueOf(LocalDate.now()),"w gara¿u",10.00);
		xActiv otherOrder = new xActiv(2,2,Date.valueOf(LocalDate.now()),"w gara¿u",10.00);
		
		//when
		
		
		//then
		assertSame(activs,activs);
		assertEquals(activs,activs);
		assertNotEquals(activs, otherOrder);
		
		assertTrue(activs.hashCode() == activs.hashCode());
		assertFalse(activs.hashCode() == otherOrder.hashCode());
		
		assertTrue(activs.equals(activs));
		assertFalse(activs.equals(otherOrder));
		assertFalse(activs.equals(null));
		assertFalse(activs.equals(new User_Car()));
	}
	
	@Test
	public void testToString() {
		//given
		xActiv activs = new xActiv();
		
		//when
		String text = "xActiv [orderId=0, userId=0, orderDate=null, status=null, total=0.0]";
		
		//then
		assertEquals(activs.toString(), text);
	}
}
