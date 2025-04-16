package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DTO.PaymentMethod;
import java.sql.ResultSet;

public class PaymentMethodDAO {
    public List<PaymentMethod> getAllPaymentMethod()
    {
        String sql="select *from payment_method";
        List<PaymentMethod> pl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                pl.add(new PaymentMethod(rs.getInt("payment_method_id"),rs.getString("payment_method_name")));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return pl;
    }
}
