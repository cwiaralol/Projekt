package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.Cart;

public class Car_User_Test {
	
	@Test
	public void testThatCreateBillingInfoWithDefaultConstructorIsNotNull() {
		//given
		
		
		//when
		User_Car user_Car = new User_Car();
		
		//then
		assertNotNull(user_Car);
	}
	
	@Test
	public void testThatBillingInfoWithConstructorDataHasCorrectData() {
		//given
		int user_car_id = 1;
		int userId = 1;
		String car_brand = "123";
		String car_model = "mondeo";
		String car_registration = "FZI 1234";
		
		//when
		User_Car user_Car = new User_Car(user_car_id, userId, car_brand, car_model, car_registration);
		
		//then
		assertEquals(user_car_id, user_Car.getUser_car_id());
		assertEquals(userId, user_Car.getUserId());
		assertEquals(car_brand, user_Car.getCar_brand());
		assertEquals(car_model, user_Car.getCar_model());
		assertEquals(car_registration, user_Car.getCar_registration());
	}
	
	@Test
	public void testThatSettersReturnTheExpectedValue() {
		//given
		User_Car user_Car = new User_Car();
		
		//when
		user_Car.setUser_car_id(1);
		user_Car.setUserId(1);
		user_Car.setCar_brand("123");
		user_Car.setCar_model("Mondeo");
		user_Car.setCar_registration("FZI 521");
		
		//then
		assertEquals(1, user_Car.getUser_car_id());
		assertEquals(1, user_Car.getUserId());
		assertEquals("123", user_Car.getCar_brand());
		assertEquals("Clio", user_Car.getCar_model());
		assertEquals("FZi 123", user_Car.getCar_registration());
	}
	
	@Test
	public void shouldHashCodeAndEqualsWorkAsIntended() {
		//given
		int user_car_id = 1;
		int userId = 1;
		String car_brand = "123";
		String car_model ="Mondeo";
		String car_registration = "Test";
		
		//when
		User_Car user_car = new User_Car(user_car_id, userId, car_brand, car_model, car_registration);
		User_Car identicalUserCar = new User_Car(user_car_id, userId, car_brand, car_model, car_registration);
		User_Car otherBUserCar = new User_Car(2,2,"321","mondeo","Test");
		User_Car nullInfo = new User_Car();
		//then
		assertEquals(user_car, identicalUserCar);
		assertNotEquals(user_car, otherBUserCar);
		
		assertFalse(user_car.equals(new Cart()));
		assertTrue(user_car.equals(user_car));
		assertTrue(user_car.equals(identicalUserCar));
		assertFalse(user_car.equals(otherBUserCar));
		assertFalse(nullInfo.equals(user_car));
		assertTrue(user_car.hashCode() == identicalUserCar.hashCode());
		assertFalse(user_car.hashCode() == otherBUserCar.hashCode());
		assertFalse(user_car.equals(null));
	}

	@Test
	public void testToString() {
		//given
		User_Car user_Car = new User_Car();

		//when
		String text = "user_Car [UserCarId=0, userId=0, car_brand=null, car_model=null, car_registration=null]";
		
		//then
		assertTrue(user_Car.toString().equals(text));
	}
}
