package DAO;

import DTO.ProductVariant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductVariantDAO {
    public ProductVariantDAO()
    {}
    public List<ProductVariant> getAllProductVariant()
    {
        String sql = "select * from product_variant";
        List<ProductVariant> pvl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                pvl.add(new ProductVariant(
                    rs.getInt("product_variant_id"),
                    rs.getInt("product_color_id"),
                    rs.getString("size"),
                    rs.getInt("quantity")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pvl;
    }
    public ProductVariant getProductVariantFromPCAndSize(int pcid,String size)
    {
        String sql="select * from product_variant where product_color_id = ? and size =?";
        ProductVariant pv =null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pcid);
            stm.setString(2,size);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                pv = new ProductVariant(
                    rs.getInt("product_variant_id"),
                    rs.getInt("product_color_id"),
                    rs.getString("size"),
                    rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pv;
    }
    public List<ProductVariant> getAllProductVariantFromPCId(int pcid)
    {
        String sql="select * from product_variant where product_color_id = ?";
        List<ProductVariant> pvl =new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pcid);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                pvl.add(new ProductVariant(
                    rs.getInt("product_variant_id"),
                    rs.getInt("product_color_id"),
                    rs.getString("size"),
                    rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pvl;
    }

}
