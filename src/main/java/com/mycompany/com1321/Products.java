/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com1321;


import java.util.Scanner;

/**
 *
 * @author 26082268
 */
public class Products {
    
static Scanner input = new Scanner(System.in);
    // Array: Storing Product records
    static ReportData[] storeItems = new ReportData[10]; 
        
    public static int DisplayMenu(){
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print report.");
        System.out.println("(6) Exit Application.");
        int choice = 0;
        System.out.print("SELECTION: ");
        while(true){
            choice = input.nextInt();
            input.nextLine();
            if(!(choice > 0 && choice < 7)){
                System.out.print("Selection must be between 1 and 6"); 
                continue;
            }
            System.out.println("");
            return choice;
        }
    }
    // CAPTURING AND STORING THE INFORMATION OF A NEW PRODUCT
    public static void CaptureProduct(){
        // INDICATION OF MAX CAPACIY
        if(ReportData.index >= storeItems.length){
            System.out.println("Max number of products has been reached");
            return;
        }
        else{
             System.out.println("**************************");
            System.out.println("CAPTURE A NEW PRODUCT");
            System.out.println("**************************");
            
            System.out.print("Enter the product code:");
            String prodCode = input.nextLine();
            // CHECKING FOR PRIOR EXISTENCE
            for(int i=0;i<ReportData.index;i++){
                if(storeItems[i]!=null && storeItems[i].getProductCode().equalsIgnoreCase(prodCode)){
                    System.out.println("Product "+storeItems[i].getProductName()+" is already in the system");
                   
                    return;
                }
            }
            
            System.out.print("Enter the product name:");
            String prodName = input.nextLine();
            
            System.out.println("");
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Enter Product Category: ");
            int category;
            // CHECKING FOR VALIDITY OF INFORMATION.
            while(true){
                category = input.nextInt();
                input.nextLine();
                if(category < 1 || category > 5){
                    System.out.println("Selection must be between 1 and 5");
                    continue;
                }
                break;
            }
            System.out.println("");
            System.out.print("Determine the product warranty. Enter (1) for 6 months or any other key for 2 years. ");
            String warranty = input.nextLine();
            double warrantyMonths;
            if("1".equals(warranty.trim())){
                warrantyMonths = 6;
            }
            else{
                warrantyMonths = 24;
            }
            System.out.println("");
            System.out.print("Enter the price for " + prodName + ": ");
            double price;
            while(true){
                price = input.nextDouble();
                input.nextLine();
                if(price < 0){
                    System.out.println("Price cannot be negative! Please re-enter the price:");
                    continue;
                }
                break;
            }
            
            int stock;
            // Entering stock level
            while(true){
                System.out.print("Enter Stock level for " + prodName + ": ");
                stock = input.nextInt();
                input.nextLine();
                if(stock < 0){
                    System.out.println("Stock cannot be negative!");
                    continue;
                }
                break;
            }
            
            System.out.print("Enter the supplier for " + prodName + ": ");
            String supplier = input.nextLine();
            
            ReportData i1 = new ReportData(prodCode.trim(), prodName.trim(), warrantyMonths, category, price, stock, supplier);
            SaveProduct(i1);
        }
    }
   // Saving the record in the next available array position.
    public static void SaveProduct(ReportData i1){
        // Storing the record
        storeItems[ReportData.index] = i1;  
        ReportData.index++;
        System.out.println("Product details has been saved successfully!");
    }
// Searching for a product using the product code.
    public static void SearchProduct(){
        System.out.print("Please enter the product code to search: ");
        String prodCode = input.nextLine();
        
        for(int i = 0; i < ReportData.index; i++){
            if(storeItems[i] != null && storeItems[i].getProductCode().equals(prodCode)){
                System.out.println("*************************************************");
                System.out.println("PRODUCT SEARCH RESULTS");
                System.out.println("*************************************************");
                System.out.println("PRODUCT CODE: " + storeItems[i].getProductCode());
                System.out.println("PRODUCT NAME: " + storeItems[i].getProductName());
                System.out.println("PRODUCT WARRANTY: " + (storeItems[i].getWarranty()) + " months");
                System.out.println("PRODUCT CATEGORY: " + CategName(storeItems[i].getCategory()));
                System.out.println("PRODUCT PRICE: R" + storeItems[i].getPrice());
                System.out.println("PRODUCT STOCK LEVELS: " + storeItems[i].getstockLevels());
                System.out.println("PRODUCT SUPPLIER: " + storeItems[i].getSupplier());
                return;
            }   
        }
        System.out.println("Invalid product! Try re-entering the product's information");
    }
    // Removing the product after comfirmation.
    public static void DeleteProduct(){
        System.out.print("Please enter the product code to delete: ");
        String prodCode = input.nextLine();
        boolean found = false;
        
        // Searching stored products
        for(int i = 0; i < ReportData.index; i++){ 
            
            // Ensure the current position contains a valid product
            if(storeItems[i] != null && storeItems[i].getProductCode().equals(prodCode)){ 
                found = true;
                System.out.println("Are you sure that you want to delete? (y) for yes, any other key to cancel");
                String confirm = input.nextLine();
                if("y".equalsIgnoreCase(confirm.trim())){
                    
                    // Shifting remaining products one position to the left 
                    for (int j = i; j < ReportData.index - 1; j++) {
                        storeItems[j] = storeItems[j + 1];
                    }
                    // Clearing the last array position after shifting
                    storeItems[ReportData.index - 1] = null;
                    
                    // Reduce the product count
                    ReportData.index--; 
                    System.out.println("Deletion Successful.");
                    break;
                }
                // Execution of successful deletion.
                else{
                    System.out.println("Cancellation Successful");
                }
            } 
        } 
        // Only true if variable found is still false meaning when product was not found
        if(!found){
            System.out.println("The product was not found in the system");
        }
        
    }
    // Updating the stock record
    public static void UpdateProduct(){
    System.out.print("Please enter the product code to update: ");
    String prodCod = input.nextLine().trim();
    boolean code = false;
    
    for(int i = 0; i < ReportData.index; i++){
        if(storeItems[i] != null && storeItems[i].getProductCode().equals(prodCod)){
            code = true;
            
            // Updating the product name section
            System.out.print("Update the warranty? (y) Yes, (n) No ");
            while(true){
                String warrInput = input.nextLine().trim().toLowerCase();
                if(warrInput.isEmpty()){
                    System.out.print("Please enter 'y' or 'n': ");
                    continue;
                }
                char month = warrInput.charAt(0);
                
                if(month == 'y'){
                    System.out.print("Indicate the new product warranty. Enter (1) for 6 months or any other key for 2 years. ");
                    String warranty = input.nextLine();
                    if("1".equals(warranty.trim())){
                        storeItems[i].setWarranty(6);
                    }
                    else{
                        storeItems[i].setWarranty(24);
                    }
                    break;
                }
                else if(month == 'n'){
                    System.out.println("It won't be changed then"); 
                    break;
                }
                else{
                    System.out.print("Invalid character entered! Try again (y/n): ");
                }
            }
            
            // Updating Price
            System.out.print("Update the price? (y) Yes, (n) No ");
            while(true){
                String costInput = input.nextLine().trim().toLowerCase();
                if(costInput.isEmpty()){
                    System.out.print("Please enter 'y' or 'n'>> ");
                    continue;
                }
                char cost = costInput.charAt(0);
                
                if(cost == 'y'){
                    while(true){
                        System.out.print("Enter the new price for >> " + storeItems[i].getProductName() + " ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        storeItems[i].setPrice(amount);
                        break;
                    } 
                    break;
                }
                else if(cost == 'n'){
                    System.out.println("Continuing...");
                    break;
                }
                else{
                    System.out.print("Invalid key! Try again (y/n) >> ");
                }
            }
            
            // Updating Stock Level.
            System.out.print("Update the stock level? (y) Yes, (n) No ");
            while(true){
                String choiceInput = input.nextLine().trim().toLowerCase();
                
                if (choiceInput.isEmpty()) {
                    System.out.print("Please enter 'y' or 'n' >> ");
                    continue;
                }
                choiceInput = choiceInput.toLowerCase();
                char stock = choiceInput.charAt(0);
                
                if(stock == 'y'){
                    while(true){
                        System.out.print("Enter the new stock level for " + storeItems[i].getProductName() + " >> ");
                        int stockLevel = input.nextInt();
                        input.nextLine();
                        
                        //changing stock level
                        if(stockLevel >= 0){
                            storeItems[i].setStockLevels(stockLevel);
                            break; 
                        }
                        else{
                            System.out.println("Stock cannot be negative!");
                        }
                    }
                    break; 
                }
                else if(stock == 'n'){
                    System.out.println("Stock level left unchanged.");
                    break; 
                }
                else{
                    System.out.print("Invalid Key! Enter (y) for Yes or (n) for No >> ");
                } 
            }
            
            // Successful Product Update
            System.out.println("Product details updated successfully!!!");
            
            return; 
        }
    } 
    
    //If product is not found
    if(!code){
        System.out.println("Product not found");
        
    }
}
    public static void PrintProductReport(){
        System.out.println("PRODUCT REPORT");
        System.out.println("=====================================================================================");
        
        //to ensure non-empty array
        if(ReportData.index == 0){
            System.out.println("No products available.");
            System.out.println("");
            
            return;
        }
        double total = 0;
        for(int i = 0; i < ReportData.index; i++){
            total += storeItems[i].getPrice() * storeItems[i].getstockLevels();
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("PRODUCT CODE >> " + storeItems[i].getProductCode());
            System.out.println("PRODUCT NAME >> " + storeItems[i].getProductName());
            double warranty = storeItems[i].getWarranty() * 12;
            System.out.println("PRODUCT WARRANTY >> " + warranty+ " months");
            System.out.println("PRODUCT CATEGORY >> " + CategName(storeItems[i].getCategory()));
            System.out.println("PRODUCT PRICE >> " + storeItems[i].getPrice());
            System.out.println("PRODUCT STOCK LEVELS >> " + storeItems[i].getstockLevels());
            System.out.println("PRODUCT SUPPLIER >> " + storeItems[i].getSupplier());
            System.out.println("-------------------------------------------------------------------------------------");  
        }
        System.out.println("==================================================================================");
        System.out.println("TOTAL PRODUCT COUNT >> " + ReportData.index);
        System.out.println("TOTAL PRODUCT VALUE >> R " + total);
        double average = total / ReportData.index;
        System.out.println("AVERAGE PRODUCT VALUE >> R " + average);
        System.out.println("==================================================================================");
        
    }
    public static String CategName(int category){
        switch (category) {
            case 1:
                return "Desktop Computer";
            case 2:
                return "Laptop";
            case 3:
                return "Tablet";
            case 4:
                return "Printer";
            case 5:
                return "Gaming Console";
            default:
                break;
        }
        return "";
    }
    public static void ExitApplication(){
        System.exit(0);
    }
}
