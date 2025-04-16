package DAO;

import DTO.Product;
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
    public boolean updateProductVariant(ProductVariant pv)
    {
        String sql ="update product_variant set product_color_id=?,size =?,quantity=? where product_variant_id=?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pv.getProductColorId());
            stm.setString(2,pv.getSize());
            stm.setInt(3,pv.getQuantity());
            stm.setInt(4,pv.getProductVariantId());
            if(stm.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Product getProductFromProductVariantId(int pvid)
    {
        String sql ="select product.product_id,product_name,category_id,material_id,description,price,brand_id,gender from product_variant join product_color on product_variant.product_color_id = product_color.product_color_id join product on product_color.product_id = product.product_id where product_variant_id =?";
        Product p = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pvid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                p = new Product(
                    rs.getInt("product_id"),
                    rs.getString("Product_name"),
                    rs.getInt("category_id"),
                    rs.getInt("material_id"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getInt("brand_id"),
                    rs.getInt("gender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }              
        return p;
    }

    public ProductVariant getProductVariantFromId(int pvid)
    {
        String sql ="select * from product_variant where product_variant_id =?";
        ProductVariant pv = null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,pvid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                pv = new ProductVariant(
                    rs.getInt("product_variant_id"),
                    rs.getInt("product_color_id"),
                    rs.getString("size"),
                    rs.getInt("quantity")
                );
            }
        }catch(SQLException e)
        {
            e.printStackTrace();

        }
        return pv;
    }

}
