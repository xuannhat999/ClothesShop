package DAO;

import DTO.ImportProduct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImportDAO {

    public List<ImportProduct> getAllImport() {
        String sql = "SELECT * FROM import_product";
        List<ImportProduct> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                list.add(new ImportProduct(
                    rs.getInt("import_product_id"),
                    rs.getInt("employee_id"),
                    rs.getBigDecimal("total_amount"),
                    rs.getDate("created_date"),
                    rs.getInt("supplier_id"),
                    rs.getInt("payment_method")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean addImport(ImportProduct imp) {
        String sql = "INSERT INTO import_product (employee_id, total_amount, created_date, supplier_id, payment_method) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, imp.getEmployeeId());
            ps.setBigDecimal(2, imp.getTotalAmount());
            ps.setDate(3, imp.getCreatedDate());
            ps.setInt(4, imp.getSupplierId());
            ps.setInt(5, imp.getPaymentMethod());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean removeImport(int importId) {
        String deleteDetail = "DELETE FROM import_product_detail WHERE import_id = ?";
        String deleteImport = "DELETE FROM import_product WHERE import_product_id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(deleteDetail);
            ps1.setInt(1, importId);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(deleteImport);
            ps2.setInt(1, importId);
            int rows = ps2.executeUpdate();

            conn.commit();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                DatabaseConnection.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                DatabaseConnection.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
    }

    public boolean updateImport(ImportProduct imp) {
        String sql = "UPDATE import_product SET employee_id = ?, total_amount = ?, created_date = ?, " +
                     "supplier_id = ?, payment_method = ? WHERE import_product_id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, imp.getEmployeeId());
            ps.setBigDecimal(2, imp.getTotalAmount());
            ps.setDate(3, imp.getCreatedDate());
            ps.setInt(4, imp.getSupplierId());
            ps.setInt(5, imp.getPaymentMethod());
            ps.setInt(6, imp.getImportProductId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public int getNextImportId() {
        String sql = "SELECT IFNULL(MAX(import_product_id), 0) + 1 AS next_id FROM import_product";
    
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
    public void resetImportId() {
        int nextId = getNextImportId(); // dùng hàm đã viết ở trên
    
        if (nextId <= 0) return; // nếu lỗi thì thoát
    
        String sql = "ALTER TABLE import_product AUTO_INCREMENT = ?";
    
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nextId);
            ps.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ImportProduct getImportById(int id) {
        String sql = "SELECT * FROM import_product WHERE import_product_id = ?";
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                return new ImportProduct(
                    rs.getInt("import_product_id"),
                    rs.getInt("employee_id"),
                    rs.getBigDecimal("total_amount"),
                    rs.getDate("created_date"),
                    rs.getInt("supplier_id"),
                    rs.getInt("payment_method")
                );
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null; // Không tìm thấy
    }
    public List<ImportProduct> getImportRecordBySupplierId(int supid)
    {
        String sql = "select * from import_product where supplier_id =?";
        List<ImportProduct> il=new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,supid);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                il.add(new ImportProduct(rs.getInt("import_product_id"),
                                            rs.getInt("employee_id"),
                                            rs.getBigDecimal("total_amount"),
                                            rs.getDate("created_date"),
                                            rs.getInt("supplier_id"),
                                            rs.getInt("payment_method")));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return il;
    }
    
        
}
