package com.shop.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shop.bean.Items;
import com.shop.persistence.ItemDao;
import com.shop.persistence.ItemDaoImpl;


public class ShopServiceImpl implements ShopService
{
	private ItemDao itemDao=new ItemDaoImpl();
	
	public Collection<Items> getAllItems()
	{
		return itemDao.getAllItems();
	}
	
	public boolean addToCart(Items item)
	{
		return true;
	}
	
	//public Items showCart();
	//{
		//return ItemDao.getCart();
	//}
	
}
	