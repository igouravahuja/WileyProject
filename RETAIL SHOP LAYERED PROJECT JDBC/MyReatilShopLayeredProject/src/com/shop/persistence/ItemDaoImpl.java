package com.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.shop.bean.Items;
import com.shop.bean.Items;
import com.shop.helper.MySQLConnection;

public class ItemDaoImpl implements ItemDao
{
	@Override
	public Collection<Items> getAllItems() throws SQLException, ClassNotFoundException
	{
		ArrayList<Items> items = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from Items");
		ResultSet resultset = statement.executeQuery();

		Items item = null;
		items = new ArrayList<Items>();

		while (resultset.next())
		{
			item = new Items();
			item.setItemId(resultset.getInt("itemId"));
			item.setItemName(resultset.getString("itemName"));
			item.setQuantity(resultset.getInt("quantity"));
			item.setUnitPrice(resultset.getInt("unitPrice"));
			items.add(item);
		}

		connection.close();

		return items;
	}
	
	@Override
	public boolean insertItem(Items item) throws SQLException, ClassNotFoundException
	{
		//ItemList.getItems().put(item.getItemId(), item);
		return true;

	}
	
	//public Items getCart()
	//{
		//Collection<Items> item=items.values();
		//return items;
	//}
}