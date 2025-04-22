package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {
    private Connection conn;

    public ThongKeDAO() {

            conn = DatabaseConnection.getConnection();
    }

    public List<Object[]> getDoanhThuTheoThang() {
        List<Object[]> result = new ArrayList<>();
        String sql = "SELECT YEAR(i.create_date) AS Nam, MONTH(i.create_date) AS Thang, SUM(i.total_amount) AS TongDoanhThu "
                    + "FROM invoice i "
                    + "GROUP BY YEAR(i.create_date), MONTH(i.create_date) "
                    + "ORDER BY YEAR(i.create_date), MONTH(i.create_date)";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(new Object[]{rs.getString("Thang"), rs.getDouble("TongDoanhThu")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Object[]> getSanPhamBanChay() {
        List<Object[]> result = new ArrayList<>();
        String sql = "SELECT p.product_name, SUM(d.quantity) AS total_sold " +
                     "FROM invoice_detail d " +
                     "JOIN product_variant v ON d.product_variant_id = v.product_variant_id " +
                     "JOIN product_color pc ON v.product_color_id = pc.product_color_id " +
                     "JOIN product p ON pc.product_id = p.product_id " +
                     "GROUP BY p.product_id, p.product_name " +
                     "ORDER BY total_sold DESC LIMIT 10";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                result.add(new Object[]{rs.getString("product_name"), rs.getInt("total_sold")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
