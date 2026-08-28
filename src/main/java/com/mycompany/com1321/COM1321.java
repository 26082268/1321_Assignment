/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.com1321;

/**
 *
 * @author 26082268 Seloi Rabatho Ali Junior
 * Acknowledgement: GeminiAI(for assistance where necessary)
 */
import java.util.Scanner;
public class COM1321 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Application Main Menu
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("**************************************");
        
        // Keep displaying the launch prompt until the application is closed
        while (true) {
        System.out.println("");
        System.out.print("Enter (1) to launch menu or any other key to exit : ");
        
        // Store the user's input
        String value = input.nextLine();
        System.out.println("");
        if("1".equals(value.trim())){ // Open the product menu if the user enters 1
            int choice = Products.DisplayMenu();// Get the selected menu option
            
            // What happens with the selected option
            switch(choice){
                case 1: Products.CaptureProduct();
                    break;
                case 2: Products.SearchProduct();
                    break;
                case 3: Products.UpdateProduct();
                    break;
                case 4: Products.DeleteProduct();
                    break;
                case 5: Products.PrintProductReport();
                    break;
                case 6: Products.ExitApplication();
                    break;
            }
        }
        // Exiting Application
        else{  
            Products.ExitApplication();
        } 
            
        }
    
    }
    
}
    

