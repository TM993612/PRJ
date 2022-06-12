/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



/**
 *
 * @author Tra My
 */

public class Product {
    private int productID;
    private String productName;
    private String picture;
    private int price;
    private String desc;
    private int categoryID;
    private int isSell;


    public Product() {
    }

    public Product(int productID, String productName, String picture, int price, String desc, int categoryID, int isSell) {
        this.productID = productID;
        this.productName = productName;
        this.picture = picture;
        this.price = price;
        this.desc = desc;
        this.categoryID = categoryID;
        this.isSell = isSell;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", picture=" + picture + ", price=" + price + ", desc=" + desc + ", categoryID=" + categoryID + ", isSell=" + isSell + '}';
    }

//    public Product(int productID, String productName, String picture, int price, String desc, int categoryID, int isSell) {
//        this.productID = productID;
//        this.productName = productName;
//        this.picture = picture;
//        this.price = price;
//        this.desc = desc;
//        this.categoryID = categoryID;
//        this.isSell = isSell;
////        this.category = category;
//    }
//
//    public int getProductID() {
//        return productID;
//    }
//
//    public void setProductID(int productID) {
//        this.productID = productID;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public int getCategoryID() {
//        return categoryID;
//    }
//
//    public void setCategoryID(int categoryID) {
//        this.categoryID = categoryID;
//    }
//
//    public int getIsSell() {
//        return isSell;
//    }
//
//    public void setIsSell(int isSell) {
//        this.isSell = isSell;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//    
//    public void addCategory(int id, String cateName)
//    {
//        Category c = new Category(id, cateName);
//        this.category = c;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" + "productID=" + productID + ", productName=" + productName + ", picture=" + picture + ", price=" + price + ", desc=" + desc + ", categoryID=" + categoryID + ", isSell=" + isSell + ", category=" + category + '}';
//    }


   
    
    
}
