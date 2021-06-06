package com.shop.bean;

public class Items
{
	private int itemId;
	private String itemName;
	private int quantity;
	private int unitPrice;
	public Items()
	{
		
	}
	public Items(int itemId, String itemName, int quantity, int unitPrice)
	{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String toString()
	{
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	

}
