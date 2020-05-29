package pl.MechanicX.dao;

import java.util.List;

import pl.MechanicX.beans.xStatus;

public interface xStatusDAO extends GenericDAO<xStatus, Integer>{
xStatus getProductByItemName(String itemName);
List<xStatus> getProductsBySellerId(int sellerId);
List<xStatus> getProductsByProductName(String searchPhrase);
List<xStatus> getProductsByType(String type);
}
