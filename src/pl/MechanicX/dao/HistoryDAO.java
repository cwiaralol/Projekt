package pl.MechanicX.dao;

import java.util.List;

import pl.MechanicX.beans.History;

public interface HistoryDAO extends GenericDAO<History, Integer>{
List<History> getHistoryOfUser(int userId);
}
