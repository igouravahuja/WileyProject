package com.shop.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.shop.bean.Items;
import com.shop.bean.Customer;
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
	int quantity;
	double total;
	int remaining;
	int itemId;
	char more;
	char choose;
	
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
				System.out.println("Item ID"+"\t"+"Item Name"+"\t"+"\t"+"Item Type");
				for(Items item:items)
				{
					System.out.print(item.getItemId()+"\t");
					System.out.print(item.getItemName()+"\t");
					System.out.println(item.getItemType()+"\t");
				}
				System.out.println("=========================================================");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			break;
		case 2:
			Customer customer=new Customer();
			if(!customer.isLoggedIn())
				{
					System.out.println("You are not currently logged in, Would you like to Login First or Exit ?(Y/N)");
					choose=sc.next().charAt(0);
					if(choose=='Y'|| choose=='y')
					{
						customer.LogInUser();
						System.out.println("Login Complete, you can add items to your cart now !!");
						do
						{
							System.out.println("Enter the Item Id For the Item, you would like to Purchase:-");
						itemId=sc.nextInt();
						System.out.println("Enter the quantity for the selected item:-");
						quantity=sc.nextInt();
						
						try
						{
							total=0;
							total=total+(shopService.addToCart(itemId,quantity));
							System.out.println("Added To Your Cart Successfully !!!!");
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
						System.out.println("Want to Add More Items (Y/N)?");
						more=sc.next().charAt(0);
						}while(more!='N');
						//getCartTotal();
						break;
					}
						
					}
					else
					{
						break;
					}
			
			/*System.out.println("=====Bill Summary=====");
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
			System.exit(0);*/
		case 3:
			System.out.println();
			System.out.println("Thankyou For Shopping, Please Visit Again!!!");
			System.exit(0);
		default :
			System.out.println("Invalid Choice");
		}
	}
}
