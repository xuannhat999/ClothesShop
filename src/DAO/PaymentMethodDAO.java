package DAO;

import DTO.PaymentMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDAO {
    public static List<PaymentMethod> getAllPaymentMethod()
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
    public static String getPaymentMethodName(int id)
    {
    
        String sql = "select payment_method_name from payment_method where payment_method_id =?";
        String name=null;
        try {
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1,id);
                ResultSet rs = stm.executeQuery();
                while(rs.next())
                    name = rs.getString("payment_method_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}
