/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import context.DBcontext;
import entity.Cart;
import entity.Item;
import entity.Product;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Legion
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getallProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from clockdata";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }
    
    


    public Product getProductbyID(String id_clock) {
        String query = "select * from ClockData\n"
                + "where id_clock = ? ";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id_clock);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public List<Product> searchByname(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from ClockData\n"
                + "where name_clock like ? ";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }

        return list;
    }

    public Account login(String email, String pass) {
        String query = "SELECT * FROM useraccount WHERE email = ? and pass = ?";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }

        return null;
    }

    public Account Checkexist(String email) {
        String query = "SELECT * FROM useraccount WHERE email = ? ";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public void signup(String email, String pass) {
        String query = "insert into useraccount values(1,?,?,0)";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.executeUpdate();
        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public List<Product> getallProductbyPrice() {
        List<Product> list = new ArrayList<>();
        String query = "select * from ClockData order by price_clock desc";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public void Order(Account a, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            String query = "insert into orderr (date,accid,totalmoney) values (?,?,?)";
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, a.getId());
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();
            String query2 = "select accid from orderr order by id desc";
            ps = conn.prepareStatement(query2);
            rs = ps.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String query3 = "insert into oderdetail values(?,?,?,?)";
                    ps = conn.prepareStatement(query3);
                    ps.setInt(1, oid);
                    ps.setInt(2, i.getProduct().getId());
                    ps.setInt(3, i.getQuantity());
                    ps.setDouble(4, i.getPrice());
                    ps.executeUpdate();
                }
            }
        } catch (Exception e) {

            System.out.println(e);

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public int getallproductbynum() {
        String query = "select count(*) from ClockData ";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return 0;
    }

    public List<Product> getallProductbypage(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from ClockData order by id_clock limit 6 offset ? ";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)));
            }

        } catch (Exception e) {

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public void deleteProduct(String id_clock) {
        String query = "delete from clockdata where id_clock = ?";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id_clock);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String id, String image, String name, String price, String description) {
        String query = "insert into clockdata (id_clock,image_clock,name_clock,price_clock,description_clock) value (?,?,?,?,?)";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, image);
            ps.setString(3, name);
            ps.setString(4, price);
            ps.setString(5, description);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void editProduct(String id, String image, String name, String price, String description) {
        String query = "update clockdata set image_clock = ?, name_clock = ?, price_clock = ?, description_clock = ? where id_clock = ?;";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, name);
            ps.setString(3, price);
            ps.setString(4, description);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    //    public static void main (String [] args)
//    {
//        DAO dao = new DAO();
//        List<Product> list = dao.getallProductbypage(1);
//        for (Product o : list)
//        { System.out.println(o);
//        
//        }
//    }
}
