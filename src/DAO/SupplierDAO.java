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
    public int getNextSupplierId() {
        String sql = "SELECT IFNULL(MAX(supplier_id), 0) + 1 AS next_id FROM supplier";
    
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
    
            if (rs.next()) {
                return rs.getInt("next_id");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return -1; // Trả về -1 nếu lỗi
    }
    public void resetSupplierid() {
        int nextId = getNextSupplierId(); // dùng hàm đã viết ở trên
    
        if (nextId <= 0) return; // nếu lỗi thì thoát
    
        String sql = "ALTER TABLE supplier AUTO_INCREMENT = ?";
    
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nextId);
            ps.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean updateSupplier(Supplier supplier) {
        String sql = "UPDATE supplier SET supplier_name = ?, phone = ?, email = ?, address = ? WHERE supplier_id = ?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, supplier.getSupplierName());
            stm.setString(2, supplier.getPhone());
            stm.setString(3, supplier.getEmail());
            stm.setString(4, supplier.getAddress());
            stm.setInt(5, supplier.getSupplierId());
    
            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addSupplier(Supplier supplier) {
        String sql = "INSERT INTO supplier (supplier_name, phone, email, address) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, supplier.getSupplierName());
            stm.setString(2, supplier.getPhone());
            stm.setString(3, supplier.getEmail());
            stm.setString(4, supplier.getAddress());
            
            int rowsInserted = stm.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        

}
