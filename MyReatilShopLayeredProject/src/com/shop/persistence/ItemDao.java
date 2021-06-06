package com.shop.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;


public interface ItemDao
{
	Collection<Items> getAllItems();
	boolean insertItem(Items item);
	//Items getCart();
}


