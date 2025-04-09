package DAO;

import DTO.Action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActionDAO {
    public Action getActionFromId(int id)
    {
        String sql ="select * from action where action_id =?";
        Action action=null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                action = new Action(
                    rs.getInt("action_id"),
                    rs.getString("Action_name")
                );
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return action;
    }
    
    
}
