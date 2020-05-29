package pl.MechanicX.dao;

import java.sql.Date;
import java.util.List;

import pl.MechanicX.beans.xActiv;

public interface xActivDAO extends GenericDAO<xActiv, Integer> {
List<xActiv> getAllOrdersOfUser(int userId);
List<xActiv> getAllOrdersWithStatus(String status);
List<xActiv> getAllOrdersWithDate(Date date);
}
