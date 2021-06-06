package com.shop.service;
import com.shop.bean.Items;
import com.shop.persistence.ItemDao;
import com.shop.persistence.ItemDaoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;

public interface ShopService
{
	Collection<Items> getAllItems();
	boolean addToCart(Items item);
	//public Items showCart();
	
	//public Employee searchEmployees(int id);
	//public boolean deleteEmployee(int id);
}