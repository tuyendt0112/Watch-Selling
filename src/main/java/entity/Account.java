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
    private int isAdmin;
    private int isUser;
    public Account ()
    {
        
    }
    public Account (int id  , String email , String pass, String fullname, int isAdmin, int isUser)
    {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.fullname = fullname;
        this.isAdmin = isAdmin;
        this.isUser = isUser;
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

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsUser() {
        return isUser;
    }

    public void setIsUser(int isUser) {
        this.isUser = isUser;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", pass=" + pass + ", fullname=" + fullname + ", isAdmin=" + isAdmin + ", isUser=" + isUser + '}';
    }
    
    
    
}
