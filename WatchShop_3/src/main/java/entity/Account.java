/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Legion
 */
public class Account {
    private int id;
    private String email;
    private String pass;
    private String fullname;
    private int isCustomer;
    private int isAdmin;
    
    public Account () {        
    }

    public Account(int id, String email, String pass, String fullname, int isCustomer, int isAdmin) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.fullname = fullname;
        this.isCustomer = isCustomer;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getIsCustomer() {
        return isCustomer;
    }
    
    public void setIsCustomer(int isCustomer) {
        this.isCustomer = isCustomer;
    }
    
    public int getIsAdmin() {
        return isAdmin;
    }
    
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", pass=" + pass + ", fullname=" + fullname + ", isCustomer=" + isCustomer + ", isAdmin=" + isAdmin + '}';
    }
    
    
}
