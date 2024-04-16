//SHIPPING MANAGEMENT SYSTEM
import java.sql.*;
import java.util.*;
class Shippingmanagement
{
String name,shiptype;
long contact;
int quantity,picdate,pictime,disdate,distime;
PreparedStatement ps;
Connection con;
Scanner sc=new Scanner(System.in);
void inserting()                                            //INSERT FUNCTION
{
try
{
System.out.println("\t\t\t<<<<< Inserting >>>>>");
System.out.print("\nEnter Dealer name: ");
name=sc.next();
System.out.print("\nEnter Quantity: ");
quantity=sc.nextInt();
System.out.print("\nEnter Picked Date: ");
picdate=sc.nextInt();
System.out.print("\nEnter Picked Time: ");
pictime=sc.nextInt();
System.out.print("\nEnter Dispatched Date: ");
disdate=sc.nextInt();
System.out.print("\nEnter Dispatched Time: ");
distime=sc.nextInt();
System.out.print("\nEnter Customer Contact: ");
contact=sc.nextLong();
System.out.print("\nEnter Shipping Type: ");
shiptype=sc.next();
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shippingmanagement","root","");
ps=con.prepareStatement("insert into fulfilment values(?,?,?,?,?,?,?,?)");
ps.setString(1,name);
ps.setInt(2,quantity);
ps.setInt(3,picdate);
ps.setInt(4,pictime);
ps.setInt(5,disdate);
ps.setInt(6,distime);
ps.setLong(7,contact);
ps.setString(8,shiptype);
ps.executeUpdate();
System.out.println("\n\t\t\t Data Saved Successfully");
}
catch(SQLException excep)
{
excep.printStackTrace();
}
catch(Exception e)
{
e.printStackTrace();
}
}
void updating()                                                      //UPDATE FUNCTION
{
	try
	{
		long c2;
		String n,st;
		int q,pd,pt,dd,dt;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shippingmanagement","root","");
		System.out.println("\t\t\t<<<<< Updating >>>>>");
		System.out.print("\nEnter Dealer name:");
		n=sc.next();
		System.out.print("\nEnter Quantity: ");
		q=sc.nextInt();
		System.out.print("\nEnter Picked Date: ");
		pd=sc.nextInt();
		System.out.print("\nEnter Picked Time: ");
		pt=sc.nextInt();
		System.out.print("\nEnter Dispatched Date: ");
		dd=sc.nextInt();
		System.out.print("\nEnter Dispatched Time: ");
		dt=sc.nextInt();
		System.out.print("\nEnter Customer Contact: ");
		c2=sc.nextLong();
		System.out.print("\nEnter Shipping Type: ");
        st=sc.next();
		ps=con.prepareStatement("update fulfilment set Dealername=(?),Quantity=(?),PickedDate=(?),PickedTime=(?),DispatchedDate=(?),DispatchedTime=(?),Customcontact=(?),Shipping=(?)");
		ps.setString(1,n);
		ps.setInt(2,q);
		ps.setInt(3,pd);
		ps.setInt(4,pt);
		ps.setInt(5,dd);
		ps.setInt(6,dt);
		ps.setLong(7,c2);
		ps.setString(8,st);
		ps.executeUpdate();
		System.out.println("\n\t\t\t Data Updated Successfully");
	}
	catch(SQLException excep)
	{
	excep.printStackTrace();
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
}
void deleting()                                                //DELETE FUNCTION
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shippingmanagement","root","");
		System.out.print("\t\t\t<<<<< DELETING >>>>>\n");
		System.out.print("\nEnter the dealer name: ");
		String n1=sc.next();
		ps=con.prepareStatement("delete * from fulfilment where (Dealername=(?))");
		ps.setString(1,n1);
		ps.executeUpdate();
		System.out.print("\n\t\t\t Data Deleted Successfully");
	}
	catch(SQLException excep)
	{
	excep.printStackTrace();
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
}
void selecting()                                          //SELECT FUNCTION
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shippingmanagement","root","");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from fulfilment");
		while (rs.next())
		{
			System.out.println("Dealer Name: "+rs.getString(1));
			System.out.println("Quantity: "+rs.getInt(2));
			System.out.println("Picked Date: "+rs.getInt(3));
			System.out.println("Picked Time: "+rs.getInt(4));
			System.out.println("Dispatched Date: "+rs.getInt(5));
			System.out.println("Dispatched Time: "+rs.getInt(6));
			System.out.println("Custom Contact: "+rs.getInt(7));
			System.out.println("Shipping Type: "+rs.getString(8));
			System.out.print("-------------------------------- \n");
		}
	}
	catch(Exception e)
	{
		System.out.println("Server Error!");
	}
	}
	void exiting()                                               //EXIT FUNCTION
	{
		System.out.println("\n\n\t\t\t\t-----> Exited <-----");
		System.exit(0);
	}
	public static void main(String args[])                           //MAIN FUNCTION
	{
		Shippingmanagement m=new Shippingmanagement();
		int choice;
		Scanner sc= new Scanner(System.in);
		System.out.print("\n\t\t\t <<<<< SHIPPING MANAGEMENT SYSTEM >>>>>\n ");
		System.out.print("\n\t\t\t 1 > INSERT \n\n\t\t\t 2 > UPDATE \n\n\t\t\t 3 > DELETE \n\n\t\t\t 4 > SELECT \n\n\t\t\t 5 > EXIT  ");
		System.out.print("\n\n\t\t\t\tEnter the Choice : ");
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:
			m.inserting();
			break;
			
			case 2:
			m.updating();
			break;
			
			case 3:
			m.deleting();
			break;
			
			case 4:
			m.selecting();
			break;
			
			case 5:
			m.exiting();
			break;
			
			default:
			System.out.println("\n Invalid Choice");
		}
	}
}
