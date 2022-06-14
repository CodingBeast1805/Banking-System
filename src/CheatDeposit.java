import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheatDeposit 
{
	void deposit()
	{
		System.out.println("================Welcome to Deposit Section of LAKSHMI CHEAT FUND===============");
	DbConnection dc=new DbConnection();
	Connection con=dc.connect();
	Scanner s=new Scanner(System.in);
	int amount=0 , oldbalance=0;
	System.out.println("Dear account holder enter your account number : ");
	int acc_num=s.nextInt();
	
	
	try
	{
		String S="select Balance from user where accountnumber=?";
		PreparedStatement pstmt=con.prepareStatement(S);
		pstmt.setInt(1, acc_num);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			oldbalance=rs.getInt(1);
			System.out.println("Enter the amount to be Deposited");
			amount=s.nextInt();
		}
		if(amount>0)
		{
			int newbalance= oldbalance+amount;
			String S1="update user set balance=? where accountnumber=?";
			PreparedStatement pstmt1=con.prepareStatement(S1);
			pstmt1.setInt(1, newbalance);
			pstmt1.setInt(2, acc_num);
			int i=pstmt1.executeUpdate();
			if(i>0)
			{
				System.out.println("Amount is Deposited Successfully");
			}
			else
			{
				System.out.println("Amount is not Deposited ");
				
			}
		}
		else
		{
			System.out.println("Dear Cheated Account Holder you cannot enter money in -ve");
		}
		System.out.println("=============================================================");
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
