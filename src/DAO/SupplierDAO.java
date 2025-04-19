package DAO;

import DTO.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    
    public List<Supplier> getAllSupplier()
    {
        String sql ="select* from supplier";
        List<Supplier> bl = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                bl.add(new Supplier(
                    rs.getInt("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bl;
    }

    // TÌM SUPPLIER THEO ID 
    public Supplier getSppulierFromId(int id)
    {
        Supplier supplier=null ;
        String sql="select * from supplier where supplier_id =?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                supplier = new Supplier(
                    rs.getInt("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }
}
