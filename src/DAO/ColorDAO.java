package DAO;

import DTO.PColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColorDAO {
    public PColor getColorFromId(int id)
    {
        PColor color = null;
        String sql = "select * from color where color_id = ?";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                color = new PColor(
                    rs.getInt("color_id"),
                    rs.getString("color_name"),
                    rs.getString("color_code"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return color;
    }
    public List<PColor> getAllColor()
    {
        List<PColor> colors = new ArrayList<>();
        String sql = "select * from color";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                colors.add(new PColor(
                    rs.getInt("color_id"),
                    rs.getString("color_name"),
                    rs.getString("color_code")));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return colors;
    }
}
