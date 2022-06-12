/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import models.Cart;
import models.Category;
import models.Order;
import models.Product;
import models.Shipping;

/**
 *
 * @author Tra My
 */
public class DAO extends DBContext {
//    Connection conn = null; //ket noi sql 
//    PreparedStatement ps = null; //cau lenh sql
//    ResultSet rs = null; //tra ve
//
//    public List<Product> getAllProduct(){
//       List<Product> list = new ArrayList<>();
//        String query = "select * from product";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
////                        rs.getObject(4, Category)
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getInt(6),
//                        rs.getInt(7)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Picture"),
                        //cat,
                        rs.getInt("Price"),
                        rs.getString("Description"),
                        rs.getInt("CategoryID"),
                        rs.getInt("sellID"));

                list.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category cat = new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("Categoryname"));

                list.add(cat);
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getAllProductByCategoryID(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product where categoryID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Picture"),
                        rs.getInt("Price"),
                        rs.getString("Description"),
                        rs.getInt("CategoryID"),
                        rs.getInt("sellID"));
                list.add(p);
            }

        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalProduct() {
        String sql = " select count(*) from Product";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product\n"
                + "  order by ProductID\n"
                + "  OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 6);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Picture"),
                        rs.getInt("Price"),
                        rs.getString("Description"),
                        rs.getInt("CategoryID"),
                        rs.getInt("sellID"));

                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

//    public int getTotalProductByCategoryId(int cateId)
//    {
//        try{
//            String sql = "select count(*) [totalP] from Product p ";
//            if (cateId!=0)
//            {
//                    sql+= "  where p.CategoryID = ?" ;
//            }
//            PreparedStatement stm = connection.prepareStatement(sql);
//            if (cateId !=0) stm.setInt(1, cateId);
//            ResultSet rs = stm.executeQuery();
//            rs.next();
//            return rs.getInt("totalP");
//        }
//        catch(Exception ex)
//        {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }
//    
//    public ArrayList<Product> getAllProductByCateIdPaging(int cateId, int offset, int pageSize)
//    {
//        ArrayList<Product> list = new ArrayList<>();
//        try{
//            String sql = "select p.*, c.CategoryName from Category c, Product p where c.CategoryID = p.CategoryID ";                   
//            if (cateId!=0) sql+= "and c.CategoryID = ?" ;
//            sql += "order by p.ProductID offset ? rows fetch next ? rows only";
//            
//            System.out.println("sql:"+sql);
//            PreparedStatement stm = connection.prepareStatement(sql);
//            if (cateId !=0) 
//            {
//                stm.setInt(1, cateId);
//                stm.setInt(2, offset);
//                stm.setInt(3, pageSize);
//            }
//            else
//            {
//                stm.setInt(1, offset);
//                stm.setInt(2, pageSize);
//            }
//            ResultSet rs = stm.executeQuery();
//            
//            while (rs.next())
//            {
//                Product p = new Product(
//                        rs.getInt("ProductID"),
//                        rs.getString("ProductName"),
//                        rs.getString("Picture"),
//                        rs.getInt("Price"),
//                        rs.getString("Description"),
//                        rs.getInt("CategoryID"),
//                        rs.getInt("sellID"));
//               p.addCategory(rs.getInt("CategoryID"), rs.getString("CategoryName"));
//                list.add(p);
//            }
//        }
//        catch(Exception ex)
//        {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    public List<Product> searchProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "  select * from Product\n"
                    + "  where ProductName like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txtSearch + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Picture"),
                        rs.getInt("Price"),
                        rs.getString("Description"),
                        rs.getInt("CategoryID"),
                        rs.getInt("sellID"));
                list.add(p);
            }

        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Product getAllProductByID(int productID) {

        try {
            String sql = "  select * from Product\n"
                    + "  where ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
//                Category cat = new Category(
//                        rs.getInt("CategoryID"),
//                        rs.getString("CategoryName"));
                return new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Picture"),
                        //cat,
                        rs.getInt("Price"),
                        rs.getString("Description"),
                        rs.getInt("CategoryID"),
                        rs.getInt("sellID"));

            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int createReturnShippingId(Shipping shipping) {
        String sql = "INSERT INTO [dbo].[Shipping]\n"
                + "           ([name]\n"
                + "           ,[phone]\n"
                + "           ,[address])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            Connection conn = new DBContext().connection;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, shipping.getName());
            ps.setString(2, shipping.getPhone());
            ps.setString(3, shipping.getAddress());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int createReturnOrderId(Order order) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([account_id]\n"
                + "           ,[totalPrice]\n"
                + "           ,[note]\n"
                + "           ,[shipping_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            Connection conn = new DBContext().connection;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getAccountId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setString(3, order.getNote());
            ps.setInt(4, order.getShippingId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void saveCart(int orderId, Map<Integer, Cart> carts) {
        try {
            String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                    + "           ([order_id]\n"
                    + "           ,[productName]\n"
                    + "           ,[productImage]\n"
                    + "           ,[productPrice]\n"
                    + "           ,[quantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
            Connection conn = new DBContext().connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer producId = entry.getKey();
                Cart cart = entry.getValue();
                ps.setString(2, cart.getProduct().getProductName());
                ps.setString(3, cart.getProduct().getPicture());
                ps.setInt(4, cart.getProduct().getPrice());
                ps.setInt(5, cart.getQuantity());
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Account login(String username, String password) {
        try {
            String sql = "select * from Account where username = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .username(rs.getString(2))
                        .password(rs.getString(3))
                        .displayName(rs.getString(4))
                        .address(rs.getString(5))
                        .email(rs.getString(6))
                        .phone(rs.getString(7))
                        .role(rs.getString(8))
                        .build()
                        ;

                return account;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

public void deleteProduct(String productId){
    String sql = "delete from Product where producID=?";
    try {
        Connection conn = new DBContext().connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productId);
            ps.executeUpdate();
    } catch (Exception e) {
    }
}

    

}
