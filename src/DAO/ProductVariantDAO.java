package DAO;

import DTO.ProductVariant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductVariantDAO {
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
}
