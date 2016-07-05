/*
ASSIGNMENT NO.: 			BATCH : T4			ROLL NO.: 
PROBLEM STATEMENT :Design and Develop SQL DDL statements which demonstrate the use of SQL objects
such as Table, View , Index using Client-Data sever(two tier)
*/

package ass2;

import java.sql.*;
//import java.sql.CallableStatement.*;
import java.util.*;

public class ass2 {          

	public static void main(String[] args) 
	{
		int ch;                            
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
				
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			System.out.println("connection successful");
			
			@SuppressWarnings("resource")
			Scanner scn = new Scanner(System.in);
			Statement sm=c.createStatement();
			//CallableStatement s = null;
			
			
			int rollno;
			String name;
			int age;
			
			do
			{   
			System.out.println("You are having following choices
....");
				
			System.out.println(" 1. Insert values in the table ");
			System.out.println(" 2. Display view before update ");
			System.out.println(" 3. Display view after update ");
			System.out.println(" 4. Create index table ");
			System.out.println(" 5. Displaying index on table ");
				
			System.out.println(" Enter your choice : ");
			ch=scn.nextInt();
				
			switch(ch)
			{
			case 1:
				System.out.println("Enter roll no : ");
				Scanner a = new Scanner(System.in);
				rollno = a.nextInt();
					
				System.out.println("Enter name : ");
				Scanner b = new Scanner(System.in);
				name = b.nextLine();
					
				System.out.println("Enter age : ");
				Scanner z = new Scanner(System.in);
				age = z.nextInt();
					
				System.out.println("\n Inserting records in table.....");
				sm.executeUpdate("INSERT INTO te VALUES ("+rollno+",'"+name+"',"+age+")");
				System.out.println("\n Success");
						
			break;
					
			case 2:
				System.out.println(" ....Displaying VIEW before updating.... ");
				String sql1 = " SELECT * FROM v";
				ResultSet rs = sm.executeQuery(sql1);
					
				while(rs.next())
				{
					int roll_no1 = rs.getInt("rollno");
					String name1 = rs.getString("name");
					
					System.out.println("rollno:" +roll_no1);
					System.out.println("name:" +name1);
				}
						
			break;
					
			case 3:
				System.out.println(" ....Displaying VIEW after updating.... ");
					
				String sql2 =" UPDATE v SET name ='viru' where rollno = 3";
				sm.executeUpdate(sql2);
				System.out.println(" view updated .... ");
					
					
				String sql3 =" SELECT * FROM v";
					
				ResultSet rs1 = sm.executeQuery(sql3);
						
				while(rs1.next())
				{
					int roll_no1 = rs1.getInt("rollno");
					String name1 = rs1.getString("name");
					
					System.out.println("rollno:" +roll_no1);
						
					System.out.println("name:" +name1);
				}
					
			break;
			
			case 4:
			  System.out.println(" Creating index on table .... ");
					
				String sql4=" CREATE INDEX i6 ON te(rollno)";
					
				sm.executeUpdate(sql4);
                     
				System.out.println(" Index is created ..... ");
					
				break;
					
					
			case 5:
				System.out.println(" Dispay index table ..... ");
						
				String sql5 = " SELECT * FROM te ";
				ResultSet rs4 = sm.executeQuery(sql5);
						
				while(rs4.next())
				{
					int roll_no1 = rs4.getInt("rollno");
							
					System.out.println("rollno:" +roll_no1);
				}
						
			break;
					
			}
			}while(ch<5);
			
			c.close();
			sm.close();
			
		}catch(Exception e)
		{
			System.out.println("Exception e");
		}
		
	}
}


/*
OUTPUT:
mysql> create table te(rollno int ,name varchar (10) ,age int);
Query OK, 0 rows affected (0.08 sec)

mysql> select * from te;
+--------+-------+------+
| rollno | name  | age  |
+--------+-------+------+
|      1 | aksh  |   19 |
|      2 | priya |   21 |
|      3 | viru  |   19 |
+--------+-------+------+
3 rows in set (0.00 sec)

mysql> create view v as select rollno,name from te;
Query OK, 0 rows affected (0.04 sec)

mysql> select * from v;
+--------+-------+
| rollno | name  |
+--------+-------+
|      1 | aksh  |
|      2 | priya |
|      3 | viru  |
+--------+-------+

driver loaded
connection successful
 You are having following choices .... 
 1. Insert values in the table 
 2. Display view before update 
 3. Display view after update 
 4. Create index table 
 5. Displaying index on table 
 Enter your choice : 
1
Enter roll no : 
4
Enter name : 
varsha
Enter age : 
19

 Inserting records in table.....

 Success
 You are having following choices .... 
 1. Insert values in the table 
 2. Display view before update 
 3. Display view after update 
 4. Create index table 
 5. Displaying index on table 
 Enter your choice : 
2
 ....Displaying VIEW before updating.... 
rollno:1
name:aksh
rollno:2
name:priya
rollno:3
name:viru
rollno:4
name:varsha
 You are having following choices .... 
 1. Insert values in the table 
 2. Display view before update 
 3. Display view after update 
 4. Create index table 
 5. Displaying index on table 
 Enter your choice : 
3
 ....Displaying VIEW after updating.... 
 view updated .... 
rollno:1
name:aksh
rollno:2
name:priya
rollno:3
name:ruchi
rollno:4
name:varsha
 You are having following choices .... 
 1. Insert values in the table 
 2. Display view before update 
 3. Display view after update 
 4. Create index table 
 5. Displaying index on table 
 Enter your choice : 
4
 Creating index on table .... 
 Index is created ..... 
 You are having following choices .... 
 1. Insert values in the table 
 2. Display view before update 
 3. Display view after update 
 4. Create index table 
 5. Displaying index on table 
 Enter your choice : 
5
 Dispay index table ..... 
rollno:1
rollno:2
rollno:3
rollno:4

*/
