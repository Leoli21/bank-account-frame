/*
 * @author ellis
 */

public abstract class BankAccount 
{
	
	
	//name of the account holder
	private String name;
	
	//balance for account
	private double balance;
	
	/**
	 * 
	 * @param n name
	 * creates account with zero balance
	 */
	public BankAccount(String n)
	{
		
		name = n;
		balance = 0;
		
	}	
	
	
	/**
	 * creates account with balance initialized to b
	 * @param n name
	 * @param b balance
	 */
	public BankAccount(String n, double b)
	{
		if(b < 0)
			throw new IllegalArgumentException("negative deposit");
		name = n;
		balance = b;
	}
	
	/**
	 * deposit amt into account
	 * @param amt amount to deposit
	 */
	public void deposit(double amt)
	{
		balance = balance + amt;
	}
	
	
	/**
	 * withdraw amt from account
	 * @param amt amount to withdraw
	 */
	public void withdraw(double amt)
	{
		balance = balance - amt;
	}
	
	//getName method that returns the name
	public String getName()
	{
		return name;
	}
	
	//getBalance method that returns the balance
	public double getBalance()
	{
		return balance;
	}
	
	
}
