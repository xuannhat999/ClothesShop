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
                image = rs.getString("url");
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
    public ProductColor getProductColorFromId(int pcid)
    {
        String sql = "select * from product_color where product_color_id =?";
        ProductColor pc =null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pcid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                pc = new ProductColor(rs.getInt("product_color_id"),
                                        rs.getInt("product_id"),
                                        rs.getInt("color_id"),
                                        rs.getString("url"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return pc;
    }
    public boolean addProductColor(ProductColor pc)
    {
        String sql="insert into product_color (product_id,color_id,url) values(?,?,?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pc.getProductId());
            stm.setInt(2,pc.getColorId());
            stm.setString(3,pc.getURL());
            return stm.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateProductColor(ProductColor pc)
    {
        String sql="update product_color set product_id =?,color_id=?,url=? where product_color_id =?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pc.getProductId());
            stm.setInt(2,pc.getColorId());
            stm.setString(3,pc.getURL());
            stm.setInt(4,pc.getProductColorId());
            return stm.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean removeProductColor(int pcid)
    {
        String sql="delete from product_color where product_color_id=?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, pcid);
            return stm.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
