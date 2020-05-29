package pl.MechanicX.beansTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.MechanicX.beans.User_Car;
import pl.MechanicX.beans.xOperation;

public class OperationTest {
	@Test
	public void shouldConstructorReturnExpectedValues() {
		//given
		int operation_id = 1;
		int orderId = 1;
		int userId = 1;
		String mechanic_name = "jakis";
		String returnAddress = "adres";
		String garage = "gara¿ 1";
		float charge = 3.0f;
		String status = "gotowy";
		
		
		//when
		xOperation operation = new xOperation(operation_id, orderId, userId, mechanic_name, returnAddress, garage, charge, status);
		
		//then
		assertTrue(operation_id == operation.getOperation_id());
		assertTrue(orderId == operation.getOrderId());
		assertTrue(userId == operation.getUserId());
		assertTrue(mechanic_name.equals(operation.getMechanicName()));
		assertTrue(returnAddress.equals(operation.getReturnAddress()));
		assertTrue(garage.equals(operation.getGarage()));
		assertTrue(charge == operation.getCharge());
		assertTrue(status.equals(operation.getStatus()));
	}
	
	@Test
	public void shouldGettersReturnTheRightValueFromSetters() {
		//given
		xOperation operation = new xOperation();

		int operation_id = 1;
		int orderId = 1;
		int userId = 1;
		String mechanic_name = "jakis";
		String returnAddress = "adres";
		String garage = "gara¿ 1";
		float charge = 3.0f;
		String status = "gotowy";
		
		//when
		operation.setGarage(garage);
		operation.setCharge(charge);
		operation.setOrderId(orderId);
		operation.setReturnAddress(returnAddress);
		operation.setOperation_id(operation_id);
		operation.setStatus(status);
		operation.setMechanicName(mechanic_name);
		operation.setUserId(userId);

		
		//then
		assertTrue(operation_id == operation.getOperation_id());
		assertTrue(orderId == operation.getOrderId());
		assertTrue(userId == operation.getUserId());
		assertTrue(mechanic_name.equals(operation.getMechanicName()));
		assertTrue(returnAddress.equals(operation.getReturnAddress()));
		assertTrue(garage.equals(operation.getGarage()));
		assertTrue(charge == operation.getCharge());
		assertTrue(status.equals(operation.getStatus()));
	}
	
	@Test
	public void testHashCodeAndEquals() {
		//given
		xOperation operation = new xOperation(1,1,1,"jakis","adres","gara¿ 1",3.0f,"gotowy");
		xOperation otherShipment = new xOperation(1,1,1,"jakis","adres","gara¿ 1",3.0f,"gotowy");
		
		//when
		
		
		//then
		assertSame(operation,operation);
		assertEquals(operation,operation);
		assertNotEquals(operation, otherShipment);
		
		assertTrue(operation.hashCode() == operation.hashCode());
		assertFalse(operation.hashCode() == otherShipment.hashCode());
		
		assertTrue(operation.equals(operation));
		assertFalse(operation.equals(otherShipment));
		assertFalse(operation.equals(null));
		assertFalse(operation.equals(new User_Car()));
	}
	
	@Test
	public void testToString() {
		//given
		xOperation operation = new xOperation();
		
		//when
		String text = "xOperation [operation_id=0, orderId=0, userId=0, mechanic_name=null, returnAddress=null, garage=null, charge=0.0, status=null]";
		
		//then
		assertEquals(operation.toString(), text);
	}
}
