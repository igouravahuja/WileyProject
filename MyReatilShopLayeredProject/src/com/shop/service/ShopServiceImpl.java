package com.shop.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shop.bean.Items;
import com.shop.persistence.InvalidQuantityException;
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
	
	double bill_total=0;
	@Override
	public double addToCart(int id,int quantity) throws SQLException, ClassNotFoundException
	{
		double tax;
		double subtotal=itemDao.calculateBill(id,quantity);
		if(id==2)
		{
			tax=(subtotal)*(0.1);
			subtotal=subtotal+tax;
		}
		if(id==3)
		{
			tax=(subtotal)*(0.12);
			subtotal=subtotal+tax;
		}
		bill_total=bill_total+subtotal;
		return bill_total;
	}
	
}
	