package DAO;

import DTO.Gender;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenderDAO {
    public List<Gender> getAllGender()
    {
        List<Gender> gl = new ArrayList<>();
        String sql ="select * from gender";
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                gl.add(new Gender(rs.getInt("gender_id"),rs.getString("gender_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gl;
    }
    public Gender getGenderFromId(int id)
    {
        String sql ="select * from gender where gender_id =?";
        Gender gender = new Gender();
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                gender = new Gender(rs.getInt("gender_id"),rs.getString("gender_name"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return gender;
    }
}
