package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class StatementDemo
{
	
	public void addData() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart","root","root");
			
			Statement s = c.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Customer Id: ");
			int id = sc.nextInt();
			
			System.out.println("Enter Customer Name: ");
			String name = sc.next();
			
			System.out.println("Enter Customer Age: ");
			int age = sc.nextInt();
			
			System.out.println("Enter Customer State: ");
			String state = sc.next();
			
			String query = "insert into customer (cid,cname,cage,cstate) values (" + id + ", '" + name + "', '" + age + "','" + state + "')";

			int i = s.executeUpdate(query);
			
			if(i>0) System.out.println("<<<< Data Inserted >>>>");
			else    System.out.println("<<<< Data Inserted >>>>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void changeData() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart","root","root");
			
			Statement s = c.createStatement();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Customer Id which you want to Update Data : ");
			int id = sc.nextInt();
			
                        System.out.println("Set Customer Name : ");
                        String name = sc.next();
            
                        System.out.println("Set Customer Age : ");
                        int age = sc.nextInt();
            
                        System.out.println("Set Customer State : ");
                        String state = sc.next();
			
			String query = "update customer set cname = '" + name + "', cage = '" + age + "',cstate = '" + state + "' where cid = " + id;

			int i = s.executeUpdate(query);
			
			if(i>0) System.out.println("<<<< Data Updated >>>>");
			else System.out.println("<<<< Data Not Updated >>>>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteData() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart","root","root");
			
			Statement s = c.createStatement();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Customer ID which you want to Delete Data : ");
			int id = sc.nextInt();
			
			String query = "delete from customer where cid=" + id;
			
			int i = s.executeUpdate(query);
			
			if(i>0) System.out.println("<<<< Data Deleted >>>>");
			else    System.out.println("<<<< Data Not Deleted >>>>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void displayData() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart","root","root");
			
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery("select * from customer");

			System.out.println("\n*************************************************");
                        System.out.println("                📋 Customer Records 📋            ");
                        System.out.println("*************************************************");

            while (rs.next()) 
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String state = rs.getString(4);

                System.out.printf(" Customer ID: %d\n Customer Name: %s\n Customer Age: %d\n Customer State: %s\n", id, name, age, state);
                System.out.println("-------------------------------------------------");
            }

            System.out.println("*************************************************\n\n\n\n\n\n");
        } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}   
}
