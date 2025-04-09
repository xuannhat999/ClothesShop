package DAO;

import DTO.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
    public List<Material> getAllMaterial()
    {
        List<Material> ml = new ArrayList<>();
        String sql = "select * from material";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                ml.add(new Material(rs.getInt("material_id"),rs.getString("material_name")));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ml;
    }
    public Material getMaterialFromId(int id)
    {
        Material material = null;
        String sql = "select * from material where material_id =?";
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                material = new Material(rs.getInt("material_id"),rs.getString("material_name"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return material;
    }
}
