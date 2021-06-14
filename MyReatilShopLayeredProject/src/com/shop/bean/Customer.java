
package com.shop.bean;

public class Customer
{
	private boolean LoggedIn;

	public Customer()
	{
		this.LoggedIn=false;
	}
		
	public boolean isLoggedIn() {
		return this.LoggedIn;
	}
	
	public void LogInUser() {
		this.LoggedIn = true;
	}
	
	public void LogOutUser() {
		this.LoggedIn = false;
	}
}