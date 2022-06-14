import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheatTransfer 
{
	void transfer()
	{
	
	
	DbConnection dc=new DbConnection();
	Connection con=dc.connect();
	int oldbalance=0 , amount=0,withdraw=0,balance=0;
	Scanner s=new Scanner(System.in);
	System.out.println("Enter account number from which you have to withdraw : ");
	int acc_num1=s.nextInt();
	System.out.println("Enter the account number to which you have to Deposit :");
	int acc_num2=s.nextInt();
	System.out.println("Enter the amount to be Withdraw");
	amount=s.nextInt();
	
	try
	{
		String S="select balance from user where accountnumber=?";
		PreparedStatement pstmt=con.prepareStatement(S);
		pstmt.setInt(1, acc_num1);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			 oldbalance=rs.getInt(1);
			//System.out.println("Enter the amount to be Withdraw");
			//amount=s.nextInt();
			
		}
		if(oldbalance>0)
		{
			if(amount>0)
			{
				int newbalance= oldbalance-amount;
				String S1="update user set balance=? where accountnumber=?";
				PreparedStatement pstmt1=con.prepareStatement(S1);
				pstmt1.setInt(1, newbalance);
				pstmt1.setInt(2, acc_num1);
				int i=pstmt1.executeUpdate();
				if(i>0)
				{
					System.out.println("Withdrawl Successfully");
				}
				else
				{
					System.out.println("Not Withdrawl");
				}
			}
			else
			{
				System.out.println("you cant withdraw -ve money");
			}
			
			int withdrawl =	oldbalance + amount;
			String S2="select Balance from user where accountnumber=?";
			//PreparedStatement pstmt2=con.prepareStatement(S2);
			//pstmt2.setInt(1, withdrawl);
			//pstmt2.setInt(2, acc_num2);
			//int i=pstmt2.executeUpdate();
			PreparedStatement pstmt2=con.prepareStatement(S2);
			pstmt2.setInt(1, acc_num2);
			ResultSet rs1=pstmt2.executeQuery();
			if(rs1.next())
			{
				oldbalance=rs1.getInt(1);
			
			}
			if(amount>0)
			{
			int newbalance=oldbalance+amount;
			String S3="update user set balance=? where accountnumber=?";
			PreparedStatement pstmt3=con.prepareStatement(S3);
			pstmt3.setInt(1, newbalance);
			pstmt3.setInt(2, acc_num2);
			int i=pstmt3.executeUpdate();
			if(i>0)
			{
				System.out.println("Deposited Successfully");
			}
			else
			{
				System.out.println(" Not Deposited ");
			}
			}
			else
			{
				System.out.println("-ve money cant be deposited");
			}
					
			
		}
		else
		{
			System.out.println("Dear Cheat user please have some amount greater than 0 in your account........");
		}
		
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	}
	
}
