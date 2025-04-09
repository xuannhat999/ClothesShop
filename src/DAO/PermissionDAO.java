package DAO;

import DTO.Permission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PermissionDAO {
    public List<Permission> getAllPermission()
    {
        String sql ="select *from permission";
        List<Permission> pl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                pl.add(new Permission(
                    rs.getInt("role_id"),
                    rs.getInt("feature_id"),
                    rs.getInt("action_id")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pl;
    }
    public List<Permission> getPermissionFromRoleId(int id)
    {
        String sql ="select * from permisstion where role_id =?";
        List<Permission> pl = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                pl.add(new Permission(
                    rs.getInt("role_id"),
                    rs.getInt("feature_id"),
                    rs.getInt("action_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pl;
    }
}
