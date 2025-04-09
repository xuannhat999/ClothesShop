package DAO;

import java.util.List;
import DTO.ProductColor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                    rs.getString("url1"),
                    rs.getString("url2")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pcl;
    }
}
