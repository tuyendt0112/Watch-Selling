/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Legion
 */
public class DBcontext {
    
    public Connection getConnection () throws Exception{
        String url = "jdbc:mysql://remotemysql.com:3306/ON7BcSSrM3";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,userID,password);
    }
    private final String userID = "ON7BcSSrM3";
    private final String password = "NqhhsWCMKw";
//    public static void main (String [] args) 
//    {
//        try{
//            System.out.println(new DBcontext().getConnection());
//            
//        }catch (Exception e){
//            
//        }
//    }
}
