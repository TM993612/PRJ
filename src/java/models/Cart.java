/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Tra My
 */

//@Data
@Builder
@Getter
@Setter
@ToString
public class Cart {
//    private int accID;
//    private int productID;
//    private int quantity;
//
//    public Cart() {
//    }
//
//    public Cart(int accID, int productID, int quantity) {
//        this.accID = accID;
//        this.productID = productID;
//        this.quantity = quantity;
//    }
//
//    public int getAccID() {
//        return accID;
//    }
//
//    public void setAccID(int accID) {
//        this.accID = accID;
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
//    public int getAmount() {
//        return quantity;
//    }
//
//    public void setAmount(int quantity) {
//        this.quantity = quantity;
//    }
    
    private Product product;
    private int quantity;


    
    
    
}
