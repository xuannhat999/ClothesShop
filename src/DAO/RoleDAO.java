package DAO;

import DTO.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    public Role getRoleFromId(int id)
    {
        String sql = "select * from role where role_id = ?";
        Role role = null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                role = new Role(
                    rs.getInt("role_id"),
                    rs.getString("role_name")
                );
            }   
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return role;

       
    }
    public List<Role> getAllRole()
    {
        String sql ="select * from role";
        List<Role> rl = new ArrayList<>();
        try {
           Connection conn = DatabaseConnection.getConnection();
           Statement stm = conn.createStatement();
           ResultSet rs = stm.executeQuery(sql);
           while(rs.next())
           {
            rl.add(new Role(rs.getInt("role_id"),rs.getString("role_name")));
           } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rl;
    }
}
