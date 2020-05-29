package pl.MechanicX.dao;

import java.util.List;

import pl.MechanicX.beans.xStatus;

public interface CartDAO{
List<xStatus> getCartProducts(int userId);
void addItemToUserCart(int itemId, int userId);
void deleteItemFromUserCart(int itemId, int userId);
void deleteAllFromCart(int userId);
List<xStatus> getDistinctCartProducts(int userId);
}
