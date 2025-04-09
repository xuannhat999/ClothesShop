package DAO;

import DTO.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public List<Category> getAllCategory()
    {
        String sql ="select * from category";
        List<Category> cl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                cl.add(new Category(rs.getInt("category_id"), rs.getString("category_name")));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return cl;
    }
    public Category getCategoryFromId(int id)
    {
        String sql ="select * from category where category_id =?";
        Category category=null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return category;
    }
}
