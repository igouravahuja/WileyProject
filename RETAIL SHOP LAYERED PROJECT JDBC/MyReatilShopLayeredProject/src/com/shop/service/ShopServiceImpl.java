package com.shop.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shop.bean.Items;
import com.shop.persistence.ItemDao;
import com.shop.persistence.ItemDaoImpl;


public class ShopServiceImpl implements ShopService
{
	private ItemDao itemDao=new ItemDaoImpl();
	
	@Override
	public Collection<Items> getAllItems() throws SQLException, ClassNotFoundException 
	{
		return itemDao.getAllItems();
	}
	
	@Override
	public boolean addToCart(Items item) throws SQLException, ClassNotFoundException
	{
		return true;
	}
	
	//public Items showCart();
	//{
		//return ItemDao.getCart();
	//}
	
}
	