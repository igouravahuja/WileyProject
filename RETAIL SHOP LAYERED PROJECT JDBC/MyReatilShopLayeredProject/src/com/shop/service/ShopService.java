package com.shop.service;
import com.shop.bean.Items;
import com.shop.persistence.ItemDao;
import com.shop.persistence.ItemDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;

public interface ShopService
{
	Collection<Items> getAllItems() throws SQLException, ClassNotFoundException;;
	boolean addToCart(Items item) throws SQLException, ClassNotFoundException;;
	//public Items showCart();
	
	//public Employee searchEmployees(int id);
	//public boolean deleteEmployee(int id);
}