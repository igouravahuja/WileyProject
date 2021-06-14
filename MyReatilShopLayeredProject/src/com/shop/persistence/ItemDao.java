package com.shop.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;


public interface ItemDao
{
	Collection<Items> getAllItems() throws SQLException, ClassNotFoundException;
	double calculateBill(int id,int quantity,String itemType) throws SQLException, ClassNotFoundException;
	String getItemType(int id) throws SQLException, ClassNotFoundException;
}


