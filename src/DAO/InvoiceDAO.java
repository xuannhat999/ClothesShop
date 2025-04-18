package DAO;

import DTO.Invoice;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class InvoiceDAO {
    private Connection conn;

    // Constructor
    public InvoiceDAO() {
        this.conn = DatabaseConnection.getConnection();
    }

    // Lấy tất cả hóa đơn
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT i.invoice_id, u.full_name AS nameuser, i.employee_id, i.total_amount, i.create_date, i.Status,i.payment_method_id,i.user_id " +
             "FROM invoice i " +
             "JOIN user u ON i.user_id = u.user_id"; // SQL truy vấn lấy tất cả hóa đơn
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setUsername(rs.getString("nameuser"));
                invoice.setEmployeeId(rs.getInt("employee_id"));
                invoice.setTotalAmount(rs.getBigDecimal("total_amount"));
                invoice.setCreateDate(rs.getDate("create_date"));
                invoice.setPaymentMethodId(rs.getInt("payment_method_id"));
                invoice.setApproved(rs.getString("Status"));
                invoice.setUserId(rs.getInt("user_id"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    // Thêm hóa đơn mới
    public boolean addInvoice(Invoice invoice) {
        String query = "INSERT INTO invoices (user_id, employee_id, total_amount, create_date, payment_method_id, bank_account_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, invoice.getUserId());
            pstmt.setInt(2, invoice.getEmployeeId());
            pstmt.setBigDecimal(3, invoice.getTotalAmount());
            pstmt.setDate(4, new java.sql.Date(invoice.getCreateDate().getTime()));
            pstmt.setInt(5, invoice.getPaymentMethodId());
            // pstmt.setInt(6, invoice.getBankAccountId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // Nếu có ít nhất 1 dòng bị ảnh hưởng thì thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật hóa đơn
    public boolean updateInvoice(Invoice invoice) {
        String query = "UPDATE invoices SET user_id = ?, employee_id = ?, total_amount = ?, create_date = ?, payment_method_id = ?, bank_account_id = ? WHERE invoice_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, invoice.getUserId());
            pstmt.setInt(2, invoice.getEmployeeId());
            pstmt.setBigDecimal(3, invoice.getTotalAmount());
            pstmt.setDate(4, new java.sql.Date(invoice.getCreateDate().getTime()));
            pstmt.setInt(5, invoice.getPaymentMethodId());
            // pstmt.setInt(6, invoice.getBankAccountId());
            pstmt.setInt(7, invoice.getInvoiceId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa hóa đơn
    public boolean deleteInvoice(int invoiceId) {
        String query = "DELETE FROM invoices WHERE invoice_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, invoiceId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


public boolean approveInvoice(int invoiceId) {
        String sql = "UPDATE invoice SET Status = 'approve' WHERE invoice_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, invoiceId);
            return stmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancelInvoice(int invoiceId) {
        String sql = "UPDATE invoice SET Status = 'cancel' WHERE invoice_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, invoiceId);
            return stmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Invoice> getInvoicesByDateRange(Date from, Date to) {
        List<Invoice> invoicestemp = new ArrayList<>();
        String sql = "SELECT i.invoice_id, u.full_name AS nameuser, i.employee_id, i.total_amount, "
        + "i.create_date, i.Status, i.payment_method_id, i.user_id "
        + "FROM invoice i "
        + "JOIN user u ON i.user_id = u.user_id "
        + "WHERE i.create_date BETWEEN ? AND ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setDate(1, new java.sql.Date(from.getTime()));
            stmt.setDate(2, new java.sql.Date(to.getTime()));
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setUsername(rs.getString("nameuser"));
                invoice.setEmployeeId(rs.getInt("employee_id"));
                invoice.setTotalAmount(rs.getBigDecimal("total_amount"));
                invoice.setCreateDate(rs.getDate("create_date"));
                invoice.setPaymentMethodId(rs.getInt("payment_method_id"));
                // invoice.setBankAccountId(rs.getInt("bank_account_id"));
                invoice.setApproved(rs.getString("Status"));
                invoicestemp.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return invoicestemp;
    }
    

    public double getTotalRevenue(Date from, Date to) {
        String sql = "SELECT SUM(total_amount) as revenue FROM invoices WHERE create_date BETWEEN ? AND ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(from.getTime()));
            stmt.setDate(2, new java.sql.Date(to.getTime()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getDouble("revenue");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Date getInvoiceDateById(int invoiceId) {
        Date date = null;
        String query = "SELECT create_date FROM invoice WHERE invoice_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, invoiceId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getDate("create_date");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    

}
