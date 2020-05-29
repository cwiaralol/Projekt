package pl.MechanicX.dao;

import java.util.List;

import pl.MechanicX.beans.xControl;

public interface xControlDAO extends GenericDAO<xControl, Integer>{
xControl getPaymentForOrder(int orderId);
List<xControl> getAllPaymentsOfUser(int userId);
List<xControl> getAllPaymentsWithLessThan(double amount);
List<xControl> getAllPaymentsWithMoreThan(double amount);
List<xControl> getAllPayemntsEqualTo(double amount);
List<xControl> getAllPaymentsWithStatus(String status);
}
