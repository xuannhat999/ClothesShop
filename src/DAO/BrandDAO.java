package DAO;

import DTO.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    public List<Brand> getAllBrand()
    {
        List<Brand> bl = new ArrayList<>();
        String sql ="select * from brand";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                bl.add(new Brand(rs.getInt("brand_id"),rs.getString("brand_name")));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return bl;
    }
    public Brand getBrandFromId(int id)
    {
        Brand brand = null;
        String sql ="select * from brand where brand_id =?";
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                brand = new Brand(rs.getInt("brand_id"),rs.getString("brand_name"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return brand;
    }
}
