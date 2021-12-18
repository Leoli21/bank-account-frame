/*
 * @author ellis
 */
public class SavingsAccount extends BankAccount
{
	/**
	 * creates savings account with initial balance
	 * @param n name
	 * @param b balance
	 */
	public SavingsAccount(String n, double b)
	{
		super(n,b);

	}
	
	
	/**
	 * creates savings account with zero balance
	 * @param n name
	 */
	public SavingsAccount(String n)
	{
		super(n);

	}
}
