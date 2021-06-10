package com.shop.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;
//import com.sujata.helper.EmployeeInputOutput;
import com.shop.service.ShopService;
import com.shop.service.ShopServiceImpl;

import java.sql.SQLException;
import java.util.*;


public class ShopPresentationImpl implements ShopPresentation
{
	Scanner sc=new Scanner(System.in);
	private ShopService shopService=new ShopServiceImpl();
	@Override
	public void showMenu()
	{
		System.out.println("WELCOME TO XYZ REATIL SHOP");
		System.out.println("1. Display All The Items We Have For You..!");
		System.out.println("2. Add Items To Your Cart");
		System.out.println("3. Exit");
	}

	@Override
	public void performMenu(int choice)
	{
		switch(choice) {
		case 1:
			try {
				Collection<Items> items=shopService.getAllItems();
				for(Items item:items)
				{
					System.out.println(item);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			break;
		case 2:
			System.out.println("Items Added To Your Cart");
			break;
		case 3:
			System.out.println("Thankyou For Shopping, Please Visit Again!!!");
			System.exit(0);
		default :
			System.out.println("Invalid Choice");
		}
	}
}
