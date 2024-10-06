package com.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcPsDemo 
{

    public void insert() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");
            
            String query = "insert into customer values (?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter Customer Id: ");
            int id = sc.nextInt();
            
            System.out.println("Enter Customer Name: ");
            String name = sc.nextLine();
            
            System.out.println("Enter Customer Age: ");
            int age = sc.nextInt();
            
            System.out.println("Enter Customer State: ");
            String state = sc.nextLine();
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, state);
            
            int i = ps.executeUpdate();
            if (i > 0)  System.out.println("Data Inserted");
            else        System.out.println("Data Not Inserted");
           
           
            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void update() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");

            String query = "update customer set cname=?, cage=?, cstate=? where cid=?";
            PreparedStatement ps = c.prepareStatement(query);

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Customer Id where you want to Update: ");
            int id = sc.nextInt();

            System.out.println("Enter New Customer Name: ");
            String name = sc.nextLine();

            System.out.println("Enter New Customer Age: ");
            int age = sc.nextInt();

            System.out.println("Enter New Customer State: ");
            String state = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, state);
            ps.setInt(4, id);

            int i = ps.executeUpdate();

            if (i > 0)  System.out.println("Data Updated Successfully");
            else        System.out.println("Data Not Updated");

            
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void delete() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");
            
            String query = "delete from customer where cid=?";
            PreparedStatement ps = c.prepareStatement(query);
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Id to Delete Data: ");
            int id = sc.nextInt();
            
            ps.setInt(1, id);  
            
            int i = ps.executeUpdate();
            if (i > 0)  System.out.println("Data Deleted.");
            else        System.out.println("Data Not Deleted");
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void display() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipcart", "root", "root");
            
            String query = "select * from customer";
            PreparedStatement ps = c.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
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

            System.out.println("*************************************************\n\n");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
