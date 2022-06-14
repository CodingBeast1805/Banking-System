import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class CheatUser 
{
	void createUser()
	{
		DbConnection dc=new DbConnection();
		Connection con=dc.connect();
		System.out.println("=======Welcome to Account Creation Section of LAKSHMI CHEAT FUND=======");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Dear Account Holder name : ");
		String username=s.next();
		System.out.println("Enter your City Name : ");
		String city=s.next();
		System.out.println("Enter your State Name : ");
		String state=s.next();
		System.out.println("Enter Pincode Number  : ");
		int pincode=s.nextInt();
		System.out.println("Enter your Residential Address : ");
		String address=s.next();
		System.out.println("Enter your Mobile Number : ");
		int mob_no=s.nextInt();
		System.out.println("Dear " +username+ " Deposit Money for creating account ");
		int balance=s.nextInt();
		
		int acc_num=0;
		
		try
		{
			
			String S ="insert into user values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(S);
			pstmt.setInt(1, acc_num);
			pstmt.setString(2, username);
			pstmt.setString(3, city);
			pstmt.setString(4, state);
			pstmt.setInt(5, pincode);
			pstmt.setString(6, address);
			pstmt.setInt(7, mob_no);
			pstmt.setInt(8, balance);
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				System.out.println("Dear Cheated Account Holder, " +username+ "  your account is created Successfully......  ");
			}
			else
			{
				System.out.println("Unfortunately your account is not created due to wrong Information......");
			}
			System.out.println("=============================================================");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
