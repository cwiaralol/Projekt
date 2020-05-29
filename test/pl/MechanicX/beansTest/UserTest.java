package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.User;

public class UserTest {
	@Test
	public void shouldConstructorReturnExpectedValues() {
		//given
		int id = 1;
		String email = "98842@g.wiea.uz.zgora.pl";
		String password = "milosz";
		String firstName = "milosz";
		String lastName = "milosz";
		String middleName = "milosz";
		String type = "customer";
		String username = "milosz";
		boolean isActive = true;
		
		
		//when
		User user = new User(id, email, password, firstName, lastName, middleName, type, username, isActive);
		
		//then
		assertEquals(id, user.getId());	
		assertEquals(email, user.getEmail());	
		assertEquals(password, user.getPassword());	
		assertEquals(firstName, user.getFirstName());	
		assertEquals(lastName, user.getLastName());	
		assertEquals(middleName, user.getMiddleName());	
		assertEquals(type, user.getType());	
		assertEquals(username, user.getUsername());	
		assertEquals(isActive, user.isActive());	
	}
	
	@Test
	public void shouldGettersReturnTheRightValueFromSetters() {
		//given
		User user = new User();
		int id = 1;
		String email = "98842@g.wiea.uz.zgora.pl";
		String password = "milosz";
		String firstName = "milosz";
		String lastName = "milosz";
		String middleName = "milosz";
		String type = "customer";
		String username = "milosz";
		boolean isActive = true;
		
		//when
		user.setActive(isActive);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setId(id);
		user.setLastName(lastName);
		user.setMiddleName(middleName);
		user.setPassword(password);
		user.setType(type);
		user.setUsername(username);
		
		//then
		assertEquals(id, user.getId());	
		assertEquals(email, user.getEmail());	
		assertEquals(password, user.getPassword());	
		assertEquals(firstName, user.getFirstName());	
		assertEquals(lastName, user.getLastName());	
		assertEquals(middleName, user.getMiddleName());	
		assertEquals(type, user.getType());	
		assertEquals(username, user.getUsername());	
		assertEquals(isActive, user.isActive());
	}
	
	@Test
	public void testHashCodeAndEquals() {
		//given
		User user = new User(1,"milosz","milosz","milosz","milosz","milosz","milosz","milosz",true);
		User otherUser = new User(1,"milosz","milosz","milosz","milosz","milosz","milosz","milosz",false);
		
		//when

		
		//then
		assertSame(user,user);
		assertEquals(user,user);
		assertNotEquals(user, otherUser);
		
		assertTrue(user.hashCode() == user.hashCode());
		assertFalse(user.hashCode() == otherUser.hashCode());
		
		assertTrue(user.equals(user));
		assertFalse(user.equals(otherUser));
		assertFalse(user.equals(null));
		assertFalse(user.equals(new User_Car()));
	}
	
	@Test
	public void testToString() {
		//given
		User user = new User();
		
		//when
		String text = "User [id=0, email=null, password=null, firstName=null, lastName=null, middleName=, type=null, username=null, isActive=false]";

		//then
		assertEquals(user.toString(), text);
	}
}
