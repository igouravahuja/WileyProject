package com.shop.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.bean.Items;
import com.shop.helper.MySQLConnection;
import com.shop.bean.Customer;
import com.shop.persistence.InvalidQuantityException;
import com.shop.persistence.ItemDao;
import com.shop.persistence.ItemDaoImpl;

@Service
public class ShopServiceImpl implements ShopService
{
	private ItemDao itemDao=new ItemDaoImpl();
	
	HashMap<Integer, Items> cartItems = new HashMap<Integer, Items>();
	
	@Override
	public Collection<Items> getAllItems() throws SQLException, ClassNotFoundException 
	{
		return itemDao.getAllItems();
	}
	
	
	double bill_total=0;
	double subtotal=0;
	double tax;
	public String itemType;
	double itemPrice;
	String itemName;
	
	@Override
	public double addToCart(int id,int quantity) throws SQLException, ClassNotFoundException
	{
		
		
		itemName = itemDao.getItemName(id);
		itemType=itemDao.getItemType(id);
		itemPrice= itemDao.getItemPrice(id);
		subtotal=itemDao.calculateBill(id,quantity,itemType);
		//System.out.println("ITEM TYPE FROM SERVICE LAYER="+itemType);
		if(itemType=="CD")
		{
			tax=(subtotal)*(0.1f);
			subtotal=subtotal+tax;
		}
		if(itemType=="Cosmetics")
		{
			tax=(subtotal)*(0.12f);
			subtotal=subtotal+tax;
		}
		if(cartItems.containsKey(id))
		{
			quantity = cartItems.get(id).getQuantity()+quantity;
			cartItems.remove(id);
		}
	
			Items cartItem = null;
			cartItem = new Items();
			cartItem.setItemId(id);
			cartItem.setItemName(itemName);
			cartItem.setQuantity(quantity);
			cartItem.setUnitPrice(itemPrice);
			cartItem.setItemType(itemType);


			cartItems.put(id, cartItem);
			System.out.println("Bill Total="+bill_total);
			System.out.println("Sub Total="+subtotal);
			
		bill_total=(bill_total+subtotal);
		return bill_total;
	}
	@Override
	public HashMap<Integer, Items> getCart() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return cartItems;
	}
	
	
		
}
	