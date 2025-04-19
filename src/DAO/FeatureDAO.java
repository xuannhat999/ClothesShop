package DAO;

import DTO.Feature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeatureDAO {
public List<Feature> getAllFeature()
{
    String sql ="select * from feature";
    List<Feature> fl = new ArrayList<>();
    try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                fl.add(new Feature(
                    rs.getInt("feature_id"),
                    rs.getString("feature_name")
                ));
            }
            
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return fl;
}

public Feature getFeatureById(int id)
{
    String sql = "select * from feature where feature_id = ?";
    Feature f = null;
    try{
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        if(rs.next())
        {
            f = new Feature(
                rs.getInt("feature_id"),
                rs.getString("feature_name")
            );
        }
        
    }catch (SQLException e)
    {
        e.printStackTrace();
    }
    return f;
}

public List<Feature> getFeatureFromRoleId(int roleid)
{
    String sql ="SELECT DISTINCT f.feature_id, f.feature_name\r\n"+//
                "FROM feature f\r\n"+//
                "JOIN permission p ON f.feature_id = p.feature_id\r\n"+//
                "WHERE p.role_id = ?;\r\n";
    List<Feature> fl = new ArrayList<>();
    try {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, roleid);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            fl.add(new Feature(
                rs.getInt("feature_id"),
                rs.getString("feature_name")
            ));
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return fl;
                
}
}
