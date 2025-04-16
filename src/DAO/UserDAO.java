package DAO;

import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<User> getAllUser()
    {
        String sql ="select * from user";
        List<User> ul = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                ul.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("full_name"),
                    rs.getDate("dob"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getInt("gender"),
                    rs.getString("address"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("role")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ul;
    }
    
    public User getUserFromId(int id)
    {
        String sql="select * from user where user_id =?";
        User user = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                user = new User(rs.getInt("user_id"),
                                rs.getString("full_name"),
                                rs.getDate("dob"),
                                rs.getString("phone"),
                                rs.getString("email"),
                                rs.getInt("gender"),
                                rs.getString("address"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getInt("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
