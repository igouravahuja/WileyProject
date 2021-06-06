package com.shop.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.shop.bean.Items;

public class ItemList
{
	private static HashMap<Integer,Items> items=new HashMap<Integer, Items>();
	
	static
	{
		items.put(001, new Items(001,"Books",10, 500));
		items.put(002, new Items(002,"CDs",20, 200));
		items.put(003, new Items(003,"Cosmetics",30, 1000));
	}
	
	public static HashMap<Integer, Items> getItems()
	{
		return items;
	}

	public static void setItems(HashMap<Integer, Items> items)
	{
		ItemList.items = items;
	}

}