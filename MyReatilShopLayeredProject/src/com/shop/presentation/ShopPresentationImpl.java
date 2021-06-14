package com.shop.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;
//import com.sujata.helper.EmployeeInputOutput;
import com.shop.service.ShopService;
import com.shop.service.ShopServiceImpl;
import com.shop.persistence.InvalidQuantityException;

import java.sql.SQLException;
import java.util.*;


public class ShopPresentationImpl implements ShopPresentation
{
	Scanner sc=new Scanner(System.in);
	private ShopService shopService=new ShopServiceImpl();
	int quantity_books,quantity_cds,quantity_cosmetics;
	double total;
	int remaining;
	
	@Override
	public void showMenu()
	{
		System.out.println();
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
				System.out.println();
				System.out.println("=========================================================");
				Collection<Items> items=shopService.getAllItems();
				for(Items item:items)
				{
					System.out.println(item);
				}
				System.out.println("=========================================================");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			break;
		case 2:
			System.out.println("Enter the number of Books You would like to Purchase:-");
			quantity_books=sc.nextInt();
			try
			{
				total=0;
				total=total+(shopService.addToCart(1,quantity_books));
				System.out.println();
				System.out.println("Item Added To Your Cart Successfully !!!!");
				System.out.println("Subtotal for Cart== "+total);
			}catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			catch(InvalidQuantityException exception)
			{
				System.out.println("Please Enter A Positive Quantity or Quantity smaller than the avaliable quantity");
				break;
			}
			System.out.println();
			System.out.println("Enter the number of CDs You would like to Purchase:-");
			quantity_cds=sc.nextInt();
			try
			{
				total=0;
				total=total+(shopService.addToCart(2,quantity_cds));
				System.out.println("Item Added To Your Cart Successfully !!!!");
				System.out.println("Subtotal for cart== "+total);
			}catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			catch(InvalidQuantityException exception)
			{
				System.out.println("Please Enter A Positive Quantity or Quantity smaller than the avaliable quantity");
				break;
			}
			System.out.println();
			System.out.println("Enter the number of Cosmetic Products You would like to Purchase:-");
			quantity_cosmetics=sc.nextInt();
			try
			{
				total=0;
				total=total+(shopService.addToCart(3,quantity_cosmetics));
				System.out.println("Item Added To Your Cart Successfully !!!!");
				System.out.println("Subtotal for cart== "+total);
			}catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			catch(InvalidQuantityException exception)
			{
				System.out.println("Please Enter A Positive Quantity or Quantity smaller than the avaliable quantity");
				break;
			}
			System.out.println();
			//System.out.println("Items Added To Your Cart Successfully !!!!");
			//System.out.println();
			System.out.println("=====Bill Summary=====");
			System.out.println();
			System.out.println("Items"+"\t"+"Quantity"+"\t"+"UnitPrice");
			System.out.println();
			System.out.println("Books"+"\t"+quantity_books+"\t"+"\t"+"500 Each");
			System.out.println("CDs"+"\t"+quantity_cds+"\t"+"\t"+"200 Each");
			System.out.println("Cosmetics  "+quantity_cosmetics+"\t"+"\t"+"1000 Each");
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println("Total Bill (Including Tax)== "+total);
			System.out.println("(10% Tax on CDs and 12% Tax on Cosmetic Products)");
			System.out.println();
			System.out.println("Thankyou For Shopping, Please Visit Again!!!");
			System.exit(0);
		case 3:
			System.out.println();
			System.out.println("Thankyou For Shopping, Please Visit Again!!!");
			System.exit(0);
		default :
			System.out.println("Invalid Choice");
		}
	}
}
