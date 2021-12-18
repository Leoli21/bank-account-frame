import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/***
 * 
 * @author Leo Li
 * Ellis National Bank Account Creation Form 
 *
 */
public class BankAccountFrame extends JFrame
{
	public ArrayList<BankAccount> BankAccounts;
	
	
	public BankAccountFrame()
	{
		BankAccounts = new ArrayList<BankAccount>();
		setTitle("Ellis National Bank");
		setBounds(100,100,500,250);
		getContentPane().setBackground(new Color(119,136,153));
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankAccountFrame.class.getResource("/logo/Ellis National Bank Logo.png")));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx= 0;
		gbc.gridy=0;
		
		JLabel accountName = new JLabel("Account Name: ");
		accountName.setOpaque(true);
		accountName.setBackground(new Color(211,211,211));
		accountName.setFont(new Font("Helvetica Neue", Font.BOLD,14));
		accountName.setPreferredSize(new Dimension(110,30));
		gbc.gridwidth = 1;
		add(accountName, gbc);
		
		JTextField inputAcctName = new JTextField();
		inputAcctName.setFont(new Font("Helvetica Neue", Font.PLAIN,14));
		inputAcctName.setPreferredSize(new Dimension(110,30));
		gbc.gridx=1;
		gbc.gridwidth = 1;
		add(inputAcctName,gbc);
		
		String[] accountTypes = {"Select Account Type", "Checking", "Savings"};
		JComboBox<String> accountType = new JComboBox<String>(accountTypes);
		accountType.setFont(new Font("Helvetica Neue", Font.BOLD,14));
		accountType.setPreferredSize(new Dimension(220,30));
		gbc.gridx=0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		add(accountType,gbc);
		
		JCheckBox initialDeposit = new JCheckBox("Initial Deposit:");
		initialDeposit.setFont(new Font("Helvetica Neue", Font.BOLD,12));
		initialDeposit.setPreferredSize(new Dimension(110,30));
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth = 1;
		add(initialDeposit,gbc);
		
		JTextField inputInitDeposit = new JTextField();
		inputInitDeposit.setFont(new Font("Helvetica Neue", Font.PLAIN,14));
		inputInitDeposit.setPreferredSize(new Dimension(110,30));
		inputInitDeposit.setEnabled(false);
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.gridwidth = 1;
		add(inputInitDeposit,gbc);
		
		initialDeposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(initialDeposit.isSelected())
				{
					inputInitDeposit.setEnabled(true);
				}
				else
				{
					inputInitDeposit.setEnabled(false);
				}
				
			}
			
		});
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setFont(new Font("Helvetica Neue", Font.BOLD,16));
		createAccount.setPreferredSize(new Dimension(220,40));
		createAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				double initialDepositValue = 0.0;
				if(!accountName.getText().equals("Account Name: ") && !accountType.getSelectedItem().equals("Select Account Type")) 
				{
					//Account with Initial Deposit
					if(initialDeposit.isEnabled() && !inputInitDeposit.getText().equals(""))
					{
						try {
							initialDepositValue = Double.parseDouble(inputInitDeposit.getText());
							if(initialDepositValue < 0)
								throw new IllegalArgumentException("Value must be Non-negative.");
					
							if(accountType.getSelectedItem().equals("Checking"))
							{								
								BankAccounts.add(new CheckingAccount(inputAcctName.getText(),initialDepositValue));
								System.out.println("Checking Account Successfully Created");
							}
							else
							{
								BankAccounts.add(new SavingsAccount(inputAcctName.getText(),initialDepositValue));
								System.out.println("Savings Account Successfully Created");
							}
							inputAcctName.setText("");
							accountType.setSelectedIndex(0);
							initialDeposit.setSelected(false);
							inputInitDeposit.setText("");
							inputInitDeposit.setEnabled(false);
						}
						catch(Exception ex){
							System.out.println("You did not input a numeric or positive deposit value.");
						}
					}
					else //Create Account without Initial Deposit
					{
						if(accountType.getSelectedItem().equals("Checking"))
						{
							BankAccounts.add(new CheckingAccount(inputAcctName.getText()));
							System.out.println("Checking Account Successfully Created");
						}
						else
						{
							BankAccounts.add(new SavingsAccount(inputAcctName.getText()));
							System.out.println("Savings Account Successfully Created");
						}
						inputAcctName.setText("");
						accountType.setSelectedIndex(0);
						initialDeposit.setSelected(false);
						inputInitDeposit.setText("");
						inputInitDeposit.setEnabled(false);
					}
		
				}
				else 
				{
					System.out.println("Account Creation Failed: Input an Account Name and/or Select an Account Type");
				}							
			}
			
		});
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth = 2;
		add(createAccount,gbc);
		
		this.setResizable(false);
		
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
	
	public static void main(String[] args)
	{
		new BankAccountFrame();
	}
	
}
