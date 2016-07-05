/*
ASSIGNMENT NO.: 			BATCH : T4			ROLL NO.: 
PROBLEM STATEMENT :DBMS using connections(Client-Data sever, two tier) Oracle/MySQL (ODBC/JDBC), SQL prompt to create data base tables insert, update data values, delete table, use table, select queries with/without where clause. ,demonstrate use of stored procedure / function (create procedure at the data side and make use of it on the client side)
*/


package ass2;

import java.sql.*;
import java.sql.CallableStatement;
import java.util.*;

public class ass1 {

	public static void main(String[] args) {
		
		int ch;
		
		try{
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("Driver loaded");
	    	
	    	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	    	System.out.println(" Connection successful ..... ");
	    	
	    	@SuppressWarnings("resource")
		Scanner scn = new Scanner (System.in);
	    	Statement sm = c.createStatement ();
	    	
	    	CallableStatement s = null;
	    	
	    	int roll,age;
	    	String name;
	    	
	    	do
	    	{
	    	System.out.println(" \n u have a following choice ..... ");
	    		System.out.println(" 1. Insert");
	    		System.out.println(" 2. Select"); 
	    		System.out.println(" 3. Delete");
	    	    	System.out.println(" 4. Update");
	    	   	System.out.println(" 5. Alter");
	    		System.out.println(" 6. Procedure");
	    		
	    		System.out.println(" Enter your choice : ");
	    		
	    		ch=scn.nextInt();
	    		
	    		switch(ch)
	    		{
	    		case 1 :
	    		  System.out.println(" Enter Roll Number : ");
	    			Scanner a = new Scanner (System.in);
	    			roll = a.nextInt();
	    			
	    			System.out.println(" Enter Name : ");
	    			Scanner b = new Scanner (System.in);
	    			name = b.nextLine();
	    			
				System.out.println("Enter Age : ");
	    			Scanner c1 = new Scanner (System.in);
	    			age = c1.nextInt();

	    			System.out.println("\n Inserting Records into Table .. ");
	    			
	    			sm.executeUpdate("INSERT INTO stud1 (roll,name,age) VALUES ("+roll+",'"+name+"',"+age+")");
	    			
	    			System.out.println(" \n Success.... ");
	    			
	    			break;
	    			
	    		case 2 :
				String sqll="select * from stud1 ORDER BY roll ASC,age ASC ";
	    			ResultSet rs = sm.executeQuery(sqll);
	    			
	    			while(rs.next())
	    			{
	    				int roll1 = rs.getInt("roll");
	    				String name1 = rs.getString("name");
	    				int age1 = rs.getInt("age");
	    				
	    				System.out.println("Roll:"+roll1+"\tName:"+name1+"\tAge:"+age1);
	    			}
	    			
	    			
	    			break;
	    		
	    		case 3 : 
	    			System.out.println("Enter Roll Number to be deleted: ");
		    		Scanner a1 = new Scanner (System.in);
		    		roll = a1.nextInt(); 
		    			
	    			 //  sm = c.createStatement();
	    			String sql = "DELETE FROM stud1 " +
	    	                   "WHERE roll = "+roll;
	    	           	sm.executeUpdate(sql);

	    	           	sql = "SELECT * FROM stud1 ORDER BY roll ASC,age ASC";
	    	           	ResultSet rs1 = sm.executeQuery(sql);

	    	          	while(rs1.next())
		    		{
		    			int roll1 = rs1.getInt("roll");
		    			String name1 = rs1.getString("name");
		    			int age1 = rs1.getInt("age");
		    				
		    			System.out.println("Roll:"+roll1+"\tName:"+name1+"\tAge:"+age1);
		    		}
	    			
	    		
	    			break;
	    			
	    			
	    		case 4 :
				System.out.println("Creating statement...");
	    			 
	    		   	sm = c.createStatement();
	    		     
	    		     	System.out.println("Enter roll no to be updated : ");
	    		     	Scanner a2 = new Scanner (System.in);
		    		roll = a2.nextInt(); 
		    			
		    		System.out.println("Enter new roll no  : ");
		    		Scanner a3 = new Scanner (System.in);
			    	int roll1 = a3.nextInt();
		    		
		    		System.out.println("Enter new Name : ");
		    		Scanner b1 = new Scanner (System.in);
		    		name = b1.nextLine();
		    			
		    		System.out.println("Enter new Age : ");
		    		Scanner c2 = new Scanner (System.in);
		    		age = c2.nextInt();
		    		
	    		     
	    		     	String sql3 = "update stud1 set age="+age+" where roll="+roll;
	    		     	sm.executeUpdate(sql3);
	    		     
	    		    	String sql4 = "update stud1 set name='"+name+"' where roll="+roll;
	    		    	sm.executeUpdate(sql4);
	    		     
	    		 
	    		    	String sql2 = "update stud1 set roll="+roll1+" where roll="+roll;
	    		     	sm.executeUpdate(sql2);

	    		     	sql2 = "SELECT * FROM stud1 ORDER BY roll ASC,age ASC";
	    		     	ResultSet rs2 = sm.executeQuery(sql2);

	    		     	while(rs2.next())
		    		{
		    			int roll2 = rs2.getInt("roll");
		    			String name1 = rs2.getString("name");
		    			int age1 = rs2.getInt("age");
		    				
		    			System.out.println("Roll:"+roll2+"\tName:"+name1+"\tAge:"+age1);
		    		}
	    		      
	    		      
	    		      break;
	    		      
	    		case 5:
	    			System.out.println(" Creating statement...");
	    			 
	    			sm = c.createStatement();
	    				
	    			String sql3 = " ALTER TABLE stud1 ADD Date_of_birth date ";
	    				
	    	            	sm.executeUpdate(sql3);
	    	            
	    	            	System.out.println(" Table alter sucessfully .... ");
	    	            
	    	         break;
	    	        
	    	  
	    		case 6 :
				System.out.println(" Preparing call..... ");
	    			String sql1="{call getname(?,?)}";
	    			s=c.prepareCall(sql1);
	    			
	    			System.out.println("enter roll no.  : ");
	    		    	Scanner a4 = new Scanner (System.in);
		    		int r = a4.nextInt();
	 
	    			s.setInt(1, r);
	    			s.registerOutParameter(2, java.sql.Types.VARCHAR);
	    			
	    			System.out.println("Executing stored procedure..... ");
	    			
	    			s.execute();
	    			
	    			String Name = s.getString(2);
	   			System.out.println("Student Name with Roll : "+r+" is : "+Name);
	    			
	    			s.close();
	    			c.close();
	    			
	    		}
	    	}while(ch<6);
	    	
	    	c.close();
	    	sm.close();
	    	
	    	
	    }
			catch(Exception e)
			{
				System.out.println("Exception:"+e);
			}
	   
	
	}
	
}


/*
OUTPUT :
mysql> create table stud1 (roll int, name varchar (20) , age int);
Query OK, 0 rows affected (0.09 sec)

mysql> describe stud1;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| roll  | int(11)     | YES  |     | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
| age   | int(11)     | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> delimiter $$
mysql> create procedure getname (in roll_no int, out stud_name varchar (20))
    -> begin
    -> select name into stud_name from stud1
    -> where roll=roll_no;
    -> end $$
Query OK, 0 rows affected (0.00 sec)

Driver loaded
 Connection successful ..... 
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
1
 Enter Roll Number : 
2
 Enter Name : 
varu
Enter Age : 
19

 Inserting Records into Table .. 
 
 Success.... 
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
1
 Enter Roll Number : 
3
 Enter Name : 
rucha
Enter Age : 
20

 Inserting Records into Table .. 
 
 Success.... 
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
1
 Enter Roll Number : 
5
 Enter Name : 
prajkta
Enter Age : 
20

 Inserting Records into Table .. 
 
 Success.... 
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
2
Roll:2	Name:varu	Age:19
Roll:3	Name:rucha	Age:20
Roll:5	Name:prajkta	Age:20
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
3
Enter Roll Number to be deleted: 
3
Roll:2	Name:varu	Age:19
Roll:5	Name:prajkta	Age:20
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
4
Creating statement...
Enter roll no to be updated : 
5
Enter new roll no  : 
4
Enter new Name : 
ruchi
Enter new Age : 
19
Roll:2	Name:varu	Age:19
Roll:4	Name:ruchi	Age:19
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
5
 Creating statement...
 Table alter sucessfully .... 
 
 u have a following choice ..... 
 1. Insert
 2. Select
 3. Delete
 4. Update
 5. Alter
 6. Procedure
 Enter your choice : 
6
 Preparing call..... 
enter roll no.  : 
2
Executing stored procedure..... 
Student Name with Roll : 2 is : varu

*/
