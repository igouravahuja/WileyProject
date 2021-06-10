package com.shop.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;


public interface ItemDao
{
	Collection<Items> getAllItems() throws SQLException, ClassNotFoundException;;
	boolean insertItem(Items item) throws SQLException, ClassNotFoundException;;
	//Items getCart();
}


