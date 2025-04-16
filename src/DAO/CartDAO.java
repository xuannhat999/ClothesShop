package DAO;

import DTO.Cart;
import DTO.ProductVariant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    public CartDAO(){}
    public List<Cart> getProductVariantInUserCart(int userid)
    {
        String sql="select * from cart where user_id =?";
        List<Cart> cl = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,userid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                cl.add(new Cart(
                    rs.getInt("user_id"),
                    rs.getInt("product_variant_id"),
                    rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cl;
    }
    public boolean addProductVariantToUserCart(Cart cart)
    {
        String sql ="insert into cart values(?,?,?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,cart.getUserId());
            stm.setInt(2,cart.getProductVariantId());
            stm.setInt(3,cart.getQuantity());
            if(stm.executeUpdate()>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean removeProductFromCart(int userid,ProductVariant pv)
    {
        String sql = "delete from cart where user_id =? and product_variant_id =?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm =conn.prepareStatement(sql);
            stm.setInt(1,userid);
            stm.setInt(2,pv.getProductVariantId());
            if(stm.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateCart(int userid,ProductVariant pv,int newbuyquan)
    {
        String sql="update cart set quantity=? where user_id=? and product_variant_id=?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,newbuyquan);
            stm.setInt(2,userid);
            stm.setInt(3,pv.getProductVariantId());
            if(stm.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Cart getCartFromProductVariantUserId(int pvid , int userid)
    {
        String sql ="select * from cart where product_variant_id =? and user_id=?";
        Cart cart = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pvid);
            stm.setInt(2,userid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                cart = new Cart(rs.getInt("user_id"),
                                rs.getInt("product_variant_id"),
                                rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }
}
