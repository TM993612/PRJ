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
@Builder
@Getter
@Setter
@ToString
public class Account {
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    
    private int id;
    private String username;
    private String password;
    private String displayName;
    private String address;
    private String email;
    private String phone;
    private String role;
//    private int accID;
//    private String accName;
//    private String pass;
//    private int isSell;
//    private int isAdmin;
//
//    public Account() {
//    }
//
//    public Account(int accID, String accName, String pass, int isSell, int isAdmin) {
//        this.accID = accID;
//        this.accName = accName;
//        this.pass = pass;
//        this.isSell = isSell;
//        this.isAdmin = isAdmin;
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
//    public String getAccName() {
//        return accName;
//    }
//
//    public void setAccName(String accName) {
//        this.accName = accName;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
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
//    public int getIsAdmin() {
//        return isAdmin;
//    }
//
//    public void setIsAdmin(int isAdmin) {
//        this.isAdmin = isAdmin;
//    }
    
            
}
