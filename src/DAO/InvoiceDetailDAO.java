package DAO;

import DTO.InvoiceDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailDAO {
    public List<Object[]> getFullDetailsByInvoiceId(int invoiceId) {
        List<Object[]> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = """
        SELECT 
            p.product_name,
            c.color_name,
            pv.size,
            idt.quantity,
            p.price AS unit_price
        FROM invoice_detail idt
        JOIN product_variant pv ON idt.product_variant_id = pv.product_variant_id
        JOIN product_color pc ON pv.product_color_id = pc.product_color_id
        JOIN product p ON pc.product_id = p.product_id
        JOIN color c ON pc.color_id = c.color_id
        WHERE idt.invoice_id = ?
    """;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, invoiceId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("product_name");
                row[1] = rs.getString("color_name");
                row[2] = rs.getString("size");
                row[3] = rs.getInt("quantity");
                row[4] = rs.getDouble("unit_price");
                list.add(row);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static double getUnitPriceByVariantId(String variantId) {
        String sql = "SELECT p.price " +
                 "FROM product_variant pv " +
                 "JOIN product_color pc ON pv.product_color_id = pc.product_color_id " +
                 "JOIN product p ON pc.product_id = p.product_id " +
                 "WHERE pv.product_variant_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, variantId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0; // Trường hợp không tìm thấy
    }

    public static boolean insertInvoiceDetail(InvoiceDetail detail) {
        String sql = "INSERT INTO invoice_detail (invoice_id, product_variant_id, quantity, amount) VALUES (?, ?, ?, ?)";
        
        try 
        (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detail.getInvoiceId());
            pstmt.setInt(2, detail.getProductVariantId());
            pstmt.setInt(3, detail.getQuantity());
            pstmt.setBigDecimal(4, detail.getAmount());
    
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return false;
    }

}
