package com.jdbc.preparedstatement;

import java.util.Scanner;

public class DemoPreparedStatement 
{
    public static void main(String[] args) 
    {
        JdbcPsDemo operation = new JdbcPsDemo();
        int option = 0;
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.println("\n*************************************************");
            System.out.println("            😊 Customer Management Menu 😊       ");
            System.out.println("*************************************************");
            System.out.println("  1. ➤ Insert New Customer Data");
            System.out.println("  2. ➤ Update Existing Customer Data");
            System.out.println("  3. ➤ Delete Customer Data");
            System.out.println("  4. ➤ Display All Customer Records");
            System.out.println("  5. ➤ Exit Program");
            System.out.println("*************************************************");
            System.out.print("👉 Choose Option: ");

            option = sc.nextInt(); 

            switch(option)
            {
                case 1:
                    operation.insert();
                    break;

                case 2:
                    operation.update();
                    break;

                case 3:
                    operation.delete();
                    break;

                case 4:
                    operation.display();
                    break;

                case 5: 
                    System.out.println(" ___________________ Program Exited (^_^) ______________________ ");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
                    break;
            }

        } while(option != 5);  

    }
}
