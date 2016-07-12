import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the Empno");
		String empno = scanner.nextLine();
		System.out.println("Enter the Name ");
		String name = scanner.nextLine();
		System.out.println("Enter the Salary to Search");
		String salary = scanner.nextLine(); // 1111 or 1=1
		//System.out.println("Enter the Name to Search in Employee");
		//String name = scanner.nextLine();
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/amit?autoReconnect=true&useSSL=false"
				,"root","amit123456");
		if(con!=null){
			System.out.println("Connection Created...");
		}
		
		// To Insert record in the DB
		PreparedStatement pstmt = con.
				prepareStatement("insert into employee "
						+ "(id,name,salary)values(?,?,?)");
		pstmt.setInt(1, Integer.parseInt(empno));
		pstmt.setString(2, name);
		pstmt.setDouble(3, Double.parseDouble(salary));
		int rowAdded = pstmt.executeUpdate();
		if(rowAdded>0){
			System.out.println("Record Added....");
		}
		else
		{
			System.out.println("Record Not Added...");
		}
		
		// PreparedStatement Will Cache the Query and It Prevent from SQL Injection
		//Statement stmt = con.createStatement();
//		PreparedStatement pstmt = con.prepareStatement("select id , name , salary from Employee where salary=?");
//		pstmt.setDouble(1, Double.parseDouble(salary));
//		ResultSet rs =pstmt.executeQuery();
////		ResultSet rs = stmt.executeQuery("select id,name ,salary from "
////				+ "Employee where salary="+salary);
//		if(rs.next()){
//			System.out.println("Record Found...");
//		}
//		else
//		{
//			System.out.println("Record Not Found...");
//		}
		scanner.close();
		//rs.close();
		pstmt.close();
		//stmt.close();
		con.close();
				

	}

}
