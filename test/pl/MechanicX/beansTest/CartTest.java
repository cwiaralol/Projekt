package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.Cart;

public class CartTest {

	@Test
	public void shouldConstructorReturnExpectedValues() {
		//given
		Cart cart = new Cart(1,1);
		
		//when
		int userId = 1;
		int status_id = 1;
		
		//then
		assertTrue(cart.getUser_id() == userId);
		assertTrue(cart.getItem_id() == status_id);
	}
	
	@Test
	public void shouldGettersReturnTheRightValueFromSetters() {
		//given
		Cart cart = new Cart();
		
		//when
		cart.setItem_id(1);
		cart.setUser_id(1);
		
		//then
		assertTrue(cart.getUser_id() == 1);
		assertTrue(cart.getUser_id() == 1);
	}
	
	@Test
	public void testHashCodeAndEquals() {
		//given
		Cart cart = new Cart(1,1);
		Cart otherCart = new Cart(2,2);
		
		//when
		
		
		//then
		assertSame(cart,cart);
		assertEquals(cart,cart);
		assertNotEquals(cart, otherCart);
		
		assertTrue(cart.hashCode() == cart.hashCode());
		assertFalse(cart.hashCode() == otherCart.hashCode());
		
		assertTrue(cart.equals(cart));
		assertFalse(cart.equals(otherCart));
		assertFalse(cart.equals(null));
		assertFalse(cart.equals(new User_Car()));
	}
	
	@Test
	public void testToString() {
		//given
		Cart cart = new Cart();
		
		//when
		String text = "Cart [user_id=0, operation_id=0]";
		
		//then
		assertEquals(cart.toString(), text);
	}
}
