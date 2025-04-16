package DAO;

import java.util.ArrayList;
import java.util.List;

import DTO.Bank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankDAO {
    public BankDAO(){}
    public List<Bank> getAllBank()
    {
        List<Bank> bl = new ArrayList<>();
        String sql ="select* from bank";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                bl.add(new Bank(rs.getInt("bank_id"),
                            rs.getString("bank_name")));

            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return bl;
    }
}
