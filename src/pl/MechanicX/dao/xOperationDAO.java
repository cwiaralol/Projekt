package pl.MechanicX.dao;

import java.util.List;

import pl.MechanicX.beans.xOperation;

public interface xOperationDAO extends GenericDAO<xOperation, Integer>{
xOperation getShipmentByTackingNumber(String mechanic_name);
List<xOperation> getAllShipmentWithStatus(String status);
List<xOperation> getAllShipmentsWithUserId(int userId);
List<xOperation> getAllShipmentWithCarrier(String garage);
}
