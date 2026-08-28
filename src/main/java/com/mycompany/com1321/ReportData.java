/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com1321;

/**
 *
 * @author 26082268
 */
public class ReportData {
    
    // Tracking the number of created ReportData objects 
    static int index=0;
    
    
    private String productCode;
    private String productName;
    private double warranty;
    private int category;
    private double price;
    private int stockLevels;
    private String supplier;
    
    // Initializing a new product record 
    public ReportData(String productCode,String productName,double warranty,int category,
            double  price,int stockLevels,String supplier){
        this.productCode = productCode;
        this.productName = productName;
        this.warranty = warranty;
        this.category = category;
        this.price = price;
        this.stockLevels = stockLevels;
        this.supplier=supplier;
        
    }
    
    // Getter methods: Retrieving product details
    public String getProductCode(){
        return this.productCode;
    }
    public String getProductName(){
        return this.productName;
    }
    public double getWarranty(){
        return this.warranty;
    }
    public int getCategory(){
        return this.category;
    }
    public double getPrice(){
        return this.price;
    }
    public int getstockLevels(){   
        return this.stockLevels;
    }
    public String getSupplier(){
        return this.supplier;
    }
    
    // Setter methods: Updating product details
    public void setProductCode(String code){
        this.productCode = code;
    }
    public void setProductName(String prodName){
        this.productName = prodName;
    }
    public void setWarranty(int month){
        this.warranty = month;
    }
    public void setCategory(int cat){
        this.category = cat;
    }
    public void setPrice(double amount){
        this.price = amount;
    }
    public void setStockLevels(int stock){
        this.stockLevels = stock;
    }
    public void setSupplier(String supply){
        this.supplier = supply;
    }
}

