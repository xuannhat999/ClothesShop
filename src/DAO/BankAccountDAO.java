package DAO;

import java.sql.SQLException;

import DTO.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankAccountDAO {
    public BankAccountDAO(){}
    public BankAccount getBankAccountFromUserBankId(int userid,int bankid)
    {
        String sql="select * from bank_account where user_id=? and bank_id=?";
        BankAccount ba = null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,userid);
            stm.setInt(2,bankid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                ba = new BankAccount(rs.getInt("bank_account_id"),
                                        rs.getInt("user_id"),
                                        rs.getString("bank_account_number"),
                                        rs.getInt("bank_id"));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        return ba;
    }
}
