package com.shop.persistence;

public class InvalidQuantityException extends RuntimeException
{
	public InvalidQuantityException(String message)
	{
		super(message);
	}
}
