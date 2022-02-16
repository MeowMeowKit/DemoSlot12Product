/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.daos;

import fu.ex.dbhelper.RepoConnector;
import fu.ex.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author LCCuong
 */
public class ProductDAO {

    public ArrayList<Product> getAllProducts() throws NamingException, SQLException {

        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Products";

        ArrayList<Product> lst = new ArrayList<>();

        try {
            conn = RepoConnector.makeConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("ProductId");
                    String name = rs.getString("ProductName");
                    String description = rs.getString("ProductDescription");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String imgURL = rs.getString("ImageUrl");

                    Product p = new Product(id, name, description, quantity, price, imgURL);
                    lst.add(p);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lst;
    }

    public Product getProductByID(String pid) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Products WHERE ProductId=?";
        try {
            conn = RepoConnector.makeConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, pid);
                rs = preStm.executeQuery();

                if (rs.next()) {
                    String id = rs.getString("ProductId");
                    String name = rs.getString("ProductName");
                    String description = rs.getString("ProductDescription");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String imgURL = rs.getString("ImageUrl");

                    Product p = new Product(id, name, description, quantity, price, imgURL);
                    return p;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public boolean deleteProduct(String id) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement preStm = null;
        String sql = "DELETE FROM Products WHERE ProductId=?";

        try {
            conn = RepoConnector.makeConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);

                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean createProduct(Product pd) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement preStm = null;
        String sql = "INSERT INTO Products(ProductId,ProductName, "
                + "ProductDescription, Quantity, Price, ImageUrl) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conn = RepoConnector.makeConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, pd.getId());
                preStm.setString(2, pd.getName());
                preStm.setString(3, pd.getDescription());
                preStm.setInt(4, pd.getQuantity());
                preStm.setDouble(5, pd.getPrice());
                preStm.setString(6, pd.getImgURL());

                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean updateProduct(Product pd) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement preStm = null;
        String sql = "UPDATE Products SET ProductName=?, "
                + "ProductDescription=?, Quantity=?, Price=?, "
                + "ImageUrl=? WHERE ProductId=? ";

        try {
            conn = RepoConnector.makeConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, pd.getName());
                preStm.setString(2, pd.getDescription());
                preStm.setInt(3, pd.getQuantity());
                preStm.setDouble(4, pd.getPrice());
                preStm.setString(5, pd.getImgURL());
                preStm.setString(6, pd.getId());

                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
