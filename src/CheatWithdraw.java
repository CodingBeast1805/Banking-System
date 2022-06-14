import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CheatWithdraw 

{
	void withdraw()
	{
		DbConnection dc=new DbConnection();
		Connection con=dc.connect();
		Scanner s=new Scanner(System.in);
		int amount=0, oldbalance=0;
		System.out.println("Dear Account Holder enter your account number");
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
				System.out.println("Enter the amount to be Withdrawl");
				amount=s.nextInt();
			}
			if(oldbalance>0)
			{
				if(amount>0)
				{
					int newbalance= oldbalance-amount;
					String S1="update user set balance=? where accountnumber=?";
					PreparedStatement pstmt1=con.prepareStatement(S1);
					pstmt1.setInt(1, newbalance);
					pstmt1.setInt(2, acc_num);
					int i=pstmt1.executeUpdate();
					if(i>0)
					{
						System.out.println("Withdrawl Successfully");
					}
				}
				else
				{
					System.out.println("You cant withdraw -ve money");
				}
				
			}
			else
			{
				System.out.println("Dear Cheat user please have some amount greater than 0 in your account........ ");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
