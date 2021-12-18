/*
 * @author ellis
 */

public class CheckingAccount extends BankAccount
{

	

	
	/**
	 * creates checking account with initial balance
	 * @param n name
	 * @param b balance
	 */
	public CheckingAccount(String n, double b)
	{
		super(n,b);

	}
	
	
	/**
	 * creates checking account with zero balance
	 * @param n name
	 */
	public CheckingAccount(String n)
	{
		super(n);

	}
	
	
	

}
