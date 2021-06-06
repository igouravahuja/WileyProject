package com.shop.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.shop.bean.Items;
import com.shop.database.ItemList;

public class ItemDaoImpl implements ItemDao
{
	@Override
	public Collection<Items> getAllItems()
	{
		HashMap<Integer,Items> items=ItemList.getItems();
		 Collection<Items> it=items.values();
		return it;
	}
	@Override
	public boolean insertItem(Items item)
	{
		ItemList.getItems().put(item.getItemId(), item);
		return true;

	}
	
	//public Items getCart()
	//{
		//Collection<Items> item=items.values();
		//return items;
	//}
}