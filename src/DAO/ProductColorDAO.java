package DAO;

import DTO.ProductColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductColorDAO {
    public List<ProductColor> getAllProductColor()
    {
        String sql ="select * from product_color";
        List<ProductColor> pcl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                pcl.add(new ProductColor(
                    rs.getInt("product_color_id"),
                    rs.getInt("product_id"),
                    rs.getInt("color_id"),
                    rs.getString("url")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pcl;
    }
    public List<ProductColor> getAllProductColorFromPId(int pid)
    {
        String sql="select * from product_color where product_id =?";
        List<ProductColor> pcl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                pcl.add(new ProductColor(
                    rs.getInt("product_color_id"),
                    rs.getInt("product_id"),
                    rs.getInt("color_id"),
                    rs.getString("url")
                ));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return pcl;
    }
    public String getAvatarProductFromProductId(int product_id){
        String sql="select url from product_color where product_id =? limit 1";
        String image="";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,product_id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                image = rs.getString("url1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return image;
    }
    public ProductColor getProductColorFromPIdAndColorId(int pid,int colorid)
    {
        String sql = "select * from product_color where product_id=? and color_id=?";
        ProductColor pc = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pid);
            stm.setInt(2,colorid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                pc = new ProductColor(
                    rs.getInt("product_color_id"),
                    rs.getInt("product_id"),
                    rs.getInt("color_id"),
                    rs.getString("url")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pc;
    }
}
